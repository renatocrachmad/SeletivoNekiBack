package br.org.neki.SistemaSkill.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.org.neki.SistemaSkill.dto.LoginDTO;
import br.org.neki.SistemaSkill.entity.Usuario;

@Service
public class TokenService {

	String secret = "a"; //verificar qual a variavel de ambiente do servidor.
	public String geracaoTokenUsuario(Usuario usuario) {
			
		
		try {
			
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create()
					.withIssuer("pmp-api")
					.withSubject(usuario.getEmail())
					.withExpiresAt(geracaoDeDataExpiracao())
					.sign(algorithm);
					//caso precise expirar o token adc o .withExpiredAt()
			return  token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro na geração do token", e);
		}
	}
	
	
	
	private Instant geracaoDeDataExpiracao () {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	public String validacaoToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("pmp-api")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException e) {
			return "";
		}
	}
}

