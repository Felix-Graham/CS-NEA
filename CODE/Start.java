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
    public static Start_Button sb = new Start_Button(); // creates object to be accessed by `Difficulty_Slider_Cursor`
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
        addObject(this.sb,326,152); // adds to world in the relevant position

        Difficulty_Slider_Cursor difficulty_Slider_Cursor = new Difficulty_Slider_Cursor(); // new object
        addObject(difficulty_Slider_Cursor,253,264); // adds to world at location
        difficulty_Slider_Cursor.setLocation(289,292);
    }
}
