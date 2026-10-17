package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.UpdateVehiculo;

public class UpdateVehiculoTest {
	private static final Logger log = LogManager.getLogger(UpdateVehiculoTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehiculo vehiculo = new Vehiculo("PDA-1355", "Cherry", "Tigo 7", 2020, 15000, "negro", true);

		UpdateVehiculo.update(vehiculo);

	}

}
