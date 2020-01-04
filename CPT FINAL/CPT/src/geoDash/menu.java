package geoDash;

/**
 * Name: Aparna Yogarajan and Masheil Mir
 * Date: May 10, 2018
 * Purpose: Geometry Dash game Menu Screen
 */

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class menu extends JFrame implements ActionListener {

	static boolean guy = true;
	
	// level labels
	JLabel lvl1 = new JLabel();
	JLabel lvl2 = new JLabel();
	JLabel lvl3 = new JLabel();
	JLabel instlbl = new JLabel();
	JLabel ch1 = new JLabel();
	JLabel ch2 = new JLabel();
	int score;

	// label for instructions
	JLabel msg = new JLabel(
			"<html> Use the up arrow on the keyboard to jump and dodge different obstacles <BR> in order to get to the end of the game. Collect coins throughout the game to earn points. <BR> If you touch an obstacle the game will re-start from the beggining of the level. <BR> The difficulty of the game increases as you choose a higher level. <BR> Please pick a level from the main screen to begin the game.</html>");

	// Aparna
	public menu() {
		// frame
		setTitle("Geometery Dash");
		setSize(1200, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("bg.jpg")));
		setLayout(null);

		// level 1 button and settings
		JButton lvl1btn = new JButton("LEVEL 1");
		lvl1btn.setBounds(200, 450, 150, 70);
		lvl1btn.setActionCommand("level 1");
		lvl1btn.addActionListener(this);
		lvl1.setBounds(550, 220, 100, 100);
		lvl1.setVisible(false);

		// level 2 button and settings
		JButton lvl2btn = new JButton("LEVEL 2");
		lvl2btn.setBounds(400, 450, 150, 70);
		lvl2btn.setActionCommand("level 2");
		lvl2btn.addActionListener(this);
		lvl2.setBounds(550, 220, 100, 100);
		lvl2.setVisible(false);

		// level 3 button and settings
		JButton lvl3btn = new JButton("LEVEL 3");
		lvl3btn.setBounds(600, 450, 150, 70);
		lvl3btn.setActionCommand("level 3");
		lvl3btn.addActionListener(this);
		lvl3.setBounds(550, 220, 100, 100);
		lvl3.setVisible(false);

		// instructions button and settings
		JButton instbtn = new JButton("INSTRUCTIONS");
		instbtn.setBounds(800, 450, 150, 70);
		instbtn.setActionCommand("instructions");
		instbtn.addActionListener(this);
		instlbl.setBounds(150, 220, 100, 100);
		instlbl.setVisible(false);

		// choosing character
		String [] Char = {" Bob", "Mark", "Billy", "Joan ", "Lily"};
		
		int i = 0;
		int j = 0;
		i = (int)(Math.random()*5+0);
		j = (int)(Math.random()*5+0);

		// bob
		JButton ch1btn = new JButton(Char[i]);
		ch1btn.setBounds(400, 100, 150, 70);
		ch1btn.setActionCommand("ch1");
		ch1btn.addActionListener(this);
		ch1.setBounds(550, 220, 100, 100);
		ch1.setVisible(false);
		
		// mark
		JButton ch2btn = new JButton(Char[j]);
		ch2btn.setBounds(600, 100, 150, 70);
		ch2btn.setActionCommand("ch2");
		ch2btn.addActionListener(this);
		ch2.setBounds(550, 220, 100, 100);
		ch2.setVisible(false);
						
		// add components to contentPane
		add(lvl1);
		add(lvl1btn);
		add(lvl2);
		add(lvl2btn);
		add(lvl3);
		add(lvl3btn);
		add(instlbl);
		add(instbtn);
		add(ch1);
		add(ch1btn);
		add(ch2);
		add(ch2btn);
		
		setVisible(true);

	}

	// Masheil
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
	
		// if user selects level 1, display level 1 game screen
		if (eventName.equals("level 1")) {
			lvl1.setVisible(true);
			instlbl.setVisible(false);
			setContentPane(new JLabel(new ImageIcon("level1.jpg")));
			runner1 lvl = new runner1();
			

		// if user selects level 2, display level 2 game screen
		} else if (eventName.equals("level 2")) {
			lvl1.setVisible(true);
			instlbl.setVisible(false);
			setContentPane(new JLabel(new ImageIcon("level2.png")));
			runner2 lvl = new runner2();

			// if user selects level 3, display level 3 game screen
		} else if (eventName.equals("level 3")) {
			lvl1.setVisible(true);
			instlbl.setVisible(false);
			setContentPane(new JLabel(new ImageIcon("level3.jpg")));
			runner3 lvl = new runner3();

			// if user selects instructions, pop up box displays 
		} else if (eventName.equals("instructions")) {
			instlbl.setVisible(true);
			lvl2.setVisible(false);

			int n = JOptionPane.showOptionDialog(this, msg, "Instructions",
					JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, null, null); // default button title

		}
		
	}

	public static void main(String[] args) {

		menu gui = new menu();

	}
}