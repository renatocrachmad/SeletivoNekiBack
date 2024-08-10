package br.org.neki.SistemaSkill.controller;


import br.org.neki.SistemaSkill.entity.Skill;
import br.org.neki.SistemaSkill.entity.UsuarioSkill;
import br.org.neki.SistemaSkill.entity.UsuarioSkill;
import br.org.neki.SistemaSkill.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
	
	
	private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/{userId}")
    public List<UsuarioSkill> getSkillsByUserId(@PathVariable Long userId) {
        return skillService.getSkillsByUserId(userId);
    }

    @PostMapping
    public UsuarioSkill associateSkill(@RequestBody UsuarioSkill userSkill) {
        return skillService.associateSkill(userSkill);
    }

    @PutMapping("/{id}")
    public UsuarioSkill updateSkillAssociation(@PathVariable Long id, @RequestBody UsuarioSkill userSkill) {
        return skillService.updateSkillAssociation(id, userSkill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillAssociation(@PathVariable Long id) {
        skillService.deleteSkillAssociation(id);
    }
}
	


