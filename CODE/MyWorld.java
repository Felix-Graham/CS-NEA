import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public static Enemy enemy; // enemy placeholder variable
    public static Player player; // all of these are public static and 
    public static Stamina_Overlay s; // can thus be accessed from anywhere

    private static boolean paused; // encapsulation-based variables controls pause state

    public static int wait; // used for initial wait period

    public static int difficulty; // difficulty populated by Difficulty Slider


    public MyWorld(int difficulty, int initial_wait) // constructor with parameters for difficulty and initial wait
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        this.difficulty = difficulty; // sets difficulty to be passed to Enemy
        MyWorld.wait = initial_wait; // initial wait period

        MyWorld.paused = true; // default start value

        prepare();
    }

    public void act(){
        if(MyWorld.wait <= 0){
            MyWorld.pause_toggle();
            MyWorld.wait = 999999; // arbitrarily high value so it is no longer effective
        } else{
            MyWorld.wait--;
        }

        // health condition checking 
        if(enemy.health <= 0){ // if enemy dies
            WinScreen win = new WinScreen(); // new win screen
            win.reset_values(); // reset variables, this is necessary because they are static and thus 
            // semi-permanent in memory. Done in this line because the next line `MyWorld` loses influence
            // as it is no longer the set world
            Greenfoot.setWorld(win); // sets world to win
        }
        if(player.health <= 0){ // if player dies
            LoseScreen lose = new LoseScreen(); // new lose screen
            lose.reset_values(); // reset values
            Greenfoot.setWorld(lose); // sets the world to the lose screen
        }
    }

    private void prepare()
    {

        Player player = new Player();
        addObject(player,137,306);
        // int SPEED, int JUMP, int SM, int DM, int KM
        Enemy enemy = new Enemy(5, 200, player);
        addObject(enemy,395,306);

        Enemy_Health enemy_Health = new Enemy_Health(150, 15, greenfoot.Color.RED, greenfoot.Color.RED);
        addObject(enemy_Health,517,38);

        Player_Health player_Health = new Player_Health();
        addObject(player_Health,91,126);

        Player_Stamina player_Stamina = new Player_Stamina();
        addObject(player_Stamina,116,148);

        Player_Cooldown player_Cooldown = new Player_Cooldown();
        addObject(player_Cooldown,314,47);
        PlayPause playPause = new PlayPause();
        addObject(playPause,60,57);

        Stamina_Overlay stamina_Overlay = new Stamina_Overlay();
        addObject(stamina_Overlay,18,148);
    }

    // pause management

    public static boolean pause_state(){
        return MyWorld.paused; // encapsulation ensures that only this class can 
        // modify or directly access the variable, makes program more robust
    }

    public static void pause_toggle(){
        MyWorld.paused = !MyWorld.paused; // flips from true -> false and vice versa
    }

    public static void pause_wait(int t){ // function for dynamic wait periods
        MyWorld.wait = t;
    }

    // modulus accessible from all classes in world
    public static int modulus(int n){
        if(n>0){
            return n;
        } else{
            return -n;
        }
    }

    public static int round(double target, String format){
        DecimalFormat df = new DecimalFormat(format); // where unused digits are 0
        df.setRoundingMode(RoundingMode.CEILING); // round up 
        return Integer.parseInt(df.format(target)); // returns the integer result. 
    }
}
