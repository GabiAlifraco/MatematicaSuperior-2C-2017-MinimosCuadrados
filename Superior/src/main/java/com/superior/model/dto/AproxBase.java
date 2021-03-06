package com.superior.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.superior.calculo.NumberUtils;

public abstract class AproxBase implements Comparable<AproximacionOperaciones> {

	protected AproxTable tablaValores;

	protected Double A;
	protected Double B;
	protected String detalleCalculo;

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

	public Double minimoErrorCometido() throws Exception {
		List<Double> errores = obtenerColumnaErrores();
		Double sumatoria = 0D;
		for (Double error : errores) {
			sumatoria += num.redondear((error * error), this.cantidadDecimales);
		}
		return num.redondear(sumatoria, this.cantidadDecimales);
	}

	public List<Double> obtenerColumnaErrores() throws Exception {
		List<Double> erores = new ArrayList<Double>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();

			Double y = aplicarFuncion(x);

			Double errorCometido = num.redondear(y - punto.y(), this.cantidadDecimales);
			erores.add(errorCometido);
		}
		return erores;
	}

	public List<Double> obtenerColumnaFuncionAplicada() throws Exception {
		List<Double> valores = new ArrayList<Double>();
		for (AproxData punto : tablaValores.getDatos()) {
			Double x = punto.x();
			valores.add(num.redondear(aplicarFuncion(x), this.cantidadDecimales));
		}
		return valores;
	}

	public int compareTo(AproximacionOperaciones o) {
		try {
			return this.minimoErrorCometido().compareTo(o.minimoErrorCometido());
		} catch (Exception e) {
			return 0;
		}
	}

	protected Double obtenerYMaximo() {
		List<AproxData> datos = tablaValores.getDatos();
		Double maximo = 0D;
		boolean controlPrimeraVez = true;
		for (AproxData dato : datos) {
			if (controlPrimeraVez) {
				maximo = dato.y();
				controlPrimeraVez = false;
			} else {
				if (maximo < dato.y()) {
					maximo = dato.y();
				}
			}
		}
		return maximo;
	}

	protected Double obtenerYMinimo() {
		List<AproxData> datos = tablaValores.getDatos();
		Double minimo = 0D;
		boolean controlPrimeraVez = true;
		for (AproxData dato : datos) {
			if (controlPrimeraVez) {
				minimo = dato.y();
				controlPrimeraVez = false;
			} else {
				if (minimo > dato.y()) {
					minimo = dato.y();
				}
			}
		}
		return minimo;
	}

	public List<AproxData> obtenerPuntosFuncionAproximacionParaGraficar() throws Exception {
		List<AproxData> puntosGrafica = new ArrayList<AproxData>();
		Collections.sort(tablaValores.getDatos());
		AproxData puntoMinimo = tablaValores.getDatos().get(0);
		AproxData puntoMaximo = tablaValores.getDatos().get(tablaValores.getDatos().size() - 1);
		Double yMaximo = obtenerYMaximo();
		Double yMinimo = obtenerYMinimo();
		// int tope = (int) (Math.abs((puntoMinimo.x() - puntoMaximo.x())) * 4);
		// incrementoX = Math.abs((puntoMinimo.x() - puntoMaximo.x())) / tope;
		double tope = puntoMaximo.x();
		double i = puntoMinimo.x();
		double incrementoX = Math.abs((tope - i)) / this.cantidadDivisiones();
		while (i <= tope) {
			Double x = i;
			Double y = aplicarFuncion(x);
			if ((yMinimo <= y) && (y <= yMaximo)) {
				AproxData puntoGrafica = new AproxData(x, y, cantidadDecimales);
				puntosGrafica.add(puntoGrafica);
			}
			i += incrementoX;
		}
		Double y = aplicarFuncion(i);
		if ((yMinimo <= y) && (y <= yMaximo)) {
			AproxData puntoGrafica = new AproxData(i, y, cantidadDecimales);
			puntosGrafica.add(puntoGrafica);
		}
		return puntosGrafica;
	}

	public abstract double cantidadDivisiones();

	public Double aplicarFuncion(Double x) throws Exception {
		if (A == null || B == null) {
			try {
				calcularFuncionAproximacion();

			} catch (Exception e) {
				throw new Exception("No es posible para los datos ingresados calcular una aproximación " + this.getNombre());
			}
		}
		return num.redondear(funcion(x), cantidadDecimales);
	}

	public abstract void calcularFuncionAproximacion();

	public abstract String getNombre();

	protected abstract Double funcion(double valorX);

	public String detalleCalculo() {
		if (detalleCalculo == null) {
			calcularFuncionAproximacion();
		}
		return detalleCalculo;
	}

	public String obtenerAoBParaDetalle(Double valor) {

		if (valor >= 0)
			return ("+ " + valor);
		return ("- " + (valor) * -1);
	}
}
