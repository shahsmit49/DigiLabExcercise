package edu.asu.diging.tutorial.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.tutorial.spring.domain.Mood;
import edu.asu.diging.tutorial.spring.service.MoodService;
import edu.asu.diging.tutorial.spring.service.MoodServiceInterface;

@Controller
public class HomeController {
	
	private Mood moodValue;
	
	@Autowired 
    private MoodServiceInterface service;
	
	@RequestMapping(value = "/")
	public String home(ModelMap map) {
		moodValue = service.getCurrentMood();
	    map.addAttribute("mood", moodValue);
	    return "index2";
	}
	
	@RequestMapping(value = "/redirect")
	   public String redirect() {
	      return "redirect:finalPage";
	   }
   @RequestMapping(value = "/finalPage")
   public String finalPage(ModelMap map) {
	  String whyItFeelThatWay = service.message();
	  map.addAttribute("mood", whyItFeelThatWay);
      return "anchor_target";
   }
	
//	@RequestMapping(value = "/")
//	public String home() {
//	    return "index";
//	}

}
