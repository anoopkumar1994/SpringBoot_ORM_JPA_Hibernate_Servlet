package com.example.webAppspringcrud.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webAppspringcrud.model.MarvelHeroesSchema;

@Repository
public interface SuperHeroCharactorRepository extends JpaRepository<MarvelHeroesSchema, Integer> {

}
