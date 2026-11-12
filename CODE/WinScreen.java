import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    private int preclick_time = 60*3; // act 60 times per seconds :. 3 seconds
    private Player player;
    private Enemy enemy;
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }

    public void act(){
        if(preclick_time > 0){
            preclick_time--;
        } else if(Greenfoot.mouseClicked(this)){
            // if clicked transition to start menu 
            World start = new Start(this.player, this.enemy); // instance new start menu world 
            Greenfoot.setWorld(start); // move to it
        }
    }

    public void reset_values(){
        // because many player/enemy values are static they persist in memory
        // thus to move on we need to alter them to their original state
        // we will do this by creating new objects to pass onto Start() and thus to MyWorld()
        this.player = new Player();
        this.enemy = new Enemy(5, 200, 100, 2, 3, player);
    }
}
