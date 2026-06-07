import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeRunner extends Actor
{
    /**
     * Act - do whatever the MazeRunner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MazeRunner(){
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }
    int speed = 4;

    public void slideAround(){
        int x = getX(); int y = getY();
        if(Greenfoot.isKeyDown("right")) setLocation(x+speed, y);
        if(Greenfoot.isKeyDown("left"))  setLocation(x-speed, y);
        if(Greenfoot.isKeyDown("up"))    setLocation(x, y-speed);
        if(Greenfoot.isKeyDown("down"))  setLocation(x, y+speed);
    }

    public boolean hitWalls(){
        if(isTouching(MazeBlock.class)){ return true; }
        else { return false; }
    }

    public void collectBoost(){
        if(isTouching(SpeedBoost.class)){
            speed++;
            removeTouching(SpeedBoost.class);
        }
    }

    public void maxSpeed(){
        if(speed >= 7){ speed = 7; }
    }

    public void youLose(){
        if(mazeRunnerLives == 0){
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    public void youWin(){
        if(isTouching(YouWinPlatform.class)){
            getWorld().addObject(new YouWinScreen(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    public void act()
    {
        // Add your action code here.
    }
}
