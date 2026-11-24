import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public final int PlayerStartX = 137;
    public final int PlayerStartY = 306;

    public static Enemy enemy;
    public static Player player;
    public static Stamina_Overlay s;

    public static boolean paused;
    public static int wait=60*3; // initial wait period

    public static int difficulty;

    //private boolean pause_state = true; // non static for local influence

    public MyWorld(int difficulty, int initial_wait)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600, 400, 1); 
        this.difficulty = difficulty;
        MyWorld.wait = initial_wait;
        MyWorld.paused = true;
        prepare();
        //paused = pause_state;
    }

    public void act(){
        if(MyWorld.wait <= 0){
            //unpause();
            MyWorld.paused = false;
            //Person.local_pause = false;
        } else{
            //pause();
            MyWorld.paused = true;
            Person.local_pause = true;
            MyWorld.wait--;
        }
        // health condition checking 
        if(enemy.health <= 0){
            WinScreen win = new WinScreen();
            win.reset_values();
            Greenfoot.setWorld(win);
        }
        if(player.health <= 0){
            LoseScreen lose = new LoseScreen();
            lose.reset_values();
            Greenfoot.setWorld(lose);
        }
    }

    private void prepare()
    {

        Player player = new Player();
        addObject(player,PlayerStartX,PlayerStartY);
        // int SPEED, int JUMP, int SM, int DM, int KM
        Enemy enemy = new Enemy(5, 200, 100, 2, 3, player);
        addObject(enemy,395,306);

        Enemy_Health enemy_Health = new Enemy_Health(150, 15, greenfoot.Color.RED, greenfoot.Color.RED);
        addObject(enemy_Health,512,126);

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
    public static void pause(){
        MyWorld.paused = true; // sets global access variable to true
        Person.local_pause = true;
    }

    public static boolean paused(){
        return MyWorld.paused; // encapsulation ensures that only this class can 
        // modify or directly access the variable, makes program more robust
    }

    public static void unpause(){
        MyWorld.paused = false;
        Person.local_pause = false;
    }

    public static void pause_toggle(){
        MyWorld.paused = !MyWorld.paused;
        Person.local_pause = !Person.local_pause;
    }

    public static void wait_please(int t){
        MyWorld.wait = t;
    }

    public boolean are_we_unpausing(){
        if(MyWorld.wait <= 0){
            return true;
        } else{
            return false;
        }
    }

    // modulus accessible from all classes in world
    public static int modulus(int n){
        if(n>0){
            return n;
        } else{
            return -n;
        }
    }
}
