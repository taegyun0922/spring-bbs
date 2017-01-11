package com.CDS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@Autowired
	private UserBasicDao userBasicDao;
	
	@Autowired
	private GameItemDao gameItemDao;
	
	
	@RequestMapping("/game_list")
	public ModelAndView getGameListView(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			UserBasic user = userBasicDao.getUserInfoBy(authentication.getName());
			List<GameItem> gameList = gameItemDao.getGameList();	
	
		
		ModelAndView view = new ModelAndView();
		view.setViewName("game_list");
		view.addObject("user_pic_src",user.getUserPicSm());
		view.addObject("user_pic_title",user.getUserName());
		view.addObject("game_list", gameList);
		return view;
	}
	return null;
	}
}
