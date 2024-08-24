package com.mycompany.Herencia;

public class Alumnos extends Personas {
	private String grado;
	private String seccion;

	public Alumnos() {
		// TODO Auto-generated constructor stub
		grado = null;
		seccion = null;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	
}
