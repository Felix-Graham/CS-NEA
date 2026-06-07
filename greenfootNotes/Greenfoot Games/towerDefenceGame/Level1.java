import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(map[i][j]==1){
                    addObject(new Road(), 30+j*60, 30+i*60);
                }
            }
        }
    }

    public void addTowers(){
        if(Greenfoot.mouseClicked(null)){
            if(Greenfoot.getMouseInfo().getActor()==null){
                int x = (Greenfoot.getMouseInfo().getX()/60)*60+30;
                int y = (Greenfoot.getMouseInfo().getY()/60)*60+30;
                addObject(new Tower(), x, y);
            }
        }
    }
}
