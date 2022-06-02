package main_classes;
import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.ImageIcon;
@SuppressWarnings("serial")

public class Player extends Entity {
	private int phase; //represents what number the frame is (basically just which one of the image states for walking its in)
	private JLabel yashu;
	private ImageIcon[] runningStates;
	private ImageIcon[] attackStates;
	private ImageIcon[] shootStates;
	private Tile dimensions;
	public Player(int px, int py, Insets insets) {
		super(px, py);
		phase = 0;
		runningStates = new ImageIcon[8];
		runningStates[0] = new ImageIcon("src/yash_00.png");
		runningStates[1] = new ImageIcon("src/yash_01.png");
		runningStates[2] = new ImageIcon("src/yash_04.png");
		runningStates[3] = new ImageIcon("src/yash_05.png");
		runningStates[4] = new ImageIcon("src/yash_08.png");
		runningStates[5] = new ImageIcon("src/yash_09.png");
		runningStates[6] = new ImageIcon("src/yash_12.png");
		runningStates[7] = new ImageIcon("src/yash_13.png");
		attackStates = new ImageIcon[4];
		attackStates[0] = new ImageIcon("src/yash_03.png");
		attackStates[1] = new ImageIcon("src/yash_07.png");
		attackStates[2] = new ImageIcon("src/yash_11.png");
		attackStates[3] = new ImageIcon("src/yash_15.png");
		shootStates = new ImageIcon[4];
		shootStates[0] = new ImageIcon("src/yash_02.png");
		shootStates[1] = new ImageIcon("src/yash_06.png");
		shootStates[2] = new ImageIcon("src/yash_10.png");
		shootStates[3] = new ImageIcon("src/yash_14.png");
		dimensions = new Tile(0, 0, insets);
		yashu = new JLabel(runningStates[0]);
		yashu.setBounds(dimensions.getRect());
		this.setBounds(px, py, (int) dimensions.getRect().getWidth(), (int) dimensions.getRect().getHeight());
		this.setVisible(true);
		this.add(yashu);
	}
	public void update() {
		super.setPX(super.getTX() + super.getDX());
		super.setPY(super.getTY() + super.getDY());
		super.setLocation(super.getTX(), super.getTY());
		repaint();
	}
}
