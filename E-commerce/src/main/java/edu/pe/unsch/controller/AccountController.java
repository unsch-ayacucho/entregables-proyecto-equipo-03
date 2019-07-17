package edu.pe.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.pe.unsch.entities.Usuario;
import edu.pe.unsch.service.AccountService;


@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/registro")
	public String register(Model model) {
		model.addAttribute("titulo", "New account : e-commerce");
		model.addAttribute("account", new Usuario());
		return "views/public/account/register";
		}
	
	@PostMapping("/registro")
	public String register(@ModelAttribute("account") Usuario account,
		RedirectAttributes redir) {
		redir.addAttribute("titulo", "New account : e-commerce");
		System.out.println("prueba account: " + account.getEmail());
		try {
			accountService.create(account);
			redir.addFlashAttribute("message", "La cuenta fue creada correctamente");
	
			return "redirect:/";
		} catch (Exception e) {
			redir.addFlashAttribute("message", "No puede registrar nueva cuenta");
			return "redirect:/account/login";
			}
		}
	
	
	@PostMapping("/login")
	public String myaccount(HttpServletRequest request, HttpSession session,RedirectAttributes redir,Model model) {
		redir.addFlashAttribute("account", new Usuario());
		Usuario account = accountService.login(request.getParameter("email"),
		request.getParameter("password"));
		//System.out.println(request.getParameter("email"));
		//System.out.println(request.getParameter("password"));
		if (account == null) {
			redir.addFlashAttribute("error", "Cuenta inválida");
			return "redirect:/account/login";
			} 
		else {
			session.setAttribute("email", account.getEmail());
			//System.out.println("---------------------------");
			//System.out.println(account.getIdCliente());
			//System.out.println(account);
			//model.addAttribute("persona",account);
			return "redirect:/";
			}
	}	

	@GetMapping("/login")
	public String customerorders(Model model) {
		model.addAttribute("titulo", "My account : e-commerce");
		//model.addAttribute("account", new Usuario());
		return "views/public/account/login";
	}
	
	
}
