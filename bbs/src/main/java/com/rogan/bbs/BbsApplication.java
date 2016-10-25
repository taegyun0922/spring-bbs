package com.rogan.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class BbsApplication {
	
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index.html");
		return mav;
	}

	@RequestMapping("/login/")
	public String login(@RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd) {
 		return "ID = "+  id + "PWD =" + pwd;

	}
	
		public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}
}
