package enemies;
import main_classes.Enemy;

import java.awt.Insets;
import java.awt.Toolkit;
@SuppressWarnings({ "serial", "unused" })

public class Ganon extends Enemy {

	public Ganon(Insets in) {
		super("ganon", 7, 5, 5, 400, 400, in);
	}

}