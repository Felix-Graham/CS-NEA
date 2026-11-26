import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test extends Actor
{
    /**
     * Act - do whatever the Test wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Test(int h, int w){
        GreenfootImage i = new GreenfootImage(h, w);
        i.setColor(Color.RED);
        i.fill();
        setImage(i);
    }
    public void act()
    {
        // Add your action code here.
    }
}
