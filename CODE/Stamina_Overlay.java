import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stamina_Overlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stamina_Overlay extends Bars
{
    /**
     * Act - do whatever the Stamina_Overlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int w;
    private final int h;
    private final Color c;

    public Stamina_Overlay() {
        this.w = 1;
        this.h = Player_Stamina.h; // height will not vary like width; aims to overlap
        this.c = Player_Stamina.fg; 
        draw(w, h, c);
    }

    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 60); 
            setLocation(MyWorld.player.getX()-(Player_Stamina.w/2), getY());

        }
    }

    public void increase(int amount){
        this.w = w + amount;
        if(w > 0){
            
        } else{
            w = 0;
            
        }
        draw(w, h, c);
    }

    public void decrease(int amount){
        this.w += amount;
        draw(w, h, c);
    }
}
