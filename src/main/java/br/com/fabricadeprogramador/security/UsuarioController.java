package br.com.fabricadeprogramador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.repository.UsuarioRepository;


@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping(value="/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario (@RequestBody Usuario usuario){
		Usuario usuCadastrado = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuCadastrado, HttpStatus.OK);
	}
}
