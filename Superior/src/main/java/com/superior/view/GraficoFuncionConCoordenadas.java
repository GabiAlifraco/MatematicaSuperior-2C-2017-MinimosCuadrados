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

	private Boolean mostrarPuntos;

	List<Double> xCoordenada;
	List<Double> yCoordenada;

	private Double divisionX, divisionY;
	private Double xminimo, xmaximo, yminimo, ymaximo;
	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

	private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

	private static Color COLOR_FONDO_GRAFICA = Color.white;

	public GraficoFuncionConCoordenadas(List<Double> xFuncionAprox, List<Double> yFuncionAprox, List<Double> xCoordenada, List<Double> yCoordenada, double divisionX, double divisionY, double xminimo, double xmaximo, double yminimo, double ymaximo, boolean mostrarPuntos) {
		super("GRAFICO COMPARATIVO");
		this.x = xFuncionAprox;
		this.y = yFuncionAprox;
		this.xCoordenada = xCoordenada;
		this.yCoordenada = yCoordenada;
		this.divisionX = divisionX;
		this.divisionY = divisionY;
		setTitle("AMIC");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(600, 570);
		setLocationRelativeTo(null);
		setVisible(true);
		this.mostrarPuntos = mostrarPuntos;
		this.xminimo = xminimo;
		this.xmaximo = xmaximo;
		this.yminimo = yminimo;
		this.ymaximo = ymaximo;
	}

	public BufferedImage creaImagen() {

		final XYSeries serie1 = new XYSeries("Función Aproximada");
		for (int i = 0; i < x.size(); i++) {
			serie1.add(x.get(i), y.get(i));
		}

		final XYSeries ejex = new XYSeries("Eje X");

		ejex.add(xminimo, new Double(0));
		ejex.add(new Double(0), new Double(0));
		ejex.add(xmaximo, new Double(0));

		final XYSeries ejey = new XYSeries("Eje Y");
		// for (int i = 0; i < y.size(); i++) {
		ejey.add(new Double(0), yminimo);
		ejey.add(new Double(0), new Double(0));
		ejey.add(new Double(0), ymaximo);
		// }
		final XYSeriesCollection collection = new XYSeriesCollection();
		collection.addSeries(ejex);
		collection.addSeries(ejey);
		collection.addSeries(serie1);
		if (this.mostrarPuntos) {
			final XYSeries serie2 = new XYSeries("Puntos Ingresados");
			for (int i = 0; i < xCoordenada.size(); i++) {
				serie2.add(xCoordenada.get(i), yCoordenada.get(i));
			}
			collection.addSeries(serie2);
		}

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

		final JFreeChart chart = ChartFactory.createXYLineChart("", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);

		// color de fondo de la gráfica
		chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);

		final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		configurarDomainAxis(domainAxis, divisionX);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		configurarRangeAxis(rangeAxis, divisionY);
		//
		final XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		configurarRendered(renderer);

		return chart;
	}

	// configuramos el contenido del gráfico (damos un color a las líneas que
	// sirven de guía)
	private void configurarPlot(XYPlot plot) {
		plot.setDomainGridlinePaint(COLOR_RECUADROS_GRAFICA);
		plot.setRangeGridlinePaint(COLOR_RECUADROS_GRAFICA);
	}

	// configuramos el eje X de la gráfica (se muestran números enteros y de uno
	// en uno)
	private void configurarDomainAxis(NumberAxis domainAxis, double division) {
		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		domainAxis.setTickUnit(new NumberTickUnit(division));
	}

	// configuramos el eje y de la gráfica (números enteros de dos en dos y
	// rango entre 120 y 135)
	private void configurarRangeAxis(NumberAxis rangeAxis, double division) {
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setTickUnit(new NumberTickUnit(division));
		// rangeAxis.setRange(120, 135);
	}

	// configuramos las líneas de las series (añadimos un círculo en los puntos
	// y asignamos el color de cada serie)
	private void configurarRendered(XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(2, false);
		if (mostrarPuntos) {
			renderer.setSeriesShapesVisible(3, true);
			renderer.setSeriesLinesVisible(3, false);
		}
		renderer.setSeriesShapesVisible(0, false);
		renderer.setSeriesShapesVisible(1, false);
//		renderer.setSeriesLinesVisible(1, false);
		renderer.setSeriesPaint(0, COLOR_SERIE_1);
		renderer.setSeriesPaint(1, COLOR_SERIE_2);

		renderer.setSeriesShapesVisible(0, false);
		renderer.setSeriesShapesVisible(1, false);
		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.BLACK);
	}
}