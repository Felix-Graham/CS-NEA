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
    public int h;
    private final Color c;
    public GreenfootImage image;

    public Stamina_Overlay() {
        this.w = 1;
        this.h = Player_Stamina.h; // height will not vary like width; aims to overlap
        this.c = Player_Stamina.fg;
        setImage(new GreenfootImage (this.w, this.h));
        this.image = getImage();
        MyWorld.s = this;
        this.image.setColor(this.c);
        this.image.fillRect(0, 0, this.w, this.h);
    }

    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 60); // same movement as Player_Stamina thus should overlay
            setLocation(MyWorld.player.getX()-(Player_Stamina.w/2-this.w/2), getY()); // moves to start of stamina bar
            //this.image.fillRect(0, 0, this.w, this.h);

        }
    }

    public void augment(int amount){
        this.w = this.w + amount;
        if(w > 0){
        } else{
            w = 0;
        }
        setImage(new GreenfootImage (this.w, this.h));
        this.image = getImage();
        this.image.setColor(this.c);
        this.image.fillRect(0, 0, w*2, this.h+5);

    }

}
