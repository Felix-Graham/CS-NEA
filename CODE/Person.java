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
        //movement(5, 100);
    }

    public void movement(int SPEED, int JUMP, int dir){ // where dir stands for direction to allow enemy to use
        // dir -1> null / 0> left / 1> right / 2> up
        if(Greenfoot.isKeyDown("a") || dir == 0){
            move(-SPEED); // moves backwards when key pressed is a
        }
        if(Greenfoot.isKeyDown("d") || dir == 1){
            move(SPEED); // forward when key pressed is d
        }
        if((Greenfoot.isKeyDown("space") || dir== 2) && isOnGround()){
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

 

}
