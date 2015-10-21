package javat.text;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static double getHalfCalculate(double total, double divide) {
		DecimalFormat decimalFormat = new DecimalFormat("#.#");
		double totalDouble = Double.valueOf(decimalFormat.format(total / divide));
		int unit = (int) (totalDouble * 10) % 10;
		int tens = (int) (totalDouble * 10) / 10;
		total = tens;
		if (unit >= 3 && unit <= 7) {
			total = tens + 0.5;
		}
		if (unit > 7) {
			total = ++tens;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(getHalfCalculate(8, 3f));
	}
}
