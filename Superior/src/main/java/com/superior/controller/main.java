package com.superior.controller;

import com.superior.model.dto.AproxTable;
import com.superior.view.AproximacionPantalla;

public class main {

	public static void main(final String[] args) {
		AproxTable aprox = new AproxTable(11);
		aprox.agregarPunto(0.0000158 ,  296);
		aprox.agregarPunto(0.0000164 ,  320 );
		aprox.agregarPunto(0.0000186 ,  354 );
		aprox.agregarPunto(0.0000191 ,  348 );
		aprox.agregarPunto(0.0000196 ,  354 );
		aprox.agregarPunto(0.0000199 ,  382 );
		aprox.agregarPunto(0.0000229 ,  418 );
		aprox.agregarPunto(0.0000226 ,  410 );
		aprox.agregarPunto(0.0000233 ,  414 );
		new AproximacionPantalla(aprox,25);

	}

}
