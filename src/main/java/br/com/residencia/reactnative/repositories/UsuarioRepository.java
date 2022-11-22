package br.com.residencia.reactnative.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.residencia.reactnative.entities.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository <Usuario, Integer> {

	Usuario findByLogin(String login);
	
	List<Usuario> findByNome(String nome);
	
	@Query(value = "select * from usuario where usuario.usu_bl_ativo = true", nativeQuery = true)
	List<Usuario> findAllAtivos(Pageable page);
	
}