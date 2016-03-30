import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonCounter extends JFrame {

	private JButton button;

	private Counter counter;

	public ButtonCounter() {
		super("Counter");
		button = new JButton();
		counter = new Counter(button);
		button.setText("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!counter.isAlive()) {
					counter.start();
				}
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(button);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; i++) {
			new ButtonCounter();
		}
	}
}
