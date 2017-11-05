package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;
import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.calculo.NumberUtils;

public class AproxPotencial extends AproxBase implements AproximacionOperaciones {

	public AproxPotencial(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {
		String[][] valores = new String[tablaValores.getDatos().size()][7];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = NumberUtils.formatter(datos.x(), cantidadDecimales);
			valores[contador][2] = NumberUtils.formatter(datos.y(), cantidadDecimales);
			valores[contador][3] = NumberUtils.formatter(datos.lnX(), cantidadDecimales);
			valores[contador][4] = NumberUtils.formatter(datos.lnXCuadrado(), cantidadDecimales);
			valores[contador][5] = NumberUtils.formatter(datos.lnY(), cantidadDecimales);
			valores[contador][6] = NumberUtils.formatter(datos.lnXlnY(), cantidadDecimales);
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3", NumberUtils.formatter(tablaValores.sumatoriaX(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatoriaY(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatorialnX(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatorialnXCuadrado(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatorialnY(), cantidadDecimales),NumberUtils.formatter(tablaValores.sumatorialnXlnY(), cantidadDecimales) };
	}

	public String[] tablaCabecera() {

		return new String[] { "i", "X", "Y", "ln(X)", "(ln(X))\u00B2", "ln(Y)", "ln(X).ln(Y)" };
	}

	public String getNombre() {
		return "Potencial";
	}

	@Override
	public void calcularFuncionAproximacion() {
		EcuacionDosIncognitasUtils ecuacion = new EcuacionDosIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatorialnXCuadrado(), tablaValores.sumatorialnX(), tablaValores.sumatorialnXlnY(), tablaValores.sumatorialnX(), tablaValores.sumatoria1(), tablaValores.sumatorialnY(), cantidadDecimales);
		A = ecuacion.X();
		B = num.redondear(Math.exp(ecuacion.Y()), cantidadDecimales);
		detalleCalculadoConFuncionObtenida(ecuacion);
	}

	@Override
	protected Double funcion(double valorX) {

		return A * Math.pow(valorX, B);
	}

	public void detalleCalculadoConFuncionObtenida(EcuacionDosIncognitasUtils ecuacion) {

		String detalle = ecuacion.detalleCalculo();
		detalle += "\n --------------------------------------------------- ";
		detalle += "\n La Funcion Potencial de minimos cuadrados es F(X) = " + B + " X ^ " + A;

		this.detalleCalculo = detalle;

	}

}
