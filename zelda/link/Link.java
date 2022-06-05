package zelda.link;

import java.awt.Rectangle;
import zelda.enemy.Soldier;
import zelda.enemy.armos.ArmosKnight;
import zelda.engine.GObject;
import zelda.engine.Game;

import zelda.items.Heart;
import zelda.karacter.Direction;
import zelda.karacter.Karacter;


public class Link extends Karacter
{
	private long inputInterval = 50;
	private long lastInput = System.currentTimeMillis();
    private long lastHit = System.currentTimeMillis();


	public Link(Game game, int x, int y)
	{
		super(game, x, y, 17, 20, Direction.DOWN, "images/link.png");
		spriteLoc.put("Link walk down 1",new Rectangle(0, 0, 16, 23));
		spriteLoc.put("Link stand down",new Rectangle(75, 0, 16, 23));
		spriteLoc.put("Link walk down 6",new Rectangle(150, 0, 16, 23));

		spriteLoc.put("Link walk up 1",	new Rectangle(0, 25, 17, 23));
		spriteLoc.put("Link stand up",	new Rectangle(75, 25, 17, 23));
		spriteLoc.put("Link walk up 6",	new Rectangle(150, 25, 17, 23));

		spriteLoc.put("Link walk left 1",new Rectangle(0, 50, 19, 24));
		spriteLoc.put("Link stand left",new Rectangle(75, 50, 19, 24));
		spriteLoc.put("Link walk left 6",new Rectangle(150, 50, 19, 24));

		spriteLoc.put("Link walk right 1",new Rectangle(0, 75, 19, 24));
		spriteLoc.put("Link stand right",new Rectangle(75, 75, 19, 24));
		spriteLoc.put("Link walk right 6",new Rectangle(150, 75, 19, 24));

		spriteLoc.put("Link sword down 1",new Rectangle(0, 100, 19, 24));
		spriteLoc.put("Link sword down 2",new Rectangle(25, 100, 20, 30));
		spriteLoc.put("Link sword down 4",new Rectangle(75, 100, 19, 32));
		spriteLoc.put("Link sword down 6",new Rectangle(160, 100, 33, 28));

		spriteLoc.put("Link sword up 1",new Rectangle(0, 150, 24, 23));
		spriteLoc.put("Link sword up 3",new Rectangle(50, 150, 24, 25));
		spriteLoc.put("Link sword up 5",new Rectangle(100, 150, 20, 33));
		spriteLoc.put("Link sword up 7",new Rectangle(150, 150, 24, 30));
		spriteLoc.put("Link sword up 8",new Rectangle(32, 174, 30, 26));
		spriteLoc.put("Link sword up 9",new Rectangle(0, 175, 32, 23));

		spriteLoc.put("Link sword right 2",new Rectangle(25, 200, 19, 23));
		spriteLoc.put("Link sword right 3",new Rectangle(50, 200, 24, 24));
		spriteLoc.put("Link sword right 5",new Rectangle(102, 200, 30, 22));
		spriteLoc.put("Link sword right 6",new Rectangle(132, 200, 32, 25));
		spriteLoc.put("Link sword right 8",new Rectangle(29, 225, 29, 29));


		spriteLoc.put("Link sword left 1",new Rectangle(100, 225, 16, 23));
		spriteLoc.put("Link sword left 3",new Rectangle(150, 225, 23, 24));
		spriteLoc.put("Link sword left 4",new Rectangle(0, 250, 25, 25));
		spriteLoc.put("Link sword left 6",new Rectangle(56, 254, 31, 21));
		spriteLoc.put("Link sword left 8",new Rectangle(125, 253, 28, 28));
		spriteLoc.put("Link sword left 9",new Rectangle(153, 250, 22, 31));
		spriteLoc.put("Link bow down 3",new Rectangle(50, 300, 18, 22));
		spriteLoc.put("Link bow left 3",new Rectangle(50, 325, 20, 20));
		spriteLoc.put("Link bow right 2",new Rectangle(25, 350, 22, 23));
		spriteLoc.put("Link bow up 3",new Rectangle(50, 375, 21, 22));
		sprite.setSprite(spriteLoc.get("Link stand down"));
		z = 2;
        health = 500;
		screenAdjust = false;
		state = new StandState(this);
	}

    
	public void shootArrow()
	{

			setState(new BowState(this));
		
	}

	public void handleInput()
	{

		if (System.currentTimeMillis() > lastInput + inputInterval)
		{
			state.handleInput();
			lastInput = System.currentTimeMillis();
		}
	}
	public void preAnimation()
	{
		state.handleAnimation();
	}
	protected void collision(GObject hitObject)
	{
        
		if (hitObject instanceof Soldier)
		{
            if (health > 0 && System.currentTimeMillis() > lastHit + 800)
            {
               health --;
               lastHit = System.currentTimeMillis();
               Soldier soldier = (Soldier)hitObject;
               setState(new TransState(this, soldier.getDirection()));
            }
        }
        
        if (hitObject instanceof ArmosKnight)
        {
            if (health > 0 && System.currentTimeMillis() > lastHit + 800)
            {
               
               health --;
               lastHit = System.currentTimeMillis();
               ArmosKnight armosKnight = (ArmosKnight)hitObject;
               setState(new TransState(this, armosKnight.getDirection()));
            }
		}
        
        if (hitObject instanceof Heart)
        {
            if (health < 5)
            {
               health++;
            }
        }

   }

	public boolean moveinput()
	{
		return (game.isaPressed() || game.isdPressed() || game.iswPressed() || game.issPressed());
	}

	public boolean noMoveinput()
	{
        return (!game.isaPressed() && !game.isdPressed() && !game.iswPressed() && !game.issPressed());
	}

   
}