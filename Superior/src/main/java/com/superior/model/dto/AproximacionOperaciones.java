package com.superior.model.dto;

import java.util.List;

public interface AproximacionOperaciones extends Comparable<AproximacionOperaciones>{
	public String[][] obtenerTablaCalculos();

	public String[] obtenerFilaSumarizadora();

	public String[] tablaCabecera();

	public List<AproxData> obtenerPuntosFuncionAproximacionParaGraficar();

	public List<AproxData> obtenerPuntosCoordenadasOriginales();

	public Double aplicarFuncion(Double x);

	public void calcularFuncionAproximacion();

	public List<Double> obtenerColumnaErrores();

	public Double minimoErrorCometido();

	public List<Double> obtenerColumnaFuncionAplicada();

	public String getNombre();
}
