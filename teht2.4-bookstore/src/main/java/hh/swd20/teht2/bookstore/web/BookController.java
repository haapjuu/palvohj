package hh.swd20.teht2.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.teht2.bookstore.domain.Book;
import hh.swd20.teht2.bookstore.domain.BookRepo;
import hh.swd20.teht2.bookstore.domain.CategoryRepo;


@Controller
public class BookController {
	
	@Autowired
	BookRepo bookRepo;
	@Autowired
	CategoryRepo categoryRepo;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listBooks() {
		return "";
	}
	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){		
		return (List<Book>) bookRepo.findAll();
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return bookRepo.findById(bookId);
	}
	
	@RequestMapping(value="/book/{isbn}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findByIsbn(@PathVariable("isbn") String isbn){
		return bookRepo.findByIsbn(isbn);
	}
	
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepo.findAll());
		
		return "addbook";
	}
	
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepo.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String getNewEditForm(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepo.findById(bookId));
		return "editbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		bookRepo.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
}

