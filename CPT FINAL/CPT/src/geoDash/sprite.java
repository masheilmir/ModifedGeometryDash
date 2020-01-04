package geoDash;
/* Masheil Mir and Aparna Yogarajan
 * Player sprite
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class sprite  {

	/* nx2 is the variable for the scrolling background position on the x axis; this changes depending on the position of x
	 *  x & y are the position of the image on the initial screen, without scrolling
	 *  nx & dy are the position of the image on the screen before it begins scrolling
	 *  Masheil
	*/ 
	int x, dx, y, nx, nx2, left, dy, points;
	protected int width, height;
	protected Image square;
	//Image square;
	ImageIcon s = new ImageIcon("square.png");

	// sets sprite position on screen and gets sprite image - Aparna
	public sprite() {
		x = 0;
		y = 0;
		left = 150;
		nx = 0;
		nx2 = 1200;
		square = s.getImage();
	}

	// sprite movement - Aparna
	public void move() {
		if (dx != -1) {
			if (left + dx <= 150)
				left += dx;
			else {
				x = x + dx;

				nx2 = nx2 + dx;
				nx = nx + dx;
			}
		} else {
			if (left + dx > 0)
				left = left + dx;
		}
	}

	 protected void getImageDimensions() {

	        width = square.getWidth(null);
	        height = square.getHeight(null);
	    }

	

	// get methods; allow other classes to access information from sprite class - Masheil
	public int getLeft() {
		return left;
	}
	
	public int getX() {
		return x;
	}

	public int getnX() {
		return nx;
	}

	public int getnX2() {
		return nx2;
	}

	public int getdx() {
		return dx;
	}
	
	public int getY() {
		return y;
	}

	public int getdY() {
		return dy;
	}
	
	public Image getImage() {
		return square;
	}
	
	

	// key listeners; react to key events - Aparna
	public void keyPressed(KeyEvent e) {
		int keyUp = e.getKeyCode();
		dx = 1;
		square = s.getImage();

		if (keyUp == KeyEvent.VK_UP) {
			dy = 1;
			square = s.getImage();
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			dy = 0;
			square = s.getImage();
		}
	}
	
	
	
}

