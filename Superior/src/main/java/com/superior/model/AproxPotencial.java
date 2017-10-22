package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;
import com.superior.calculo.EcuacionDosIncognitasUtils;

public class AproxPotencial extends AproxBase implements AproximacionOperaciones {

	public AproxPotencial(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {
		String[][] valores = new String[tablaValores.getDatos().size()][7];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = datos.x().toString();
			valores[contador][2] = datos.y().toString();
			valores[contador][3] = datos.lnX().toString();
			valores[contador][4] = datos.lnXCuadrado().toString();
			valores[contador][5] = datos.lnY().toString();
			valores[contador][6] = datos.lnXlnY().toString();
			contador++;
		}
		return valores;
	}
	
	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3", 
				tablaValores.sumatoriaX().toString(),
				tablaValores.sumatoriaY().toString(),
				tablaValores.sumatorialnX().toString(),
				tablaValores.sumatorialnXCuadrado().toString(),
				tablaValores.sumatorialnY().toString(),
				tablaValores.sumatorialnXlnY().toString()};
	}

	public String[] tablaCabecera() {
		
		return new String[] { "i", "X", "Y", "ln(X)", "(ln(X))\u00B2", "ln(Y)", "ln(X).ln(Y)"};
	}

	public String getNombre() {
		return "Potencial";
	}

	@Override
	public void calcularFuncionAproximacion() {
		EcuacionDosIncognitasUtils ecuacion = new EcuacionDosIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatorialnXCuadrado(), tablaValores.sumatorialnX(), tablaValores.sumatorialnXlnY(),
				tablaValores.sumatorialnX(), tablaValores.sumatoria1(), tablaValores.sumatorialnY());
		A =num.redondear( ecuacion.X(), cantidadDecimales); 
		B =num.redondear( Math.exp(ecuacion.Y()), cantidadDecimales);
		
	}

	

}
