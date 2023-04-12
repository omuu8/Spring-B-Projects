package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	
	@RequestMapping("/")
	public String edureka() {
		
		return "edureka";
	}
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "edureka";
		//here we do save the data in h2 repo
		
	}
	@RequestMapping("/getdetails")
	public String getdetails() {
		
		return "ViewCustomers";
	}
@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam() int cid){
	ModelAndView mv = new ModelAndView("Retrieve");
	Customers customers = repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
}
//we will create here diff diff methods ok
@RequestMapping("/customers")
@ResponseBody
public List<Customers> getCustomers() {
	return repo.findAll();
	// we changed return type as list so we will get the data in the form of list
	// so we get the o/p in JSON format
}
@RequestMapping("/customers/{cid}")
@ResponseBody
public Optional<Customers> getCustomers2(@PathVariable("cid") int cid) {
	return repo.findById(cid);
	// here instead of the string object we have made it as optional class to return
	
}
@PostMapping("/customers/{cid}")

public Customers  getCustomers3(@RequestBody Customers customers) {
	
	repo.save(customers);
	return customers;	
}
@DeleteMapping("/customers/{cid}")

public Customers  getCustomers4(@PathVariable("cid") int cid) {
	Customers cust = repo.getOne(cid);
	repo.delete(cust);
	return cust;
}

@PutMapping(path = "/customers",consumes = {"application/json"})

public Customers  getCustomers5(@RequestBody Customers customers) {
	
	repo.save(customers);
	return customers;
}
}