package com.rogan.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// main route
@RestController
@SpringBootApplication
public class BbsApplication {

	@Autowired
	private BbsDao dao;

	@RequestMapping("/")
	@ResponseBody
	public ModelAndView index() throws Exception {
		
		ModelAndView mav = new ModelAndView("index.html");
		
		return mav;
	}

/*	@RequestMapping("/login/")
	public String login(@RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd) {
		 
		return "ID = " + id + "PWD =" + pwd;

	}*/
	
	/*public static boolean isUserAuthorized(User user) {
	
		
		char id, pwd;
		
		if (id==){
			
		}
		 {
			
			return true;
		}
		 
		 System.out.println("plaese check your account for Auth");		 
		 return false;
	}
		*/
	

	@RequestMapping("/test/")
	public List<User> getAllListForBeanPropertyRowMapper() {
		return dao.listForBeanPropertyRowMapper();
	}

	@RequestMapping("/add/")
	public String add(@RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd)
	{
		User user = new User();
		user.setUserID(id);
		user.setUserPwd(pwd);
		
		int affextrdRows = dao.insert(user);
		if(affextrdRows !=1) {
			return "Erorr";
		} else {
			return "Insert hello: " + id ;
		}
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}
}
