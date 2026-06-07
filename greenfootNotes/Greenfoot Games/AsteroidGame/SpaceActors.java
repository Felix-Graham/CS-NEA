import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceActors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceActors extends Actor
{
    /**
     * Act - do whatever the SpaceActors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int verticalSpeed=0;
    int horizontalSpeed=0;
    public void act()
    {
        wrapAtEdge();
        setLocation(getX()+horizontalSpeed, getY()+verticalSpeed);
    }
    
    public void wrapAtEdge(){
        if(getX()==0){
            setLocation(598, getY());
        }
        if(getY()==0){
            setLocation(getX(), 398);
        }
        if(getX()==599){
            setLocation(1, getY());
        }
        if(getY()==399){
            setLocation(getX(), 0);
        }
    }
}
