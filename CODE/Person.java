import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.*;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Person extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cooldown;
    public static int health;
    final int collision_threshold = 20;

    public void act()
    {
        collide(MyWorld.player, MyWorld.enemy);
    }

    public int get_collision(Person p1, Person p2){
        // method to avoid player and enemy being too close
        // passes two "people" being player 1 and two
        int dx;
        if(p1.getX() > p2.getX()){
            dx = p1.getX() - p2.getX();
        } else{
            dx = p2.getX() - p1.getX();
        }
        
        return dx;
    }
    
    public void collide(Person p1, Person p2){
        int dx = get_collision(p1, p2);
        if(p1.getX() > p2.getX()){
            while (dx <= collision_threshold){
                p1.setLocation(p1.getX()+1, p1.getY());
                p2.setLocation(p1.getX()-1, p1.getY());
            }
        } else{
            while (dx <= collision_threshold){
                p2.setLocation(p1.getX()+1, p1.getY());
                p1.setLocation(p1.getX()-1, p1.getY());
            }
        }
    }

    public void movement(int SPEED, int JUMP, int dir){ // where dir stands for direction to allow enemy to use
        // dir -1> null / 0> left / 1> right / 2> up
        if(Greenfoot.isKeyDown("a") || dir == 0){
            move(-SPEED); // moves backwards when key pressed is a
        }
        if(Greenfoot.isKeyDown("d") || dir == 1 && !MyWorld.player.inhibited_movement){
            move(SPEED); // forward when key pressed is d
        }
        if((Greenfoot.isKeyDown("space") || dir== 2) && isOnGround()){
            setLocation(getX(), getY()-JUMP); // moves up the screen by variable JUMP
        }
        if(!isOnGround()){
            setLocation(getX(), getY()+2); // falls at a rate of 2 units per second
        }
    }

    public void enemovement(int SPEED, int JUMP, int dir){ // where dir stands for direction to allow enemy to use
        // dir -1> null / 0> left / 1> right / 2> up
        if(dir == 0){
            move(-SPEED); // moves backwards when key pressed is a
        }
        if(dir == 1 && !MyWorld.enemy.inhibited_movement){
            move(SPEED); // forward when key pressed is d
        }
        if(dir== 2 && isOnGround()){
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

    public boolean onCooldown(Person p){
        if(p.cooldown > 0){
            return true;
        } else{
            return false;
        }
    }

    // setters
    public void cooldown(double t, Person p){
        double unrounded_cooldown = t*60.0; // converts from seconds to greenfoot ticks
        cooldown = round(unrounded_cooldown, "###"); // sets the cooldown to appropriate integer
        p.cooldown = p.cooldown + cooldown;
    }

    public void damage(int d, Person p){
        this.health = this.health-d;
    }

    public void knockback(int k){
        move(-k);
    }

    // misc
    public static int round(double target, String format){
        DecimalFormat df = new DecimalFormat(format); // where unused digits are 0
        df.setRoundingMode(RoundingMode.CEILING); // round up 
        return Integer.parseInt(df.format(target)); // returns the integer result. 
    }

    public int modulus(int n){
        if(n>0){
            return n;
        } else{
            return -n;
        }
    }

}
