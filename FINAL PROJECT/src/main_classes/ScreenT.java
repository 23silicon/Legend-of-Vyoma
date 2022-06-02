package main_classes;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ScreenT extends Screen {

	private static Coord[] coords = {
			new Coord(0,0), new Coord(1,0), new Coord(2,0), new Coord(3,0), new Coord(4,0), new Coord(5,0), new Coord(6,0), new Coord(7,0), new Coord(8,0), 
			new Coord(0,1), new Coord(4,1), new Coord(8,1), 
			new Coord(5,2), new Coord(6,2), new Coord(7,2), 
			new Coord(0,3), new Coord(1,3), new Coord(2,3), 
			new Coord(0,5), new Coord(1,5), new Coord(2,5), new Coord(3,5), new Coord(6,5), new Coord(7,5), new Coord(8,5), };
	
	private ImageIcon image;
	private JLabel display;
	
	public ScreenT(Insets insets) {
		super(insets, coords);
		setLayout(null);
		try {
		image = new ImageIcon("src/maps/MapT.png");
		if (image.getIconWidth() == -1) throw new Exception();
		display = new JLabel(image);
		display.setBounds(0,0,1027,685);
		this.add(display);
		} catch (Exception e) {
			System.err.println("Image not found. Make sure you move it into the src folder > "
					+ "\"maps\""
					+ "\nand it's named \"MapT.png\"\n - Nikhil");
		}
		setFocusable(false);
		setVisible(true);
	}
}
