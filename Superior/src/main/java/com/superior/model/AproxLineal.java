package com.superior.model;

import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxLineal extends AproxBase implements AproximacionOperaciones {

	public AproxLineal(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public void calcularFuncionAproximacion() {
		EcuacionDosIncognitasUtils ecuacion = new EcuacionDosIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXY(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatoriaY(),cantidadDecimales);
		A = ecuacion.X();
		B = ecuacion.Y();
		this.detalleCalculo = ecuacion.detalleCalculo();
	}

	public String[][] obtenerTablaCalculos() {
		String[][] valores = new String[tablaValores.getDatos().size()][5];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = datos.x().toString();
			valores[contador][2] = datos.y().toString();
			valores[contador][3] = datos.xy().toString();
			valores[contador][4] = datos.xCuadrado().toString();
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3", tablaValores.sumatoriaX().toString(), tablaValores.sumatoriaY().toString(), tablaValores.sumatoriaXY().toString(), tablaValores.sumatoriaXCuadrado().toString() };
	}

	public String[] tablaCabecera() {
		return new String[] { "i", "X", "Y", "X . Y", "X^2" };
	}

	public String getNombre() {
		return "Lineal";
	}
	@Override
	protected Double funcion( double valorX) {
	
		return A *valorX + B ;
	}

}
