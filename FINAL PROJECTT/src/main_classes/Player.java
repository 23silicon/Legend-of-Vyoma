package main_classes;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.ImageIcon;
@SuppressWarnings("serial")

public class Player extends Entity {
	private int phase; //represents what number the frame is (basically just which one of the image states for walking its in)
	private JLabel yashu;
	private ImageIcon[] runningStates;
	private ImageIcon[] attackStates;
	private ImageIcon[] shootStates;
	private ImageIcon current;
	private int up,down,left,right;
	private String direction;
	
	
	public Player(int px, int py, Insets insets) {
		super(px, py, insets);
		phase = 0;
		up = 0;
		down = 0;
		left = 0;
		right = 0;
		direction = null;
		try {
			runningStates = new ImageIcon[8];
			runningStates[0] = new ImageIcon("src/entities/Lonk/yash_00.png");
			runningStates[1] = new ImageIcon("src/entities/Lonk/yash_01.png");
			runningStates[2] = new ImageIcon("src/entities/Lonk/yash_04.png");
			runningStates[3] = new ImageIcon("src/entities/Lonk/yash_05.png");
			runningStates[4] = new ImageIcon("src/entities/Lonk/yash_08.png");
			runningStates[5] = new ImageIcon("src/entities/Lonk/yash_09.png");
			runningStates[6] = new ImageIcon("src/entities/Lonk/yash_12.png");
			runningStates[7] = new ImageIcon("src/entities/Lonk/yash_13.png");
			attackStates = new ImageIcon[4];
			attackStates[0] = new ImageIcon("src/entities/Lonk/yash_03.png");
			attackStates[1] = new ImageIcon("src/entities/Lonk/yash_07.png");
			attackStates[2] = new ImageIcon("src/entities/Lonk/yash_11.png");
			attackStates[3] = new ImageIcon("src/entities/Lonk/yash_15.png");
			shootStates = new ImageIcon[4];
			shootStates[0] = new ImageIcon("src/entities/Lonk/yash_02.png");
			shootStates[1] = new ImageIcon("src/entities/Lonk/yash_06.png");
			shootStates[2] = new ImageIcon("src/entities/Lonk/yash_10.png");
			shootStates[3] = new ImageIcon("src/entities/Lonk/yash_14.png");
			current = runningStates[0];
			for (int i = 0; i < runningStates.length; i++) {
				if (runningStates[i].getIconWidth() == -1) {throw new Exception();}
			}
			
		} catch (Exception e) {
			System.err.println("Something went wrong... (player class)");
		}
		repaint();
	}
	
	public void update() {
		super.update();
		
		if(this.getDY() < 0) {
			direction = "up";
			if (up > 10) current = runningStates[7];
			else if (up > 0) current = runningStates[6];
			up++;
			if (up > 20) up = 0;
		}
		if(this.getDY() > 0) {
			direction = "down";
			if (down > 10) current = runningStates[1];
			else if (down > 0) current = runningStates[0];
			down++;
			if (down > 20) down = 0;
		}
		if (this.getDX() > 0 && this.getDY() == 0) {
			direction = "right";
			if (right > 10) current = runningStates[3];
			else if (right > 0) current = runningStates[2];
			right++;
			if (right > 20) right = 0;
		}
		if (this.getDX() < 0 && this.getDY() == 0) {
			direction = "left";
			if (left > 10) current = runningStates[5];
			else if (left > 0) current = runningStates[4];
			left++;
			if (left > 20) left = 0;
		}
		
		repaint();
	}
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 current.paintIcon(this, g, 0, 0);
	}
	
	public String getDirect() {
		return direction;
	}
}
