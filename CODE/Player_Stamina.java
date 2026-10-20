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
    public static final int w=200;
    public static final int h=15;
    private final Color bg;
    public static final Color fg = greenfoot.Color.BLACK;
    private GreenfootImage image;
    private GreenfootImage overlay;
    private int last_stamina=100; // default value before properly called (assumes full)

    public Player_Stamina(){
        // main
        this.bg = greenfoot.Color.ORANGE;
        draw(w, h, bg);
        // overlay
    }

    public void act()
    {
        // current iteration of update() will be unfit
        if(!MyWorld.paused()){
            follow(MyWorld.player, 60);

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
        Stamina_Overlay s = new Stamina_Overlay();
        if(diff > 0){
            // if positive...
            s.increase(diff);
        } else{
            s.decrease(-diff);
        }
    }
}
