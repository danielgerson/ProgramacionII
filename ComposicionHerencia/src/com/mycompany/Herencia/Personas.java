package com.mycompany.Herencia;

public class Personas {

	private String CUI;
	private String nombre;
	private String apellido;
	private String edad;
	
	public Personas() {
		// TODO Auto-generated constructor stub
		CUI = null;
		nombre = null;
		apellido = null;
		edad = null;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}	

}
