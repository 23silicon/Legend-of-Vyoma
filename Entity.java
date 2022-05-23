package main_classes;
import javax.swing.JComponent;
/*
 * This class represents entities within the game
 * Any class that creates a mob such as a player or enemy MUST extend this class
 */
@SuppressWarnings("all")
public class Entity extends JComponent {

//Sunflower Fields
	private int dx, dy, px, py;

//****CONSTRUCTION ZONE KEEP OUT****
	public Entity(int px, int py) {
		this.dx = 0;
		this.dy = 0;
		this.px = px;
		this.py = py;
	}
//****CONSTRUCTION ZONE KEEP OUT****

/*
 * Update method for entity, used for movement
 */
	public void update() {
		px += dx;
		py += dy;
		setLocation(px,py);
		repaint();
	}

/*
 * Allows entities to move to specific tiles
 */
	public void moveToTile(Tile t) {
		
	}

//Accessor Methods
	public int getPX() {return px;}
	public int getPY() {return py;}
	public int getDX() {return dx;}
	public int getDY() {return dy;}
}
