package com.superior.model;

import java.util.ArrayList;
import java.util.List;

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
		ecuacion.calcular(tablaValores.sumatoriaXCuadrado(), tablaValores.sumatoriaX(), tablaValores.sumatoriaXY(), tablaValores.sumatoriaX(), tablaValores.sumatoria1(), tablaValores.sumatoriaY());
		A = ecuacion.X();
		B = ecuacion.Y();
	}

	public Double aplicarFuncion(Double x) {
		if (A == null || B == null) {
			calcularFuncionAproximacion();
		}
		return num.redondear((A * x + B), cantidadDecimales);
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

		return new String[] { "S", tablaValores.sumatoriaX().toString(), tablaValores.sumatoriaY().toString(), tablaValores.sumatoriaXY().toString(), tablaValores.sumatoriaXCuadrado().toString() };
	}

	public List<AproxData> obtenerPuntosFuncionAproximacionParaGraficar() {
		List<AproxData> puntosGrafica = new ArrayList<AproxData>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();
			Double y = aplicarFuncion(x);
			AproxData puntoGrafica = new AproxData(x, y, cantidadDecimales);
			puntosGrafica.add(puntoGrafica);
		}
		return puntosGrafica;
	}

	public String[] tablaCabecera() {

		return new String[] { "i", "X", "Y", "X . Y", "X^2" };
	}

	public String getNombre() {

		return "Lineal";
	}

	

}
