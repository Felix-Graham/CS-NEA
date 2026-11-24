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
    // nemesis 
    Player p; // instead of struggling to get player object pass it into constructor when created.
    // to be populated
    int SPEED;
    int JUMP;
    int DAMAGE_PUNCH; // to be populated by difficulty
    int DAMAGE_KICK;
    int KNOCKBACK_PUNCH;
    int KNOCKBACK_KICK;
    int REACTION_TIME;
    double IMAGE_SCALE;
    int HEALTH_MAX;

    // constants
    final int STAMINA_DRAIN_PUNCH = 10;
    final double COOLDOWN_PUNCH = 0.2;
    final double COOLDOWN_KICK = 0.5;
    final int STAMINA_DRAIN_KICK = 20;
    final int STAMINA_MAX=100; 
    // Mutable variables
    public int stamina = 100;
    private int cooldown = 0;
    public static int health = 100;
    private int imgState = 0; // 0 as default, 1 for punch, 2 for kick
    private int imgCountdown = 0;
    private int reaction = 0;

    final static int RANGE_KICK = 100;
    final static int RANGE_PUNCH = 80;

    public boolean inhibited_movement = false;

    private boolean read_pause_state = MyWorld.paused();

    public Enemy(int SPEED, int JUMP, int SM, int DM, int KM, Player nemesis){
        this.SPEED = SPEED;
        this.JUMP = JUMP;
        this.p = nemesis;
        // add self to world variable
        MyWorld.enemy = this;

        int world_difficulty = MyWorld.difficulty;
        double lower;
        double upper;

        switch(world_difficulty){
            case 1:
                lower = 0.2;
                upper = 0.8;
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

        this.DAMAGE_KICK = Person.round(this.p.DAMAGE_KICK * get_random_in_range(lower, upper), "###");
        this.DAMAGE_PUNCH = Person.round(this.p.DAMAGE_PUNCH * get_random_in_range(lower, upper), "###");
        this.KNOCKBACK_KICK = Person.round(this.p.KNOCKBACK_KICK * get_random_in_range(lower, upper), "###");
        this.KNOCKBACK_PUNCH = Person.round(this.p.KNOCKBACK_PUNCH * get_random_in_range(lower, upper), "###");
        this.SPEED = Person.round(this.p.SPEED * get_random_in_range(lower, upper)-1, "###");

        this.HEALTH_MAX = Person.round(this.p.health * get_random_in_range(lower, upper), "###");
        this.health = HEALTH_MAX;

        this.IMAGE_SCALE  = get_random_in_range(lower, upper);
        int w = Person.round(getImage().getWidth()*IMAGE_SCALE, "###");
        int h = Person.round(getImage().getHeight()*IMAGE_SCALE, "###"); // defined by one variable for continuity
        GreenfootImage image = getImage();

        image.scale(w, h);
        setImage(image);
    }

    public double get_random_in_range(double n1, double n2){ // where n1 > n2
        Random r = new Random();
        double rd = r.nextDouble(); // 0 -> 1
        double result = rd*(n2-n1)+n1;
        return result;
    }

    public void act()
    {
        read_pause_state = MyWorld.paused;

        if(Person.local_pause == true){
            //collision(MyWorld.player, MyWorld.enemy);
            imgCountdown++;
            if(this.cooldown > 0){
                this.cooldown--;
            }
            if(this.stamina < this.STAMINA_MAX){
                this.stamina++;
            }
            // image changes 
            if(this.imgCountdown >= 30){
                changeImage();
                this.imgCountdown = 0;
            } else{
                this.imgCountdown++;
            }
            if(this.reaction >= this.REACTION_TIME){ // loops back infinitely
                this.reaction = 0;
            } else{
                this.reaction++;
            }

            decide();

        }
        force_collision(this);
    }

    public void damage(int d){
        if(this.health - d <= 0){
            this.health = 0;
        } else{
            this.health = this.health-d;
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
        if(proximity < 150 && react){ // adds time to attack (reaction time)
            // attack
            if(cooldown == 0 && stamina > STAMINA_DRAIN_KICK){
                kick();
                this.imgState = 2;
            } else if(cooldown == 0 && stamina > STAMINA_DRAIN_PUNCH){
                punch();
                this.imgState = 1;
            }
            this.imgState = 0;
        }
    }
    // the following is a near-copy paste job from the player class.
    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){
            if(cooldown == 0){

                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_PUNCH){ 
                    MyWorld.player.damage(DAMAGE_PUNCH);
                    MyWorld.player.knockback(KNOCKBACK_PUNCH);
                }

                //setImage("enemy_punch.png");
                this.imgState = 1;
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_PUNCH*60, "###");
            }
        } else {
            this.imgState = 0;
        }
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(cooldown == 0){

                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_KICK){ 
                    MyWorld.player.damage(DAMAGE_KICK);
                    MyWorld.player.knockback(KNOCKBACK_KICK);
                }

                //setImage("enemy_kick.png");
                this.imgState = 2;
                stamina = stamina - STAMINA_DRAIN_KICK;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_KICK*60, "###");
            }
        } else{
            this.imgState = 0;
        }
    }

    private void changeImage(){
        int s = this.imgState; // for easier reference
        switch(s){ // switch case removes need for innefficient if/else
            case 0:
                GreenfootImage stand_sprite = new GreenfootImage("enemy_stand_arms_down.png");
                sprite_scale(stand_sprite);
                break;
            case 1:
                GreenfootImage punch_sprite = new GreenfootImage("enemy_punch.png");
                sprite_scale(punch_sprite);
                break;
            case 2:
                GreenfootImage kick_sprite = new GreenfootImage("enemy_kick.png");
                sprite_scale(kick_sprite);
                break;
            default:
                GreenfootImage default_sprite = new GreenfootImage("enemy_stand_arms_down.png");
                sprite_scale(default_sprite);
                break;
        }
        // now instead of changing image in a method (happens ~instantly),
        // changes image in act method via this method.
    }

    public void sprite_scale(GreenfootImage image){
        // method to return the scaled image from global IMAGE_SCALE
        int w = Person.round(image.getWidth()*this.IMAGE_SCALE, "###");
        int h = Person.round(image.getHeight()*this.IMAGE_SCALE, "###");
        image.scale(w, h);
        setImage(image);
    }

    // collision
    public void collide(){
        // enemy collide will function by setting a condition to true which will inhibit 
        // movement. This will be set to false by following method
        inhibited_movement = true;
    }
}
