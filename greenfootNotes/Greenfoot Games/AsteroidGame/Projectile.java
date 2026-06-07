import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SpaceActors
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){
        
    }
    public void act()
    {
        move(5);
        killRocks();
    }
    public void killRocks(){
        Actor rocks = getOneIntersectingObject(Rocks.class);
        Actor debris1 = new SmallRock();
        Actor debris2 = new SmallRock();
        if(rocks!=null){
            getWorld().addObject(debris1, getX(), getY());
            getWorld().addObject(debris2, getX(), getY());
            getWorld().removeObject(rocks);
            getWorld().removeObject(this);
            
        }
        
    }
}
