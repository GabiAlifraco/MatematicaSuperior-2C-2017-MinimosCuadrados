package com.superior.calculo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
	public Double redondear(Double numero, Integer decimales) {
		return (new BigDecimal(numero).setScale(decimales,RoundingMode.DOWN)).doubleValue();
	}
}
