package com.superior.view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	List<Integer> grafico;

	private Boolean mostrarPuntos;

	List<Double> xCoordenada;
	List<Double> yCoordenada;

	private Double divisionX, divisionY;
	private Double xminimo, xmaximo, yminimo, ymaximo;
	private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

	private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

	private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

	private static Color COLOR_FONDO_GRAFICA = Color.white;
	private int cantidadDecimales;

	public GraficoFuncionConCoordenadas(List<Double> xFuncionAprox, List<Double> yFuncionAprox, List<Double> xCoordenada, List<Double> yCoordenada, double divisionX, double divisionY, double xminimo, double xmaximo, double yminimo, double ymaximo, boolean mostrarPuntos, int cantidadDecimales, List<Integer> grafico) {
		super("GRAFICO COMPARATIVO");
		this.cantidadDecimales = cantidadDecimales;
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
		this.grafico = grafico;
	}

	final XYSeries serie1 = new XYSeries("Función Aproximada");
	final XYSeries serie1Hiper = new XYSeries(" ");

	public BufferedImage creaImagen() {

		for (int i = 0; i < x.size(); i++) {
			if (grafico.get(i) == 1) {
				serie1.add(x.get(i), y.get(i));
			} else if (grafico.get(i) == 2) {
				serie1Hiper.add(x.get(i), y.get(i));
			}
		}

		final XYSeriesCollection collection = new XYSeriesCollection();

		collection.addSeries(serie1);
		if (this.mostrarPuntos) {
			final XYSeries serie2 = new XYSeries("Puntos Ingresados");
			for (int i = 0; i < xCoordenada.size(); i++) {
				serie2.add(xCoordenada.get(i), yCoordenada.get(i));
			}
			collection.addSeries(serie2);
		}

		if(!serie1Hiper.isEmpty()){
			collection.addSeries(serie1Hiper);
		}
		JFreeChart chart = crearGrafica(collection);

		BufferedImage image = chart.createBufferedImage(500, 500);

		return image;
	}

	// supongo que esto es demaciado obvio pero sino entienden pregunten...
	public void paint(java.awt.Graphics g) {
		try {
			// super.paint(g);
			if (grafica == null) {
				grafica = this.creaImagen();
			}
			g.drawImage(grafica, 30, 30, null);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error. No es posible graficar la aproximacion");
			this.hide();
		}
	}

	public JFreeChart crearGrafica(XYSeriesCollection dataset) {

		final JFreeChart chart = ChartFactory.createXYLineChart("", "", "", dataset, PlotOrientation.VERTICAL, true, true, false);

		// color de fondo de la gráfica
		chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

		final XYPlot plot = (XYPlot) chart.getPlot();
		configurarPlot(plot);

		final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		configurarDomainAxis(domainAxis, divisionX, xminimo, xmaximo);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		configurarRangeAxis(rangeAxis, divisionY, yminimo, ymaximo);
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
	private void configurarDomainAxis(NumberAxis domainAxis, double division, double xmin, double xmax) {

		domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		NumberFormat numerFormat = NumberFormat.getInstance();
		numerFormat.setMaximumFractionDigits(cantidadDecimales);
		NumberTickUnit numero = new NumberTickUnit(division, numerFormat);
		domainAxis.setTickUnit(numero);
		domainAxis.setRange(xmin - divisionX, xmax + divisionX);
	}

	// configuramos el eje y de la gráfica (números enteros de dos en dos y
	// rango entre 120 y 135)
	private void configurarRangeAxis(NumberAxis rangeAxis, double division, double ymin, double ymax) {

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		NumberFormat numerFormat = NumberFormat.getInstance();
		numerFormat.setMaximumFractionDigits(cantidadDecimales);
		NumberTickUnit numero = new NumberTickUnit(division, numerFormat);
		rangeAxis.setTickUnit(numero);
		rangeAxis.setRange(ymin - divisionY, ymax + divisionY);
	}

	// configuramos las líneas de las series (añadimos un círculo en los puntos
	// y asignamos el color de cada serie)
	private void configurarRendered(XYLineAndShapeRenderer renderer) {
		renderer.setSeriesShapesVisible(0, false);
		renderer.setSeriesLinesVisible(0, true);
		if (mostrarPuntos) {
			renderer.setSeriesShapesVisible(1, true);
			renderer.setSeriesLinesVisible(1, false);
		}
		
		
		if(!serie1Hiper.isEmpty()){
			renderer.setSeriesShapesVisible(2, false);
			renderer.setSeriesLinesVisible(2, true);
		}
		// renderer.setSeriesShapesVisible(0, false);
		// renderer.setSeriesShapesVisible(1, false);
		// renderer.setSeriesLinesVisible(1, false);
		// renderer.setSeriesPaint(0, COLOR_SERIE_1);
		// renderer.setSeriesPaint(1, COLOR_SERIE_2);

		// renderer.setSeriesShapesVisible(0, false);
		// renderer.setSeriesShapesVisible(1, false);
		// renderer.setSeriesPaint(0, Color.BLACK);
		// renderer.setSeriesPaint(1, Color.BLACK);
	}
}