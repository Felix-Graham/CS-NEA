import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Person
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // to be populated
    int SPEED;
    int JUMP;
    int STAMINA_MAX;
    int DAMAGE_PUNCH;
    int DAMAGE_KICK;
    int KNOCKBACK_PUNCH;
    int KNOCKBACK_KICK;
    // constants
    final int STAMINA_DRAIN_PUNCH = 10;
    final double COOLDOWN_PUNCH = 0.2;
    final double COOLDOWN_KICK = 0.5;
    final int STAMINA_DRAIN_KICK = 20;
    // Mutable variables
    public int stamina = 100;
    private int cooldown = 0;
    public int health = 100;
    private int imgState = 0; // 0 as default, 1 for punch, 2 for kick
    private int imgCountdown = 0;

    public Enemy(int SPEED, int JUMP, int SM, int DM, int KM){
        this.SPEED = SPEED;
        this.JUMP = JUMP;
        this.STAMINA_MAX = SM;
        // DM stands for Damage Multiplier and takes 1 as player attributes
        World w = (World) getWorld();
        //Player p = (Player) w.getObjects(Player.class); // gets player class

        this.DAMAGE_PUNCH = round((Player.DAMAGE_PUNCH * DM), "###");
        this.DAMAGE_KICK = round((Player.DAMAGE_KICK * DM), "###");
        // KM stands for knockback multiplier and takes from player 
        this.KNOCKBACK_PUNCH = round((Player.KNOCKBACK_PUNCH * DM), "###");
        this.KNOCKBACK_KICK = round((Player.KNOCKBACK_KICK * DM), "###");

    }
    public void act()
    {
        // Add your action code here.
    }
}
