package com.midominio.GestionBiblioteca.app.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.GestionBiblioteca.app.models.entities.Libro;
import com.midominio.GestionBiblioteca.app.services.LibroService;

import com.midominio.spring02.app.utilis.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	
	@Autowired
	LibroService libroService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libros/listar", libros); 
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libros/listar";
	}
	
	@GetMapping("/editar")
	public String editar(Model model) {
		model.addAttribute("titulo", "Inserción de un Libro");
		model.addAttribute("libro", new Libro());
		return "libros/form";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id,@RequestParam(defaultValue = "0") int page, Model model) {
		List<Libro> librosId = new ArrayList<>();
		librosId.add(libroService.findById(id));
		Pageable pageRequest = PageRequest.of(0, 1);
		Page<Libro> libros =  new PageImpl<>(librosId, pageRequest, 1);
		PageRender<Libro> pageRender = new PageRender<>("/articulos/id/" +  id, libros); 
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libros/listar";		
	}
	
	@GetMapping("/autor/{autor}")
	public String listarPorAutor(@PathVariable String autor, @RequestParam(defaultValue = "0") int page, Model model) {	
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.findbyAutor(pageRequest,autor);
		PageRender<Libro> pageRender = new PageRender<>("/libros/autor/" + autor, libros); 
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libros/listar";
	}
	
	
	@GetMapping("/editorial/{editorial}")
	public String listarPorEditorial(@PathVariable String editorial, @RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.findByEditorial(pageRequest,editorial);
		PageRender<Libro> pageRender = new PageRender<>("/libros/editorial/" + editorial, libros); 
		model.addAttribute("titulo", "Listado de Libros por editorial");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		return "libros/listar";
	}
	
	@GetMapping("/borrar/{id}")
	public String listarPor(@PathVariable Long id, Model model,RedirectAttributes flash) {
		model.addAttribute("titulo", "Listado de Libros");
		libroService.delete(id);
		model.addAttribute("libros", libroService.listar());
		flash.addFlashAttribute("warning", "Libro borrado con éxito");
		return "redirect:/libros/listar";		
	}
	
	
	@GetMapping("/editar/{id}")
	public String formGetById(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Edición de un libro");
		model.addAttribute("libro",libroService.findById(id));
		return "libros/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Libro libro, BindingResult result, Model model,RedirectAttributes flash) {  
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un libro");
			return "libros/form"; 
		}
		libroService.save(libro);
		flash.addFlashAttribute("success", "Libro guardado con éxito");
		return "redirect:listar";
	}
	
	
}
