package net.gondr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String mainPage( Model model ) {
		
		model.addAttribute("msg" , "ㅇㅅㅇ");
		
		return "main";
	}
	
	@GetMapping("/hello")
	public String hello(Model model , @RequestParam(value="name") String name ) {
		model.addAttribute("msg" , name);
		return "hello";
	}
	
	@GetMapping("/rect/{width}/{height}/{color}")
	public String rect(Model model , @PathVariable int width, @PathVariable int height , @PathVariable String color) {
		
		model.addAttribute("width" , width);
		model.addAttribute("height" , height);
		model.addAttribute("color" , color);
		
		return "rect";
	}
	
	@GetMapping("/world/{name}")
	public String world(Model model , @PathVariable String name ) {
		model.addAttribute("msg" , name);
		return "hello";
	}
	
	@GetMapping("/asdf")
	public String asdf(Model model, @RequestParam(value="id") String id , @RequestParam(value="password") String password , @RequestParam(value="password2") String password2 , @RequestParam(value="name") String name ,@RequestParam(value="email") String email  ) {
		model.addAttribute("id" , id );
		model.addAttribute("password" , password );
		model.addAttribute("password2" , password2 );
		model.addAttribute("name" , name );
		model.addAttribute("email" , email );
		return "asdf";
	}
	
}
