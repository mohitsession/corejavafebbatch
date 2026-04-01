
public class MyThread extends Thread {

	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(name+" extends Thread count is "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
