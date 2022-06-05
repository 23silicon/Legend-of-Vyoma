package zelda.menu;

import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.engine.Scene;

/**
 * 
 */
public class HelpMenu extends Scene
{
	public HelpMenu(Game game)
	{
		super(game, "images/help-menu.png", "HelpMenu");
		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));
	}

	public void handleInput()
	{
			if (game.isEnterPressed())
			{
				game.setScene(new MainMenu(game));
			}

	}
}
