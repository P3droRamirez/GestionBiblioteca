package com.midominio.GestionBiblioteca.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>,PagingAndSortingRepository<Usuario, Long>{

	
	List<Usuario> findByLogin (String login);
	List<Usuario> findByEmail (String email);
	List<Usuario> findByDireccion (String direccion);
}
