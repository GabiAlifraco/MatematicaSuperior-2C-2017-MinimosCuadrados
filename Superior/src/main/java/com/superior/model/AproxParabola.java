package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;
import com.superior.calculo.EcuacionTresIncognitasUtils;
import com.superior.calculo.NumberUtils;
import com.superior.model.dto.AproxData;

public class AproxParabola extends AproxBase implements AproximacionOperaciones {

	private Double C;

	public AproxParabola(AproxTable tablaValores, Integer cantidadDecimales) {
		super(tablaValores, cantidadDecimales);
	}

	public String[][] obtenerTablaCalculos() {

		String[][] valores = new String[tablaValores.getDatos().size()][9];
		int contador = 0;
		for (AproxData datos : tablaValores.getDatos()) {
			valores[contador][0] = (contador + 1) + "";
			valores[contador][1] = NumberUtils.formatter(datos.x(), cantidadDecimales);
			valores[contador][2] = NumberUtils.formatter(datos.y(), cantidadDecimales);
			valores[contador][3] = NumberUtils.formatter(datos.xy(), cantidadDecimales);
			valores[contador][4] = NumberUtils.formatter(datos.xCuadrado(), cantidadDecimales);
			valores[contador][5] = NumberUtils.formatter(datos.xCubo(), cantidadDecimales);
			valores[contador][6] = NumberUtils.formatter(datos.xCuarta(), cantidadDecimales);
			valores[contador][7] = NumberUtils.formatter(datos.yxCuadrado(), cantidadDecimales);
			contador++;
		}
		return valores;
	}

	public String[] obtenerFilaSumarizadora() {

		return new String[] { "\u03A3",NumberUtils.formatter( tablaValores.sumatoriaX(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaY(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaXY(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatoriaXCuadrado(), cantidadDecimales), NumberUtils.formatter(tablaValores.sumatoriaXCubo(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatoriaXCuarta(), cantidadDecimales),NumberUtils.formatter( tablaValores.sumatoriaYXCuadrado(), cantidadDecimales) };
	}

	public String[] tablaCabecera() {

		return new String[] { "i", "X", "Y", "X . Y", "X^2", "X^3", "X^4", "Y . X^2" };
	}

	public String getNombre() {
		return "Parabola";
	}

	@Override
	public void calcularFuncionAproximacion() {

		EcuacionTresIncognitasUtils ecuacion = new EcuacionTresIncognitasUtils();
		ecuacion.calcular(tablaValores.sumatoriaXCuarta(), tablaValores.sumatoriaXCubo(), tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaYXCuadrado(), tablaValores.sumatoriaXCubo(), tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXY(), tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatoriaY(), cantidadDecimales);
		A = ecuacion.X();
		B = ecuacion.Y();
		C = ecuacion.Z();
		detalleCalculadoConFuncionObtenida(ecuacion);
	}

	public void detalleCalculadoConFuncionObtenida(EcuacionTresIncognitasUtils ecuacion) {

		String detalle = ecuacion.detalleCalculo();
		detalle += "\n --------------------------------------------------- ";
		detalle += "\n La Parabola de minimos cuadrados es P(X) = " + A + " X^2 " + obtenerAoBParaDetalle(B) + " X " + obtenerAoBParaDetalle(C);
		detalle += "\n";

		this.detalleCalculo = detalle;
	}

	@Override
	protected Double funcion(double valorX) {

		return A * Math.pow(valorX, 2) + valorX * B + C;
	}

	@Override
	public double cantidadDivisiones() {
		
		return 30;
	}

}
