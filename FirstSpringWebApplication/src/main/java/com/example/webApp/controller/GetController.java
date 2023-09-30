package com.example.webApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
	
	@GetMapping
	public String getSearch() {
		return "Hello Spring";
	}
	
	@GetMapping("/search")
	public String getSearching() {
		return "Hello Spring Boot";
	}
	
	@GetMapping("/searching")
	public String getSearched(@RequestParam(name = "query") String str) {
		return str;
	}
	
	@GetMapping("/searched/{act_name}")
	public String getSearches(@PathVariable(name = "act_name") String str ) {
		return str;
	}

}
