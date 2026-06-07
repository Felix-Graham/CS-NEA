import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SpaceActors
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int verticalSpeed=0;
    int horizontalSpeed=0;
    boolean fire=true;
    public void act()
    {
        turn();
        accelerateOnCommand();
        wrapAtEdge();
        fireOnCommand();
        setLocation(getX()+horizontalSpeed, getY()+verticalSpeed);
    }

    public void fireOnCommand(){
        Projectile projectile = new Projectile();
        if(Greenfoot.isKeyDown("f") && fire){
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            fire=false;
        }
        if(!Greenfoot.isKeyDown("f")){
            fire=true;
        }
    }

    public void turn(){
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
        }
    }

    public void accelerateOnCommand(){
        if(Greenfoot.isKeyDown("space")){
            if(getRotation()==0){
                horizontalSpeed++;
            }
            if(getRotation()==180){
                horizontalSpeed--;
            }
            if(getRotation()==90){
                verticalSpeed++;
            }
            if(getRotation()==270){
                verticalSpeed--;
            }
        }
    }

}
