package com.luv2code.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	//Request mapping should map with form action
	@RequestMapping("/processForm")
	public String processMyForm() {
		System.out.println("Inside my processform");
		return "helloworld";
	}

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest req, Model model) {
		String name = req.getParameter("studentName");
		name = name.toUpperCase();
		String result = "Yo!" + name;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();
		String result = "Hello my friend from version three! " + name;
		model.addAttribute("message", result);
		return "helloworld";
	}

}
