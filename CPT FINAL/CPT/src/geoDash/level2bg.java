package geoDash;

/* Masheil Mir and Aparna Yogarajan
 * Level 2
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class level2bg extends JPanel implements ActionListener, Runnable {

	// Masheil
		// variable declaration
	BufferedImage obs1, obs2, obs3, obs4, obs5, obs6, obs7, obs9, obs8, gameover, top, bottom, spike;
	sprite p;
	JLabel endMsg = new JLabel(" Game over ");
	
	int score = 0;

	public Image img;
	Timer time;
	int v = 472;
	Thread animator;

	boolean a = false;
	boolean done2 = false;

	public level2bg() {
		p = new sprite();
		addKeyListener(new AL());
		setFocusable(true);
		setBackground(new Color (122, 74, 141));
		ImageIcon i = new ImageIcon("level2.jpg");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
		
		// gets obstacle images - Aparna
	       try {
	           obs1 = ImageIO.read(new File("tril2.png"));
	           obs2 = ImageIO.read(new File("obstl2.png"));
	           obs3 = ImageIO.read(new File("l2obst.png"));
	           obs4 = ImageIO.read(new File("tril2.png"));
	           obs5 = ImageIO.read(new File("l2obst.png"));
	           obs6 = ImageIO.read(new File("l2obst.png"));
	           obs7 = ImageIO.read(new File("tril2.png"));
	           obs8 = ImageIO.read(new File("obstl2.png"));
	           gameover = ImageIO.read(new File("gameOver.png"));
	           top = ImageIO.read(new File("l2top.png"));
	           bottom = ImageIO.read(new File("floorl2.png"));
	           spike = ImageIO.read(new File("extra2.png"));
	       } catch (IOException e) {
	       }   
	}

	// paints scrolling background - Masheil
	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
		
		// stops game when score exceeds a certain point - Aparna
		String eventName = e.getActionCommand();
		if (p.getX() == 4250) {
			JOptionPane.showMessageDialog(null, "You finished level 2!");
			menu menu = new menu();
			add(new menu());
			eventName.equals("done");

		}
	}
	// checks coordinates of sprite and background - Aparna
	public void paint(Graphics g) {
		if (p.dy == 1 && done2 == false) {
			done2 = true;
			animator = new Thread(this);
			animator.start();
		}

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// checks to see where first background ends - Masheil
		if ((p.getX() - 420) % 2400 == 0)
			p.nx = 0;
		if ((p.getX() - 1200) % 2400 == 0)
			p.nx2 = 0;

		/* creates scrolling background 
		 * and adds new background each time first one ends
		 * Masheil
		*/
		g2d.drawImage(img, 1200 - p.getnX2(), 0, null);
		if (p.getX() > 420) {
			g2d.drawImage(img, 1200 - p.getnX(), 0, null);
		}
		g2d.drawImage(p.getImage(), p.left, v, null);

		if (p.getdx() == -1) {
			g2d.drawImage(img, 1200 - p.getnX2(), 0, null);
			g2d.drawImage(p.getImage(), p.left, v, null);
		}
		
		// draws obstacles, scrolls, and sets coordinates - Aparna
				 g.drawImage(obs1, 285 - p.getX(), 510, null);
				 g.drawImage(obs2, 850 - p.getX(), 510, null);
				 g.drawImage(obs3, 1450 - p.getX(), 480, null);
				 g.drawImage(obs4, 2050 - p.getX(), 510, null);
				 g.drawImage(obs5, 2650 - p.getX(), 480, null);
				 g.drawImage(obs6, 3250 - p.getX(), 480, null);
				 g.drawImage(obs7, 3750 - p.getX(), 510, null);
				 g.drawImage(obs8, 4300 - p.getX(), 510, null);
				 g.drawImage(gameover, 4700 - p.getX(), 100, null);
				 
				 g.drawImage(spike, 900 - p.getX(), 50, null);
				 g.drawImage(spike, 1800 - p.getX(), 50, null);
				 g.drawImage(spike, 2400 - p.getX(), 50, null);
				 g.drawImage(spike, 3200 - p.getX(), 50, null);
				 g.drawImage(spike, 4400 - p.getX(), 50, null);
				 
				 g.drawImage(top, 0 - p.getX(), 0, null);
				 g.drawImage(top, 500 - p.getX(), 0, null);
				 g.drawImage(top, 1000 - p.getX(), 0, null);
				 g.drawImage(top, 1500 - p.getX(), 0, null);
				 g.drawImage(top, 2000 - p.getX(), 0, null);
				 g.drawImage(top, 2500 - p.getX(), 0, null);
				 g.drawImage(top, 3000 - p.getX(), 0, null);
				 g.drawImage(top, 3500 - p.getX(), 0, null);
				 g.drawImage(top, 4000 - p.getX(), 0, null);
				 g.drawImage(top, 4500 - p.getX(), 0, null);
				 g.drawImage(top, 5000 - p.getX(), 0, null);
				 
				 g.drawImage(bottom, 0 - p.getX(), 573, null);
				 g.drawImage(bottom, 600 - p.getX(), 573, null);
				 g.drawImage(bottom, 1200 - p.getX(), 573, null);
				 g.drawImage(bottom, 1800 - p.getX(), 573, null);
				 g.drawImage(bottom, 2400 - p.getX(), 573, null);
				 g.drawImage(bottom, 3000 - p.getX(), 573, null);
				 g.drawImage(bottom, 3600 - p.getX(), 573, null);
				 g.drawImage(bottom, 4200 - p.getX(), 573, null);
				 g.drawImage(bottom, 4600 - p.getX(), 573, null);
				 g.drawImage(bottom, 4800 - p.getX(), 573, null);
				 g.drawImage(bottom, 5000 - p.getX(), 573, null);

				 // setting score - location, colour, size, font - Aparna
				 String val = Integer.toString(score);
				 Font font = new Font("Helvetica", Font.BOLD, 32);
				 g.setFont(font);
				 g.setColor(Color.WHITE);
				 g.drawString(val, getWidth()-150, 50);		
	}

	// allows background to scroll when sprite begins moving - Aparna
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

	
//  sets sprite coordinates and jump height - Aparna
	public void cycle() {

		if (h == false)
			v--;
		if (v == 380)
			h = true;
		if (h == true && v <= 472) {
			v++;
			if (v == 472) {
				done = true;
			}
		}
	}

	// runs scrolling background program - Masheil
	public void run() {

		long beforeTime, timeDiff, sleep;

		beforeTime = System.currentTimeMillis();

		// allocates number of points - Aparna
		score+= 25;
		
		// runs scrolling background - Masheil
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
	
	
	 // outputs obstacle image - Aparna
	 public static void main(String[] args) {
		 
	        JFrame f = new JFrame("Level 1");
	             
	        f.addWindowListener(new WindowAdapter(){
	                public void windowClosing(WindowEvent e) {
	                    System.exit(0);
	                }
	            });
	 
	        f.add(new level1bg());
	        f.pack();
	        f.setVisible(true);
	    }
	 
	 
	 

}