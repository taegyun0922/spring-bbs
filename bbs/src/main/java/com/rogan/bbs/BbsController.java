package com.rogan.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BbsController {
	
	@Autowired
	private BbsDao dao;
	
	@RequestMapping("/test/")
	public List <User> getAllListForBeanPropertyRowMapper(){
		return dao.listForBeanPropertyRowMapper();
		//return dao.listForBeanPropertyRowMapper<User>(User.class);
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
	
}
