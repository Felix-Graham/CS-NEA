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
    public static final int w=200; // default width for the screen
    public static final int h=15; // default height
    private final Color bg = Color.ORANGE; // colour for this bar
    public static final Color fg = greenfoot.Color.BLACK;
    private GreenfootImage image;
    private GreenfootImage overlay;
    private int last_stamina=100; // default value before properly called (assumes full)
    private Stamina_Overlay s;

    public Player_Stamina(){
        draw(w, h, bg); // calls `Bars` method to draw self with necessary parameters
        Stamina_Overlay s = new Stamina_Overlay(); // creates new overlay object
    }

    public void act()
    {
        if(!MyWorld.pause_state()){ // world not paused
            stamina_update(); // update from player stamina (public)
            last_stamina = MyWorld.player.stamina; // to be at last line of act method
        }
    }

    private void stamina_update(){
        int diff = -2*(MyWorld.player.stamina - last_stamina); // diff is the change of the stamina variable in Player
        if(diff == 0){
            return; // end function
        }
        MyWorld.s.augment(diff); // where diff is a signed int
        // calls overlay `augment` method via world because it is easier
    }
}
