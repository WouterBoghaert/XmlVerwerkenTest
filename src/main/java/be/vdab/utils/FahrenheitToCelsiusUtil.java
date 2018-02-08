package be.vdab.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class FahrenheitToCelsiusUtil {
	private BigDecimal tempCelsius;
	
	public FahrenheitToCelsiusUtil(String tempFahrenheit) {
		tempCelsius = (new BigDecimal(tempFahrenheit).subtract(new BigDecimal(32))
			.multiply(new BigDecimal(5)).divide(new BigDecimal(9), MathContext.DECIMAL32)).setScale(1, RoundingMode.HALF_UP);
	}
	
	
	
	public BigDecimal getTempCelsius() {
		return tempCelsius;
	}
}
