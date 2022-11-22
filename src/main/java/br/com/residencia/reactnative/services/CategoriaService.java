package br.com.residencia.reactnative.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.residencia.reactnative.entities.Categoria;
import br.com.residencia.reactnative.exceptions.RegistryNotFoundException;
import br.com.residencia.reactnative.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public List<Categoria> findByNome (String nome) {
        return categoriaRepository.findByNome(nome);
    }
	
	public Categoria findById(Integer id) {
		Optional <Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new RegistryNotFoundException(id));
	}
	
	public List<Categoria> findAll(Pageable page) {
		return categoriaRepository.findAll(page).getContent();
	}
	
	public Long count() {
		return categoriaRepository.count();
	}
	
	public void deleteLogical(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			categoriaRepository.deleteById(id);
		}
	}
	
	public Categoria save(Categoria categoria) {
		Categoria newCategoria = categoriaRepository.save(categoria);
		return newCategoria;
	}
	
	public Categoria update(Categoria categoria, Integer id) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}
}
