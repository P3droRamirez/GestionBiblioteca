package com.midominio.GestionBiblioteca.app.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.GestionBiblioteca.app.models.entities.Libro;


public interface LibroService {

	List<Libro> listar();
	Page<Libro> listar(Pageable pageable);
	List<Libro> findByTitulo(String titulo);
	Page<Libro> findbyTitulo(Pageable pageable,String titulo);
	List<Libro> findByAutor(String autor);
	Page<Libro> findbyAutor(Pageable pageable,String autor);
	List<Libro> findByEditorial(String editorial);
	Page<Libro> findbyEditorial(Pageable pageable,String editorial);
	Libro findById (Long id);
	void delete(Long id);
	void save(Libro libro);
	Libro saveRest(Libro libro);
}
