package com.superior.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxFactory;
import com.superior.model.dto.AproxTable;
import com.superior.model.dto.AproximacionOperaciones;
import com.superior.view.GraficoFuncionAproximacion;
import com.superior.view.GraficoFuncionConCoordenadas;
import com.superior.view.VerComparacionForm;
import com.superior.view.VistaCalculosForm;

public class AproximacionController implements IAproximacionController {

	public void visualizarAproximacion(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales) {
		AproximacionOperaciones aproximacion = AproxFactory.crearAproximacion(tipoAproximacion, datos, cantidadDecimales);

		try {

			List<AproxData> puntosFuncion = aproximacion.obtenerPuntosFuncionAproximacionParaGraficar();
			List<Double> x = new ArrayList<Double>();
			List<Double> y = new ArrayList<Double>();
			for (AproxData punto : puntosFuncion) {
				x.add(punto.x());
				y.add(punto.y());
			}
			new GraficoFuncionAproximacion(x, y, tipoAproximacion);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede calcular la aproximacion " + aproximacion.getNombre() + " con los datos ingresados");
		}
	}

	public void visualizarCalculos(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales) {
		AproximacionOperaciones aproximacion = AproxFactory.crearAproximacion(tipoAproximacion, datos, cantidadDecimales);

		try {
			DefaultTableModel dtm = new DefaultTableModel(aproximacion.obtenerTablaCalculos(), aproximacion.tablaCabecera());
			dtm.addRow(aproximacion.obtenerFilaSumarizadora());
			new VistaCalculosForm(dtm);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede calcular la aproximacion " + aproximacion.getNombre() + " con los datos ingresados");
		}
	}

	public void visualizarFuncionAproximadaConCoordenadas(String tipoAproximacion, AproxTable datos, Integer cantidadDecimales) {
		AproximacionOperaciones aproximacion = AproxFactory.crearAproximacion(tipoAproximacion, datos, cantidadDecimales);
		try {
			List<AproxData> puntosFuncion = aproximacion.obtenerPuntosFuncionAproximacionParaGraficar();
			List<Double> x = new ArrayList<Double>();
			List<Double> y = new ArrayList<Double>();
			List<Double> yCoordenada = new ArrayList<Double>();
			List<Double> xCoordenada = new ArrayList<Double>();
			for (AproxData punto : puntosFuncion) {
				x.add(punto.x());
				y.add(punto.y());
			}
			for (AproxData punto : datos.getDatos()) {
				yCoordenada.add(punto.y());
				xCoordenada.add(punto.x());
			}
			new GraficoFuncionConCoordenadas(x, y, xCoordenada, yCoordenada);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede calcular la aproximacion " + aproximacion.getNombre() + " con los datos ingresados");
		}
	}

	public void compararErrorFunciones(VerComparacionForm form) {
		List<AproximacionOperaciones> aproximacionesElegidas = obtenerAproximacionesElegidas(form);

		if (aproximacionesElegidas == null)
			return;
		try {
			String[] cabecera = new String[3 + (2 * aproximacionesElegidas.size())];
			cabecera[0] = "i";
			cabecera[1] = "X";
			cabecera[2] = "Y";

			List<List<Double>> columnasErrores = new ArrayList<List<Double>>();
			List<List<Double>> columnasValores = new ArrayList<List<Double>>();
			int indiceCabecara = 3;
			for (AproximacionOperaciones aproximacion : aproximacionesElegidas) {

				columnasValores.add(aproximacion.obtenerColumnaFuncionAplicada());
				columnasErrores.add(aproximacion.obtenerColumnaErrores());
				cabecera[indiceCabecara] = aproximacion.getNombre();
				cabecera[indiceCabecara + aproximacionesElegidas.size()] = aproximacion.getNombre();
				indiceCabecara++;
			}
			int cantidadFilas = form.getTV().getDatos().size();
			String[][] tabla = new String[cantidadFilas][3 + (2 * aproximacionesElegidas.size())];
			for (int i = 0; i < cantidadFilas; i++) {
				tabla[i][0] = i + 1 + "";
				tabla[i][1] = form.getTV().getDatos().get(i).x().toString();
				tabla[i][2] = form.getTV().getDatos().get(i).y().toString();
				for (int j = 0; j < columnasErrores.size(); j++) {

					tabla[i][j + 3] = columnasValores.get(j).get(i).toString();
					tabla[i][j + 3 + aproximacionesElegidas.size()] = columnasErrores.get(j).get(i).toString();
				}
			}
			DefaultTableModel dtm = new DefaultTableModel(tabla, cabecera);
			form.tablaCalculos().setModel(dtm);

			Collections.sort(aproximacionesElegidas);
			form.setearTexto("La mejor aproximaciòn es " + aproximacionesElegidas.get(0).getNombre() + ".Su error cuadratico es " + aproximacionesElegidas.get(0).minimoErrorCometido());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private List<AproximacionOperaciones> obtenerAproximacionesElegidas(VerComparacionForm form) {
		List<AproximacionOperaciones> aproximaciones = new ArrayList<AproximacionOperaciones>();
		int contadorCheckeos = 0;
		if (form.getChkLineal()) {
			contadorCheckeos++;
			aproximaciones.add(AproxFactory.crearAproximacion("LINEAL", form.getTV(), form.getDecimales()));
		}

		if (form.getChkParabola()) {
			contadorCheckeos++;
			aproximaciones.add(AproxFactory.crearAproximacion("PARABOLA", form.getTV(), form.getDecimales()));
		}

		if (form.getChkPotencial()) {
			contadorCheckeos++;
			aproximaciones.add(AproxFactory.crearAproximacion("POTENCIAL", form.getTV(), form.getDecimales()));
		}

		if (form.getChkHiberbola()) {
			contadorCheckeos++;
			aproximaciones.add(AproxFactory.crearAproximacion("HIPERBOLA", form.getTV(), form.getDecimales()));
		}

		if (form.getChkExponencial()) {
			contadorCheckeos++;
			aproximaciones.add(AproxFactory.crearAproximacion("EXPONENCIAL", form.getTV(), form.getDecimales()));
		}

		if (contadorCheckeos <= 1) {
			JOptionPane.showMessageDialog(form, "Debe seleccionar al menos dos aproximaciones para comparar.");
			return null;
		}
		return aproximaciones;
	}

}
