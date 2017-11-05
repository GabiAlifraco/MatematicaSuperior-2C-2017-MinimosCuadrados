package com.superior.controller;

import com.superior.model.dto.AproxTable;
import com.superior.view.VerComparacionForm;

public interface IAproximacionController {

	public void visualizarAproximacion(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales);

	public void visualizarCalculos(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales);

	public void visualizarFuncionAproximadaConCoordenadas(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales);

	public void compararErrorFunciones(VerComparacionForm form,int decimales);
}
