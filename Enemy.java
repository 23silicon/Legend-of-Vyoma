/*
 * Enemy is a superclass that represents any enemy in the game.
 * This class has 4 instance variables that represent different attributes of the enemy.
 * Additionally this class has some useful methods to represent enemy behavior.
 * 
 */
import java.awt.Rectangle;
public class Enemy {

	private String type; //type of enemy
	private int hp; //amount of hp enemy has
	private int atk; //attack strength of enemy
	private int pfE; //relative pathfinding efficiency of enemy
	
	
	public Enemy(String type) {
		this.type = type;
		switch (type) {
			case "Octorok":
				hp = 1;
				atk = 1;
				pfE = (int)(Math.random()*2);
				break;
			case "Moblin":
				hp = 2;
				atk = 2;
				pfE = (int)(Math.random()*3) + 2;
			case "Lynel":
				hp = 5;
				atk = 5;
				pfE = 5;
		}
	}
	
	public Enemy(String type, int health, int attack, int pathfindingEfficiency) {
		this.type = type;
		hp = health;
		atk = attack;
		pfE = pathfindingEfficiency;
	}
	
	/*
	 * TODO
	 * Moves enemy to a tile depending on its relative pathfinding efficiency. 
	 * This is the most important method in this class.
	 * 
	 */
	public void pathfind() {
		
	}
	
	/*
	 * TODO
	 * Calculates a single tile move that will bring it closer to the player,
	 * should be used to assist pathfind().
	 */
	public void tileToPlayer() { 
		
	}
	
	//TODO shoots projectile in direction specified by a string
	public void shootProjectile(String direction, Rectangle r) {
		Rectangle proj = new Rectangle(r);
	}
	
}
