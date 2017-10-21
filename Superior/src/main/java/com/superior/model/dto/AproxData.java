package com.superior.model.dto;

import com.superior.calculo.NumberUtils;

public class AproxData {
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
	public Double lnY(){
		return num.redondear(Math.log(y), cantidadDecimales);
	}
	
	public Double XlnY(){
		return num.redondear(x * lnY(), cantidadDecimales);
	}
	
	
	
	
}
