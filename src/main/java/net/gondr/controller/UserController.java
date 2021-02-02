package net.gondr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.gondr.domain.UserVO;
import net.gondr.domain.YYSampleVO;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@RequestMapping(value="data" , method=RequestMethod.GET)
	public @ResponseBody UserVO getUserData() {
		UserVO temp = new UserVO();
		temp.setUserid("ajwwlswotjd");
		temp.setPassword("1234");
		temp.setUsername("정재성");
		
		return temp;
	}
	
	@RequestMapping(value="logout" , method=RequestMethod.GET)
	public String logout( HttpSession session ) {
		
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping(value="regist" , method=RequestMethod.GET)
	public String viewRegistPage() {
		
		// /user/regist
		
		return "user/regist";
	}
	
	@RequestMapping(value="regist" , method=RequestMethod.POST)
	public String registProcess( YYSampleVO user ) {

		
		return ("redirect:/world " + user.getId());
	}
	
	@RequestMapping(value="regist2" , method=RequestMethod.GET)
	public String regist2() {
		
		return "user/regist2";
	}
	
	@RequestMapping(value="regist2" , method=RequestMethod.POST)
	public String regist2Process( Model model , YYSampleVO user ) {
		
		if(user.getEmail().isEmpty() || user.getId().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getPassword2().isEmpty()) {
			return ("redirect:/user/regist2");
		}
		
		String password = user.getPassword();
		String password2 = user.getPassword2();
		
		if(!password.equals(password2)) {
			return ("redirect:/user/regist2");
		}
		
		model.addAttribute("user", user);
	
		return "asdf";
	}
	
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String loginView( Model model ) {
		
		
		
		return "user/login";
		
	}
	
	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String loginProcess( HttpSession session , UserVO user ) {
		
		if(user.getUserid().equals("asdf") && user.getPassword().equals("1234")) {
			session.setAttribute("user", user);
			return "redirect:/";
		} else {
			
			session.setAttribute("login_msg", "아이디 혹은 비밀번호가 잘못되었습니다.");
			return "redirect:/user/login";
		}
		
//		return "redirect:/";
		
	}
	
	@RequestMapping( value="info" , method=RequestMethod.GET )
	public String viewInfoPage( HttpSession session ) {
		
		if(session.getAttribute("user") == null) {
//			session.setAttribute("flash", "로그인 후 확인하실 수 있습니다.");
			return "redirect:/user/login";
		}
		
		return "user/info";
	}
	
}
