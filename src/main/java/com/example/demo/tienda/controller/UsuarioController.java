package com.example.demo.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tienda.entities.Usuario;
import com.example.demo.tienda.repository.UsuarioRepository;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuariosById(@PathVariable Integer id) {
		Optional<Usuario>usuario=usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			Usuario usuarioReturn=usuario.get();
			
			return usuarioReturn;
		}
		return null;
	}

	@PostMapping
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		
		usuarioRepository.save(usuario);
		return usuario;
	}
	@PutMapping("/{id}")
	public Usuario putUsuario(@RequestBody Usuario usuario,@PathVariable Integer id) {
		
		Optional<Usuario>usuarioCurrent=usuarioRepository.findById(id);
		if(usuarioCurrent.isPresent()) {
			Usuario usuarioReturn=usuarioCurrent.get();
			usuarioReturn.setNombre(usuario.getNombre());
			usuarioReturn.setEmail(usuario.getEmail());
			usuarioRepository.save(usuarioReturn);
			return usuarioReturn;
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
		
	}
}
