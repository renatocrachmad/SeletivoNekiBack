package br.org.neki.SistemaSkill.repository;

import br.org.neki.SistemaSkill.entity.Usuario;
import br.org.neki.SistemaSkill.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
		Usuario findByEmail(String email);
	

}
