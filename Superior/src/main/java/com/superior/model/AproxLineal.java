package com.superior.model;

import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.calculo.NumberUtils;
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
		ecuacion.calcular(tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXY(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatoriaY(), cantidadDecimales);
		A = ecuacion.X();
		B = ecuacion.Y();
		detalleCalculadoConFuncionObtenida(ecuacion);
	}

	public String[][] obtenerTablaCalculos() {
		String[][] valores = new String[tablaValores.getDatos().size()][5];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = NumberUtils.formatter(datos.x(), cantidadDecimales);
			valores[contador][2] = NumberUtils.formatter(datos.y(), cantidadDecimales);
			valores[contador][3] = NumberUtils.formatter(datos.xy(), cantidadDecimales);
			valores[contador][4] = NumberUtils.formatter(datos.xCuadrado(), cantidadDecimales);
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3", NumberUtils.formatter(tablaValores.sumatoriaX(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaY(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaXY(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaXCuadrado(), cantidadDecimales)};
	}

	public String[] tablaCabecera() {
		return new String[] { "i", "X", "Y", "X . Y", "X^2" };
	}

	public String getNombre() {
		return "Lineal";
	}

	@Override
	protected Double funcion(double valorX) {

		return A * valorX + B;
	}

	public void detalleCalculadoConFuncionObtenida(EcuacionDosIncognitasUtils ecuacion) {

		String detalle = ecuacion.detalleCalculo();
		detalle += "\n --------------------------------------------------- ";
		detalle += "\n La Recta de minimos cuadrados es P(X) = " + A + " X  " + obtenerAoBParaDetalle(B);

		this.detalleCalculo = detalle;

	}

	@Override
	public double cantidadDivisiones() {

		return 5;
	}

}
