package geoDash;

import javax.swing.JFrame;

public class runner3 extends JFrame {

	public runner3() {
		JFrame frame = new JFrame();
		frame.add(new level3bg());
		frame.setTitle("Level 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 650);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new runner3();
	}
}