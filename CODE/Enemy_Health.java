import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enemy_Health extends Bars
{
    /**
     * Act - do whatever the Enemy_Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int w;
    private final int h;
    private final Color bg;
    private final Color fg;
    private GreenfootImage image;

    public Enemy_Health(int w, int h, Color bg, Color fg){
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
