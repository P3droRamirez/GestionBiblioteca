package com.midominio.GestionBiblioteca.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

public interface UsuarioService {

	List<Usuario> listar();
	Page<Usuario> listar(Pageable pageable);
	Usuario findById(Long id);
	void delete(Long id);
	void save(Usuario usuario);

	
}
