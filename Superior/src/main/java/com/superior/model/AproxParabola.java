package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxParabola extends AproxBase implements AproximacionOperaciones {

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

}
