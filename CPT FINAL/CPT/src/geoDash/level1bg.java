package geoDash;

/* Masheil Mir and Aparna Yogarajan
 * Level 1 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class level1bg extends JPanel implements ActionListener, Runnable {

	// Masheil
	// variable declaration
	BufferedImage obs1, obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9, obs10, gameover, top, bottom, spike, floor1;
	sprite p;
	JLabel endMsg = new JLabel(" Game over ");
	JLabel msg = new JLabel("Game Over");
	int score = 0;

	public Image img;
	Timer time;
	int v = 472;
	Thread animator;

	boolean a = false;
	boolean done2 = false;

	public level1bg() {
		p = new sprite();
		addKeyListener(new AL());
		setFocusable(true);
		setBackground(Color.black);
		ImageIcon i = new ImageIcon("level1.jpg"); // creates background image
		img = i.getImage();
		time = new Timer(5, this);
		time.start();

	// gets obstacle images - Aparna
	       try {
	           obs2 = ImageIO.read(new File("Obst2.png"));
	           obs3 = ImageIO.read(new File("Obst2.png"));
	           obs5 = ImageIO.read(new File("Obst1.png"));
	           obs6 = ImageIO.read(new File("Obst2.png"));
	           obs7 = ImageIO.read(new File("Obst1.png"));
	           gameover = ImageIO.read(new File("gameOver.png"));
	           top = ImageIO.read(new File("l1floor.png"));
	           bottom = ImageIO.read(new File("floorl1.png"));
	           spike = ImageIO.read(new File("extra1.png"));
	           floor1 = ImageIO.read(new File("anothaone.png"));
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
			JOptionPane.showMessageDialog(null, "You finished level 1!");
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
		 g.drawImage(obs2, 850 - p.getX(), 518, null);
		 g.drawImage(obs3, 1350 - p.getX(), 518, null);
		 g.drawImage(obs5, 2050 - p.getX(), 525, null);
		 g.drawImage(obs6, 2550 - p.getX(), 518, null);
		 g.drawImage(obs7, 3250 - p.getX(), 525, null);
		 g.drawImage(obs9, 3850 - p.getX(), 525, null);
		 g.drawImage(gameover, 4700 - p.getX(), 100, null);
		 
		 g.drawImage(spike, 900 - p.getX(), 0, null);
		 g.drawImage(spike, 1800 - p.getX(), 0, null);
		 g.drawImage(spike, 2400 - p.getX(), 0, null);
		 g.drawImage(spike, 3200 - p.getX(), 0, null);
		 g.drawImage(spike, 4400 - p.getX(), 0, null);
		 
		 g.drawImage(top, 0 - p.getX(), 0, null);
		 g.drawImage(top, 900 - p.getX(), 0, null);
		 g.drawImage(top, 1800 - p.getX(), 0, null);
		 g.drawImage(top, 2400 - p.getX(), 0, null);
		 g.drawImage(top, 3200 - p.getX(), 0, null);
		 g.drawImage(top, 4400 - p.getX(), 0, null);
		 
		 g.drawImage(bottom, 0 - p.getX(), 573, null);
		 g.drawImage(bottom, 600 - p.getX(), 573, null);
		 g.drawImage(bottom, 1200 - p.getX(), 573, null);
		 g.drawImage(bottom, 1800 - p.getX(), 573, null);
		 g.drawImage(bottom, 2400 - p.getX(), 573, null);
		 g.drawImage(bottom, 3000 - p.getX(), 573, null);
		 g.drawImage(bottom, 3600 - p.getX(), 573, null);
		 g.drawImage(bottom, 4200 - p.getX(), 573, null);
		 g.drawImage(bottom, 4600 - p.getX(), 573, null);
		 g.drawImage(bottom, 5100 - p.getX(), 573, null);

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
		score+= 50;
		
		
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
