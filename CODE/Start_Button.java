import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_Button extends Actor
{
    /**
     * Act - do whatever the Start_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start_Button(){
        // should aim to take up displayed play button
    }

    public void act()
    {
        play();
    }

    private void play(){
        if(Greenfoot.mouseClicked(this)){
            // start
            // switch to other world
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
