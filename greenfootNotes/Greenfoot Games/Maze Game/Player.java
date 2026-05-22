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
    public void act()
    {
        
        move();
    }
    public boolean hitWall(){
        if(getOneIntersectingObject(Walls.class) != null){
            return true;
        } else{
            return false;
        }
    }
    
    public void move(){
        if(Greenfoot.isKeyDown("left") && hitWall()){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("right") && hitWall()){
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("up") && hitWall()){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("down") && hitWall()){
            setLocation(getX(), getY()+2);
        }
    }
}
