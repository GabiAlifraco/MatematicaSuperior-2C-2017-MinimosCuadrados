package com.superior.view;

import javax.swing.JFrame;

import com.superior.controller.AproximacionController;
import com.superior.controller.IAproximacionController;
import com.superior.model.dto.AproxTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setSize(438, 414);
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
		String[] aproximacionesPantalla = Messages_ES.aproximacionesPantalla;
		String[] tipoAproximacion = new String[] { "LINEAL", "PARABOLA", "EXPONENCIAL", "POTENCIAL", "HIPERBOLA" };

		String tipoAproximacionElegida = (String) this.cmbFunciones.getSelectedItem();

		for (int i = 0; i < aproximacionesPantalla.length; i++) {
			if (aproximacionesPantalla[i].equalsIgnoreCase(tipoAproximacionElegida)) {
				return tipoAproximacion[i];
			}
		}
		return null;
	}

	private void cmdVolver(ActionEvent arg0) {
		new IngresoNumerosForm(datos);
		this.hide();

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

		JButton btnVolver = new JButton();
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdVolver(arg0);
			}

		});
		btnVolver.setText("Volver ");
		btnVolver.setBounds(70, 317, 280, 23);
		getContentPane().add(btnVolver);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel2.setText(Messages_ES.lblTipoAproximacion);
		getContentPane().add(jLabel2);
		jLabel2.setBounds(80, 80, 240, 20);

		cmbFunciones.setModel(new javax.swing.DefaultComboBoxModel(Messages_ES.aproximaciones));
		getContentPane().add(cmbFunciones);
		cmbFunciones.setBounds(80, 110, 250, 20);

		cmdVisualizarAproximacion.setText(Messages_ES.cmdVisualizarAproximacion);
		cmdVisualizarAproximacion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdVisualizarAproximacionActionPerformed(evt);
			}
		});
		getContentPane().add(cmdVisualizarAproximacion);
		cmdVisualizarAproximacion.setBounds(70, 170, 280, 23);

		cmdVerCalculos.setText(Messages_ES.cmdVerCalculos);
		cmdVerCalculos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdVerCalculosActionPerformed(evt);
			}
		});
		getContentPane().add(cmdVerCalculos);
		cmdVerCalculos.setBounds(70, 200, 280, 23);

		cmdVisualizarAproximacionCoordenadas.setText(Messages_ES.cmdVisualizarAproximacionCoordenadas);
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
		cmdCompararAproximaciones.setBounds(70, 290, 280, 23);

		cmdFinalizar.setText("Finalizar");
		cmdFinalizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmdFinalizarActionPerformed(evt);
			}
		});
		getContentPane().add(cmdFinalizar);
		cmdFinalizar.setBounds(70, 351, 280, 23);

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
