import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocks extends SpaceActors
{
    /**
     * Act - do whatever the Rocks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int horizontalSpeed=1;
    int verticalSpeed=1;
    public Rocks(){
        if(Greenfoot.getRandomNumber(2)==1){
            horizontalSpeed=-horizontalSpeed;
        }
        if(Greenfoot.getRandomNumber(2)==1){
            verticalSpeed=-verticalSpeed;
        }
    }
    public void moving(){
        setLocation(getX()+horizontalSpeed, getY()+verticalSpeed);
        wrapAtEdge();
    }
    public void act()
    {
        wrapAtEdge();
    }
}
