import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Player_Health extends Bars
{
    /**
     * Act - do whatever the Player_Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int w=150;
    private final int h=15;
    private final Color bg=Color.GREEN;
    private final Color fg=Color.BLACK;
    private GreenfootImage image;

    public Player_Health(){
        draw(w, h, bg); // draw bar from inherited method
    }

    public void act()
    {
        if(!MyWorld.pause_state()){ // if world not paused
            update(heartbeat(), fg, this); // update
        }
    }

    private int heartbeat(){
        // method for calculating the necessary fill for the bar
        // from player health
        return MyWorld.round(100-MyWorld.player.health, "###"); // already a percentage because out of 100
    }

}
