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
    private final int w=100;
    private final int h=15;
    private final Color bg=Color.BLUE; // both the same as it is displayed for such short amount of time
    private final Color fg=Color.BLUE; // an overlay/decrementation would be irrelevant
    private GreenfootImage image;

    public Player_Cooldown(){
        draw(w, h, bg); // draws self
    }

    public void act()
    {
        if(!MyWorld.pause_state()){ // if not paused
            follow(MyWorld.player, 100); // follow player
            if(MyWorld.player.cooldown > 0){ // if Player's cooldown is not 0 
                show(); // display this
            } else{
                hide(); // otherwise do not
            }
        }
    }

    private void show(){
        draw(w, h, bg); // draws new self
    }

    private void hide(){
        GreenfootImage i = new GreenfootImage(1, 1); // new blank image of minimal dimensions and no colour
        setImage(i); // sets to invisible
    }

}
