package br.com.residencia.reactnative.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.residencia.reactnative.entities.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository <Categoria, Integer> {

	List<Categoria> findByNome(String nome);
	
}