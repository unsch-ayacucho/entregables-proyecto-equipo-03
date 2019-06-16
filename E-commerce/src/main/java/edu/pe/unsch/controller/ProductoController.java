package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.unsch.entities.Categoria;
import edu.pe.unsch.service.CategoriaService;
import edu.pe.unsch.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/categoria/{id}")
	public String categoria(@PathVariable("id") Integer id, Model model){
		Categoria categoria=categoriaService.find(id);
		model.addAttribute("Titulo","Categoria");
		model.addAttribute("productos",categoria.getProductos());
		model.addAttribute("classActive","active");
		return "views/public/producto/categoria";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("titulo", "Producto detalle");
		model.addAttribute("productoDetalle", productoService.find(id));
		return "views/public/producto/producto";
	}

}
