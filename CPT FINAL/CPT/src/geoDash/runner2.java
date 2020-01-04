package geoDash;

import javax.swing.JFrame;

public class runner2 extends JFrame {

	// Aparna
	// sets frame - window title, size, visibility etc.
	public runner2() {
		JFrame frame = new JFrame();
		frame.add(new level2bg());
		frame.setTitle("Level 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 650);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new runner2();
	}
}