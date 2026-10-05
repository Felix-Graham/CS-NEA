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

        this.DAMAGE_PUNCH = round((Player.DAMAGE_PUNCH * DM), "###");
        this.DAMAGE_KICK = round((Player.DAMAGE_KICK * DM), "###");
        // KM stands for knockback multiplier and takes from player 
        this.KNOCKBACK_PUNCH = round((Player.KNOCKBACK_PUNCH * DM), "###");
        this.KNOCKBACK_KICK = round((Player.KNOCKBACK_KICK * DM), "###");

    }
    public void act()
    {
        decide();
    }
    
    public int proximity(){
        int prox;
        // prox will work with the X axis alone both for ease and practicality
        Player p = (Player) getWorld().getObjects(Player.class);
        prox = (this.getX() - p.getX());
        if(prox > 0){ // as if 5
            return prox;
        } else{ // as if -5
            return -prox;
        }
        // above if statement functions as modulus because negative proximity would not be possible
        // proximity would be negative if the player is on the other side to the enemy as planned
    }
    private void runToward(){
        Player p = (Player) getWorld().getObjects(Player.class);
        int locX = p.getX();
        // left of player where (0, 0) at left of screen 
        if(locX < this.getX()){ // this.getX() used for clarity over "getX()" on its own
            movement(SPEED, JUMP, 1); // dir (final parameter) 0 as left, 1 as right
        } else if(locX > this.getX()){
            movement(SPEED, JUMP, 0);
        }
    }
    private void runAway(){
        Player p = (Player) getWorld().getObjects(Player.class);
        int locX = p.getX();
        // left of player where (0, 0) at left of screen 
        if(locX < this.getX()){ // this.getX() used for clarity over "getX()" on its own
            movement(SPEED, JUMP, 0); // dir (final parameter) 0 as left, 1 as right
        } else if(locX > this.getX()){
            movement(SPEED, JUMP, 1);
        }
        // code copy and pasted from runToward method with movement parameters modified
    }
    private void decide(){
    /*
     * Conditions:
     * p.stamina > this.stamina
     * p.health > this.health
     * proximity < 5
     */
        Player p = (Player) getWorld().getObjects(Player.class);
        
        boolean staminaDiff = (p.stamina > this.stamina);
        boolean healthDiff = (p.health > this.health);
        int proximity = proximity();
        
        // staminaDiff condition:
        if(staminaDiff){
            // run away from player
            runAway();
        } else{
            // run toward player
            runToward();
        }
        
        // healthDiff condition
        if(healthDiff){
            //run away
            runAway();
        } else{
            //run toward
            runToward();
        }
        
        // proximity condition
        if(proximity < 5){
            // attack
            /* if(!kickCooldown && stamina > kickStaminaDrain){
             *      kick();
             *  } else{
             *      punch();
             *  }
             */
        }
    }
}
