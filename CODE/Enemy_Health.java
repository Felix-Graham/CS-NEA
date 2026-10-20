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
    private final int hover_space = 250;

    public Enemy_Health(int w, int h, Color bg, Color fg){
        this.w = w;
        this.h = h;
        this.fg = Color.BLACK;//fg;
        this.bg = Color.RED;//bg;
        draw(w, h, bg);
    }

    public void act()
    {
        update(heartbeat(), fg, this);
        if(!MyWorld.paused()){
            follow(MyWorld.enemy, 50);

        }
    }

    private int heartbeat(){
        // method for calculating the necessary fill for the bar
        // from enemy health
        return 100-MyWorld.enemy.health; // already a percentage because out of 100
    }
}
