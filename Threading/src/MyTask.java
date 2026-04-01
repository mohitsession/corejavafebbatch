
public class MyTask implements Runnable {

	private String name;

	public MyTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(name + " implements Runnable count is " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
