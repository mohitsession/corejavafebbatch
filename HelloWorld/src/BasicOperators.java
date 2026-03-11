
public class BasicOperators {

	public static void main(String[] args) {
		int a=17;
		int b=5;
		double a_double = 17;
		
//		int a=17, b=5;
		
		//Arithmetic
		System.out.println("a+b = " + (a+b));
		System.out.println("a-b = " + (a-b));
		System.out.println("a*b = " + (a*b));
		System.out.println("a/b = " + (a/b));
		System.out.println("a%b = " + (a%b));
		
		System.out.println("a/b (floating) = " + (double) a/b);
		System.out.println("a/b (floating) = " +  a_double/b);
		
		//Assignment Operators
		int age = 30;
		age = age + 1;
		System.out.println("age = age +1 : "+age);
		age++;
		System.out.println("age++ : "+age);
		age += 1;
		System.out.println("age += 1 : "+age);
		
		age -= 2;
		System.out.println("age -= 2 : "+age);
		age *= 2;
		System.out.println("age *= 2 : "+age);
		
		// Relational operators
//		a=5;
		System.out.println(" a is equal b : " + (a==b));

		System.out.println(" a is not equal b : " + (a!=b));
		
		System.out.println("a is greater than b : "+ (a>b));
		System.out.println("a is less than b : "+ (a<b));
		System.out.println("a is greater than equal to  b : "+ (a>=b));
		System.out.println("a is less than equal to b : "+ (a<=b));
		
		
		// logical operators
		boolean x=true, y=false;
		System.out.println("x and y : "+ (x && y));
		System.out.println("x or y : "+ (x || y));
		System.out.println(" Negation of x : "+ (!x));
		System.out.println("Negation of x or y : "+ !(x || y));
		
		boolean hasDriversLicense = true;
		boolean hasGoodGrades = true;
		boolean isRaining = false;
		
		boolean canGetCardDiscount = hasDriversLicense && hasGoodGrades;
		
		System.out.println("Can get Car Discount : "+canGetCardDiscount);
		
		System.out.println("Can go to park : " + (hasDriversLicense && !isRaining));
		
	}

}
