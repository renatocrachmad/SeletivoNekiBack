package br.org.neki.SistemaSkill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.neki.SistemaSkill.repository.UsuarioRepository;

@Service
public class AutorizacaoService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository repository;

	 @Override
	    public UserDetails loadUserByUsername(String userNameEmail) throws UsernameNotFoundException {
	        UserDetails userDetails = repository.findByEmail(userNameEmail);
	        if (userDetails == null) {
	            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + userNameEmail);
	        }
	        return userDetails;
	    }

}