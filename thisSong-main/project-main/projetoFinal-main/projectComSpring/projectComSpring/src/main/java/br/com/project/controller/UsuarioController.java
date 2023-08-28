package br.com.project.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.project.model.Produto;
import br.com.project.model.Usuario;
import br.com.project.repository.ProdutoRepository;
import br.com.project.repository.UsuarioRepository;
import br.com.project.service.ServiceExc;
import br.com.project.service.ServiceUser;
import br.com.project.util.Util;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ServiceUser serviceUser;
	
	@GetMapping("/entrar")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("login");
		return mv;
	}
	
	
	
	@GetMapping ("/login")
	public ModelAndView listarProduto () {
		Random rd = new Random ();
		
		
		Set<Integer> numeros = new HashSet<>();
		
		
		
		int num = rd.nextInt(1); 
	
	
			if(num == num) {
				num = rd.nextInt(12);
			}
			
	
		
		ModelAndView mv = new ModelAndView();
		
		List<Produto> produtos = (List<Produto>) produtoRepository.findAll(PageRequest.of(num, 1)).toList();
	
		
		mv.addObject("produtos", produtos);
		mv.setViewName("produtos");
		 
		return mv;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("cadastro");
		return mv;
	}
	
	@PostMapping("/salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		serviceUser.salvarUsuario(usuario);
		mv.setViewName("redirect:/entrar");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("/produto");
		}
		
		Usuario userLogin = serviceUser.loginUser(usuario.getEmail(), Util.md5(usuario.getSenha()));
		if(userLogin == null) {
			mv.addObject("msg", "Usuário não encontrado!");
		} else {
			session.setAttribute("usuarioLogado", userLogin);
			return listarProduto();
		}
		 return mv;
		
	}



	
}
