import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty_Slider_Cursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty_Slider_Cursor extends Actor
{
    /**
     * Act - do whatever the Difficulty_Slider_Cursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int movement_amount = 2;
    GreenfootImage image;
    public static int third;
    public Difficulty_Slider_Cursor(){

    }

    public void act()
    {
        move_with_mouse();
        keyboard_movement();
        this.third = get_third();
    }

    public void keyboard_movement(){
        if(Greenfoot.isKeyDown("d") && getX() < 355){
            this.setLocation(this.getX()+movement_amount, this.getY());
        } 
        if(Greenfoot.isKeyDown("a") && getX() > 285){
            this.setLocation(this.getX()-movement_amount, this.getY());
        }
    }

    public int get_third(){
        int x = getX(); // get x  
        int third_num;
        if(x < 300){ // third 1 [285 -> 300]
            third_num = 1;
        } else if(x < 330){ // third 2 [300 -> 330]
            third_num = 2; 
        } else if(x < 375){ // third 1 [330 -> 375]
            third_num = 3;
        } else{
            return -1; //  error code
        }
        return third_num;
    }

    public void move_with_mouse(){
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null && m.getButton() == 1 && m.getActor() != Start.sb){ // has info, left click. not on start button
            // assume down
            m = Greenfoot.getMouseInfo(); // constant update
            // if above top
            if(m.getX() < 285){
                // above right limit
                this.setLocation(285, this.getY());
            } else if(m.getX() > 355){
                // past left limit
                this.setLocation(355, this.getY());
            } else{
                // in middle 
                this.setLocation(m.getX(), this.getY());
            }
        }
    }

}

