package br.com.project.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.Expection.CriptoExistsException;
import br.com.project.excepetion.EmailExistsException;
import br.com.project.model.Usuario;
import br.com.project.repository.UsuarioRepository;
import br.com.project.util.Util;

@Service
public class ServiceUser {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void salvarUsuario(Usuario usuario) throws Exception {
		try {
			if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + usuario.getEmail());
			}
			
			usuario.setSenha(Util.md5(usuario.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CriptoExistsException("Erro na criptografia da senha!");
		}
		
		usuarioRepository.save(usuario);
	}
	
	public Usuario loginUser(String email, String senha) throws ServiceExc {
		Usuario userLogin = usuarioRepository.buscarLogin(email, senha);
		return userLogin;
	}
	
	
}
