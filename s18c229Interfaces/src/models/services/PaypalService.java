package models.services;

public class PaypalService implements OnlinePaymentService {
	final private static double FEES = 0.01;
	final private static double PAY_RATE = 0.02;

	@Override
	public double interest(double amount, int months) {
		return amount * FEES * months;
	}

	@Override
	public double paymentFee(double amount) {
		return amount * PAY_RATE;
	}
}
