package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class index {
	@GetMapping({"/","/home"})
	public String home(){
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
	
	@GetMapping("/cart")
	public String cart(){
		return "views/public/cart";
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
		return "views/public/login";
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