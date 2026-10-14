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
    
    public MyWorld()
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

        Player player = new Player();
        addObject(player,PlayerStartX,PlayerStartY);
        // int SPEED, int JUMP, int SM, int DM, int KM
        Enemy enemy = new Enemy(5, 200, 100, 2, 3, player);
        addObject(enemy,395,306);
        Enemy_Health enemy_Health = new Enemy_Health(150, 15, greenfoot.Color.RED, greenfoot.Color.RED);
        addObject(enemy_Health,201,160);
        enemy_Health.setLocation(302,144);
        Player_Health player_Health = new Player_Health();
        addObject(player_Health,308,111);
        Player_Stamina player_Stamina = new Player_Stamina();
        addObject(player_Stamina,320,83);
        Player_Cooldown player_Cooldown = new Player_Cooldown();
        addObject(player_Cooldown,314,47);
    }
    




    public int modulus(int n){
        if(n>0){
            return n;
        } else{
            return -n;
        }
    }
}
