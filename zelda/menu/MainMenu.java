package zelda.menu;

import java.awt.Rectangle;
import zelda.engine.Game;
import zelda.engine.Scene;
import zelda.scene.HouseScene;

/**
 *
 * 
 */
public class MainMenu extends Scene
{
	private Fairy f = new Fairy(game, 210, 215);
	private static int  current	= 0;
	private int newg	= 0;
	private int help	= 1;

	public MainMenu(Game game)
	{
		super(game, "images/main-menu.png", "MainMenu");

		sprite.setSprite(new Rectangle(0, 0, game.getWidth(), game.getHeight()));

		gameObjects.add(f);
		
	}

	public void handleInput()
	{
		if (System.currentTimeMillis() > 0)
		{
			enter();
			input();
			fairy();
		}
	}

	private void enter()
	{
		if (game.isEnterPressed())
		{
				if(current == newg) {
					game.setScene(new HouseScene(game, "GameStart"));
					
				}
				if(current == help) {
					game.setScene(new HelpMenu(game));
				
				}
		}
	}
	private void input()
	{
			if(game.issPressed() && current == newg)
			{
				current += 1;
			}

			if(game.iswPressed() && current == help)
			{
				current -= 1;
			}
	}

	private void fairy()
	{
			if (current == newg)
			{
				f.setY(220);
			}
			if (current == help)
			{
				f.setY(290);
			}
		
	}
}
