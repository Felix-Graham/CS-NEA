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
    private final int w;
    private final int h;
    private final Color bg;
    private final Color fg;
    private GreenfootImage image;

    public Player_Health(){
        this.w = 150;
        this.h = 15;
        this.fg = greenfoot.Color.BLACK;
        this.bg = greenfoot.Color.GREEN;
        draw(w, h, bg);
    }

    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 30);
            update(player_heartbeat(), fg, this);
        }
    }

    private int player_heartbeat(){
        // method for calculating the necessary fill for the bar
        // from player health
        return round(100-MyWorld.player.health, "###"); // already a percentage because out of 100
    }
    

}
