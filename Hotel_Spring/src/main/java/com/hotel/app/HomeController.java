package com.hotel.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	   public String booking() {
	      return "booking"; // JSP 화일이름
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
	@RequestMapping(value="/newinfo", method=RequestMethod.POST)
	public String newinfo(@ModelAttribute("pl") ParamList pl) {
		return "newinfo";
	}
	@RequestMapping("/room")
	   public String go_reservation() {
	      return "room";
	   }
	   @RequestMapping("show_all")
	   public String show_all() {
	      return "show_all";
	   }
}