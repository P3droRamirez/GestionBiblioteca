package com.midominio.GestionBiblioteca.app.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

import com.midominio.GestionBiblioteca.app.services.UsuarioService;
import com.midominio.spring02.app.utilis.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	
	@Autowired
	UsuarioService usuarioService;
	
	
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.listar(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuarios/listar", usuarios); 
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		return "usuarios/listar";
	}
	
	@GetMapping("/editar")
	public String editar(Model model) {
		model.addAttribute("titulo", "Inserción de un Usuario");
		model.addAttribute("usuario", new Usuario());
		return "usuarios/form";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id,@RequestParam(defaultValue = "0") int page, Model model) {
		List<Usuario> usuariosId = new ArrayList<>();
		usuariosId.add(usuarioService.findById(id));
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<Usuario> usuarios =  new PageImpl<>(usuariosId, pageRequest, 1);
		PageRender<Usuario> pageRender = new PageRender<>("/articulos/id/" +  id, usuarios); 
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		return "usuarios/listar";		
	}
	
	@GetMapping("/borrar/{id}")
	public String listarPor(@PathVariable Long id, Model model,RedirectAttributes flash) {
		model.addAttribute("titulo", "Listado de Usuarios");
		usuarioService.delete(id);
		model.addAttribute("usuarios", usuarioService.listar());
		flash.addFlashAttribute("warning", "Usuario borrado con éxito");
		return "redirect:/usuarios/listar";		
	}
	
	
	@GetMapping("/editar/{id}")
	public String formGetById(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Edición de un usuario");
		model.addAttribute("usuario",usuarioService.findById(id));
		return "usuarios/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Usuario usuario, BindingResult result,@RequestParam("file") MultipartFile foto, Model model, RedirectAttributes flash) {  
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un usuario");
			return "usuarios/form"; 
		}
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src/main/resources/static/upload");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Subido correctamente " + foto.getOriginalFilename());
				usuario.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {

			}
		}
		usuarioService.save(usuario);
		flash.addFlashAttribute("success", "Usuario guardado con éxito");
		return "redirect:listar";
	}
}
