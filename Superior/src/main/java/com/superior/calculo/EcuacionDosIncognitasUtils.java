package com.superior.calculo;

public class EcuacionDosIncognitasUtils {

	private Double x, y;
	private String detalle = "";

	/*
	 * Ax+By=C; Dx+Ey=F;O
	 */
	public void calcular(Double a, Double b, Double c, Double d, Double e, Double f, Integer cantidadDecimales) {
		NumberUtils num = new NumberUtils();
		y = ((f * a) - (d * c)) / ((e * a) - (d * b));
		x = (c - (b * y)) / a;

		y = num.redondear(y, cantidadDecimales);
		x = num.redondear(x, cantidadDecimales);
		generarDetalleCalculo(a, b, c, d, e, f, x, y);
	}

	public Double X() {
		return x;
	}

	public Double Y() {
		return y;
	}

	public String detalleCalculo() {
		return detalle;
	}

	private void generarDetalleCalculo(Double a, Double b, Double c, Double d, Double e, Double f, Double x, Double y) {
		detalle += "\n Detalle del Cálculo";
		detalle += "\n" + a.toString() + " . X + " + b.toString() + " . Y = " + c.toString();
		detalle += "\n" + d.toString() + " . X + " + e.toString() + " . Y = " + f.toString();

		detalle += "\n";
		detalle += "\n y = ((" + f.toString() + "*" + a.toString() + ") - (" + d.toString() + "* " + c.toString() + ")) / ((" + e.toString() + " * " + a.toString() + ") - (" + d.toString() + " * " + b.toString() + "))";
		detalle += "\n y = " + y;
		detalle += "\n x = (" + c + " - (" + b + "* y)) / " + a;
		detalle += "\n x = (" + c + " - (" + b + "* " + y + ")) / " + a;
		detalle += "\n x = " + x;
	}

}