import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayPause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayPause extends Actor
{
    /**
     * Act - do whatever the PlayPause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this) || Greenfoot.isKeyDown("p")){
            /*if(MyWorld.paused == true){
            MyWorld.paused = false;
            } else{
            MyWorld.paused = true;
            }*/
            MyWorld.paused = true;
        } else{
            MyWorld.paused = true;
        }
        if(MyWorld.paused()){
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.RED);
            image.fill();
            this.setImage(image);
        } else{
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.GREEN);
            image.fill();
            this.setImage(image);
        }
    }

}
