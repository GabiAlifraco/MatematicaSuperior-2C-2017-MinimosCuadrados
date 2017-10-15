package com.superior.view;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import com.superior.model.dto.AproxData;
import com.superior.model.dto.AproxTable;

public class IngresoNumerosForm extends javax.swing.JFrame {
	ListModel<String> datosListaCoordenadas;

	public IngresoNumerosForm() {
		initComponentsJ();
		setTitle("AMIC");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(430, 310);
		setLocationRelativeTo(null);
		setVisible(true);

		datosListaCoordenadas = new DefaultListModel();
	}

	private void initComponentsJ() {

		jProgressBar1 = new javax.swing.JProgressBar();
		jScrollPane1 = new javax.swing.JScrollPane();
		lstCoordenadas = new javax.swing.JList();
		cmbQuitarCoordenada = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		lblCoordenadaX = new javax.swing.JLabel();
		txtCoordenadaX = new javax.swing.JTextField();
		txtCoordenadaY = new javax.swing.JTextField();
		lblCoordenadaX1 = new javax.swing.JLabel();
		cmbIngresarCoordenada = new javax.swing.JButton();
		cmbOperarConDatos = new javax.swing.JButton();
		panelDecimales = new javax.swing.JPanel();
		txtCantidadDecimales = new javax.swing.JTextField();
		lblCoordenadaX2 = new javax.swing.JLabel();
		panelNumerosIngresar = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jScrollPane1.setViewportView(lstCoordenadas);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(250, 40, 150, 120);

		cmbQuitarCoordenada.setText("Quitar Coordenada");
		cmbQuitarCoordenada.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbQuitarCoordenadaActionPerformed(evt);
			}
		});
		getContentPane().add(cmbQuitarCoordenada);
		cmbQuitarCoordenada.setBounds(250, 170, 150, 23);

		jPanel1.setBackground(new java.awt.Color(204, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblCoordenadaX.setText("Coordenada X");

		lblCoordenadaX1.setText("Coordenada Y");

		cmbIngresarCoordenada.setText("Ingresar");
		cmbIngresarCoordenada.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbIngresarCoordenadaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(cmbIngresarCoordenada, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(lblCoordenadaX, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addComponent(lblCoordenadaX1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addComponent(txtCoordenadaY).addComponent(txtCoordenadaX, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(lblCoordenadaX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(txtCoordenadaX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(lblCoordenadaX1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(txtCoordenadaY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE).addComponent(cmbIngresarCoordenada).addContainerGap()));
		jPanel1.setLayout(jPanel1Layout);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(20, 90, 190, 100);

		cmbOperarConDatos.setText("Operar con Datos");
		getContentPane().add(cmbOperarConDatos);
		cmbOperarConDatos.setBounds(130, 210, 190, 23);

		panelDecimales.setBackground(new java.awt.Color(204, 255, 255));
		panelDecimales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		lblCoordenadaX2.setText("Cantidad Decimales");

		javax.swing.GroupLayout panelDecimalesLayout = new javax.swing.GroupLayout(panelDecimales);
		panelDecimalesLayout.setHorizontalGroup(panelDecimalesLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, panelDecimalesLayout.createSequentialGroup().addContainerGap().addComponent(lblCoordenadaX2, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED).addComponent(txtCantidadDecimales, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		panelDecimalesLayout.setVerticalGroup(panelDecimalesLayout.createParallelGroup(Alignment.TRAILING).addGroup(panelDecimalesLayout.createSequentialGroup().addContainerGap().addGroup(panelDecimalesLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCoordenadaX2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(txtCantidadDecimales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
		panelDecimales.setLayout(panelDecimalesLayout);

		getContentPane().add(panelDecimales);
		panelDecimales.setBounds(20, 40, 190, 40);

		panelNumerosIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/superior/view/principal.jpg"))); // NOI18N
		getContentPane().add(panelNumerosIngresar);
		panelNumerosIngresar.setBounds(0, 0, 448, 340);

		cmbOperarConDatos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbOperarConDatosActionPerformed(evt);
			}
		});

	}

	// Variables declaration - do not modify
	private javax.swing.JButton cmbIngresarCoordenada;
	private javax.swing.JButton cmbOperarConDatos;
	private javax.swing.JButton cmbQuitarCoordenada;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblCoordenadaX;
	private javax.swing.JLabel lblCoordenadaX1;
	private javax.swing.JLabel lblCoordenadaX2;
	private javax.swing.JList<String> lstCoordenadas;
	private javax.swing.JPanel panelDecimales;
	private javax.swing.JLabel panelNumerosIngresar;
	private javax.swing.JTextField txtCantidadDecimales;
	private javax.swing.JTextField txtCoordenadaX;
	private javax.swing.JTextField txtCoordenadaY;
	// End of variables declaration

	private void cmbIngresarCoordenadaActionPerformed(java.awt.event.ActionEvent evt) {
		String valorX = this.txtCoordenadaX.getText();
		String valorY = this.txtCoordenadaY.getText();

		if (valorX.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error. Debe ingresar la coordenad X.");
			return;
		}

		if (valorY.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error. Debe ingresar la coordenad Y.");
			return;
		}

		try {
			Double.parseDouble(valorX);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error. El formato de la coordenada X debe ser un numero");
			return;
		}

		try {
			Double.parseDouble(valorY);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error. El formato de la coordenada Y debe ser un numero");
			return;
		}

		String coordenada = "(" + valorX + ";" + valorY + ")";
		((DefaultListModel) datosListaCoordenadas).addElement(coordenada);
		this.lstCoordenadas.setModel(this.datosListaCoordenadas);

		this.txtCoordenadaX.setText("");
		this.txtCoordenadaY.setText("");
	}

	private void cmbQuitarCoordenadaActionPerformed(java.awt.event.ActionEvent evt) {
		Integer elementosSeleccionado = this.lstCoordenadas.getSelectedIndex();
		if (elementosSeleccionado != -1) {
			((DefaultListModel) datosListaCoordenadas).removeElementAt(elementosSeleccionado);
		}

	}

	private void cmbOperarConDatosActionPerformed(java.awt.event.ActionEvent evt) {
		String cantidadDecimales = this.txtCantidadDecimales.getText();
		if (cantidadDecimales.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error. Debe ingresar la cantidad de Decimales.");
			return;
		}
		int numero=0;
		try {
			 numero = Integer.parseInt(cantidadDecimales);
			if (numero <= 0) {
				JOptionPane.showMessageDialog(this, "Error. La cantidad de decimales debe ser un numero mayor a cero");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error. La cantidad de decimales debe ser un numero mayor a cero");
			return;
		}

		if (this.datosListaCoordenadas.getSize() == 0) {
			JOptionPane.showMessageDialog(this, "Error. Debe ingresar al menos una coordenada");
			return;
		}

		AproxTable tablaDatos = new AproxTable(numero);
		for (int i = 0; i < this.datosListaCoordenadas.getSize(); i++) {
			String dato = this.datosListaCoordenadas.getElementAt(i);
			String[] numeros = dato.split(";");
			String numeroX = numeros[0].substring(1);
			String numeroY = numeros[1].substring(0, numeros[1].length() - 1);

			tablaDatos.agregarPunto(Double.parseDouble(numeroX), Double.parseDouble(numeroY));
		}
		
		
		AproximacionPantalla aproxPantallaMenu = new AproximacionPantalla(tablaDatos,numero);
		this.hide();
	}

}
