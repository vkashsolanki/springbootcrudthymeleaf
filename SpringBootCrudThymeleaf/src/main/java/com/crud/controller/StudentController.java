package com.crud.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Student;
import com.crud.repo.StudentRepository;

@Controller
@RequestMapping("/students/")
public class StudentController {
	
	private StudentRepository repository;
	@Autowired
	public StudentController(StudentRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(Student student) {
		
		return "add-student";
				
	}
	
	 @GetMapping("/list")
      public String showUpdateForm(Model model ) {
        model.addAttribute("students", repository.findAll());
        return "index";
    }
	
	 
	    @PostMapping(value = "/add")
	    public String addStudents(@Valid Student student, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-student";
	        }

	        repository.save(student);
	        return "redirect:list";
	    }


	    @GetMapping("edit/{id}")
	    public String showUpdatesForm(@PathVariable("id") long id, Model model) {
	    	Student student = repository.findById(id).orElseThrow(() ->
	    	new IllegalArgumentException("Invalid Student id :"+id));
	    	model.addAttribute("student",student);
	    	return "update-student";
	    	
	    }

	    @PostMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            student.setId(id);
	            return "update-student";
	        }

	        repository.save(student);
	        model.addAttribute("students", repository.findAll());
	        return "index";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteStudent(@PathVariable("id") long id, Model model) {
	    	Student student = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Student id"+id));
	        repository.delete(student);
	        model.addAttribute("students", repository.findAll());
	        return "index";
	    }
	}
	
	

