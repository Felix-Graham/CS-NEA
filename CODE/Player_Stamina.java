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
    private GreenfootImage overlay;
    private int last_stamina=100; // default value before properly called (assumes full)

    public Player_Stamina(){
        // main
        this.w = 200;
        this.h = 15;
        this.fg = greenfoot.Color.BLACK;
        this.bg = greenfoot.Color.ORANGE;
        draw(w, h, bg);
        // overlay
    }

    public void act()
    {
        // current iteration of update() will be unfit
        if(!MyWorld.paused()){
            follow(MyWorld.player, 30);

        }
        // update
        stamina_update();
        last_stamina = MyWorld.player.stamina; // to be at last line of act method
    }

    private void increase_overlay_size(){

    }

    private void decrease_overlay_size(){

    }

    private void stamina_update(){
        int diff = MyWorld.player.stamina - last_stamina;
        if(diff == 0){
            return; // end function
        }
        if(diff > 0){
            // if positive..
            increase_overlay_size();
        } else{
            decrease_overlay_size();
        }
    }
}
