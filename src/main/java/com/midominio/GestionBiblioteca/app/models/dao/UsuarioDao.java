package com.midominio.GestionBiblioteca.app.models.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>,CrudRepository<Usuario, Long>{


}
