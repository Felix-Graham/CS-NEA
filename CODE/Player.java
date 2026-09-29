import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // constant variables
    // By declaring these here, the program is easier to tweak because the variables are easier to see.
    final int SPEED = 5;
    final int JUMP = 70;
    final int DAMAGE_PUNCH = 15;
    final int STAMINA_DRAIN_PUNCH = 0;//10;
    final double COOLDOWN_PUNCH = 0;//0.2;
    final double COOLDOWN_KICK = 0;//0.5;
    final int STAMINA_DRAIN_KICK = 0;//20;
    final int DAMAGE_KICK = 25;
    final int KNOCKBACK_PUNCH = 3;
    final int KNOCKBACK_KICK = 7;

    // Mutable variables
    public int stamina = 1000;
    private int cooldown = 0;
    public int health = 100;


    public void act()
    {
        movement(SPEED, JUMP); // passes constant parameters to inherited method `movement`
        attacks();
        wait2(900);
    }
    
    public int wait2(int secs){     // named as such because wait() is already a builtin (just not what I want)
        //int ticks = round(secs*6000, "###"); // rounds value for how many greenfoot ticks to wait
        int ticks_remaining = 831308756; // copy of ticks to iterate down
        /*for(int i=0; i<=secs*60; i++){ // ticks used here because ticks_remaining will be constantly decreasing and thus invalid
            if(ticks_remaining == 0){
                return;
            } else{
                ticks_remaining = ticks_remaining-1;
            }
        }*/
        while(ticks_remaining > 0){
            ticks_remaining--;
        }
        return 0;
    }

    private void attacks(){
        MouseInfo mouse = Greenfoot.getMouseInfo(); // calls Greenfoot's MouseInfo class for data such as follows 
        if(mouse != null && mouse.getButton() == 1){ // 1 for left mouse button, 2 for middle, 3 for right 
            // if left mouse button clicked:
            punch();
            wait2(100);
        } 
        else if(mouse != null && mouse.getButton() == 3){ // in this and above, != null is used because Greenfoot has that as default value
            kick();
            wait2(100);
        } else{
            wait2(999);
            setImage("player_stand_arms_down.png");
        }
    }

    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){
            if(cooldown == 0){
                /*
                 * enemy = getOneIntersectingObject(Enemy);
                 * enemy.damage(DAMAGE_PUNCH);
                 * enemy.knockback(KNOCKBACK_PUNCH);
                 */
                setImage("player_punch.png");
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                cooldown(COOLDOWN_PUNCH);
                wait2(999);
            }
        }
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(cooldown == 0){
                /*
                 * enemy = getOneIntersectingObject(Enemy);
                 * enemy.damage(DAMAGE_KICK);
                 * enemy.knockback(KNOCKBACK_KICK);
                 */ 
                setImage("player_kick.png");
                stamina = stamina - STAMINA_DRAIN_KICK;
                cooldown(COOLDOWN_KICK);
            }
        }
    }
}
