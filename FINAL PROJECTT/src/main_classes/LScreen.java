package main_classes;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
@SuppressWarnings({ "serial", "unused" })
/*
 * LScreen is just a JPanel that creates a loading screen at the start of the game
 * It disappears once the loading bar is complete
 */
public class LScreen extends JPanel {
	
	private LBar bar;
	boolean destroy; //if this is set to true, the screen disappears
	private ImageIcon image;
	private JLabel display;
	
	public LScreen(Rectangle r) {
		
		destroy = false;
		setLayout(null);
		try {
			image = new ImageIcon("src/maps/main-menu.png");
			if (image.getIconWidth() == -1) throw new Exception();
			display = new JLabel(image);
			display.setBounds(0,0,1027,685);
			this.add(display);
			} catch (Exception e) {
				System.err.println("Image not found. Make sure you move it into the src folder > "
						+ "\"maps\""
						+ "\n and it's named \"main-menu.png\"\n - Nikhil");
		}
		setBackground(Color.black);
		bar = new LBar(r);
		add(bar);
		this.setComponentZOrder(display, 1);
		this.setComponentZOrder(bar, 0);
		setVisible(true);
		
	}
	
	public void update() {
		bar.update();
//		if (bar.destroyTitleScreen) this.remove(display);
		if (bar.destroy) destroy = true; 
		repaint();
	}
}





	
	@SuppressWarnings("serial")
	class LBar extends JComponent {
		
		private Rectangle2D.Double midbar;
		private Rectangle2D.Double backbar;
		private Rectangle2D.Double frontbar;
		private Rectangle2D.Double dumbar;
		private int counter = 0;
		private int e = 10;
		private int i = 0;
		boolean destroy;
		boolean destroyTitleScreen;
		
		public LBar(Rectangle r) {
			setSize(2000,200);
			setLocation((int)r.getWidth()/2-350-700,(int)r.getHeight()/2+150);
			setFocusable(false);
			midbar = new Rectangle2D.Double(700,5,700,40);
			dumbar = new Rectangle2D.Double(695,0,710,50);
			backbar = new Rectangle2D.Double(0,5,700,40);
			frontbar = new Rectangle2D.Double(0,5,700,40);
			setVisible(false);
			
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
			i++;
			if (i == 70) destroyTitleScreen = true;
			if (i > 70) {
				this.setVisible(true);
				backbar.setRect(backbar.getX()+e, backbar.getY(), backbar.getWidth(), backbar.getHeight());
				repaint();
				counter++;
				if (counter > 69) { //this is the part where the loading bar has reached completion
					e = 0;
					destroy = true;
				}
			}
		}
	}