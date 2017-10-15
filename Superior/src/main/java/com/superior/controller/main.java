package com.superior.controller;

import java.util.ArrayList;
import java.util.List;

import com.superior.model.AproxLineal;
import com.superior.model.dto.AproxTable;
import com.superior.view.GraficoFuncionAproximacion;
import com.superior.view.PantallaPrincipal;

public class main {

	public static void main(String[] args) {
//		ApoximacionLinealController app = new ApoximacionLinealController();
//		app.calcular();
		
		PantallaPrincipal pp= new PantallaPrincipal();
	//	IngresoNumerosForm ingreso = new IngresoNumerosForm();
		
//		AproxTable tablaValores = new AproxTable();
//		tablaValores.agregarPunto(1, 5);
//		tablaValores.agregarPunto(2, 6);
//		tablaValores.agregarPunto(3, 9);
//		tablaValores.agregarPunto(4, 8);
//		tablaValores.agregarPunto(6, 10);
//		AproximacionPantalla pantalla = new AproximacionPantalla(tablaValores);
	}

	public void calcular() {

		AproxTable tablaValores = new AproxTable(2);
		tablaValores.agregarPunto(1, 5);
		tablaValores.agregarPunto(2, 6);
		tablaValores.agregarPunto(3, 9);
		tablaValores.agregarPunto(4, 8);
		tablaValores.agregarPunto(5, 10);

		AproxLineal aprox = new AproxLineal(tablaValores,2);

		List<Double> puntosX = new ArrayList<Double>();

		List<Double> puntosY = new ArrayList<Double>();

		for (int i = -10; i < 11; i++) {
			puntosY.add(aprox.aplicarFuncion((double) i));
			puntosX.add((double) i);
		}

		GraficoFuncionAproximacion miventana = new GraficoFuncionAproximacion(puntosX, puntosY,"LINEAL");
		miventana.setSize(450, 450);

		miventana.show();
	}
}
