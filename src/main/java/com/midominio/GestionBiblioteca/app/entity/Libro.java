package com.midominio.GestionBiblioteca.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "libros")
@Data
public class Libro {

	
	private Long id;
	private String titulo;
	private String autor;
	private String editorial;
	private String numPag;
	
}
