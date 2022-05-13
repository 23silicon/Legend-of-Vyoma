import javax.swing.JComponent;
/*
 * This class represents entities within the game!!!!!!!
 * Any class that creates a mob such as a player or enemy MUST extend this class.
 */
public class Entity extends JComponent {
	
	private int dx, dy, px, py;
	
	public Entity() {}
	
	public Entity(int dx, int dy, int px, int py) {
		this.dx = dx;
		this.dy = dy;
		this.px = px;
		this.py = py;
	}
	
	public void update() {
		px  += dx;
		py += dy;
		repaint();
	}
}
