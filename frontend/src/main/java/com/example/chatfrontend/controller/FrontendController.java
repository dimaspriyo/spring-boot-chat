package com.example.chatfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

	@GetMapping("/a")
	public String UserA() {
		return "a";
	}
	
	@GetMapping("/b")
	public String UserB() {
		return "b";
	}
	
	@GetMapping("/chat")
	public String chat() {
		return "chat";
	}
	
}
