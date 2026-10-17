package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);

	public static void delete(String placa) {
		if (placa == null || placa.isBlank()) {
			log.info("Placa es vacia a null");
			return;
		}

		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
					DELETE from vehiculos where placa = ?;
				""";
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, placa);

			int filas = ps.executeUpdate();
			log.info("Filas eliminadas: " + filas);
		} catch (Exception e) {
			log.error("Ocurrio un error al eliminar vehiculo: " + e.getMessage());

		} finally {
			try {
				con.close();
				ps.close();
				log.info("Conexion cerrada");
			} catch (Exception e2) {
				log.error("Ocurrio un error al eliminar vehiculo: " + e2.getMessage());

			}
		}

	}

}
