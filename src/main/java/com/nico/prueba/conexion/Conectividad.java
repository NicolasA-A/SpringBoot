package com.nico.prueba.conexion;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conectividad {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://GTD-134;databaseName=prueba;";
	private String usuario = "sa";
	private String contra = "1234";
	
	 protected Connection conectar() {
		try {
			Class.forName(driver);
			Connection cn = DriverManager.getConnection(url, usuario, contra);
			return cn;
		} catch(ClassNotFoundException | SQLException ex) {
			System.out.print("Error en conexion de bases de datos: " + ex);
			return null;
		}
	}
}
