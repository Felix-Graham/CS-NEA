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
    public int w;
    public final int h;
    private final Color c;
    public static GreenfootImage image;

    public Stamina_Overlay() {
        this.w = 1;
        this.h = Player_Stamina.h; // height will not vary like width; aims to overlap
        this.c = Player_Stamina.fg; 
        draw(w, h, c);
        MyWorld.s = this;
    }

    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 60); 
            setLocation(MyWorld.player.getX()-(Player_Stamina.w/2), getY());

        }
    }

    public void increase(int amount){
        this.w = this.w + amount;
        if(w > 0){
        } else{
            w = 0;
        }
        //draw(w, h, c);
        image.fillRect(0, 0, this.w, this.h);
    
    }

    public void decrease(int amount){
        this.w += amount;
        draw(w, h, c);
    }
}
