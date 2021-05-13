package com.nico.prueba.interfaz;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nico.prueba.Configuracion;
import com.nico.prueba.alumno.AlumnoTemp;
import com.nico.prueba.conexion.Consultas;

public class Formulario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bean = "alumnoTemp";
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		AlumnoTemp alumno = contexto.getBean(bean, AlumnoTemp.class);
		String resp = "";
		while(resp != null) {
			try {
				resp = JOptionPane.showInputDialog(null, "1: Crear nuevo alumno\n" + "2: Actualizar alumno\n" + 
						"3: Borrar alumno\n" + "0: Cerrar\n" + "Digita la opción que deseas:");
			} catch (HeadlessException e) {
				resp = "0";
			}
		switch (resp) {
		case "1":
			alumno.setNombres(JOptionPane.showInputDialog(null, "Nombres del alumno:"));
			alumno.setApellidos(JOptionPane.showInputDialog(null, "Apellidos del alumno:"));
			alumno.setGrado(JOptionPane.showInputDialog(null, "Grado del alumno:"));
			alumno.setInstructor(JOptionPane.showInputDialog(null, "Instructor del alumno:"));
			Consultas consulta1 = new Consultas(alumno);
			consulta1.insertar();
			break;
		case "2":
			alumno.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Id del alumno:")));
			alumno.setNombres(JOptionPane.showInputDialog(null, "Nombres del alumno:"));
			alumno.setApellidos(JOptionPane.showInputDialog(null, "Apellidos del alumno:"));
			alumno.setGrado(JOptionPane.showInputDialog(null, "Grado del alumno:"));
			alumno.setInstructor(JOptionPane.showInputDialog(null, "Instructor del alumno:"));
			Consultas consulta2 = new Consultas(alumno);
			consulta2.actualizar();
			break;
		case "3":
			alumno.setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Id del alumno:")));
			Consultas consulta3 = new Consultas(alumno);
			consulta3.eliminar();
			break;
		case "0":
			resp = null;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Respuesta no valida, intente de nuevo.");
			break;
		}
		}
		contexto.close();
	}

}
