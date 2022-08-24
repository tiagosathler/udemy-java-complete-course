import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		System.out.print("Hello World! ");
		System.out.println("Good morning!");
		int y = 32;
		System.out.println(y);
		
		double x = 10.35784;
		System.out.println(x);
		System.out.printf("%.2f%n", x);
		System.out.printf("%.4f%n", x);
		Locale.setDefault(Locale.US);
		System.out.printf("%.4f%n", x);

		System.out.println("RESULTADO = " + x + " metros");
		System.out.printf("Resultado = %.2f metros%n", x);
		
		String nome = "Maria";
		int idade = 31;
		double renda = 4000.00;
		
		System.out.printf("%s tem %d anos e ganha R$ %.2f Reais%n", nome, idade, renda);
		
		Main.exercise();
	}
	
	public static void exercise() {
		String product1 = "Computer";
		String product2 = "Office desk";
		
		int age = 30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.00;
		double price2 = 650.50;
		double measure = 53.234567;
		
		Locale BRAZIL = new Locale("pt", "BR");
		
		Locale.setDefault(BRAZIL);
		
		String report = "%nProducts:%n"
				+ "%n"
				+ "%s, which price is $ %.2f%n"
				+ "%s, which price is $ %.2f%n"
				+ "%n"
				+ "Record: %d years old, code %d and gender: %s%n"
				+ "%n"
				+ "Rouded (three decimal places): %.3f%n"
				+ "US decimal point: %.2f %n";
		
		System.out.printf(report, product1, price1, product2, price2, age, code, gender, measure, measure);
	}

}
