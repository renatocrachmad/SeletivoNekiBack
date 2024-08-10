package br.org.neki.SistemaSkill.repository;

import br.org.neki.SistemaSkill.entity.UsuarioSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long>{
	List<UsuarioSkill> findByUserId(Long usuarioId);
	

}
