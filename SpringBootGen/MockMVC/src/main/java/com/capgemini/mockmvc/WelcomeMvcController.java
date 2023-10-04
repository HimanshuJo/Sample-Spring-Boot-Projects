package com.capgemini.mockmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeMvcController {
	@Autowired
	private WelcomeService welcomeService;

	@GetMapping(value = "/")
	public String greeting1(String name, Model model) {
		model.addAttribute("welcome", welcomeService.greetingMessage1(name));
		return "welcome-page";
	}

	@GetMapping(value = "/event")
	public String greeting2(String name, Model model) {
		model.addAttribute("welcomeToEvent", welcomeService.greetingMessage2(name));
		return "event-page";
	}
}
