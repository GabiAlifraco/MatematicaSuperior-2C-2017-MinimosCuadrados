package com.superior.view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*
 * GraficoSimpleLin.java
 *
 * Created on 3 de noviembre de 2008, 8:11
 */
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Roberto Leon Cruz
 */
public class GraficoFuncionAproximacion extends javax.swing.JFrame {
	BufferedImage grafica = null;
	List<Double> x;
	List<Double> y;
	private String tipoFuncion;

	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

	private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

	private static Color COLOR_FONDO_GRAFICA = Color.white;

	public GraficoFuncionAproximacion(List<Double> x, List<Double> y, String tipoFuncion) {
		super("GRAFICO DE FUNCION APROXIMACION");
		this.x = x;
		this.y = y;
		this.tipoFuncion = tipoFuncion;
		setTitle("EMPRESA");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(600, 570);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public BufferedImage creaImagen() {
		// XYSeries es una clase que viene con el paquete JFreeChart
		// funciona como un arreglo con un poco mas de posibilidades

		XYSeries series = new XYSeries("Aproximacion " + tipoFuncion);
		// como su nombre lo indica el primer valor sera asignado al eje X
		// y el segundo al eje Y

		for (int i = 0; i < x.size(); i++) {
			series.add(x.get(i), y.get(i));
		}

		XYDataset juegoDatos = new XYSeriesCollection(series);

		JFreeChart chart = ChartFactory.createXYLineChart("", "Eje X", "Eje Y", juegoDatos, PlotOrientation.VERTICAL, true, true, true // Show
																																		// legend
		);

		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);

		final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		configurarDomainAxis(domainAxis);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		configurarRangeAxis(rangeAxis);
		//
		final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		configurarRendered(renderer);

		BufferedImage image = chart.createBufferedImage(500, 500);

		return image;
	}

	private void configurarPlot(XYPlot plot) {
		plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
		plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
	}

	private void configurarDomainAxis(NumberAxis domainAxis) {
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setTickUnit(new NumberTickUnit(1));
	}

	private void configurarRangeAxis(NumberAxis rangeAxis) {
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setTickUnit(new NumberTickUnit(1));

	}

	private void configurarRendered(XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesPaint(0, COLOR_SERIE_1);

	}

	public void paint(java.awt.Graphics g) {

		if (grafica == null) {
			grafica = this.creaImagen();
		}
		g.drawImage(grafica, 30, 30, null);
	}

}