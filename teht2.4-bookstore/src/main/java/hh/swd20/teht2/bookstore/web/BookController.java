package hh.swd20.teht2.bookstore.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import hh.swd20.teht24.bookstore.domain.Book;

@Controller
public class BookController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listBooks() {
		
		

		return "";
	}
	
}

