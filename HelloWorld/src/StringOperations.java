
public class StringOperations {

	public static void main(String[] args) {
		String greeting = "Hello";
		String name = "Ram ";
		String message = greeting + " , " + name.trim() + "!";
		System.out.println(message);

		System.out.println("NAME : " + name.toUpperCase());
		System.out.println("Length of message : " + message.length());
		
		String name2 = "Ram ";
		System.out.println("name is equal to name1 : "+name.equals(name2));
		
		String dupName = name;
		System.out.println("dupName is equal to name : "+(dupName == name));
		
		dupName = new String("Ram ");
		System.out.println("dupName is equal to name : " + (dupName == name));

		System.out.println("dupName is equal to name : " + (dupName.equals(name)));
		
	}

}
