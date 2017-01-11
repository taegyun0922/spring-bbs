package com.CDS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private UserBasicDao userBasicDao;

	@RequestMapping("/")
	public String index() {
		return "hello World!!";
	}

	@RequestMapping("/user/list")
	public String getUserList() {
		List<UserBasic> userList = userBasicDao.getUserList();

		String result = "user list : ";

		for (UserBasic user : userList) {
			result += user.getUserId() + " ( " + user.getUserName() + " ), ";
		}

		return result;

	}

	@RequestMapping(// http://localhost:8080/user/auth?user_id=chansung18&user_pwd=123456
			value = "/user/auth", params = { "user_id", "user_pwd" })
	public String isUserAuthorizedBy(
			@RequestParam("user_id") String userId,
			@RequestParam("user_pwd") String userPwd
			) {

		boolean result = userBasicDao.isUserAuthorizedBy(userId, userPwd);

		return result ? userId + " is Authorized " : userId + " is not Authorized ";
	}

	@RequestMapping(						//url에 사용할 파라미터 지
			value = "/user/info",
			params = {"user_id","user_pwd"} 
			)
	public 
	String getUserInfoBy( 					// 요청에 사용할 parameter선언 
			@RequestParam("user_id") String userId, 
			@RequestParam("user_pwd") String userPwd 
			) {
		
		UserBasic result = userBasicDao.getUserInfoBy(userId);	
		
		return "ID: "+result.getUserId() + " PWD: "+ result.getUserPwd() + " NAME: "+ result.getUserName() 
		 + " SM: " + result.getUserPicSm();
	}
}