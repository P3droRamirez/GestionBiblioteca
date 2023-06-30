package com.midominio.GestionBiblioteca.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.midominio.GestionBiblioteca.app.models.entities.Libro;
import com.midominio.GestionBiblioteca.app.models.entities.Usuario;
import com.midominio.GestionBiblioteca.app.services.LibroService;
import com.midominio.GestionBiblioteca.app.services.UsuarioService;
import com.midominio.spring02.app.utilis.paginator.PageRender;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	
	@Autowired
	UsuarioService usuarioService;
	
	
	/*
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/usuarios/listar", usuarios); 
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		return "usuarios/listar";
	}
	*/
}
