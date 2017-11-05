package com.superior.view;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.superior.controller.AproximacionController;
import com.superior.controller.IAproximacionController;
import com.superior.model.dto.AproxTable;

public class VerComparacionForm extends javax.swing.JFrame {

	private AproxTable datos;
	private Integer cantidadDecimales;

	public boolean getChkExponencial() {
		return chkExponencial.getState();
	}

	public boolean getChkHiberbola() {
		return chkHiberbola.getState();

	}

	public boolean getChkLineal() {
		return chkLineal.getState();

	}

	public boolean getChkParabola() {
		return chkParabola.getState();

	}

	public boolean getChkPotencial() {
		return chkPotencial.getState();

	}

	public VerComparacionForm(AproxTable datos, Integer cantidadDecimales) {
		this.datos = datos;
		this.cantidadDecimales = cantidadDecimales;

		initComponents();
		this.lblMejorAproximacion.setText("");
		setTitle("AMIC");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(630, 480);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cmbCompararActionPerformed(java.awt.event.ActionEvent evt) {
		IAproximacionController aproxController = new AproximacionController();
		aproxController.compararErrorFunciones(this,cantidadDecimales);
	}

	private void cmbVolverActionPerformed(java.awt.event.ActionEvent evt) {
		AproximacionPantalla aprox = new AproximacionPantalla(datos, cantidadDecimales);
		this.hide();
	}

	private void initComponents() {

		chkHiberbola = new java.awt.Checkbox();
		chkLineal = new java.awt.Checkbox();
		chkParabola = new java.awt.Checkbox();
		chkPotencial = new java.awt.Checkbox();
		chkExponencial = new java.awt.Checkbox();
		jScrollPane1 = new javax.swing.JScrollPane();
		tablaComparacion = new javax.swing.JTable();
		cmbComparar = new javax.swing.JButton();
		cmbVolver = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		chkHiberbola.setLabel("Hiperbola");
		getContentPane().add(chkHiberbola);
		chkHiberbola.setBounds(500, 30, 100, 20);

		chkLineal.setLabel("Lineal");
		getContentPane().add(chkLineal);
		chkLineal.setBounds(20, 30, 100, 20);

		chkParabola.setLabel("Parábola");
		getContentPane().add(chkParabola);
		chkParabola.setBounds(140, 30, 100, 20);

		chkPotencial.setLabel("Potencial");
		getContentPane().add(chkPotencial);
		chkPotencial.setBounds(380, 30, 100, 20);

		chkExponencial.setLabel("Exponencial");
		getContentPane().add(chkExponencial);
		chkExponencial.setBounds(260, 30, 100, 20);

		tablaComparacion.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		jScrollPane1.setViewportView(tablaComparacion);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(20, 138, 580, 220);

		cmbComparar.setText("Comparar");
		cmbComparar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbCompararActionPerformed(evt);
			}
		});
		getContentPane().add(cmbComparar);
		cmbComparar.setBounds(260, 70, 120, 23);

		cmbVolver.setText("Volver");
		cmbVolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbVolverActionPerformed(evt);
			}
		});
		getContentPane().add(cmbVolver);
		cmbVolver.setBounds(500, 369, 90, 23);

		lblMejorAproximacion = new javax.swing.JLabel();
		lblMejorAproximacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		lblMejorAproximacion.setText("jLabel2");
		getContentPane().add(lblMejorAproximacion);
		lblMejorAproximacion.setBounds(20, 110, 580, 22);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/superior/view/principal.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 625, 470);

	}

	private java.awt.Checkbox chkExponencial;
	private java.awt.Checkbox chkHiberbola;
	private java.awt.Checkbox chkLineal;
	private java.awt.Checkbox chkParabola;
	private java.awt.Checkbox chkPotencial;
	private javax.swing.JButton cmbComparar;
	private javax.swing.JButton cmbVolver;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tablaComparacion;
	private javax.swing.JLabel lblMejorAproximacion;

	public Integer getDecimales() {

		return this.cantidadDecimales;
	}

	public AproxTable getTV() {

		return this.datos;
	}

	public JTable tablaCalculos() {

		return tablaComparacion;
	}

	public void setearTexto(String text) {
		lblMejorAproximacion.setText(text);
	}
}
