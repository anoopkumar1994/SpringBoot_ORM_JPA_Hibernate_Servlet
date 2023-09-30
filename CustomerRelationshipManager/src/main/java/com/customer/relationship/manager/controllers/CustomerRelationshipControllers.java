package com.customer.relationship.manager.controllers;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.customer.relationship.manager.model.CustomerRelationshipModel;
import com.customer.relationship.manager.services.CustomerRelationshipServices;

@RestController
public class CustomerRelationshipControllers {
	
	@Autowired
	CustomerRelationshipServices customerRelationshipServices;
	
	
	@GetMapping("/customerform")
	public ModelAndView showCustomerListForm(@RequestParam(required = false) UUID id) {
		String viewName =  "customerform";
		
		Map<String, Object> model = new HashMap<>();// CustomerRelationshipModel Map with customerform
		
		if(id == null) {
			model.put("customerlistItem", new CustomerRelationshipModel());
		}else {
			model.put("customerlistItem", customerRelationshipServices.getListById(id));
		}
	
		return new ModelAndView(viewName, model);
	
//		CustomerRelationshipModel c = new CustomerRelationshipModel();
//		c.setFirstName("anoop");
//		c.setLastName("kumar");
//		c.setEmail("abc@gmail.com");
//		model.put("customerlistItem", c);
//		return new ModelAndView(viewName, model);
	
	}
	
	
	// Submit the customer list	
	@PostMapping("/customerform")
	public ModelAndView submitCustomerListForm(CustomerRelationshipModel customerRelationshipModel) {
		
		customerRelationshipServices.create(customerRelationshipModel);
		RedirectView rd = new RedirectView(); // Redirect the "/customer" URL
		rd.setUrl("/customerlist");
		return new ModelAndView(rd);
	}
	
	
	// Get All Customer List
	@GetMapping("/customerlist")
	public ModelAndView getCustomerList() {
		
		String viewName =  "customerlist";
		Map<String, Object> model = new HashMap<>();
		model.put("customerlistrows" ,customerRelationshipServices.getAllCustomerList());
		return new ModelAndView(viewName, model);
	}	  
	  
	
//	Update Customer List By Id
	@GetMapping()
	public ModelAndView updateCustomerList() {
		String viewName = "customerform";
		Map<String, Object> model = new HashMap<>();
		model.put("customerlistrows", model);
		return new ModelAndView(viewName, model);
	}
	
	
	
	  // Delete Customer List By Id
	  @GetMapping("/deletecustomerlist/{id}")
	  
	  public ModelAndView deleteListById(@PathVariable UUID id) {
	      customerRelationshipServices.deleteCustomerListById(id);
	      RedirectView rd = new RedirectView();
	      rd.setUrl("/customerlist");
	      return new ModelAndView(rd);
	      
	  }
}