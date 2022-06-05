package zelda.enemy;

import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.engine.Game;
import zelda.karacter.Direction;


public class BlueSoldier extends Soldier implements Hittable
{
	public BlueSoldier(Game game, int x, int y, Direction direction, int ticks)
	{
		super(game, x, y, direction, "images/will.png");
		behavior = new PatrolBehavior(this, ticks);
	}

	public void hitBy(Weapon weapon)
	{
        if (health >= 1)
        {
          
        }

        switch(weapon)
		{
			case SWORD:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800)
                {
                    lastHit = System.currentTimeMillis();
                    health -= 3;
                    setState(new TransState(this, game.getLink().getDirection()));
					setBehavior(new AttackBehavior(this));
                }
				break;

            
            case ARROW:
                if (health > 0 && System.currentTimeMillis() > lastHit + 800)
                {
                    lastHit = System.currentTimeMillis();
                    health -= 3;
                    setBehavior(new AttackBehavior(this));
                }
				break;
		}
        
        if(health <= 0)
        {
            alive = false;
         
            randomGoodie();
        }
	}
}
