
public class Variables {

	public static void main(String[] args) {
		// Whole Numbers

		short age = 17;
		long population = 800000000000000l;

		// Decimal numbers
		float temperature = 46.6666666f;
		double price = 21.6666666;

		// Character
		char grade = 'A';
		char dollar = '$';

		// Boolean
		boolean isLoggedIn = true;
		boolean isAdult = age >= 18;

		System.out.println("Age :" + age);
		System.out.println("Price :" + price);
		System.out.println("Grade : " + grade);
		System.out.println("Is Adult? " + isAdult);
		System.out.println("Population " + population);
		System.out.println("Temperature :" + temperature);
		System.out.println("price :" + price);

		int maxValue = Integer.MAX_VALUE;

		System.out.println("Max Value : " + maxValue);

		System.out.println("Max Value +100 : " + (maxValue + 100));
	}

}
