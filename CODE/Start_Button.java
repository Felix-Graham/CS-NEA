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
    public Start_Button(){
        // should aim to take up displayed play button
    }

    int timer = 60*3; // 3 lots of 60 calls per second
    public void act()
    {
        //play();
        if(Greenfoot.mouseClicked(this)){
            // start
            // switch to other world
            World world = new MyWorld(Difficulty_Slider_Cursor.third);
            //world.difficulty = Difficulty_Slider_Cursor.get_third();
            Greenfoot.setWorld(world);
            MyWorld.pause(); // pause world 

        }
        // wait three seconds 
        MyWorld.wait_please(60*3);

    }
}

