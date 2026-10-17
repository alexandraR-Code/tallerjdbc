package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class InsertVehiculo {
	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void insertar(Vehiculo vehiculo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible, kilometraje)
				VALUES (?,?,?,?,?,?,?,?)
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vehiculo.getPlaca());
			ps.setString(2, vehiculo.getMarca());
			ps.setString(3, vehiculo.getModelo());
			ps.setInt(4, vehiculo.getAnio());
			ps.setDouble(5, vehiculo.getPrecio());
			ps.setString(6, vehiculo.getColor());
			ps.setBoolean(7, vehiculo.isDisponible());
			ps.setInt(8, vehiculo.getKilometraje());

			int filas = ps.executeUpdate();

			log.info("Filas insertadas: " + filas);

		} catch (Exception e) {
			log.error("Ocurrio un error durante la ejecucion: " + e.getMessage());

		} finally {
			try {
				ps.close();
				con.close();
				log.info("Conexion cerrda");
			} catch (SQLException e) {
				log.error("Ocurrio un error al cerrar la conexion" + e.getMessage());
			}
		}
	}

}
