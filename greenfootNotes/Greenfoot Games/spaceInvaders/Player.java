import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean canFire=true;

    public void act()
    {
        setRotation(270);
        movement();
        shoot();
    }
    public void movement(){
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-3, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+3, getY());
        }
    }
    public void shoot(){
        
        if(Greenfoot.isKeyDown("space") && canFire){
            Actor shot = new Projectile();
            getWorld().addObject(shot, getX(), getY()-3);
            canFire=false;
        }
        if(!Greenfoot.isKeyDown("space")){
            canFire=true;
        }
    }
}
