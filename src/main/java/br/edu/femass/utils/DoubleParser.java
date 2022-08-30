package br.edu.femass.utils;

import java.text.DecimalFormat;

public class DoubleParser {
    private static DecimalFormat decimalFormat = new DecimalFormat("#,###,00");

    public static Double parse(Double value) {
        return  Double.parseDouble(decimalFormat.format(value));
    }
}
