package com.superior.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.superior.calculo.NumberUtils;

public class AproxTable {
	private List<AproxData> datos = new ArrayList<AproxData>();

	private Integer cantidadDecimales = 0;

	private NumberUtils num = new NumberUtils();

	public AproxTable(Integer cantidadDecimales) {
		super();
		this.cantidadDecimales = cantidadDecimales;
	}

	public void agregarPunto(double x, double y) {
		AproxData dato = new AproxData(x, y, cantidadDecimales);
		datos.add(dato);
	}

	public List<AproxData> getDatos() {
		return datos;
	}

	public Double sumatoria1() {
		return (double) datos.size();
	}

	public Double sumatoriaX() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.x(), cantidadDecimales);
		}
		return sumatoria;
	}

	public Double sumatoriaY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.y(), cantidadDecimales);
		}
		return sumatoria;
	}

	public Double sumatoriaXY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xy(), cantidadDecimales);
		}
		return sumatoria;
	}

	public Double sumatoriaXCuadrado() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xCuadrado(), cantidadDecimales);
		}
		return sumatoria;
	}
	public Double sumatoriaXlnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.XlnY(), cantidadDecimales);
		}
		return sumatoria;
	}
	
	public Double sumatorialnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnY(), cantidadDecimales);
		}
		return sumatoria;
	}
	public Double sumatorialnX() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnX(), cantidadDecimales);
		}
		return sumatoria;
	}
	
	public Double sumatorialnXCuadrado() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnXCuadrado(), cantidadDecimales);
		}
		return sumatoria;
	}
	
	public Double sumatorialnXlnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnXlnY(), cantidadDecimales);
		}
		return sumatoria;
	}
}
