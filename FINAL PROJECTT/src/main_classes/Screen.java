package main_classes;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel {
	private Tile[][] t;
	private JLabel[][] corden;
	
	public Screen(Insets insets, Coord[] coords, Coord[] spikeCoords) {
		setLayout(null);
		setFocusable(false);
		this.setBackground(new Color(0,0,0));
		t = new Tile[6][9];
		corden = new JLabel[6][9];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Tile(j,i, insets);
				
				for (Coord co: coords) {
					if (co.ix == j && co.iy == i)
						t[i][j].setObstacle();	
				}
				
				if (spikeCoords != null) for (Coord co: spikeCoords) {
					if (co.ix == j && co.iy == i)
						t[i][j].setSpike();	
				}
				
			}
		}
		
	}
	
	public void update() {
		if (Main.debug)	for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				add(t[i][j]); 
//				corden[i][j] = new JLabel("(" + j + "," + i + ")", JLabel.CENTER);
//				corden[i][j].setForeground(Color.blue);
//				if (t[i][j].isObs || t[i][j].isSpike)
//					corden[i][j].setForeground(Color.pink);
//				corden[i][j].setBounds(t[i][j].getRect());
//				add(corden[i][j]);
//				setComponentZOrder(corden[i][j],1);
				setComponentZOrder(t[i][j], 1);
			}
		} 
		if (!Main.debug) for (int i = 0; i < t.length; i++) {for (int j = 0; j < t[i].length; j++) {
				
				if (corden[i][j] != null) {
					remove(corden[i][j]);
				}
				revalidate();
				repaint();
				remove(t[i][j]);
			}
			
		} 
		repaint();
	}
	
	public boolean compareAgainstTiles(Rectangle r) {
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j].isObs) {
					if (t[i][j].getRect().intersects(r)) {
//						System.out.println("\n\n\n" + t[i][j] + "\n" + r);
						return true;
					}
				}
			}
		}
		return false;
	}
}
