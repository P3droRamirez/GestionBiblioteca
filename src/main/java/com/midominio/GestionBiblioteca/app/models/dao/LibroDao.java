package com.midominio.GestionBiblioteca.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.GestionBiblioteca.app.models.entities.Libro;


public interface LibroDao extends CrudRepository<Libro, Long>,PagingAndSortingRepository<Libro, Long>{


	List<Libro> findByTitulo(String titulo);
	/*
	List<Libro> findByAutor(String autor);
	List<Libro> findByEditorial(String editorial);
	
	Page<Libro> findbyTitulo(Pageable pageable,String titulo);
	Page<Libro> findbyAutor(Pageable pageable,String autor);
	Page<Libro> findbyEditorial(Pageable pageable,String editorial);
	*/
}
