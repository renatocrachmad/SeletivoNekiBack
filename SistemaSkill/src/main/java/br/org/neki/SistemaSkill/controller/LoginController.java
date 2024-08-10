package br.org.neki.SistemaSkill.controller;


import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.neki.SistemaSkill.dto.LoginDTO;
import br.org.neki.SistemaSkill.entity.Usuario;
import br.org.neki.SistemaSkill.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	AuthenticationManager authManager;
	@Autowired
	TokenService tokenService;
	@PostMapping
	public ResponseEntity loginUsuario(@RequestBody @Valid LoginDTO data) throws AuthenticationException {
	    var senhaUsuario = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
		var auth = authManager.authenticate(senhaUsuario);
		var token = tokenService.geracaoTokenUsuario((Usuario) auth.getPrincipal());
		return ResponseEntity.ok(token);
	}
}
