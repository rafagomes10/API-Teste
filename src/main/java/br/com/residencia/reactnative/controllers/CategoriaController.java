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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.reactnative.entities.Categoria;
import br.com.residencia.reactnative.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public CategoriaService categoriaService;
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> findByNome(@PathVariable String nome) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findByNome(nome), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(Pageable page) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findAll(page), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return categoriaService.count();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		categoriaService.deleteLogical(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
		HttpHeaders headers = new HttpHeaders();
		Categoria newCategoria = categoriaService.save(categoria);
		if(null != newCategoria) {
			return new ResponseEntity<>(newCategoria, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(newCategoria, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria update(@Valid @RequestBody Categoria categoria, @PathVariable Integer id) {
		return categoriaService.update(categoria, id);
	}
}