import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWalker extends Actor
{
    /**
     * Act - do whatever the EnemyWalker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EnemyWalker(boolean upDown){
        this.upDown = upDown;
    }

    public void enemyHitWalls(){
        if(hitWalls() || atEdge()){
            speed = -speed;
        }
    }

    public void mazeRunnerHit(){
        if(hitEnemy()){ setLocation(45, 60); }
    }

    public void act()
    {
        // Add your action code here.
    }
}
