package com.example.webApp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@PostMapping(path = "post")
	public void postControl() {
		System.out.println("page hited saccussfully");
	}

}
