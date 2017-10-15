package com.superior.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.superior.calculo.NumberUtils;

public abstract class AproxBase implements Comparable<AproximacionOperaciones> {

	protected AproxTable tablaValores;

	protected Double A;
	protected Double B;

	protected Integer cantidadDecimales;
	protected NumberUtils num = new NumberUtils();

	public AproxBase(AproxTable tablaValores, Integer cantidadDecimales) {
		this.tablaValores = tablaValores;
		this.cantidadDecimales = cantidadDecimales;
	}

	public List<AproxData> obtenerPuntosCoordenadasOriginales() {
		List<AproxData> puntosGrafica = new ArrayList<AproxData>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();
			Double y = punto.y();
			AproxData puntoGrafica = new AproxData(x, y, cantidadDecimales);
			puntosGrafica.add(puntoGrafica);
		}
		return puntosGrafica;
	}

	public Double minimoErrorCometido() {
		List<Double> errores = obtenerColumnaErrores();
		Double sumatoria = 0D;
		for (Double error : errores) {
			sumatoria += num.redondear((error * error), this.cantidadDecimales);
		}
		return num.redondear(sumatoria, this.cantidadDecimales);
	}

	public List<Double> obtenerColumnaErrores() {
		List<Double> erores = new ArrayList<Double>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();
			Double y = aplicarFuncion(x);

			Double errorCometido = num.redondear(y - punto.y(), this.cantidadDecimales);
			erores.add(errorCometido);
		}
		return erores;
	}

	public List<Double> obtenerColumnaFuncionAplicada() {
		List<Double> valores = new ArrayList<Double>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();
			valores.add(num.redondear(aplicarFuncion(x), this.cantidadDecimales));
		}
		return valores;
	}

	public int compareTo(AproximacionOperaciones o) {
		return this.minimoErrorCometido().compareTo(o.minimoErrorCometido());
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

	public Double aplicarFuncion(Double x) {
		if (A == null || B == null) {
			calcularFuncionAproximacion();
		}
		return num.redondear((A * x + B), cantidadDecimales);
	}

	public abstract void calcularFuncionAproximacion();
}
