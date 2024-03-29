package tcc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.UsuarioModel;
import tcc.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private UsuarioRepository repository;
	
	public UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	
	 @GetMapping("/listarTodos")
	 public ResponseEntity<List<UsuarioModel>> listarTodos() {
	     return ResponseEntity.ok(repository.findAll());
	 }
	 
	 
	 public ResponseEntity<UsuarioModel> salvar (@RequestBody UsuarioModel usuario){
		 return ResponseEntity.ok(repository.save(usuario));
	 }
}
