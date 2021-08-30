package com.hotel.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String goLoing() {
		return "login";
	}
	
//	@RequestMapping(value="/viewinfo", method=RequestMethod.POST)
//	public String viewInfo(HttpServletRequest hsr, Model model) {
//		String userid = hsr.getParameter("userid");
//		String userpw = hsr.getParameter("userpw");
//		model.addAttribute("userid", userid);
//		model.addAttribute("userpw", userpw);
//		return "viewinfo";
//	}
	@RequestMapping(value="/check_user", method=RequestMethod.POST)
	   public String go_room(HttpServletRequest hsr, Model model) {
	      String userid = hsr.getParameter("userid");
	      String userpw = hsr.getParameter("userpw");
	      model.addAttribute("userid", userid);
	      model.addAttribute("userpw", userpw);
	      HttpSession session = hsr.getSession(); // session 사용가능하게 함
	      session.setAttribute("loginid", userid);
	      return "redirect:/booking"; // RequestMapping의 경로이름
	   }
	@RequestMapping(value="/booking", method=RequestMethod.GET)
	   public String booking(HttpServletRequest hrs) {
		HttpSession session = hrs.getSession();
		String loginid = (String)session.getAttribute("loginid");
		if(loginid.equals("1234")) {
			return "booking";
		}
		else {
			return "redirect:/home";
		}
	   }
	
   @RequestMapping("/booking")
   public String goRoom() {
      return "booking";
   }

	@RequestMapping("/home")
	public String goHome() {
		return "home";
	}
	@RequestMapping("/newbie")
	public String goJoin() {
		return "newbie";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String newinfo(@ModelAttribute("pl") ParamList pl) {
		return "home";
	}
	@RequestMapping("/room")
	   public String go_reservation(HttpServletRequest hsr,Model model) {
		HttpSession session = hsr.getSession();
		if(session.getAttribute("loginid")==null) {
			return "redirect:/home";
		}
		// 여기서 interface호출하고 결과를 room.jsp에 전달.
		IRoom room=sqlSession.getMapper(IRoom.class);
		ArrayList<Roominfo> roominfo=room.getRoomList();
		model.addAttribute("list",roominfo);
	      return "room";
	   }
	@RequestMapping("/logout")
	   public String logout(HttpServletRequest hsr) {
		HttpSession session = hsr.getSession();
		session.invalidate();
	      return "redirect:/";
	   }
	
   @RequestMapping("show_all")
   public String show_all() {
      return "show_all";
   }
}