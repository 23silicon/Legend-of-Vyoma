package zelda.items;

import java.awt.Rectangle;
import zelda.collision.Hittable;
import zelda.collision.Weapon;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.karacter.Direction;
import zelda.link.Link;

public class Arrow extends GObject
{

    private static String[] arrowRight= {"arrowRight"};
    private final static int SPEED = 3;
    private boolean hit = false;
    private Direction direction;
	private static String[] arrowLeft     = {"arrowLeft"};
	private static String[] arrowDown     = {"arrowDown"};
	private static String[] arrowUp       = {"arrowUp"};

    public Arrow(Game game, int x, int y)
    {
        super(game, x, y, 13, 4, "images/arrows.png");

        // Arrow Direction only
        spriteLoc.put("arrowRight", new Rectangle(75, 0, 17, 6));
        spriteLoc.put("arrowLeft", new Rectangle(50, 0, 17, 6));
        spriteLoc.put("arrowDown", new Rectangle(0, 0, 6, 17));
        spriteLoc.put("arrowUp", new Rectangle(25, 0, 6, 17));
        setAnimationInterval(99);

        direction = game.getLink().getDirection();

        switch (direction)
		{
            case UP:
                sprite.setSprite(spriteLoc.get("arrowUp"));
                this.setAnimation(arrowUp);
                this.setHeight(13);
                this.setWidth(4);
                break;

			case DOWN:
                sprite.setSprite(spriteLoc.get("arrowDown"));
                this.setAnimation(arrowDown);
                this.setHeight(13);
                this.setWidth(4);
				break;

			case LEFT:
                sprite.setSprite(spriteLoc.get("arrowLeft"));
                this.setAnimation(arrowLeft);
				break;

			case RIGHT:
                sprite.setSprite(spriteLoc.get("arrowRight"));
                this.setAnimation(arrowRight);
				break;
		}

		
    }

	@Override
    public void doInLoop()
    {
		// if arrow moves outside of the scene it should die.
		if (x > game.getScene().getSprite().getWidth() || y > game.getScene().getSprite().getWidth() || x < 0 || y < 0)
		{
			alive = false;
			return;
		}

        switch (direction)
		{
			case UP:
                setY(getY() - SPEED);
				break;

			case DOWN:
                setY(getY() + SPEED);
				break;

			case LEFT:
                setX(getX() - SPEED);
				break;

			case RIGHT:
                setX(getX() + SPEED);
				break;
		}
    }

	@Override
    public void preAnimation()
    {
        if(hit)
        {
            liquid = true;
            if(animationCounter == animation.length)
            {
                setAlive(false);
            }
        }
    }

	@Override
    public void wallCollision()
    {
		hit = true;
    }

	@Override
	public void collision(GObject obj)
	{
		if (obj instanceof Hittable && !(obj instanceof Link) && !(obj instanceof Bush))
		{
			Hittable hittable = (Hittable)obj;
			hittable.hitBy(Weapon.ARROW);
            alive = false;
            hit = true;
        }

		if(obj instanceof Guard)
		{
			hit = true;
		}

		if(obj instanceof Bush)
		{
			switch (direction)
			{
				case UP:
					setYHardCore(getY() - SPEED);
					break;

				case DOWN:
					setYHardCore(getY() + SPEED);
					break;

				case LEFT:
					setXHardCore(getX() - SPEED);
					break;

				case RIGHT:
					setXHardCore(getX() + SPEED);
					break;
			}
		}
	}

 
}