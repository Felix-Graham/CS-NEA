import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyFlyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFlyer extends Actor
{
    /**
     * Act - do whatever the EnemyFlyer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(5);
    }

    public void wrapAtEdge(){
        int worldWidth = getWorld().getWidth()-1;
        int worldHeight = getWorld().getHeight()-1;
        if(getX() >= worldWidth) setLocation(1, getY());
        if(getX() <= 0) setLocation(worldWidth-1, getY());
        if(getY() >= worldHeight) setLocation(getX(), 1);
        if(getY() <= 0) setLocation(getX(), worldHeight-1);
    }
}
