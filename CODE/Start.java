import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start_Button start_Button = new Start_Button();
        addObject(start_Button,448,302);
        Difficulty_Slider difficulty_Slider = new Difficulty_Slider();
        
        addObject(difficulty_Slider,166,267);
        
        Difficulty_Slider_Cursor difficulty_Slider_Cursor = new Difficulty_Slider_Cursor();
        addObject(difficulty_Slider_Cursor,253,264);
        difficulty_Slider_Cursor.setLocation(264,260);

    }
}
