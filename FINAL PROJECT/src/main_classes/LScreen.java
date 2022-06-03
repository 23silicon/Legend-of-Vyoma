package main_classes;
/*
 * LScreen is just a JPanel that creates a loading screen at the start of the game.
 * It disappears once the loading bar is complete.
 */

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
public class LScreen extends JPanel {
	
	private LBar bar;
	boolean destroy; //if this is set to true, the screen disappears
	private PlayMusic musicPlayer;
	
	public LScreen(Rectangle r, PlayMusic pm) {
		
		destroy = false;
		setLayout(null);
		setBackground(Color.black);
		bar = new LBar(r);
		add(bar);
		musicPlayer = pm;

		
		setVisible(true);
		
		
	}
	
	public void update() {
		bar.update();
		if (bar.getCounter() ==30)
		{
			musicPlayer.startMusic();
		}
		if (bar.destroy) destroy = true; 
	}
}

class LBar extends JComponent {
	
	private Rectangle2D.Double midbar;
	private Rectangle2D.Double backbar;
	private Rectangle2D.Double frontbar;
	private Rectangle2D.Double dumbar;
	private int counter = 0;
	private int e = 10;
	boolean destroy;
	
	public LBar(Rectangle r) {
		setSize(2000,200);
		setLocation((int)r.getWidth()/2-350-700,(int)r.getHeight()/2-20);
		System.out.println((int)r.getWidth());
		setFocusable(false);
		midbar = new Rectangle2D.Double(700,5,700,40);
		dumbar = new Rectangle2D.Double(695,0,710,50);
		backbar = new Rectangle2D.Double(0,5,700,40);
		frontbar = new Rectangle2D.Double(0,5,700,40);
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(255,255,255));
		g2.draw(midbar);
		g2.draw(backbar);
		g2.fill(backbar);
		g2.setColor(Color.black);
		g2.draw(frontbar);
		g2.fill(frontbar);
		g2.setColor(Color.white);
		g2.draw(dumbar);
	}
	
	public void update() {
		backbar.setRect(backbar.getX()+e, backbar.getY(), backbar.getWidth(), backbar.getHeight());
		repaint();
		counter++;
		if (counter > 69) { //this is the part where the loading bar has reached completion
			e = 0;
			destroy = true;
		}
	}
	
	public int getCounter()
	{
		return counter;
	}
}