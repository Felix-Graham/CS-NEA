import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayPause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayPause extends Actor
{
    /**
     * Act - do whatever the PlayPause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this) || Greenfoot.isKeyDown("p")){
            MyWorld w = getWorldOfType(MyWorld.class);
            w.pause_toggle();
        }
        if(MyWorld.paused()){
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.RED);
            image.fill();
            this.setImage(image);
        }
    }
    

}
