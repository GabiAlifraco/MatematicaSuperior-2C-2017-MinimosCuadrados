package com.superior.model.dto;

public class ErrorCuadratico implements Comparable<ErrorCuadratico> {
	private AproximacionOperaciones aproximacion;

	public AproximacionOperaciones getAproximacion() {
		return aproximacion;
	}

	public Double getErrorCuadratico() {
		return aproximacion.minimoErrorCometido();
	}

	public ErrorCuadratico(AproximacionOperaciones aproximacion, Double errorCuadratico) {
		super();
		this.aproximacion = aproximacion;
		
	}

	public int compareTo(ErrorCuadratico o) {
		return this.aproximacion.minimoErrorCometido().compareTo(o.aproximacion.minimoErrorCometido());
	}

}
