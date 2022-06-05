package zelda.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import zelda.Main;
import zelda.link.Link;
import zelda.menu.MainMenu;
import zelda.scene.ArmosScene;
import zelda.scene.CastleBasementScene;
import zelda.scene.CastleScene;
import zelda.scene.DungeonScene;
import zelda.scene.HiddenScene;
import zelda.scene.HyruleScene;
import zelda.scene.HouseScene;


public class Game
{
	private boolean running = true;
	private boolean paused  = false;
	private boolean debug   = false;

    private int gameSpeed = 10;
    private int width = 500;
    private int height = 400;

    private Link link;
    private Scene scene;

	
    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    private boolean wPressed = false;
    private boolean jPressed = false;
    private boolean kPressed = false;
	private boolean enterPressed = false;

    private long lastHit = System.currentTimeMillis();
    private long lastHit2 = System.currentTimeMillis();

    public Game()
	{
        link = new Link(this, 100, 100);
		scene = new MainMenu(this);
    }

	public void quit()
	{
		System.exit(0);
	}

	public Scene initScene(String sceneName)
	{
		Scene scn = null;

		if(sceneName.equals("HouseScene"))
		{
			scn = new HouseScene(this, "GameStart");
		}

        if(sceneName.equals("HyruleScene"))
		{
			scn = new HyruleScene(this, "HouseScene");
		}

        if(sceneName.equals("HiddenScene"))
		{
			scn = new HiddenScene(this, "HyruleSceneHatch");
		}
        

        if (sceneName.equals("DungeonScene"))
        {
            scn = new DungeonScene(this, "GameStart");
        }

        if (sceneName.equals("CastleScene"))
        {
            scn = new CastleScene(this, "HyruleScene");
        }

        if (sceneName.equals("CastleBasementScene"))
        {
            scn = new CastleBasementScene(this, "CastleScene");
        }
        
        if (sceneName.equals("ArmosScene"))
        {
            scn = new ArmosScene(this, "CastleBasementScene");
        }


		return scn;
	}

	
	public Link getLink()
	{
		return link;
	}

	public boolean isRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	public boolean isPaused()
	{
		return paused;
	}

	public boolean isDebug()
	{
		return debug;
	}

	public void setPaused(boolean paused)
	{
		this.paused = paused;
	}

	public int getGameSpeed()
	{
		return gameSpeed;
	}

	public void setGameSpeed(int gameSpeed)
	{
		this.gameSpeed = gameSpeed;
	}

	public synchronized Scene getScene()
	{
		return scene;
	}

	public synchronized void setScene(Scene scene)
	{
		this.scene = scene;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setaPressed(boolean aPressed)
	{
		this.aPressed = aPressed;
	}

	public void setdPressed(boolean dPressed)
	{
		this.dPressed = dPressed;
	}

	public void setjPressed(boolean jPressed)
	{
		this.jPressed = jPressed;
	}

	public void setkPressed(boolean kPressed)
	{  
		this.kPressed = kPressed;
	}

	public void setsPressed(boolean sPressed)
	{
		this.sPressed = sPressed;
	}

	public void setwPressed(boolean wPressed)
	{
		this.wPressed = wPressed;
	}

	public void setEnterPressed(boolean enterPressed)
	{
		this.enterPressed = enterPressed;
	}

	public boolean isaPressed()
	{
		return aPressed;
	}

	public boolean isdPressed()
	{
		return dPressed;
	}

	public boolean isjPressed()
	{
		return jPressed;
	}

	public boolean iskPressed()
	{
		return kPressed;
	}


	public boolean issPressed()
	{
		return sPressed;
	}

	public boolean iswPressed()
	{
		return wPressed;
	}

	public boolean isEnterPressed()
	{
		return enterPressed;
	}
}
