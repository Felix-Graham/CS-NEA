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
public abstract class Person extends Actor // abstract class meaning we cannot construct a `Person` object
{ // this is intended because it is designed solely as a parent class
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cooldown;
    public static int health;
    final int collision_threshold = 20; // variables created to be inherited
    
    // act() method not applicable to abstract class

    public int get_collision(Person p1, Person p2){
        // method to avoid player and enemy being too close
        // passes two "people" being player 1 and two
        int dx = MyWorld.modulus(p1.getX() - p2.getX());
        return dx;
    }

    public void collide(Person p1, Person p2){
        int dx = get_collision(p1, p2); // gets distance between two people
        if(p1.getX() > p2.getX()){ // p2 further left of p1
            while (dx < collision_threshold){ // while the distance is less than optimal (threshold)
                p1.setLocation(p1.getX()+1, p1.getY()); // move each one apart
                p2.setLocation(p1.getX()-1, p1.getY());
                dx = get_collision(p1, p2); // refresh dx
            }
        } else{
            while (dx < collision_threshold){ 
                p2.setLocation(p1.getX()+1, p1.getY()); // moves each apart in relevant directions (left-most goes left)
                p1.setLocation(p1.getX()-1, p1.getY());
                dx = get_collision(p1, p2);
            }
        }
    }

    public void force_collision(Person p){
        Actor intersected = p.getOneIntersectingObject(Person.class); // Actor for Greenfoot class conversion
        if(intersected != null){
            // if this actor is 'inside' another 'Person' 
            // then 'move back'
            if(intersected.getX() > p.getX()){
                move(-1);
            } else if(intersected.getX() < p.getX()){
                move(1);
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
    public boolean isOnGround(){ // method to get if a `Person` child is on the ground
        if(getY()==306){
            return true;
        }
        return false;
    }

    public boolean onCooldown(Person p){ // method to get if a `Person` child's cooldown is not 0
        if(p.cooldown > 0){
            return true;
        } else{
            return false;
        }
    }

    // setters
    public void cooldown(double t, Person p){
        double unrounded_cooldown = t*60.0; // converts from seconds to greenfoot ticks
        cooldown = MyWorld.round(unrounded_cooldown, "###"); // sets the cooldown to appropriate integer
        p.cooldown = p.cooldown + cooldown;
    }

    public void damage(int d, Person p){
        this.health = this.health-d; // polymorphic method for a `Person` child to be damaged
    }

    public void knockback(int k, Person aggressor){
        // code copied from Enemy runToward() and modified
        int locX = aggressor.getX(); // gets aggressor x
        if(locX < this.getX()+10){ // if aggressor left of this
            move(1); 
        } else if(locX > this.getX()-10){ // if aggressor right of this
            move(-1);
        }// the if clauses above feature +/-10 so that if the aggressor is very 
        // close they do not get stuck
    }
}
