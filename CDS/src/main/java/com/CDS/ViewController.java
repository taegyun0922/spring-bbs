package com.CDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@Autowired
	private UserBasicDao userBasicDao;
	
	@RequestMapping("/game_list")
	public ModelAndView getGameListView()
	{
		UserBasic user = userBasicDao.getUserInfoBy("chansung18","123456");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("game_list");
		view.addObject("user_pic_src",user.getUser_pic_sm());
		view.addObject("user_pic_title",user.getUser_name());
		
		System.out.println(user.getUser_pic_sm());
		
		return view;
	}
}
