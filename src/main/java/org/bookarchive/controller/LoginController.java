package org.bookarchive.controller;

import org.bookarchive.model.LoginId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
		if (login != null && (login.getUsername() != null && !login.getUsername().equals(""))
				&& (login.getPassword() != null && !login.getPassword().equals(""))) {
			model.addAttribute("user", login.getUsername().toUpperCase());
			return "home";
		} else {
			model.addAttribute("error", "Please enter username and password");
			return "index";
		}
	}

}
