package com.nico.prueba.conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.nico.prueba.alumno.AlumnoTemp;

public class Consultas extends Conectividad {

	private List<String> datos;

	public Consultas(AlumnoTemp alumno) {
		List<String> lista = new ArrayList<String>();
		lista.add(alumno.getNombres()); // 0
		lista.add(alumno.getApellidos()); // 1
		lista.add(alumno.getGrado()); // 2
		lista.add(alumno.getInstructor()); // 3
		lista.add(Integer.toString(alumno.getId())); // 4
		this.datos = lista;
	}

	public void insertar() {
		String consulta = "insert into aprendices(nombres, apellidos, grado, instructor) values(?,?,?,?)";
		List<String> datos = this.datos;
		try {
			Connection cn = conectar();
			PreparedStatement ps = cn.prepareStatement(consulta);
			ps.setString(1, datos.get(0));
			ps.setString(2, datos.get(1));
			ps.setString(3, datos.get(2));
			ps.setString(4, datos.get(3));
			ps.executeUpdate();
			cn.close();
			JOptionPane.showMessageDialog(null, "Creado exitosamente!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta: " + e);
		}
	}

	public void eliminar() {
		String consulta = "delete from aprendices where id = ?";
		List<String> datos = this.datos;
		try {
			Connection cn = conectar();
			PreparedStatement ps = cn.prepareStatement(consulta);
			ps.setString(1, datos.get(4));
			ps.executeUpdate();
			cn.close();
			JOptionPane.showMessageDialog(null, "Eliminado exitosamente!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta: " + e);
		}
	}

	public void actualizar() {
		String consulta = "update aprendices set nombres = ?, apellidos = ?, grado = ?, instructor = ? where id = ?";
		List<String> datos = this.datos;
		try {
			Connection cn = conectar();
			PreparedStatement ps = cn.prepareStatement(consulta);
			ps.setString(1, datos.get(0));
			ps.setString(2, datos.get(1));
			ps.setString(3, datos.get(2));
			ps.setString(4, datos.get(3));
			ps.setString(5, datos.get(4));
			ps.executeUpdate();
			cn.close();
			JOptionPane.showMessageDialog(null, "Actualizado exitosamente!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta: " + e);
		}
	}
}
