package edu.pe.unsch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.unsch.service.ProductoService;

@Controller

public class index {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping({"/","/home"})
	public String home(Model model){
		model.addAttribute("destacado",productoService.featured(5));
		model.addAttribute("oferta",productoService.lasted(6));
		return "views/public/index";
	}
	
	@GetMapping("/about")
	public String about(){
		return "views/public/about";
	}
	
	@GetMapping("/afiliacion")
	public String afiliacion(){
		return "views/public/afiliacion";
	}
	
	@GetMapping("/blog")
	public String blog(){
		return "views/public/blog";
	}
	 
	
	@GetMapping("/categoria")
	public String categoria(){
		return "views/public/producto/categoria";
	}
	
	@GetMapping("/checkout")
	public String checkout(){
		return "views/public/checkout";
	}
	
	@GetMapping("/contact")
	public String contact(){
		return "views/public/contact";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword(){
		return "views/public/forgetPassword";
	}
	
	@GetMapping("/login")
	public String login(){
		return "views/public/Account/login";
	}
	
	@GetMapping("/producto")
	public String producto() {
		return "views/public/producto/producto";
	}
	
	@GetMapping("/register")
	public String register() {
		return "views/public/register";
	}
	
	@GetMapping("/singleBlog")
	public String singleBlog() {
		return "views/public/single_blog";
	}
}