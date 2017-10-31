package com.superior.model;

import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxExponencial extends AproxBase implements AproximacionOperaciones {

	public AproxExponencial(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {

		String[][] valores = new String[tablaValores.getDatos().size()][6];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = datos.x().toString();
			valores[contador][2] = datos.y().toString();
			valores[contador][3] = datos.XlnY().toString();
			valores[contador][4] = datos.xCuadrado().toString();
			valores[contador][5] = datos.lnY().toString();
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3", tablaValores.sumatoriaX().toString(), tablaValores.sumatoriaY().toString(), tablaValores.sumatoriaXlnY().toString(), tablaValores.sumatoriaXCuadrado().toString(), tablaValores.sumatorialnY().toString() };
	}

	public String[] tablaCabecera() {
		return new String[] { "i", "X", "Y", "X . ln(Y)", "X\u00B2", "ln(Y)" };
	}

	public String getNombre() {
		return "Exponencial";
	}

	@Override
	public void calcularFuncionAproximacion() {

		EcuacionDosIncognitasUtils ecuacion = new EcuacionDosIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXlnY(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatorialnY(),cantidadDecimales);
		A = num.redondear(ecuacion.X(), cantidadDecimales);
		B = num.redondear(Math.exp(ecuacion.Y()), cantidadDecimales);
		detalleCalculadoConFuncionObtenida(ecuacion);
	}
	@Override
	protected Double funcion(double valorX) {

		return B * Math.pow(Math.E, A * valorX);
	}
	
	public void detalleCalculadoConFuncionObtenida(EcuacionDosIncognitasUtils ecuacion){
		
		String detalle = ecuacion.detalleCalculo();
		detalle += "\n --------------------------------------------------- ";
		detalle += "\n La Funcion Exponencial de minimos cuadrados es E(X) = "+ B +" e ^ " + A+" X"  ;
		
		this.detalleCalculo=detalle;
		
	}
	
	
	
	
	
	
	

}
