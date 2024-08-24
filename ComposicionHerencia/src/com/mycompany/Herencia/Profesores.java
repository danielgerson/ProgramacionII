package com.mycompany.Herencia;

public class Profesores extends Personas{
	private String materia;
	private String rol;

	public Profesores() {
		// TODO Auto-generated constructor stub
		materia = null;
		rol = null;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
}
