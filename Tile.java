package main_classes;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Tile extends JComponent {
	private int cornerX, cornerY;
	private int px, py, sX, sY;
	private Rectangle rect;
	private Rectangle2D.Double paintedTile;
	private Dimension screenSize;
	private boolean isRael; 
	
	
	public Tile(int pX, int pY, Insets in) {
		px = pX;
		py = pY;
		screenSize = new Dimension(1026,684);
		sX = (int)(screenSize.getWidth()/9)-in.left-in.right-5;
		sY = (int)(screenSize.getHeight()/6)-in.bottom-in.top-10;
		cornerX = pX * sX + 10;
		cornerY = pY * sY + 10;
		paintedTile = new Rectangle2D.Double(0,0,sX, sY);
		this.setLocation(cornerX, cornerY);
		this.setSize(sX+1, sY+1);
		isRael = true;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		g2.draw(paintedTile);
		g2.setColor(new Color(100,100,255));
		if (!isRael) {
			g2.setColor(new Color(50,50,50));
		}
		g2.fill(paintedTile);
		
	}
	
	public void setObstacle() {
		isRael = false;
		repaint();
	}
	
	public void unObstacle() {
		isRael = true;
		repaint();
	}
	
	
	public String toString() {
		return "|cX:" + cornerX + "|cY:" + cornerY + "|pX:" + px + "|pY:" + py
				+ "|rect:" + rect + "|\n|screenSize:" + screenSize + "|"
				+ "\n|sX:" + sX + "|sY:" + sY + "|\n";
	}
}
