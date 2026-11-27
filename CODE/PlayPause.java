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
    private boolean p_pause = false; // by having a different pause interface we can apply certain rules 
    // to using the p key to pause. This is used here to add a short break `p_pause_cooldown` to stop multiple inputs detected for
    // one press
    private int p_pause_cooldown = 30; 
    public void act()
    {
        if(Greenfoot.isKeyDown("p") && p_pause_cooldown == 0){ // if is allowed to detect p input

            p_pause = !p_pause; // flips from true -> false or false -> true
            p_pause_cooldown = 30; // reset cooldown

        }

        if(p_pause_cooldown > 0){ // tends toward 0 as long as it has not passed it
            p_pause_cooldown--;
        }

        if(Greenfoot.mousePressed(this) || p_pause){ // pause if pause actor pressed OR p_pause (p button pressed)
            MyWorld.pause_toggle(); // uses MyWorld static method to pause game globally
        } 

        if(MyWorld.pause_state() || p_pause){ // if paused by either method display as red
            GreenfootImage image = new GreenfootImage(100, 100); // dimensions
            image.setColor(Color.RED); // colour
            image.fill(); // fill
            this.setImage(image); // render
        } else{ // otherwise display the same size as green
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.GREEN);
            image.fill();
            this.setImage(image);
        }
    }

}
