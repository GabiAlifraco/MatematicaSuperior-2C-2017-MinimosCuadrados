package com.superior.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.superior.calculo.NumberUtils;

public class AproxTable {
	private List<AproxData> datos = new ArrayList<AproxData>();

	private Integer cantidadDecimales = 0;

	private NumberUtils num = new NumberUtils();

	public Integer getCantidadDecimales() {
		return cantidadDecimales;
	}

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
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.y(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xy(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXCuadrado() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xCuadrado(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXlnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.XlnY(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatorialnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnY(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatorialnX() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnX(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatorialnXCuadrado() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnXCuadrado(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatorialnXlnY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.lnXlnY(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXCubo() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xCubo(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXCuarta() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.xCuarta(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaYXCuadrado() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.yxCuadrado(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaInversaY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.inversaY(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

	public Double sumatoriaXInversaY() {
		Double sumatoria = 0D;
		for (AproxData dato : datos) {
			sumatoria += num.redondear(dato.XinversaY(), cantidadDecimales);
		}
		return num.redondear(sumatoria, cantidadDecimales);
	}

}
