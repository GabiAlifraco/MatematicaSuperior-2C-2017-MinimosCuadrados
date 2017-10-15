package com.superior.view;

import javax.swing.JFrame;

public class PantallaPrincipal extends javax.swing.JFrame {

	public PantallaPrincipal() {
		initComponentsJ();
		setTitle("AMIC");
		setAutoRequestFocus(false);
		setBounds(100, 100, 544, 360);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(480, 380);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponentsJ() {

		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel2.setText("BIENVENIDOS A AMIC");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(112, 115, 240, 40);

		jButton1.setText("INGRESAR");
		getContentPane().add(jButton1);
		jButton1.setBounds(151, 196, 151, 23);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/superior/view/principal.jpg")));
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 625, 371);
		
		jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

	}// </editor-f

	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new IngresoNumerosForm();
        this.hide();
    }  
	
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
}
