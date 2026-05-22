import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallHeightSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallHeightSmall extends Walls
{
    /**
     * Act - do whatever the WallHeightSmall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WallHeightSmall(){
        getImage().scale(getImage().getWidth(), getImage().getHeight()*4);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
