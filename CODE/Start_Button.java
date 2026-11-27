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
    public Start_Button(){ // constructor
        GreenfootImage image = new GreenfootImage(60, 90); // covers doorway
        setImage(image); // sets blank/transparent image
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){ // if clicked (any mouse button)
            // start
            // switch to other world
            MyWorld world = new MyWorld(Difficulty_Slider_Cursor.third, 3*60); // new world with starting 
            // wait time of 3 seconds (3*60acts/s)
            Greenfoot.setWorld(world); // sets world
            // this class now cannot do anything 
        }

    }
}

