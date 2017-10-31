
package com.superior.calculo;

import java.applet.*;
import java.net.*;
import java.awt.*;
import java.math.*;

public class Imagenes extends Applet {
	Button btnGraficar;
	TextField txtNum1, txtNum2;
	int num1, num2;

	public void init() {
		setLayout(null);

		btnGraficar = new Button("Graficar");
		txtNum1 = new TextField("-5");
		txtNum2 = new TextField("5");

		txtNum1.reshape(10, 10, 90, 20);
		txtNum2.reshape(110, 10, 90, 20);
		btnGraficar.reshape(310, 10, 60, 20);
		add(txtNum1);
		add(txtNum2);
		add(btnGraficar);
		show();
	}

	public void paint(Graphics p) {
		p.drawString("Ejemplo de Graficas en Applets", 110, 50);
		p.drawString("-- By Crysfel Villa", 130, 80);
		hacerGrafica();

	}

	public void hacerGrafica() {
		Graphics p = getGraphics();
		double punto, y;
		p.setColor(new Color(255, 255, 255));
		p.fillRect(51, 100, 299, 200); // Fondo para que borre a las anteriores
		p.setColor(new Color(0, 0, 0));
		p.drawLine(50, 300, 300, 300); // eje horizontal
		p.drawLine(150, 100, 150, 350); // eje vertical

		p.setColor(new Color(255, 0, 0));
		for (double x = num1; x < num2; x += 0.01) {
			punto = 150 + x * 30;
			y = 300 - Math.sin(x) * 30;
			p.drawLine((int) punto, (int) y, (int) punto + 1, (int) y + 1);
		}
	}

	public boolean getDatos() {
		boolean temp = true;
		try {
			num1 = Integer.parseInt(txtNum1.getText());
			num2 = Integer.parseInt(txtNum2.getText());
		} catch (Exception exc) {
			System.out.println("Error :)" + exc);
			temp = false;
		}
		return temp;
	}

	public boolean action(Event e, Object o) {
		if (e.target == btnGraficar) {
			if (getDatos())
				hacerGrafica();
		}
		return true;
	}

}