import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmallRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallRock extends Rocks
{
    /**
     * Act - do whatever the SmallRock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moving();
        //getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
}
