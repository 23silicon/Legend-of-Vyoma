package main_classes;
import javax.swing.JComponent;
/*
 * This class represents entities within the game
 * Any class that creates a mob such as a player or enemy MUST extend this class
 */
@SuppressWarnings("all")
public class Entity extends JComponent {

//Sunflower Fields
	private int dx, dy, tx, ty;

//****CONSTRUCTION ZONE KEEP OUT****
	public Entity(int tx, int ty) {
		this.dx = 0;
		this.dy = 0;
		this.tx = tx;
		this.ty = ty;
	}
//****CONSTRUCTION ZONE KEEP OUT****

/*
 * Update method for entity, used for movement
 */
	public void update() {
		tx += dx;
		ty += dy;
		setLocation(tx,ty);
		repaint();
	}

/*
 * Allows entities to move to specific tiles
 */
	public void moveToTile(Tile t) {
		
	}

//Accessor Methods
	public int getPX() {return tx;}
	public int getPY() {return ty;}
	public int getDX() {return dx;}
	public int getDY() {return dy;}
}
