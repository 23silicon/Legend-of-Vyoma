package main_classes;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ScreenU extends Screen {

	private static Coord[] coords = {
			new Coord(0,0), new Coord(1,0), new Coord(2,0), new Coord(3,0), new Coord(5,0), new Coord(6,0), new Coord(7,0), new Coord(8,0), 
			new Coord(0,1), new Coord(0,2), new Coord(0,3), new Coord(0,4), new Coord(0,5),  
			new Coord(8,1), new Coord(8,2), new Coord(8,3), new Coord(8,4), new Coord(8,5),
			new Coord(0,0), new Coord(1,0), new Coord(2,0), new Coord(3,0), new Coord(4,0), new Coord(5,0), new Coord(6,0), new Coord(7,0), new Coord(8,0), 
			};
	
	private ImageIcon image;
	private JLabel display;
	
	public ScreenU(Insets insets) {
		super(insets, coords);
		setLayout(null);
		try {
		image = new ImageIcon("src/maps/MapU.png");
		if (image.getIconWidth() == -1) throw new Exception();
		display = new JLabel(image);
		display.setBounds(0,0,1027,685);
		this.add(display);
		} catch (Exception e) {
			System.err.println("Image not found. Make sure you move it into the src folder > "
					+ "\"maps\""
					+ "\n and it's named \"MapU.png\"\n - Nikhil");
		}
		setFocusable(false);
		setVisible(true);
	}
}
