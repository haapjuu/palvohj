package hh.swd20.teht23.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import hh.swd20.teht23.domain.Friend;

@Controller
public class FriendController {
	
	List<Friend> friends = new ArrayList<Friend>();

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listFriends(Model model) {
		
		model.addAttribute("friend", new Friend());
		
		model.addAttribute("friends", friends);

		return "friendlist";
	}
	
	  @RequestMapping(value="/index", method=RequestMethod.POST)
	  public String inputFriends(Friend friend, Model model) {
		  
		friends.add(friend);
		
	    model.addAttribute("friend", new Friend());
	    
	    model.addAttribute("friends", friends);

	    return "friendlist";
	  }
}
