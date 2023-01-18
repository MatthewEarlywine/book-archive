package org.bookarchive.webapp.controller;

import org.bookarchive.webapp.model.LoginId;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@Configuration
//@ComponentScan("org.bookarchive")
public class LoginController {

	@GetMapping("/")
	public String getLoginPage() {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "index";
	}

	@PostMapping(value = "/login")
	public String submit(Model model, @ModelAttribute("login") LoginId login) {

		if ((login.getUsername().length() < 8) || (login.getPassword().length() < 8)) {
			model.addAttribute("error", "Both Username and Password must each be at least eight (8) characters long, no spaces.");
			return "index";
		}

		if ((login.getUsername() != null && !login.getUsername().equals("") && !login.getUsername().contains(" "))
				&& (login.getPassword() != null && !login.getPassword().equals("") && !login.getPassword().contains(" "))) {
			model.addAttribute("user", login.getUsername().toUpperCase());
			return "home";
		} else {
			model.addAttribute("error", "Please enter correct username and password");
			return "index";
		}
	}

}
