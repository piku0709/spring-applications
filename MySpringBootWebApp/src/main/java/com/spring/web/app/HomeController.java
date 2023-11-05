package com.spring.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		System.out.println("hi " + name + " - from home controller GET api");
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		return "home";
	}

}
