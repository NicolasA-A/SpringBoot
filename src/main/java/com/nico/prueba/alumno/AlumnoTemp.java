package com.nico.prueba.alumno;

import org.springframework.stereotype.Component;

@Component("alumnoTemp")
public class AlumnoTemp implements Alumno {
	
	private String nombres;
	private String apellidos;
	private String grado;
	private String instructor;
	private int id;

	/*public AlumnoTemp(int id, String nombres, String apellidos, String grado, String instructor) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.grado = grado; 
		this.instructor = instructor;
	}*/

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getNombres() {
		// TODO Auto-generated method stub
		return this.nombres;
	}

	@Override
	public String getApellidos() {
		// TODO Auto-generated method stub
		return this.apellidos;
	}

	@Override
	public String getGrado() {
		// TODO Auto-generated method stub
		return this.grado;
	}

	@Override
	public String getInstructor() {
		// TODO Auto-generated method stub
		return this.instructor;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

}
