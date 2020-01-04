package geoDash;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class runner1 extends JFrame {

	// Masheil
	// sets frame - window title, size, visibility etc.
	public runner1() {
		JFrame frame = new JFrame();
		frame.add(new level1bg());
		frame.setTitle("Level 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 650);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		new runner1();
	}
}