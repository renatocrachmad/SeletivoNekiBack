package br.org.neki.SistemaSkill.controller;

import br.org.neki.SistemaSkill.dto.UsuarioDTO;
import br.org.neki.SistemaSkill.entity.Usuario;
import br.org.neki.SistemaSkill.entity.Usuario;
import br.org.neki.SistemaSkill.service.UsuarioService;
import br.org.neki.SistemaSkill.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private final UsuarioService usuarioService;

    
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioDTO register(@RequestBody Usuario usuario) {
        return usuarioService.insert(usuario);
    }
}


