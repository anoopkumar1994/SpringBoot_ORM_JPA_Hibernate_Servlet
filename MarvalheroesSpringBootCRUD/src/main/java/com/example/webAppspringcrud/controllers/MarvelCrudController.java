package com.example.webAppspringcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.webAppspringcrud.model.MarvelHeroesSchema;
import com.example.webAppspringcrud.services.CRUDService;

@RestController
public class MarvelCrudController {

	@Autowired
	CRUDService crudService;
	
	//create 
	@PostMapping(path = "create")
	public void createSuprhero(@RequestBody MarvelHeroesSchema marvelHeroesSchema) {
		crudService.createSuperhero(marvelHeroesSchema);
	}
	
	//Read
	@GetMapping("read")
	public MarvelHeroesSchema readSuperHeroById(@RequestParam(name = "id") int val) {
		return crudService.readSuperHeroById(val);
	}
	
	//Update
	@PutMapping(path = "update")
	public void getUpdate(@RequestBody MarvelHeroesSchema marvelHeroesSchema, @RequestParam(name ="id") int id) {
		crudService.updateSuperHero(marvelHeroesSchema, id);
	}
	
	//Delete
	@DeleteMapping(path = "delete")
	public void deleteSuperhero(@RequestParam(name = "id") int id) {
		crudService.deleteSuperHeroes(id);
	}
}
