package hh.swd20.teht21.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller

public class HelloController {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String sayHello(Model model, @RequestParam(name="name") String name, @RequestParam(name="age") Integer age) {
	
	
		
	model.addAttribute("name", name);
	model.addAttribute("age", age);
		
	return "sayhello";
	}
}
