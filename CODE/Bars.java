import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 * Write a description of class Bars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bars extends Actor
{
    /**
     * Act - do whatever the Bars wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private final int w=100;
    private final int h=10;
    private final Color bg=Color.RED;
    private final Color fg=Color.BLACK; 
    private GreenfootImage image;
    private final int hover_space=150;
    
/*    public Bars(int w, int h){//, Color bg, Color fg){
        this.w = w;
        this.h = h;
        this.bg = Color.RED;//bg;
        this.fg = Color.BLACK;//fg;

        draw(w, h, bg);
    }
    */

    public void act()
    {/*
        if(Greenfoot.isKeyDown("k")){
            fill_pc = fill_pc+10;
        } else if(Greenfoot.isKeyDown("j")){
            fill_pc = fill_pc-10;
        }
        update(fill_pc, this.fg);
        */
    }

    public void follow(Person p, int space){
        space = space+100; // normalises for player heights
        // passes person such that can follow with p.getX() and p.getY()
        int x = getX();
        int y = getY();
        int next_x = p.getX();
        int next_y = p.getY() - space;
        // the goal is to have a slow-ish speed at which to follow the person over their head
        // this will thus have a separate function called `move_request()` to handle gradual movement
        // via the act method.
        int tdx = x - next_x; // total displacement x
        int tdy = y - next_y;
        // these values will be constantly updated via the act method
        // move_request() will be called to move incrementally to the next_x/y location
        if(x != next_x && y != next_y){
            if(x > next_x){
                // next to the left
                move_request(-10, 0);
            }
            if(y > next_y){
                // next higher up
                move_request(0, -10);
            }
            if(y < next_y){
                move_request(0, 10);
            }
            if(x < next_x){
                move_request(10, 0);
            }
        }
    }
    
    public void move_request(int dx, int dy){
        setLocation(getX()+dx, getY()+dy);
    }
    
    public void draw(int w, int h, Color c){
        // method to instantiate a bar
        // method will be used by child classes to display them
        setImage(new GreenfootImage(w, h)); // declares image
        GreenfootImage bar = getImage(); // gets declared image as a variable
        // draw the rectangle
        bar.setColor(c);
        bar.drawRect(0, 0, w+2, h+1); // x, y, width, height
        bar.fillRect(0, 0, w, h);
        this.image = bar; // allows other methods to access and modify bar

    }

    public void update(int pc, Color c, Bars b){ // where pc is the percentage of the bar to be filled
        // calculate width to fill from given percentage
        int w = round((b.w*(pc/100)), "###"); // relies on java's auto rounding for int
        this.image.setColor(c);
        this.image.fillRect(0, 0, w, b.h);
    }
    
        public int round(double target, String format){
        DecimalFormat df = new DecimalFormat(format); // where unused digits are 0
        df.setRoundingMode(RoundingMode.CEILING); // round up 
        return Integer.parseInt(df.format(target)); // returns the integer result. 
    }
    
}
