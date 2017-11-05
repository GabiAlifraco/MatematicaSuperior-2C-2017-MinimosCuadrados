package com.superior.model.dto;

import com.superior.calculo.NumberUtils;

public class AproxData implements Comparable<AproxData> {
	private Double x;
	private Double y;

	private NumberUtils num = new NumberUtils();
	private int cantidadDecimales;

	public AproxData(double x, double y, int cantidadDecimales) {
		this.x = x;
		this.y = y;
		this.cantidadDecimales = cantidadDecimales;
	}

	public Double x() {
		return num.redondear(x, cantidadDecimales);
	}

	public Double y() {
		return num.redondear(y, cantidadDecimales);
	}

	public Double xy() {
		return num.redondear(x * y, cantidadDecimales);
	}

	public Double xCuadrado() {
		return num.redondear(Math.pow(x, 2), cantidadDecimales);
	}

	public Double lnY() {
		return num.redondear(Math.log(y), cantidadDecimales);
	}

	public Double lnX() {
		return num.redondear(Math.log(x), cantidadDecimales);
	}

	public Double lnXCuadrado() {
		return num.redondear(Math.pow(lnX(), 2), cantidadDecimales);
	}

	public Double XlnY() {
		return num.redondear(x * lnY(), cantidadDecimales);
	}

	public Double lnXlnY() {
		return num.redondear(lnX() * lnY(), cantidadDecimales);
	}

	public Double xCubo() {
		return num.redondear(Math.pow(x, 3), cantidadDecimales);
	}

	public Double xCuarta() {
		return num.redondear(Math.pow(x, 4), cantidadDecimales);
	}

	public Double yxCuadrado() {
		return num.redondear(y * xCuadrado(), cantidadDecimales);
	}

	public Double inversaY() {
		return num.redondear(Math.pow(y, -1), cantidadDecimales);
	}

	public Double XinversaY() {
		return num.redondear(x * inversaY(), cantidadDecimales);
	}

	public int compareTo(AproxData o) {

		return this.x.compareTo(o.x);
	}

}
