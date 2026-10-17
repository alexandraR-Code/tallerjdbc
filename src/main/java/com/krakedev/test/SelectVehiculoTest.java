package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.jdbc.SelectVehiculo;

public class SelectVehiculoTest {

	private static final Logger log = LogManager.getLogger(SelectVehiculoTest.class);

	public static void main(String[] args) {
		

		SelectVehiculo.select();

	}

}
