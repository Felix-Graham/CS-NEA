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
    int REACTION_TIME;
    double IMAGE_SCALE;
    // constants
    final int STAMINA_DRAIN_PUNCH = 10;
    final double COOLDOWN_PUNCH = 0.2;
    final double COOLDOWN_KICK = 0.5;
    final int STAMINA_DRAIN_KICK = 20;
    // Mutable variables
    public int stamina = 100;
    private int cooldown = 0;
    public static int health = 100;
    private int imgState = 0; // 0 as default, 1 for punch, 2 for kick
    private int imgCountdown = 0;
    private int reaction = 0;

    final static int RANGE_KICK = 40;
    final static int RANGE_PUNCH = 20;

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

        int world_difficulty = MyWorld.difficulty;
        switch(world_difficulty){
            case 1:
                this.REACTION_TIME = 90; // measured in act() calls 
                this.IMAGE_SCALE = 0.8;
                break;
            case 2:
                this.REACTION_TIME = 60;
                this.IMAGE_SCALE = 1;
                break;
            case 3: 
                this.REACTION_TIME = 30;
                this.IMAGE_SCALE = 1.2;
                break;
        }

        int w = Person.round(getImage().getWidth()*1.2, "###");
        int h = Person.round(getImage().getHeight()*1.2, "###");
        GreenfootImage image = getImage();

        image.scale(w, h);
        setImage(image);
    }

    public void act()
    {
        if(!MyWorld.paused()){
            //collision(MyWorld.player, MyWorld.enemy);
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
            
            if(reaction >= REACTION_TIME){ // loops back infinitely
                reaction = 0;
            } else{
                reaction++;
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
        if(proximity < 120 && react){ // adds time to attack (reaction time)
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
            if(cooldown == 0){

                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_PUNCH){ 
                    MyWorld.player.damage(DAMAGE_PUNCH);
                    MyWorld.player.knockback(KNOCKBACK_PUNCH);
                }

                setImage("enemy_punch.png");
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_PUNCH*60, "###");
            }
        }
        imgState = 0;
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(cooldown == 0){

                if(MyWorld.modulus((MyWorld.player.getX()-getX())) < RANGE_KICK){ 
                    MyWorld.player.damage(DAMAGE_KICK);
                    MyWorld.player.knockback(KNOCKBACK_KICK);
                }

                setImage("enemy_kick.png");
                stamina = stamina - STAMINA_DRAIN_KICK;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_KICK*60, "###");
            }
        }
        imgState = 0;
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
