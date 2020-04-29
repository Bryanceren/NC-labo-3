package com.uca.capas.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	private List<Student> students= new ArrayList<Student>();
	@GetMapping(path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programacion n capas";
	}
	
	@GetMapping(path = "/ejemplo2")
	public @ResponseBody List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("Nombre1","Apellido","10/10/1998","Carrera1",true),
				new Student("Nombre2","Apellido","10/10/1998","Carrera2",false)
				);
	}
	@GetMapping("/inicio")
	public String inicio(Student student) {
		return "index";
	}
	@PostMapping("/formData")
	public ModelAndView procesar(Student student) {
		students.add(student);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		mav.addObject("student", new Student());
		
		return mav;
	}
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", this.students);
		return mav;
	}
	
	
}
