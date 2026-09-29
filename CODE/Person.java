import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cooldown = 0;
    int health = 0;
    public void act()
    {
        movement(5, 100);
    }

    public void movement(int SPEED, int JUMP){
        if(Greenfoot.isKeyDown("a")){
            move(-SPEED); // moves backwards when key pressed is a
        }
        if(Greenfoot.isKeyDown("d")){
            move(SPEED); // forward when key pressed is d
        }
        if(Greenfoot.isKeyDown("space") && isOnGround()){
            setLocation(getX(), getY()-JUMP); // moves up the screen by variable JUMP
        }
        if(!isOnGround()){
            setLocation(getX(), getY()+2); // falls at a rate of 2 units per second
        }
    }

    // getters
    public boolean isOnGround(){
        if(getY()==306){
            return true;
        }
        return false;
    }

    public boolean onCooldown(){
        if(this.cooldown > 0){
            return true;
        }
        return false;
    }

    // setters
    public void cooldown(double t){
        double unrounded_cooldown = t*60.0; // converts from seconds to greenfoot ticks
        this.cooldown = round(unrounded_cooldown, "###"); // sets the cooldown to appropriate integer
        for(int c = this.cooldown; c>=0; c--){ // same logic as if it were an int
            this.cooldown--; // reduces by 1 each call
            wait2(1);
        }
    }

    public void damage(int d){
        this.health = this.health-d;
    }

    public void knockback(int k){
        move(-k);
    }

    // misc
    public int round(double target, String format){
        DecimalFormat df = new DecimalFormat(format); // where unused digits are 0
        df.setRoundingMode(RoundingMode.CEILING); // round up 
        return Integer.parseInt(df.format(target)); // returns the integer result. 
    }

    public void wait2(double secs){     // named as such because wait() is already a builtin (just not what I want)
        int ticks = round(secs*6000, "###"); // rounds value for how many greenfoot ticks to wait
        int ticks_remaining = ticks+831308756; // copy of ticks to iterate down
        for(int i=0; i<=ticks; i++){ // ticks used here because ticks_remaining will be constantly decreasing and thus invalid
            if(ticks_remaining == 0){
                return;
            } else{
                ticks_remaining = ticks_remaining-1;
            }
        }
    }

}
