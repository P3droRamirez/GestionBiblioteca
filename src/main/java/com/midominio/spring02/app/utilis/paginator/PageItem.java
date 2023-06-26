package com.midominio.spring02.app.utilis.paginator;

public class PageItem {

	
	private int numero;   //numero de pagina
	private boolean actual;   //si es la pagina actual
	
	
	
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	
	
	
	public int getNumero() {
		return numero;
	}
	public boolean isActual() {
		return actual;
	}
	
}
