import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int SPEED = 5;
    final int JUMP = 70;
    final int DAMAGE_PUNCH = 15;
    final int DAMAGE_KICK = 25;
    final int KNOCKBACK_PUNCH = 3;
    final int KNOCKBACK_KICK = 7;
    
    int cooldown = 0;
    int health = 100;
    public void act()
    {
        movement(5, 70);
    }

    private void punch(){
        setImage("player_punch");
        /*
         * enemy = getOneIntersectingObject(Enemy)
         * enemy.damage(DAMAGE_PUNCH);
         * enemy.knockback(KNOCKBACK_PUNCH);
         */
        cooldown(10);
    }
}
