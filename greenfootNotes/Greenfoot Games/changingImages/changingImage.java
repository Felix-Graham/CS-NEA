import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class changingImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class changingImage extends Actor
{
    /**
     * Act - do whatever the changingImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int num = 0;
    public void act()
    {
        moveAround();
    }

    public void moveAround(){
        move(3);
        if(getX()==599){
            turn(90);
            changeImage();
        }
    }
    public void changeImage(){
        num++;
        if(num>3){
            num=0;
        }
        setImage(num+".png");
    }
}
