package com.superior.view;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class VistaCalculosForm extends javax.swing.JFrame {

	public VistaCalculosForm(DefaultTableModel valores) {
		initComponents();
		this.tablaCalculos.setModel(valores);
		setTitle("CALCULOS");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(575, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		tablaCalculos = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// tablaCalculos.setModel(new javax.swing.table.DefaultTableModel(new
		// Object[][] { {}, {}, {}, {} }, new String[] {
		//
		// }));
		jScrollPane1.setViewportView(tablaCalculos);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(20, 60, 520, 220);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/superior/view/principal.jpg"))); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 570, 420);

		pack();
	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tablaCalculos;
	// End of variables declaration
}
