package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxParabola extends AproxBase implements AproximacionOperaciones {

	private Double C;

	public AproxParabola(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {

		return null;
	}

	public String[] obtenerFilaSumarizadora() {

		return null;
	}

	public String[] tablaCabecera() {

		return null;
	}

	public String getNombre() {
		return "Cuadratica";
	}

	@Override
	public void calcularFuncionAproximacion() {

	}

	@Override
	protected Double funcion(double valorX) {

		return A * Math.pow(valorX, 2) + valorX * B + C;
	}

}
