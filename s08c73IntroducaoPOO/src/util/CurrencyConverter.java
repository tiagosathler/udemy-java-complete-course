package util;

public class CurrencyConverter {
	private static final double IOF = 6.00;

	public static double getPaid(double exchange, double bought) {
		return (bought * exchange) * (1 + IOF / 100);
	}
}
