package edu.pe.unsch.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.unsch.entities.Compra;
import edu.pe.unsch.entities.Detallecompra;
import edu.pe.unsch.entities.Item;
import edu.pe.unsch.entities.Usuario;
import edu.pe.unsch.service.AccountService;
import edu.pe.unsch.service.OrdersDetailService;
import edu.pe.unsch.service.OrdersService;
import edu.pe.unsch.service.ProductoService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrdersDetailService ordersDetailService;

	@GetMapping("/")
	public String cart (Model model) {
		model.addAttribute("titulo","Cart : e-commerce");
		return "views/public/cart/cart";
		}
		
	
	@GetMapping("/buy/{id}")
	public String add(@PathVariable("id") int id, HttpSession session,Model model) {
		model.addAttribute("titulo","Cart : e-commerce");
		if(session.getAttribute("cart")==null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productoService.find(id),1));
			session.setAttribute("cart",cart);
		}
		else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isEXists(id,session);
			if(index == -1) {
				cart.add(new Item(productoService.find(id), 1));
			} 
			else {
				int cantidad = cart.get(index).getCantidad() + 1;
				cart.get(index).setCantidad(cantidad);
				session.setAttribute("cart", cart);
			}
			session.setAttribute("cart", cart);
		}
		return "views/public/cart/cart";
	}

	@GetMapping("delete/{index}")
	public String delete(@PathVariable("index") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/";
	}

	private int isEXists(int id, HttpSession session) {
		// TODO Auto-generated method stub
		List<Item> cart = (List<Item>) session.getAttribute("cart");		
		
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProducto().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	@PostMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		model.addAttribute("titulo", "Checkout : e-commerce");
		model.addAttribute("account", new Usuario());
		if (session.getAttribute("email") == null) {
			return "redirect:/account/login";
		} 
		else {
			// Guardar Orden
			Compra orders = new Compra();
			Usuario account = accountService.find(session.getAttribute("email").toString());
			System.out.println(session.getAttribute("email").toString());
			orders.setUsuario(account);;
			orders.setCreacion(new Date());
			Compra newOrder = ordersService.create(orders);
			// Guardar Detalle del orden
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			for (Item item : cart) {
				System.out.println("Orders detail " + newOrder.getId());
				Detallecompra ordersdetail = new Detallecompra();
				ordersdetail.setCompra(newOrder);
				ordersdetail.setProducto(item.getProducto());
				ordersdetail.setPrecio(item.getProducto().getPrecio());
				ordersdetail.setCantidad(item.getCantidad());
				ordersDetailService.create(ordersdetail);
				}
			// Limpiar carrito
			session.removeAttribute("cart");
			return "views/public/account/thanks";
			}
		}
	
	
	
	
}
