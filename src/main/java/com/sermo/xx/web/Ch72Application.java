package com.sermo.xx.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sermo.xx.model.Person;

@Controller
public class Ch72Application {
	
	@RequestMapping("/person")
	public String index(Model model){
		Person single = new Person("aa", 11);
		
		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx", 11);
		Person p2 = new Person("yy", 22);
		Person p3 = new Person("zz", 33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		
		return "thy";
	}
}
