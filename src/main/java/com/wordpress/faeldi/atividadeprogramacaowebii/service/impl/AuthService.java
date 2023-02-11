package com.wordpress.faeldi.atividadeprogramacaowebii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Usuario;
import com.wordpress.faeldi.atividadeprogramacaowebii.repository.UsuarioRepository;

import java.util.Optional;

@Component
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByUsername(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Usuário não encontrado.");
	}

}
