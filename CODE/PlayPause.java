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
    private boolean p_pause = false;
    private int p_pause_cooldown = 10; // 1/6 of a second between possible presses of key
    public void act()
    {
        if(p_pause_cooldown <= 0){
            p_pause_cooldown = 10;

            if(Greenfoot.getKey() == "p"){
                p_pause = !p_pause; // flips from true -> false or false -> true
            }
        } else {
            p_pause_cooldown--;
        }
        
        if(Greenfoot.mousePressed(this) || p_pause){
            //MyWorld.pause_toggle();
            Person.local_pause = !Person.local_pause; // flips from true -> false or false -> true
        } else{
            //MyWorld.paused = !MyWorld.paused;
        }
        if(MyWorld.paused() || Person.local_pause || p_pause){
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
