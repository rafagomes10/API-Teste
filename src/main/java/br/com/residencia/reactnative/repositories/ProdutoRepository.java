package br.com.residencia.reactnative.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.residencia.reactnative.entities.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository <Produto, Integer> {

	List<Produto> findByNome(String nome);
}