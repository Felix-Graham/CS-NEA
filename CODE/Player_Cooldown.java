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
    private final Color hfg;
    private final Color hbg;
    private GreenfootImage image;

    public Player_Cooldown(){
        this.w = 100;
        this.h = 15;
        this.fg = greenfoot.Color.BLUE;
        this.bg = greenfoot.Color.BLUE;
        this.hbg = greenfoot.Color.WHITE;
        this.hfg = greenfoot.Color.PINK;
        draw(w, h, bg);

    }

    public void act()
    {
        follow(MyWorld.player, 80);
        if(MyWorld.player.cooldown > 0){
            show();
            //update(player_heartbeat(), fg, this);
        } else{
            hide();
        }
    }

    private void show(){
        draw(w, h, bg);
    }

    private void hide(){
        draw(w, h, hbg);

    }

  
}
