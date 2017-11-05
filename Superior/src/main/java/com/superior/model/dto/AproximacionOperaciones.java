package com.superior.model.dto;

import java.util.List;

public interface AproximacionOperaciones extends Comparable<AproximacionOperaciones> {
	public String[][] obtenerTablaCalculos();

	public String[] obtenerFilaSumarizadora();

	public String[] tablaCabecera();

	public List<AproxData> obtenerPuntosFuncionAproximacionParaGraficar() throws Exception;

	public List<AproxData> obtenerPuntosCoordenadasOriginales();

	public Double aplicarFuncion(Double x) throws Exception;

	public void calcularFuncionAproximacion() throws Exception;

	public List<Double> obtenerColumnaErrores() throws Exception;

	public Double minimoErrorCometido() throws Exception;

	public List<Double> obtenerColumnaFuncionAplicada() throws Exception;

	public String getNombre();

	public String detalleCalculo();
}
