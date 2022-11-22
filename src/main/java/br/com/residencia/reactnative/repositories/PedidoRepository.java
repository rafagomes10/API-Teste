package br.com.residencia.reactnative.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.residencia.reactnative.entities.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository <Pedido, Integer> {

}