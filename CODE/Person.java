import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public void cooldown(int t){ // t in seconds
        this.cooldown = t*60; // greenfoot tick speed is 60 per second, this allows t to be passed as seconds
        for(int c = this.cooldown; c>=0; c--){ // uses this.cooldown to reference object's value
            this.cooldown--; // eventually sets cooldown back to 0
        }
    }

    public void damage(int d){
        this.health = this.health-d;
    }

    public void knockback(int k){
        move(-k);
    }

}
