package br.org.neki.SistemaSkill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.neki.SistemaSkill.entity.UsuarioSkill;
import br.org.neki.SistemaSkill.repository.UsuarioSkillRepository;

@Service
public class SkillService {
	

	private final UsuarioSkillRepository userSkillRepository;

    @Autowired
    public SkillService(UsuarioSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public List<UsuarioSkill> getSkillsByUserId(Long userId) {
        return userSkillRepository.findByUserId(userId);
    }

    public UsuarioSkill associateSkill(UsuarioSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    public UsuarioSkill updateSkillAssociation(Long id, UsuarioSkill userSkill) {
        UsuarioSkill existingUserSkill = userSkillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill association not found"));
        existingUserSkill.setLevel(userSkill.getLevel());
        return userSkillRepository.save(existingUserSkill);
    }

    public void deleteSkillAssociation(Long id) {
        userSkillRepository.deleteById(id);
    }
}
