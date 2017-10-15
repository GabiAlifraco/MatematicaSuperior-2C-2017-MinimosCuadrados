package com.superior.model.dto;

import com.superior.model.AproxLineal;

public class AproxFactory {
	public static AproximacionOperaciones crearAproximacion(String tipoAproximacion, AproxTable tablaValores, Integer cantidadDecimales) {
		if (tipoAproximacion.equalsIgnoreCase("LINEAL")) {
			return new AproxLineal(tablaValores,cantidadDecimales);
		} else if (tipoAproximacion.equalsIgnoreCase("PARABOLA")) {

		} else if (tipoAproximacion.equalsIgnoreCase("EXPONENCIAL")) {

		} else if (tipoAproximacion.equalsIgnoreCase("POTENCIAL")) {

		} else if (tipoAproximacion.equalsIgnoreCase("HIPERBOLA")) {

		}
		return null;
	}
}
