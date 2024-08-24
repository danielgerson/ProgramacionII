package com.mycompany.Herencia;

public class LlamadoPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// POO Alumnos
		Alumnos alumno = new Alumnos();
		alumno.setNombre("Daniel");
		alumno.setApellido("Barrios");
		alumno.setCUI("30054820600235");
		alumno.setEdad("20");
		alumno.setGrado("2do anio");
		alumno.setSeccion("B");
		
		// POO Profesores
		Profesores profesor = new Profesores();
		profesor.setNombre("Paolo");
		profesor.setApellido("Guerrero");
		profesor.setEdad("38");
		profesor.setCUI("58798755054");
		profesor.setMateria("Sistemas");
		profesor.setRol("Profesor Informatico");
		
		System.out.println("Datos De Alumno -> " + "Nombre: " +alumno.getNombre()+ " Apellido: " +alumno.getApellido()+ " CUI: " +alumno.getCUI()+ " Edad: " +alumno.getEdad()+ " Grado: " +alumno.getGrado()+ " Seccion: " +alumno.getSeccion());
		System.out.println("Datos De Profesor -> " + "Nombre: " +profesor.getNombre()+ " Apellido: " +profesor.getApellido()+ " CUI: " +profesor.getCUI()+ " Edad: " +profesor.getEdad()+ " Materia: " +profesor.getMateria()+ " Rol: " +profesor.getRol());
	}

}
