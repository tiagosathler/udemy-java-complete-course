package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	private LocalDate manafactureDate;
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, double price, LocalDate manafactureDate) {
		super(name, price);
		this.manafactureDate = manafactureDate;
	}

	@Override
	public String priceTag() {
		return super.getName()
				+ " (used) $ "
				+ String.format("%.2f", super.getPrice())
				+ " (Manufacture date: "
				+ manafactureDate.format(fmt)
				+ ")";

	}
}
