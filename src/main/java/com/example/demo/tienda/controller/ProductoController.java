package com.example.demo.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tienda.entities.Producto;
import com.example.demo.tienda.repository.ProductoRepository;
//@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductoRepository productoRepository;
	@GetMapping
	public List<Producto> listar() {
		return productoRepository.findAll();

	}
	
	@GetMapping("/{id}")
	public Optional<Producto>getProductoById(@PathVariable Integer id){
		Optional<Producto>producto=productoRepository.findById(id);
		if(producto.isPresent()) {
			return producto;
		}
		return null;
	}
	@PostMapping
	public Producto postProducto(@RequestBody Producto producto) {
		productoRepository.save(producto);
		return producto;
	}
	@PutMapping("/{id}")
	public Producto putPorducto(@PathVariable Integer id,@RequestBody Producto producto) {
		Optional<Producto>productoCurrent=productoRepository.findById(id);
		if(productoCurrent.isPresent()) {
			Producto p=productoCurrent.get();
			p.setNombre(producto.getNombre());
			p.setDescripcion(producto.getDescripcion());
			productoRepository.save(p);
			return p;
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public Producto deleteProductoById(@PathVariable Integer id) {
		Optional<Producto>producto=productoRepository.findById(id);
		if(producto.isPresent()) {
			Producto p=producto.get();
			productoRepository.deleteById(id);
			return p;
			
		}
		return null;
	}
	

}
