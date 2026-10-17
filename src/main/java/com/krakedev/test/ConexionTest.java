package com.krakedev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConexionTest {

	private static final Logger log = LogManager.getLogger(ConexionTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tallerjdbc", "postgres",
					"Maribel1995.");

			log.info("Conexion exitosa");

		} catch (SQLException e) {
			log.error("Error de conexion: " + e.getMessage());
		} finally {
			try {
				con.close();
				log.info("Conexion cerrada");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Conexion cerrada");
			}
		}

	}

}
