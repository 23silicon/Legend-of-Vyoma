package main_classes;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;
/*
 * This class represents entities within the game
 * Any class that creates a mob such as a player or enemy MUST extend this class
 */
@SuppressWarnings("all")
public class Entity extends JComponent {

//Sunflower Fields
	private int dx, dy, tx, ty,px,py;
	private Tile dimensions;
	Rectangle enrec;
	private Insets insets;

//****CONSTRUCTION ZONE KEEP OUT****
	public Entity(int tx, int ty, Insets insets) {
		dimensions = new Tile(tx, ty, insets);
		this.insets = insets;
		this.setBounds(dimensions.cornerX, dimensions.cornerY, (int) dimensions.getWidth(), (int) dimensions.getHeight());
		enrec = this.getBounds();
		dx = 0;
		dy = 0;
		px = this.getX();
		py = this.getY();
		this.tx = tx;
		this.ty = ty;
	}
//****CONSTRUCTION ZONE KEEP OUT****

/*
 * Update method for entity, used for movement
 */
	public void update() {
		px += dx;
		py += dy;
		this.setLocation(this.getX() + dx, this.getY() + dy);
		enrec = new Rectangle(getBounds().x+20, getBounds().y+20, (int)getBounds().getWidth()-40, (int)getBounds().getHeight()-40);
		repaint();
	}

/*
 * Allows entities to move to specific tiles
 */
	public void moveToTile(Tile t) {
		
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public void setLocationByTile(int tilex, int tiley) {
		Tile d = new Tile(tilex, tiley, insets);
		super.setLocation(d.cornerX, d.cornerY);
	}
	
//Accessor Methods
	public int getPX() {return tx;}
	public int getPY() {return ty;}
	public int getDX() {return dx;}
	public int getDY() {return dy;}
}
