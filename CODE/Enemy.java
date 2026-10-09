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
    // nemesis 
    Player p; // instead of struggling to get player object pass it into constructor when created.
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
    
    public boolean inhibited_movement = false;

    public Enemy(int SPEED, int JUMP, int SM, int DM, int KM, Player nemesis){
        this.SPEED = SPEED;
        this.JUMP = JUMP;
        this.STAMINA_MAX = SM;
        this.p = nemesis;
        // DM stands for Damage Multiplier and takes 1 as player attributes

        this.DAMAGE_PUNCH = round((Player.DAMAGE_PUNCH * DM), "###");
        this.DAMAGE_KICK = round((Player.DAMAGE_KICK * DM), "###");
        // KM stands for knockback multiplier and takes from player 
        this.KNOCKBACK_PUNCH = round((Player.KNOCKBACK_PUNCH * DM), "###");
        this.KNOCKBACK_KICK = round((Player.KNOCKBACK_KICK * DM), "###");

        // add self to world variable
        MyWorld.enemy = this;
    }

    public void act()
    {
        collision(MyWorld.player, MyWorld.enemy);
        imgCountdown++;
        if(cooldown > 0){
            cooldown--;
        }
        if(stamina < STAMINA_MAX){
            stamina++;
        }
        // image changes 
        if(imgCountdown == 30){
            changeImage();
            imgCountdown = 0;
        }

        decide();

    }

    public int proximity(){
        int prox;
        // prox will work with the X axis alone both for ease and practicality
        //Player p = (Player) getWorld().getObjects(Player.class).get(0); // .get(0) because the method returns an array where we want the first item in it
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
        //Player p = (Player) getWorld().getObjects(Player.class);
        int locX = p.getX()+120;
        // left of player where (0, 0) at left of screen 
        if(locX < this.getX()){ // this.getX() used for clarity over "getX()" on its own
            enemovement(SPEED, JUMP, 0); // dir (final parameter) 0 as left, 1 as right
        } else if(locX > this.getX()){
            enemovement(SPEED, JUMP, 1);
        }
    }

    private void runAway(){
        //Player p = (Player) getWorld().getObjects(Player.class);
        int locX = p.getX();
        // left of player where (0, 0) at left of screen 
        if(locX < this.getX()){ // this.getX() used for clarity over "getX()" on its own
            enemovement(SPEED, JUMP, 0); // dir (final parameter) 0 as left, 1 as right
        } else if(locX > this.getX()){
            enemovement(SPEED, JUMP, 1);
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
        //Player p = (Player) getWorld().getObjects(Player.class).get(0);

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
        if(proximity < 130){
            // attack
            if(cooldown == 0 && stamina > STAMINA_DRAIN_KICK){
                kick();
                imgState = 2;
            } else if(cooldown == 0 && stamina > STAMINA_DRAIN_PUNCH){
                punch();
                imgState = 1;
            }
            imgState = 0;
        }
    }
    // the following is a near-copy paste job from the player class.
    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){
            if(!onCooldown()){
                /*
                 * enemy = getOneIntersectingObject(Enemy);
                 * enemy.damage(DAMAGE_PUNCH);
                 * enemy.knockback(KNOCKBACK_PUNCH);
                 */
                setImage("enemy_punch.png");
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                cooldown(COOLDOWN_PUNCH);
                p.knockback(KNOCKBACK_PUNCH);
                p.damage(DAMAGE_PUNCH);
            }
        }
        imgState = 0;
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(!onCooldown()){
                /*
                 * enemy = getOneIntersectingObject(Enemy);
                 * enemy.damage(DAMAGE_KICK);
                 * enemy.knockback(KNOCKBACK_KICK);
                 */ 
                setImage("enemy_kick.png");
                stamina = stamina - STAMINA_DRAIN_KICK;
                cooldown(COOLDOWN_KICK);
                p.knockback(KNOCKBACK_KICK);
                p.damage(DAMAGE_KICK);
            }
        }
        imgState = 0;
    }

    private void changeImage(){
        int s = this.imgState; // for easier reference
        switch(s){ // switch case removes need for innefficient if/else
            case 0:
                setImage("enemy_stand_arms_down.png");
                break;
            case 1:
                setImage("enemy_punch.png");
                break;
            case 2:
                setImage("enemy_kick.png");
            default:
                setImage("enemy_stand_arms_down.png");
                break;
        }
        // now instead of changing image in a method (happens ~instantly),
        // changes image in act method via this method.
    }

    // collision
    public void collide(){
        // enemy collide will function by setting a condition to true which will inhibit 
        // movement. This will be set to false by following method
        inhibited_movement = true;
    }
}
