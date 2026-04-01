
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable hello = () -> {System.out.println("Hello");};
		
		hello.run();
	}

}


@FunctionalInterface
interface XYZ {
	void m1();
	default void m2() {
		// this is default implementation
		
	}
	
	default void m3() {
		// this is default implementation
		
	}
	
	static void m4() {
		
	}
	
static void m5() {
		
	}
}