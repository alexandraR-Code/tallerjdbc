package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class SelectVehiculo {

	private static final Logger log = LogManager.getLogger(SelectVehiculo.class);

	public static void select() { // Método estático: se llama sin crear objeto; consulta (SELECT) y lista los
									// vehículos
		Connection con = null; // Connection: conexión abierta con PostgreSQL; null al inicio para poder
								// cerrarla en el finally
		PreparedStatement ps = null; // PreparedStatement: sentencia SQL precompilada que usa parámetros ? (evita
										// inyección SQL)
		ResultSet rs = null; // ResultSet: tabla de resultados del SELECT; se recorre fila por fila con
								// rs.next()

		String sql = """
				SElECT placa, marca, modelo, anio, precio, color, disponible FROM vehiculos;
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setPlaca(rs.getString("placa"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setModelo(rs.getString("modelo"));
				vehiculo.setAnio(rs.getInt("anio"));
				vehiculo.setPrecio(rs.getDouble("precio"));
				vehiculo.setColor(rs.getString("color"));
				vehiculo.setDisponible(rs.getBoolean("disponible"));

				System.out.println(vehiculo);
				log.info("vehiculo");
			}

		} catch (Exception e) {
			log.info("Ocurrio un error al mostrar dato sdel vehiculo: ", e.getMessage());
		} finally {
			try {
				con.close();
				ps.close();
				rs.close();
				log.info("Se cerraron la conexiones de forma correcta");
			} catch (SQLException e) {
				log.error("Ocurrio un error al cerrar la conexion: ", e.getMessage());
			}

		}

	}

}
