package geoDash;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class level3bg extends JPanel implements ActionListener, Runnable {

	sprite p;

	public Image img;
	Timer time;
	int v = 472;
	Thread animator;

	boolean a = false;
	boolean done2 = false;

	public level3bg() {
		p = new sprite();
		addKeyListener(new AL());
		setFocusable(true);
		setBackground(new Color(34, 99, 118));
		ImageIcon i = new ImageIcon("level3.jpg");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
	}

	public void paint(Graphics g) {
		if (p.dy == 1 && done2 == false) {
			done2 = true;
			animator = new Thread(this);
			animator.start();
		}

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// checks to see where first background ends
		if ((p.getX() - 420) % 2400 == 0)// p.getX() == 590 || p.getX() == 2990)
			p.nx = 0;
		if ((p.getX() - 1200) % 2400 == 0)// p.getX() == 1790 || p.getX() ==
											// 4190)
			p.nx2 = 0;

		// creates scrolling background and adds new background each time first
		// one ends
		g2d.drawImage(img, 1200 - p.getnX2(), 0, null);
		if (p.getX() > 420) {
			g2d.drawImage(img, 1200 - p.getnX(), 0, null);
		}
		g2d.drawImage(p.getImage(), p.left, v, null);

		if (p.getdx() == -1) {
			g2d.drawImage(img, 1200 - p.getnX2(), 0, null);
			g2d.drawImage(p.getImage(), p.left, v, null);
		}
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
	}

	boolean h = false;
	boolean done = false;

	public void cycle() {

		if (h == false)
			v--;
		if (v == 405)
			h = true;
		if (h == true && v <= 472) {
			v++;
			if (v == 472) {
				done = true;
			}
		}
	}

	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		while (done == false) {

			cycle();

			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 10 - timeDiff;

			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}
		done = false;
		h = false;
		done2 = false;
	}

}