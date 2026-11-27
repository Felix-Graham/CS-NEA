import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
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
    Player p; // instead of struggling to get player object pass it into constructor when created.
    // to be populated
    public int SPEED;
    public int JUMP;
    public int DAMAGE_PUNCH; // to be populated by difficulty
    public int DAMAGE_KICK; // from player values
    public int KNOCKBACK_PUNCH;
    public int KNOCKBACK_KICK;
    public int REACTION_TIME;
    public double IMAGE_SCALE; // allows values such as 1.5x etc
    public int HEALTH_MAX;

    // constants
    final int STAMINA_DRAIN_PUNCH = 10;
    final double COOLDOWN_PUNCH = 0.2;
    final double COOLDOWN_KICK = 0.5;
    final int STAMINA_DRAIN_KICK = 20;
    final int STAMINA_MAX=100; 
    final static int RANGE_KICK = 100;
    final static int RANGE_PUNCH = 80;

    // Mutable variables
    public int stamina = 100;
    private int cooldown = 0;
    public static int health = 100; // static for global reference

    // act mutable values
    private int imgState = 0; // 0 as default, 1 for punch, 2 for kick
    private int imgCountdown = 0;
    private int reaction = 0;

    public boolean inhibited_movement = false; // force collision from Player

    private GreenfootImage stand_sprite;
    private GreenfootImage kick_sprite; // sprites initialised
    private GreenfootImage punch_sprite;

    private void spriting(){
        GreenfootImage i = new GreenfootImage("sir chicken digby ceaser.png"); // declares i as target image
        this.stand_sprite = sprite_scale(i); // declares initialised variable as scaled for use
        i = new GreenfootImage("sdcc_punch.png"); // repeats ...
        this.punch_sprite = sprite_scale(i);
        i = new GreenfootImage("sdcc_kick.png");
        this.kick_sprite = sprite_scale(i);
    }

    public Enemy(int SPEED, int JUMP, Player nemesis){
        //       speed        jump    player location 
        //                   height     in   memory

        this.SPEED = SPEED; // sets speed
        this.JUMP = JUMP; // sets jump height 
        this.p = nemesis; // sets `p`

        // add self to world variable
        MyWorld.enemy = this;

        int world_difficulty = MyWorld.difficulty; // collects World difficulty from public variable
        double lower; // upper random bound
        double upper; // lower random bound

        switch(world_difficulty){
            case 1: // if world difficulty is 1 then
                lower = 0.2;
                upper = 0.8; // set upper and lower bounds
                break;
            case 3:
                lower = 1.4;
                upper = 2;
                break;
            default: // instead of case 2 :. default is average
                lower = 0.7;
                upper = 1.2;
                break;
        }

        this.DAMAGE_KICK = MyWorld.round(this.p.DAMAGE_KICK * get_random_in_range(lower, upper), "###"); // sets kick damage as {player kick damage * random in bounds)
        this.DAMAGE_PUNCH = MyWorld.round(this.p.DAMAGE_PUNCH * get_random_in_range(lower, upper), "###"); // same for those below
        this.KNOCKBACK_KICK = MyWorld.round(this.p.KNOCKBACK_KICK * get_random_in_range(lower, upper), "###");
        this.KNOCKBACK_PUNCH = MyWorld.round(this.p.KNOCKBACK_PUNCH * get_random_in_range(lower, upper), "###");
        this.SPEED = MyWorld.round(this.p.SPEED * get_random_in_range(lower, upper)-1, "###");

        this.HEALTH_MAX = MyWorld.round(this.p.health * get_random_in_range(lower, upper), "###");
        this.health = HEALTH_MAX; // sets health to the health maximum (starts full)

        this.IMAGE_SCALE  = get_random_in_range(lower, upper); // random image scale set globally
        spriting(); // assigns sprites
        setImage(this.stand_sprite); // sets image as default stand sprite
    }

    public double get_random_in_range(double n1, double n2){ // where n1 > n2
        Random r = new Random(); // gets a new random number
        double rd = r.nextDouble(); // 0 -> 1; for testing let rd = 0.5, n1(lower_bound) = 0.2, n2(upper_bound) = 0.8
        double result = rd*(n2-n1)+n1; // result = 0.5*(0.8 - 0.2) + 0.2; result = 0.40+0.2 = 0.42 which is a double between 0.2 and 0.8
        return result; // thus result is 
    }

    public void act()
    {
        if(!MyWorld.pause_state()){ // only runs if world is not paused
            if(this.cooldown > 0){
                this.cooldown--;
            }
            if(this.stamina < this.STAMINA_MAX){
                this.stamina++;
            }
            // image changes 
            if(this.imgCountdown >= 30){ // if imgCountdown is greater or equal to 30 then (happens every 0.5 seconds)
                changeImage(); // change image to the next stored one (kick/punch/stand)
                this.imgCountdown = 0; // reset at 0
            } else{
                this.imgCountdown++; // if variable does not meet the condition increment it
            }

            if(this.reaction >= this.REACTION_TIME){ // loops back infinitely
                this.reaction = 0; 
            } else{
                this.reaction++;
            }

            decide(); // main decision algoithm for attacking, moving etc

            force_collision(this); // collision unique as to not inhibit player and make the game frustrating
        }
    }

    public void damage(int d){ // public damage encapsulative method so that enemy can be damaged
        if(this.health - d <= 0){ // if health would go under 0, stop at 0
            this.health = 0;
        } else{
            this.health = this.health-d; // otherwise decrease accordingly
        }
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
        int locX = p.getX();
        // left of player where (0, 0) at left of screen 
        if(locX+120 < this.getX()){ // this.getX() used for clarity over "getX()" on its own
            enemovement(SPEED, JUMP, 0); // dir (final parameter) 0 as left, 1 as right
        } else if(locX-120 > this.getX()){
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
        boolean react = this.reaction == 0; // checks reaction when called
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
        if(proximity < 90 && react){ // adds time to attack (reaction time)
            // attack
            if(cooldown == 0 && stamina > STAMINA_DRAIN_KICK){
                kick();
            } else if(cooldown == 0 && stamina > STAMINA_DRAIN_PUNCH){
                punch();
            }
        } else {
            this.imgState = 0; // change image

        }
    }
    // the following is a near-copy paste job from the player class.
    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){ // if there is enough stamina
            if(cooldown == 0){ // if is not on cooldown
                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_PUNCH){  // and player in range
                    MyWorld.player.damage(DAMAGE_PUNCH); // damage player
                    MyWorld.player.knockback(KNOCKBACK_PUNCH, this); // knockback player
                }

                this.imgState = 1; // set corresponding image 
                stamina = stamina - STAMINA_DRAIN_PUNCH; // decrease stamina
                cooldown = cooldown + MyWorld.round(COOLDOWN_PUNCH*60, "###"); // apply cooldown by seconds
            }
        } else {
            this.imgState = 0; // set to default sprite if not met condition
        }
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){ // exactly the same process as above
            if(cooldown == 0){ 

                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_KICK){ 
                    MyWorld.player.damage(DAMAGE_KICK);
                    MyWorld.player.knockback(KNOCKBACK_KICK, this);
                }
                this.imgState = 2;
                stamina = stamina - STAMINA_DRAIN_KICK;
                cooldown = cooldown + MyWorld.round(COOLDOWN_KICK*60, "###");
            }
        } else{
            this.imgState = 0;
        }
    }

    private void changeImage(){
        int s = this.imgState; // for easier reference
        switch(s){ // switch case removes need for innefficient if/else
            case 0:
                setImage(this.stand_sprite); // scales and sets the passed image 
                break;
            case 1:
                setImage(this.punch_sprite);
                break;
            case 2:
                setImage(this.kick_sprite);
                break;
            default:
                setImage(this.stand_sprite);
                break;
        }
        // now instead of changing image in a method (happens ~instantly),
        // changes image in act method via this method.
    }

    public GreenfootImage sprite_scale(GreenfootImage image){
        // method to return the scaled image from global IMAGE_SCALE
        int w = MyWorld.round(image.getWidth()*this.IMAGE_SCALE, "###");
        int h = MyWorld.round(image.getHeight()*this.IMAGE_SCALE, "###");
        image.scale(w, h);
        return image;
    }

    // collision
    public void collide(){
        // enemy collide will function by setting a condition to true which will inhibit 
        // movement. This will be set to false by following method
        inhibited_movement = true;
    }
}
