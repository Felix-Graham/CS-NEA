import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty_Slider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty_Slider extends Actor
{
    /**
     * Act - do whatever the Difficulty_Slider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image;
    public Difficulty_Slider(){
        setImage(new GreenfootImage(190, 225));
        this.image = getImage();
        this.image.setColor(Color.RED);
        this.image.setTransparency(10);
        this.image.fillRect(0, 0, 700, 400);
    }

    public void act()
    {
        // Add your action code here.
    }
}
