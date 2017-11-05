package com.superior.model;

import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.calculo.NumberUtils;
import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;

public class AproxHiperbola extends AproxBase implements AproximacionOperaciones {

	public AproxHiperbola(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {
		String[][] valores = new String[tablaValores.getDatos().size()][6];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = NumberUtils.formatter(datos.x(), cantidadDecimales);
			valores[contador][2] = NumberUtils.formatter(datos.y(), cantidadDecimales);
			valores[contador][3] = NumberUtils.formatter(datos.xCuadrado(), cantidadDecimales);
			valores[contador][4] = NumberUtils.formatter(datos.inversaY(), cantidadDecimales);
			valores[contador][5] = NumberUtils.formatter(datos.XinversaY(), cantidadDecimales);
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {
		return new String[] { "\u03A3",NumberUtils.formatter(tablaValores.sumatoriaX(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaY(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaXCuadrado(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaInversaY(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatoriaXInversaY(), cantidadDecimales) };
	}

	public String[] tablaCabecera() {
		return new String[] { "i", "X", "Y", "X^2", "1/y", "X*(1/y)" };
	}

	public String getNombre() {
		return "Hiperbolica";
	}

	@Override
	public void calcularFuncionAproximacion() {
		EcuacionDosIncognitasUtils ecuacion = new EcuacionDosIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXInversaY(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatoriaInversaY(), cantidadDecimales);
		A = ecuacion.X();
		B = ecuacion.Y();

		A = num.redondear(Math.pow(ecuacion.X(), -1), cantidadDecimales);
		B = num.redondear(ecuacion.Y() / ecuacion.X(), cantidadDecimales);

		detalleCalculadoConFuncionObtenida(ecuacion);

	}

	public void detalleCalculadoConFuncionObtenida(EcuacionDosIncognitasUtils ecuacion) {

		String detalle = ecuacion.detalleCalculo();
		detalle += "\n --------------------------------------------------- ";
		detalle += "\n La Hiperbola de minimos cuadrados es H(X) = " + A + " /( " + obtenerAoBParaDetalle(B) + " + X) ";

		this.detalleCalculo = detalle;

	}

	@Override
	protected Double funcion(double valorX) {

		return A / (valorX + B);
	}

}
