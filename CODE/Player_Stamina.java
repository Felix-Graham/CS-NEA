import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_Stamina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Player_Stamina extends Bars
{
    /**
     * Act - do whatever the Player_Stamina wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int w;
    private final int h;
    private final Color bg;
    private final Color fg;
    private GreenfootImage image;

    public Player_Stamina(){
        this.w = 200;
        this.h = 15;
        this.fg = greenfoot.Color.BLACK;
        this.bg = greenfoot.Color.ORANGE;
        draw(w, h, bg);
    }

    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 60);
        }
    }
}
