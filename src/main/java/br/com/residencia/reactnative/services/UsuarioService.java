package br.com.residencia.reactnative.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.residencia.reactnative.entities.Usuario;
import br.com.residencia.reactnative.exceptions.RegistryNotFoundException;
import br.com.residencia.reactnative.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	public List<Usuario> findByNome (String nome) {
        return usuarioRepository.findByNome(nome);
    }
	
	public Usuario findById(Integer id) {
		Optional <Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new RegistryNotFoundException(id));
	}
	
	public List<Usuario> findAll(Pageable page) {
		return usuarioRepository.findAllAtivos(page);
	}
	
	public Long count() {
		return usuarioRepository.count();
	}
	
	public void deleteLogical(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			Usuario usu = usuario.get();
			usu.setAtivo(false);
			usuarioRepository.save(usu);
		}
	}
	
	public Usuario save(Usuario usuario) {
		Usuario newUsuario = usuarioRepository.save(usuario);
		return newUsuario;
	}
	
	public Usuario update(Usuario usuario, Integer id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}
	
	public String loginApp(String login, String senha){
		
		Usuario usuario = usuarioRepository.findByLogin(login);

		if(usuarioRepository.findByLogin(login) != null){
			if(usuario.getSenha().equals(senha)){
				return "Login confirmado!";
			} else {
				return "Login e/ou senha inválidos.";
			}
		} else {
			return "Login e/ou senha inválidos.";
		}
	}

}
