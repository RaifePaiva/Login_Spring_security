package com.projeto.spring.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.projeto.spring.domain.Usuario;
import com.projeto.spring.repositories.UsuarioRepository;

@Repository
@Transactional
public class UserDetailsServiceimpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository user;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = user.findByEmail(email);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true, usuario.getAuthorities());
	}

}
