package br.com.residencia.reactnative.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.reactnative.entities.Usuario;
import br.com.residencia.reactnative.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> findByNome(@PathVariable String nome) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuarioService.findByNome(nome), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuarioService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(Pageable page) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuarioService.findAll(page), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return usuarioService.count();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		usuarioService.deleteLogical(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
		HttpHeaders headers = new HttpHeaders();
		Usuario newUsuario = usuarioService.save(usuario);
		if(null != newUsuario) {
			return new ResponseEntity<>(newUsuario, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(newUsuario, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@Valid @RequestBody Usuario usuario, @PathVariable Integer id) {
		return usuarioService.update(usuario, id);
	}
	
	@GetMapping("/login")
	public String loginApp(@Valid @RequestParam String login, @RequestParam String senha) {
		return usuarioService.loginApp(login, senha);
	}
}