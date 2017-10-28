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
public class GraficoFuncionConCoordenadas extends javax.swing.JFrame {
	BufferedImage grafica = null;
	List<Double> x;
	List<Double> y;

	List<Double> xCoordenada;
	List<Double> yCoordenada;

	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

	private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

	private static Color COLOR_FONDO_GRAFICA = Color.white;

	// http://foro.chuidiang.org/otras-herramientas-y-librerias/insertar-2-funciones-en-una-misma-grafica-con-jfreechart/
	// constructor
	public GraficoFuncionConCoordenadas(List<Double> xFuncionAprox, List<Double> yFuncionAprox, List<Double> xCoordenada, List<Double> yCoordenada) {
		super("GRAFICO COMPARATIVO");
		this.x = xFuncionAprox;
		this.y = yFuncionAprox;
		this.xCoordenada = xCoordenada;
		this.yCoordenada = yCoordenada;

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

		final XYSeries serie1 = new XYSeries("Puntos Ingresadas");
		for (int i = 0; i < x.size(); i++) {
			serie1.add(x.get(i), y.get(i));
		}

		final XYSeries serie2 = new XYSeries("Funci�n Aproximada");
		for (int i = 0; i < xCoordenada.size(); i++) {
			serie2.add(xCoordenada.get(i), yCoordenada.get(i));
		}

		final XYSeriesCollection collection = new XYSeriesCollection();
		collection.addSeries(serie1);
		collection.addSeries(serie2);

		// XYDataset juegoDatos = new XYSeriesCollection(collection);

		JFreeChart chart = crearGrafica(collection);

		BufferedImage image = chart.createBufferedImage(500, 500);

		return image;
	}

	// supongo que esto es demaciado obvio pero sino entienden pregunten...
	public void paint(java.awt.Graphics g) {
		// super.paint(g);
		if (grafica == null) {
			grafica = this.creaImagen();
		}
		g.drawImage(grafica, 30, 30, null);
	}

	public JFreeChart crearGrafica(XYSeriesCollection dataset) {

		final JFreeChart chart = ChartFactory.createXYLineChart("", "Eje X", "Eje Y", dataset, PlotOrientation.VERTICAL, true, true, false);
	
		
		// color de fondo de la gr�fica
		chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);

		final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		configurarDomainAxis(domainAxis);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		configurarRangeAxis(rangeAxis);
//
		final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		configurarRendered(renderer);

		return chart;
	}

	// configuramos el contenido del gr�fico (damos un color a las l�neas que
	// sirven de gu�a)
	private void configurarPlot(XYPlot plot) {
		plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
		plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
	}

	// configuramos el eje X de la gr�fica (se muestran n�meros enteros y de uno
	// en uno)
	private void configurarDomainAxis(NumberAxis domainAxis) {
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setTickUnit(new NumberTickUnit(1));
	}

	// configuramos el eje y de la gr�fica (n�meros enteros de dos en dos y
	// rango entre 120 y 135)
	private void configurarRangeAxis(NumberAxis rangeAxis) {
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setTickUnit(new NumberTickUnit(1));
//		rangeAxis.setRange(120, 135);
	}

	// configuramos las l�neas de las series (a�adimos un c�rculo en los puntos
	// y asignamos el color de cada serie)
	private void configurarRendered(XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesShapesVisible(1, true);
		renderer.setSeriesLinesVisible(1, false);
		renderer.setSeriesPaint(0, COLOR_SERIE_1);
		renderer.setSeriesPaint(1, COLOR_SERIE_2);
	}
}