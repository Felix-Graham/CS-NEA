import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Constants
    int FLOOR = 306;

    // attributes
    boolean isOnGround = true;

    public void act()
    {
        movement();
        if(getY() <= FLOOR){
            isOnGround = false;
        }
        while(isOnGround == false){
            setLocation(getX(), getY()+1);
            if(getY() >= FLOOR){
                isOnGround = true;
            }
        }
    }

    public void movement(){
        if(Greenfoot.isKeyDown("d")){
            move(2);
        } else if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("space") && isOnGround == true){
            // jump
            setLocation(getX(), getY()-1000);
        }

    }
}
