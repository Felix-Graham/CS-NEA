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
        // act not applicable: all update methods called from outside this class
    }

    public void augment(int amount){
        this.w = this.w + amount; // increases width by the given amount
        if(w > 0){
        } else{ // if width is not greater than 0 (-1) set as 1 for continuity correction
            w = 1;
        }
        setImage(new GreenfootImage (this.w, this.h)); // creates a new sprite for this image
        this.image = getImage(); // gets this image as a variable to edit etc
        this.image.setColor(this.c); // set the image colour
        this.image.fillRect(0, 0, w*2, this.h+5); // fills the image

    }

}
