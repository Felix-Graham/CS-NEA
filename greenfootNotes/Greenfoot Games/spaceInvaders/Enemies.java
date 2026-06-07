import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Actor
{
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed=2;
    int health=1;
    public int getHealth(){
        return health;
    }
    public void lowerHealth(){
        health--;
        Counter c = new Counter();
        c.score++;
        
    }
    public void shot(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile!=null){
            lowerHealth();
            getWorld().removeObject(projectile);
        }
    }
    public void isDead(){
        if(health<=0){
            getWorld().removeObject(this);
        }
    }
    public void act()
    {
        removeAtEdge();
    }
    public void removeAtEdge(){
        if(getY()>390){
            lowerHealth();
        }
    }
    public void movement(){
        setLocation(getX(), getY()+speed);
    }
}
