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

import br.com.residencia.reactnative.VO.ProdutosVO;
import br.com.residencia.reactnative.entities.Produto;
import br.com.residencia.reactnative.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	public ProdutoService produtoService;
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> findByNome(@PathVariable String nome) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findByNome(nome), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> findAll(Pageable page) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findAll(page), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return produtoService.count();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produtoService.deleteLogical(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> save(@Valid @RequestBody ProdutosVO produto) {
		HttpHeaders headers = new HttpHeaders();
		Produto newProduto = produtoService.save(produto);
		if(null != newProduto) {
			return new ResponseEntity<>(newProduto, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(newProduto, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto update(@Valid @RequestBody ProdutosVO produto, @PathVariable Integer id) {
		return produtoService.update(produto, id);
	}
}
