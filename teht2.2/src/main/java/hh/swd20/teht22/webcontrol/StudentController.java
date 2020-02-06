package hh.swd20.teht22.webcontrol;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.swd20.teht22.domain.Student;



@Controller

public class StudentController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String listStudents(Model model) {
		
		model.addAttribute("student", new Student());
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Kate", "Cole"));
		students.add(new Student("Dan", "Brown"));
		students.add(new Student("Mike", "Mars"));
		
		model.addAttribute("students", students);

		
		return "studentlist";
	}
}
