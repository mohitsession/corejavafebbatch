
public class ThreadingExample {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread("T1");
		
		MyTask task = new MyTask("T2");
		Thread thread2 = new Thread(task);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Main thread execution is over");
	}

}
