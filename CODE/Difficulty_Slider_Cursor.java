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
    int movement_amount = 3;
    GreenfootImage image;
    int third;
    public Difficulty_Slider_Cursor(){
        setImage(new GreenfootImage(50, 10));
        this.image = getImage();
        this.image.setColor(Color.BLUE);
        this.image.fillRect(0, 0, 700, 400);
    }

    public void act()
    {
        move_with_mouse();
        keyboard_movement();
        this.third = get_third();
        colour_by_third();
    }

    public void colour_by_third(){
        switch(this.third){
            case 1:
                // in first third
                this.image = getImage();
                this.image.setColor(Color.YELLOW);
                this.image.fillRect(0, 0, 700, 400);
                break;
            case 2:
                // in second third
                this.image = getImage();
                this.image.setColor(Color.PINK);
                this.image.fillRect(0, 0, 700, 400);
                break;
            case 3:
                // in last third
                this.image = getImage();
                this.image.setColor(Color.RED);
                this.image.fillRect(0, 0, 700, 400);
                break;
        }
    }

    public void keyboard_movement(){
        if(Greenfoot.isKeyDown("a") && getY() < 372){
            this.setLocation(this.getX(), this.getY()+movement_amount);
        } 
        if(Greenfoot.isKeyDown("d") && getY() > 160){
            this.setLocation(this.getX(), this.getY()-movement_amount);
        }
    }

    public int get_third(){
        int y = this.getY(); // get y level 
        // thirds
        int[] third3 = {160, 230};
        int[] third2 = {230, 300};
        int[] third1 = {300, 370}; // in seemingly revserse order because top of screen is y=0
        // get which third is in
        int third_num;
        if(y < third3[1]){
            third_num = 3;
        } else if(y < third2[1]){
            third_num = 2;
        } else if(y < third1[1]){
            third_num = 1;
        } else{
            return -1;
        }
        return third_num;
    }

    public void move_with_mouse(){
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null && m.getButton() == 1){
            // assume down
            m = Greenfoot.getMouseInfo(); // constant update
            // if above top
            if(m.getY() < 160){
                // above top
                this.setLocation(this.getX(), 160);
            } else if(m.getY() > 370){
                // below bottom
                this.setLocation(this.getX(), 370);
            } else{
                // in middle 
                this.setLocation(this.getX(), m.getY());
            }
        }
    }

}

