package com.superior.model.dto;

import com.superior.model.AproxExponencial;
import com.superior.model.AproxHiperbola;
import com.superior.model.AproxLineal;
import com.superior.model.AproxParabola;
import com.superior.model.AproxPotencial;

public class AproxFactory {
	public static AproximacionOperaciones crearAproximacion(String tipoAproximacion, AproxTable tablaValores, Integer cantidadDecimales) {
		if (tipoAproximacion.equalsIgnoreCase("LINEAL")) {
			return new AproxLineal(tablaValores,cantidadDecimales);
		} else if (tipoAproximacion.equalsIgnoreCase("PARABOLA")) {
			return new AproxParabola(tablaValores,cantidadDecimales);
		} else if (tipoAproximacion.equalsIgnoreCase("EXPONENCIAL")) {
			return new AproxExponencial(tablaValores,cantidadDecimales);
		} else if (tipoAproximacion.equalsIgnoreCase("POTENCIAL")) {
			return new AproxPotencial(tablaValores,cantidadDecimales);
		} else if (tipoAproximacion.equalsIgnoreCase("HIPERBOLA")) {
			return new AproxHiperbola(tablaValores,cantidadDecimales);
		}
		return null;
	}
}