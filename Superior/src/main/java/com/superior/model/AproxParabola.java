package com.superior.model;

import com.superior.model.dto.AproxBase;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;
import com.superior.calculo.EcuacionDosIncognitasUtils;
import com.superior.calculo.EcuacionTresIncognitasUtils;
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
		valores[contador][1] = datos.x().toString();
		valores[contador][2] = datos.y().toString();
		valores[contador][3] = datos.xy().toString();
		valores[contador][4] = datos.xCuadrado().toString();
		valores[contador][5] = datos.xCubo().toString();
		valores[contador][6] = datos.xCuarta().toString();
		valores[contador][7] = datos.yxCuadrado().toString();
		contador++;
		}
	return valores;
	}

	public String[] obtenerFilaSumarizadora() {

		return new String[] { "\u03A3", 
				 tablaValores.sumatoriaX().toString(),
				 tablaValores.sumatoriaY().toString(),
				 tablaValores.sumatoriaXY().toString(),
				 tablaValores.sumatoriaXCuadrado().toString(),
				 tablaValores.sumatoriaXCubo().toString(),
				 tablaValores.sumatoriaXCuarta().toString(),
				 tablaValores.sumatoriaYXCuadrado().toString()};
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
		ecuacion.calcular(tablaValores.sumatoriaXCuarta(),
		tablaValores.sumatoriaXCubo(),
		tablaValores.sumatoriaXCuadrado(),
		tablaValores.sumatoriaYXCuadrado(),
		tablaValores.sumatoriaXCubo(),
		tablaValores.sumatoriaXCuadrado(),
		tablaValores.sumatoriaX(),
		tablaValores.sumatoriaXY(),
		tablaValores.sumatoriaXCuadrado(),
		tablaValores.sumatoriaX(),
		tablaValores.sumatoria1(),
		tablaValores.sumatoriaY(),
		cantidadDecimales);
		A =ecuacion.X();
		B =ecuacion.Y();
		C =ecuacion.Z();
		detalleCalculadoConFuncionObtenida(ecuacion);
	}

	public void detalleCalculadoConFuncionObtenida(EcuacionTresIncognitasUtils ecuacion){
			
			String detalle = ecuacion.detalleCalculo();
			detalle += "\n --------------------------------------------------- ";
			detalle += "\n La Parabola de minimos cuadrados es P(X) = "+ A +" X^2 + "+ B + " X + "+ C;
			detalle += "\n";
			
			this.detalleCalculo=detalle;
	}
	
	@Override
	protected Double funcion(double valorX) {

		return A * Math.pow(valorX, 2) + valorX * B + C;
	}

}
