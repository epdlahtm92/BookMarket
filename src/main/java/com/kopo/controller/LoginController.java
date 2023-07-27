package com.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loginfailed")
	public String Loginerror(Model model) {
		model.addAttribute("error", "true"); // 에러가 트루면 에러가 발생한 것
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login";
	}
}
