package com.superior.view;

import javax.swing.JFrame;

import com.superior.controller.AproximacionController;
import com.superior.controller.IAproximacionController;
import com.superior.model.dto.AproxTable;

public class AproximacionPantalla extends javax.swing.JFrame {

	private AproxTable datos;
	private Integer cantidadDecimales;

	private IAproximacionController controller = new AproximacionController();

	public AproximacionPantalla(AproxTable datos, Integer cantidadDecimales) {
		this.datos = datos;
		this.cantidadDecimales = cantidadDecimales;
		initComponents();
		setTitle("AMIC");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(430, 350);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void cmdVisualizarAproximacionActionPerformed(java.awt.event.ActionEvent evt) {
		controller.visualizarAproximacion(obtenerTipoAproximacion(), datos, cantidadDecimales);
	}

	private void cmdVerCalculosActionPerformed(java.awt.event.ActionEvent evt) {
		controller.visualizarCalculos(obtenerTipoAproximacion(), datos, cantidadDecimales);
	}

	private void cmdVisualizarAproximacionCoordenadasActionPerformed(java.awt.event.ActionEvent evt) {
		controller.visualizarFuncionAproximadaConCoordenadas(obtenerTipoAproximacion(), datos, cantidadDecimales);
	}

	private void cmdCompararAproximacionesActionPerformed(java.awt.event.ActionEvent evt) {
		new VerComparacionForm(datos, cantidadDecimales);
		this.hide();
	}

	private void cmdFinalizarActionPerformed(java.awt.event.ActionEvent evt) {
		new IngresoNumerosForm();
		this.hide();
	}

	private String obtenerTipoAproximacion() {
		String[] aproximacionesPantalla = new String[] { "Recta de m�nimos cuadrados", "Par�bola de m�nimos cuadrados", "Aproximaci�n Exponencial", "Aproximaci�n Potencial", "Aproximaci�n Hip�rbola" };
		String[] tipoAproximacion = new String[] { "LINEAL", "PARABOLA", "EXPONENCIAL", "POTENCIAL", "HIPERBOLA" };

		String tipoAproximacionElegida = (String) this.cmbFunciones.getSelectedItem();

		for (int i = 0; i < aproximacionesPantalla.length; i++) {
			if (aproximacionesPantalla[i].equalsIgnoreCase(tipoAproximacionElegida)) {
				return tipoAproximacion[i];
			}
		}
		return null;
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		cmbFunciones = new javax.swing.JComboBox();
		cmdVisualizarAproximacion = new javax.swing.JButton();
		cmdVerCalculos = new javax.swing.JButton();
		cmdVisualizarAproximacionCoordenadas = new javax.swing.JButton();
		cmdCompararAproximaciones = new javax.swing.JButton();
		cmdFinalizar = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel2.setText("Tipo de Aproximaci�n");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(80, 80, 240, 20);

		cmbFunciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Recta de m�nimos cuadrados", "Par�bola de m�nimos cuadrados", "Aproximaci�n Exponencial", "Aproximaci�n Potencial", "Aproximaci�n Hip�rbola" }));
		getContentPane().add(cmbFunciones);
		cmbFunciones.setBounds(80, 110, 250, 20);

		cmdVisualizarAproximacion.setText("Visualizar Aproximaci�n");
		cmdVisualizarAproximacion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdVisualizarAproximacionActionPerformed(evt);
			}
		});
		getContentPane().add(cmdVisualizarAproximacion);
		cmdVisualizarAproximacion.setBounds(70, 170, 280, 23);

		cmdVerCalculos.setText("Ver C�lculos");
		cmdVerCalculos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdVerCalculosActionPerformed(evt);
			}
		});
		getContentPane().add(cmdVerCalculos);
		cmdVerCalculos.setBounds(70, 200, 280, 23);

		cmdVisualizarAproximacionCoordenadas.setText("Visualizar Aproximaci�n con Coordenadas");
		cmdVisualizarAproximacionCoordenadas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdVisualizarAproximacionCoordenadasActionPerformed(evt);
			}
		});
		getContentPane().add(cmdVisualizarAproximacionCoordenadas);
		cmdVisualizarAproximacionCoordenadas.setBounds(70, 230, 280, 23);

		cmdCompararAproximaciones.setText("Comparar Aproximaciones");
		cmdCompararAproximaciones.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdCompararAproximacionesActionPerformed(evt);
			}
		});
		getContentPane().add(cmdCompararAproximaciones);
		cmdCompararAproximaciones.setBounds(70, 290, 190, 23);

		cmdFinalizar.setText("Finalizar");
		cmdFinalizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdFinalizarActionPerformed(evt);
			}
		});
		getContentPane().add(cmdFinalizar);
		cmdFinalizar.setBounds(270, 290, 80, 23);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/superior/view/principal.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 615, 469);

	}// </editor-fold>

	private javax.swing.JComboBox cmbFunciones;
	private javax.swing.JButton cmdCompararAproximaciones;
	private javax.swing.JButton cmdFinalizar;
	private javax.swing.JButton cmdVerCalculos;
	private javax.swing.JButton cmdVisualizarAproximacion;
	private javax.swing.JButton cmdVisualizarAproximacionCoordenadas;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
}
