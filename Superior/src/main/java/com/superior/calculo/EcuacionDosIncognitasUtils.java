package com.superior.calculo;

public class EcuacionDosIncognitasUtils {

	private Double x, y;

	/*
	 * Ax+By=C; Dx+Ey=F;O
	 */
	public void calcular(Double a, Double b, Double c, Double d, Double e, Double f) {

		y = ((f * a) - (d * c)) / ((e * a) - (d * b));
		x = (c - (b * y)) / a;

	}

	public Double X() {
		return x;
	}

	public Double Y() {
		return y;
	}

}