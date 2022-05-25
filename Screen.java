package main_classes;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel {
	private Tile[][] t;
	
	public Screen(Insets insets, Coord[] coords) {
		setLayout(null);
		setFocusable(false);
	/*	t = new Tile[6][9];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Tile(j,i, insets);
				for (Coord co: coords) {
					if (co.ix == j && co.iy == i)
						t[i][j].setObstacle();
				}
				
			}
		}
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				add(t[i][j]);
			}
		}*/
		
	}
}
