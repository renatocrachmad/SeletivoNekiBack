package br.org.neki.SistemaSkill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.neki.SistemaSkill.dto.UsuarioDTO;
import br.org.neki.SistemaSkill.entity.Usuario;
import br.org.neki.SistemaSkill.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuariosRepository;

	@Lazy
	@Autowired
	private BCryptPasswordEncoder encoder;

	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuariosRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			usuariosDTO.add(usuarioDTO);
		}
		return usuariosDTO;
	}

	public UsuarioDTO findById(Long idUsuario) throws NotFoundException {
		Usuario usuario = usuariosRepository.findById(idUsuario).orElseThrow();
		return new UsuarioDTO(usuario);
	}

	public UsuarioDTO insert(Usuario usuario) {

		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario = usuariosRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}

	@Transactional
	public UsuarioDTO findAndUpdate(Long idUsuario, Usuario usuariosAtualizadas) throws NotFoundException {
		Usuario usuarioExistente = usuariosRepository.findById(idUsuario).orElseThrow();
		usuarioExistente.setNome(usuariosAtualizadas.getNome());
		usuarioExistente.setEmail(usuariosAtualizadas.getEmail());
		usuarioExistente.setSenha(encoder.encode(usuariosAtualizadas.getSenha()));

		Usuario usuarioAtualizado = usuariosRepository.save(usuarioExistente);
		return new UsuarioDTO(usuarioAtualizado);
	}
}
