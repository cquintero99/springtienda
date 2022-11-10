package com.example.demo.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tienda.entities.Categoria;
import com.example.demo.tienda.repository.CategoriaRepository;
@CrossOrigin(origins="*" ,allowedHeaders = "*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listaCategorias(){
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Categoria getCategoriaById(@PathVariable Integer id) {
		Optional<Categoria>categoria=categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		return null;
	}
	
	@PostMapping
	public Categoria postCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.save(categoria);
		return categoria;
	}
	
	@PutMapping("/{id}")
	public Categoria putCategoria(@PathVariable Integer id,   @RequestBody Categoria categoria) {
		Optional<Categoria>categoriaCurren=categoriaRepository.findById(id);
		if(categoriaCurren.isPresent()) {
			
			Categoria categoriaReturn =categoriaCurren.get();
			
			categoriaReturn.setDescripcion(categoria.getDescripcion());
			
			categoriaRepository.save(categoriaReturn);
			
			return categoriaReturn;
		}
		return null;
		
	}
	
	@DeleteMapping("/{id}")
	public Categoria deleteCategoria(@PathVariable Integer id) {
		Optional<Categoria>categoria=categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			
			Categoria categoriaReturn=categoria.get();
			
			categoriaRepository.deleteById(id);
			
			return categoriaReturn;
		}
		return null;
		
		
	}
	
	
	
}
