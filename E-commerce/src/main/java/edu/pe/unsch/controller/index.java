package edu.pe.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class index {
	@GetMapping("/home")
	public String home(){
		return "views/index";
	}
	
	@GetMapping("/about")
	public String about(){
		return "views/about";
	}
	
	@GetMapping("/afiliacion")
	public String afiliacion(){
		return "views/afiliacion";
	}
	
	@GetMapping("/blog")
	public String blog(){
		return "views/blog";
	}
	
	@GetMapping("/cart")
	public String cart(){
		return "views/cart";
	}
	
	@GetMapping("/categoria")
	public String categoria(){
		return "views/categoria";
	}
	
	@GetMapping("/checkout")
	public String checkout(){
		return "views/checkout";
	}
	
	@GetMapping("/contact")
	public String contact(){
		return "views/contact";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword(){
		return "views/forgetPassword";
	}
	
	@GetMapping("/login")
	public String login(){
		return "views/login";
	}
	
	@GetMapping("/producto")
	public String producto() {
		return "views/producto";
	}
	
	@GetMapping("/register")
	public String register() {
		return "views/register";
	}
	
	@GetMapping("/singleBlog")
	public String singleBlog() {
		return "views/single_blog";
	}
}