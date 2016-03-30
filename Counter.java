import javax.swing.JButton;

public class Counter extends Thread {
	private JButton button;

	private int counter = -1;

	public Counter(JButton b) {
		button = b;
		increase();
	}

	public void increase() {
		String label;
		synchronized (this) {
			label = Integer.toString(counter++);
		}
		button.setText(label);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		for (;;) {
			increase();
		}
	}
}
