import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallHeightBig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallHeightBig extends Walls
{
    /**
     * Act - do whatever the WallHeightBig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WallHeightBig(){
        getImage().scale(getImage().getWidth(), getImage().getHeight()*15);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
