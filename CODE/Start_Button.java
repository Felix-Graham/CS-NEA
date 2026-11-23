import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_Button extends Actor
{
    /**
     * Act - do whatever the Start_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Player player;
    private Enemy enemy;
    public Start_Button(){
        // should aim to take up displayed play button
        this.player = player; 
        this.enemy = enemy;
        // player and enemy passed in 
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            // start
            // switch to other world
            MyWorld world = new MyWorld(Difficulty_Slider_Cursor.third, 3*60); // new world with starting 
            // wait time of 3 seconds (3*60acts/s)
            Greenfoot.setWorld(world); // sets world
            // this class now cannot do anything 
        }

    }
}

