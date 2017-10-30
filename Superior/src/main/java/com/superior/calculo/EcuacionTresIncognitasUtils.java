package com.superior.calculo;

public class EcuacionTresIncognitasUtils {

	private Double x, y, z;
	private String detalle = "";

	/*
	 * a1x+b1y+c1z=d1;
	 * a2x+b2y+c2z=d2;
	 * a3x+b3y+c3z=d3; 
	 */
	
	public double calcula_determinante(double A1, double B1, double C1, double A2, double B2, double C2, double A3, double B3, double C3){
		double resultado;
		resultado = (A1*B2*C3+B1*C2*A3+A2*B3*C1)-(C1*B2*A3+B1*A2*C3+C2*B3*A1);
		return resultado;
	}
	
	public void calcular(double a1, double b1, double c1, double d1,double a2, double b2,double c2, double d2, double a3, double b3,double c3,double d3, Integer cantidadDecimales){
	Double d;
	NumberUtils num = new NumberUtils();
	d = calcula_determinante(a1, b1, c1, a2, b2, c2, a3, b3, c3); //determinante
	x = (calcula_determinante(d1, b1, c1, d2, b2, c2, d3, b3, c3))/d;
	y = (calcula_determinante(a1, d1, c1, a2, d2, c2, a3, d3, c3))/d;
	z = (calcula_determinante(a1, b1, d1, a2, b2, d2, a3, b3, d3))/d;

	x = num.redondear(x, cantidadDecimales);
	y = num.redondear(y, cantidadDecimales);
	z = num.redondear(z, cantidadDecimales);
	generarDetalleCalculo(a1, b1, c1, d1, a2, b2, c2, d2, a3, b3, c3, d3, x, y, z);
	
	}
	
	private void generarDetalleCalculo(Double a1, Double b1, Double c1, Double d1,Double a2, Double b2, Double c2, Double d2, Double a3, Double b3, Double c3, Double d3, Double x, Double y, Double z) {
		detalle += "\n Sistema de Ecuaciones utilizado :";
		detalle += "\n --------------------------------------------";
		detalle += "\n" + a1.toString() + " . X + " + b1.toString() + " . Y = " + c1.toString() + "*" +d1.toString();
		detalle += "\n" + a2.toString() + " . X + " + b2.toString() + " . Y = " + c2.toString() + "*" +d2.toString();
		detalle += "\n" + a3.toString() + " . X + " + b3.toString() + " . Y = " + c3.toString() + "*" +d3.toString();

		detalle += "\n";
		detalle += "\n Detalle del Cálculo :";
		detalle += "\n ---------------------------";
		
		detalle += "\n x = " + x;
		detalle += "\n y = " + y;
		detalle += "\n z = " + z;
		
		detalle += "\n  ";
		detalle += "\n Funcion hallada para la aproximacion: ";
	}
	
	public String detalleCalculo() {
		return detalle;
	}


	public Double X() {
		return x;
	}

	public Double Y() {
		return y;
	}
	
	public Double Z() {
		return z;
	}
}