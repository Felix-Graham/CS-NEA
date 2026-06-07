import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){

    }

    public void act()
    {
        setLocation(getX(), getY()-5);
        removeAtEdge();
    }

    public void removeAtEdge(){
        if(getY()<20){
            getWorld().removeObject(this);
        }
    }

}

