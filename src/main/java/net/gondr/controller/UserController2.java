package net.gondr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.api.Session;

import net.gondr.dao.UserDAO;
import net.gondr.domain.UserVO;

@Controller
@RequestMapping("/asdf/")
public class UserController2 {
	
	@Autowired
	private UserDAO dao;
	
	@RequestMapping(value="logout" , method=RequestMethod.GET)
	public String logout( HttpSession session ) {
		session.removeAttribute("user");
		return ("redirect:/asdf/main");
	}
	
	@RequestMapping(value="main" , method=RequestMethod.GET)
	public String viewMain( HttpSession session ) {
		
		return "asdf/main";
	}
	
	@RequestMapping(value="login" , method=RequestMethod.GET)
	public String viewlogin() {
		
		return "asdf/login";
	}
	
	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String loginProcess( UserVO user , HttpSession session ) {
		
		if( dao.selectUser(user.getUserid()) == null ) {
			session.setAttribute("msg", "존재하지 않는 아이디 입니다.");
			return ("redirect:/asdf/login");
		}
		UserVO vo = dao.selectUser(user.getUserid());
		if( !vo.getPassword().equals(user.getPassword()) ) {
			session.setAttribute("msg", "비밀번호가 잘못되었습니다.");
			return ("redirect:/asdf/login");
		}
		session.setAttribute("user" , vo);
		
		return ("redirect:/asdf/main");
	}

	@RequestMapping(value="join" , method=RequestMethod.GET)
	public String viewJoin() {
		
		return "asdf/join";
	}
	
	@RequestMapping(value="join" , method=RequestMethod.POST)
	public String joinProcess( Model model , UserVO user , HttpSession session ) {
		
		if(user.getUserid().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getPassword_check().isEmpty()) {
			session.setAttribute("msg", "비어있는 값이 있습니다.");
			return ("redirect:/asdf/join");
		}
		
		if(!user.getPassword().equals(user.getPassword_check())) {
			session.setAttribute("msg", "비밀번호와 비밀번호 확인이 다릅니다.");
			return ("redirect:/asdf/join");
		}
		
		//dao.selectUser( user.getUserid() );
		if(dao.selectUser( user.getUserid() ) != null) {
			session.setAttribute("msg", "이미 존재하는 아이디  입니다.");
			return ("redirect:/asdf/join");
		}
		
		dao.insertUser(user);
		return ("redirect:/asdf/join");
	}

	@RequestMapping(value="/user/data/{userid}" , method=RequestMethod.GET)
	public @ResponseBody UserVO showUser(@PathVariable String userid) {
		
		UserVO temp = dao.selectUser(userid);
		return temp;
		
	}
	
}
