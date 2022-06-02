package main_classes;
import java.awt.Rectangle;
@SuppressWarnings({ "serial", 
					"unused" })
//line 3 may be deleted while updating class

/*
 * Enemy is a superclass that can represent any enemy in the game
 * This class has 5 instance variables that represent different attributes of the enemy
 * Additionally, this class has some useful methods to represent enemy behavior
 * 
 * You may find the outline tab on the right useful when navigating this class
 */
public class Enemy extends Entity {

//Sunflower Fields
	private String type; //type of enemy
	private int hp; //amount of hp enemy has
	private int atk; //attack strength of enemy
	private int pfE; //relative pathfinding efficiency of enemy
	private boolean living; //control whether enemy should remain alive
	
	
//****CONSTRUCTION ZONE KEEP OUT****
	
	public Enemy(String type, int px, int py) {
		super(px,py); //sets position of enemy
		this.type = type;
		switch (type) {
			case "Octorok":
				hp = 1;
				atk = 1;
				pfE = (int)(Math.random()*2); //pathfinding power based on enemy type, slightly random
				break;
			case "Moblin":
				hp = 2;
				atk = 2;
				pfE = (int)(Math.random()*3) + 2; //above
			case "Lynel":
				hp = 5;
				atk = 4;
				pfE = 5; //unlike others, lynels will always have a pfE of 5
		}
		living = true;
	}
	/*
	 * Constructor 2: Electic boogaloo
	 * Custom values can be set for enemy fields
	 * Use this constructor for non-regular enemies like bosses
	 */
	public Enemy(String type, int health, int attack, int pathfindingEfficiency, int px, int py) {
		super(px,py); //sets position of enemy
		this.type = type;
		hp = health;
		atk = attack;
		pfE = pathfindingEfficiency;
		living = true;
	}
	
//****CONSTRUCTION ZONE KEEP OUT****

	
	
//Functional Methods

	/*
	 * Reduces enemy health by amount of damage dealt by the player
	 * 
	 * Parameters: int (damage taken)
	 * Returns: Remaining HP of enemy
	 */
	public int hit(int damage) {
		hp -= damage;
		if (hp <= 0)
			living = false;
		return hp;
	}
	
	/* 
	 * TODO
	 * Moves enemy to a tile depending on its relative pathfinding efficiency
	 * This is the most important method in this class as it governs movement of the enemy
	 * 
	 * Manipulates px and py fields of superclass Entity
	 * Parameters: none
	 * Returns: nothing
	 */
	public void pathfind() {}
	
	/*
	 * TODO
	 * Calculates a single tile move that will bring it closer to the player,
	 * should be used to assist pathfind()
	 * 
	 * Parameter(s): Player, Map (Panel representing the current screen)
	 * 		Player used to calculate distance to player and direction required to move
	 * 		Map used to make sure enemy does not move into an inaccessible area
	 * 			(e.g. beyond borders or into obstacles)
	 * 
	 * Returns: Tile close to player - return type currently void, will change when implemented
	 */
	public void tileToPlayer(/*Player p, Map screen*/) {}
	
	/*
	 * TODO
	 * Shoots projectile in direction specified by a string
	 * The player should ONLY be damaged if projectile collides with player and does not
	 * run into an obstacle
	 * 
	 * Parameter(s): Player, String (direction)
	 * Returns: nothing
	 */
	public void shootProjectile(/*Player p, */ String direction) {/*Rectangle projectile;*/}
	
	/*
	 * TODO
	 * Performs an attack, damage done as per the atk field
	 * The player should ONLY be damaged if the enemy is within one tile of the player
	 * 
	 * Parameter(s): Player
	 * Returns: Remaining HP of player
	 */
	public int attackMeelee(/*Player p, */) {return 0;}
//End of Functional Methods
	
//Accessor Methods
	public String getType() {return type;}
	public int getHP() {return hp;}
	public int getAttack() {return atk;}
	public int getPathfindingEfficiency() {return pfE;}
	public boolean isAlive() {return living;}
	
}
