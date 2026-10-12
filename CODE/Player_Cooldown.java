import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_Cooldown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Player_Cooldown extends Bars
{
    /**
     * Act - do whatever the Player_Cooldown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int w;
    private final int h;
    private final Color bg;
    private final Color fg;
    private GreenfootImage image;

    public Player_Cooldown(int w, int h, Color bg, Color fg){
        this.w = w;
        this.h = h;
        this.fg = fg;
        this.bg = bg;
        draw(w, h, bg);
    }

    public void act()
    {
        // Add your action code here.
    }
}
