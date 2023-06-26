package com.midominio.GestionBiblioteca.app.models.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "libros")
@Data
public class Libro implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min = 3, max=15)
	private String titulo;
	
	@NotEmpty
	@Size(min = 3, max=15)
	private String autor;
	
	@NotEmpty
	@Size(min = 3, max=15)
	private String editorial;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 1_000)
	private Long numPag;
	
	@NotNull
	private boolean prestado;
	
}
