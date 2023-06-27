package com.midominio.GestionBiblioteca.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.GestionBiblioteca.app.models.dao.LibroDao;
import com.midominio.GestionBiblioteca.app.models.entities.Libro;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroDao libroDao;
	
	
	@Override
	@Transactional
	public List<Libro> listar() {
		return (List<Libro>)libroDao.findAll();
	}
/*
	@Override
	@Transactional(readOnly = true)
	public List<Libro> findByTitulo(String titulo) {
		return libroDao.findByTitulo(titulo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findByAutor(String autor) {
		return libroDao.findByAutor(autor);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Libro> findByEditorial(String editorial) {
		return libroDao.findByEditorial(editorial);
	}

*/
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> listar(Pageable pageable) {
		return libroDao.findAll(pageable);
	}
/*
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> findbyTitulo(Pageable pageable, String titulo) {
		return libroDao.findbyTitulo(pageable, titulo);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Libro> findbyAutor(Pageable pageable, String autor) {
		return libroDao.findbyAutor(pageable, autor);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Page<Libro> findbyEditorial(Pageable pageable, String editorial) {
		return libroDao.findbyEditorial(pageable, editorial);
	}
	

	@Override
	@Transactional(readOnly = true)
	public Libro findById(Long id) {
		return libroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		libroDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		libroDao.save(libro);
		
	}

	@Override
	@Transactional
	public Libro saveRest(Libro libro) {
		return libroDao.save(libro);
	}


*/





}
