package com.superior.calculo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
	public Double redondear(Double numero, Integer decimales) {

		Double valor = (new BigDecimal(numero).setScale(decimales, RoundingMode.DOWN)).doubleValue();

		// String[] partesNumericas = valor.toString().split("\\.");
		// for (int i = 0; i < (decimales - partesNumericas[1].length() ); i++)
		// {
		// partesNumericas[1] += "0";
		// }
		//
		// String numeroNuevo = partesNumericas[0] + "." + partesNumericas[1];
		// return Double.parseDouble(numeroNuevo);
		return valor;
	}
}
