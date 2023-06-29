package com.midominio.GestionBiblioteca.app.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.GestionBiblioteca.app.models.entities.Libro;


public interface LibroService {

	List<Libro> listar();
	
	Page<Libro> listar(Pageable pageable);
	Libro findById (Long id);
	List<Libro> findByAutor(String autor);
	Page<Libro> findbyAutor(Pageable pageable,String autor);
	List<Libro> findByEditorial(String editorial);
	Page<Libro> findByEditorial(Pageable pageable,String editorial);
	void delete(Long id);
	void save(Libro libro);
	/*
	
	Libro saveRest(Libro libro);
	*/
}
