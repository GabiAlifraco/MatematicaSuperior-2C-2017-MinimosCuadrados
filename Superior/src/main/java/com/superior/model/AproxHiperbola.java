package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxHiperbola extends AproxBase implements AproximacionOperaciones {

	public AproxHiperbola(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);		
	}

	public String[][] obtenerTablaCalculos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] obtenerFilaSumarizadora() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] tablaCabecera() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void calcularFuncionAproximacion() {
		// TODO Auto-generated method stub

	}
	@Override
	protected Double funcion( double valorX) {
	
		return A/(valorX+B);
	}

}
