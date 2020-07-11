package com.aipalbot.result.system.util;

import java.text.DecimalFormat;

public class CommonUtils {

	
	public static double roundTo2Decimal(double value) {
		 DecimalFormat f = new DecimalFormat("##.00");
		String val =  f.format(value);
		double myValue = Double.parseDouble(val);
		
		return myValue;
	}
}
