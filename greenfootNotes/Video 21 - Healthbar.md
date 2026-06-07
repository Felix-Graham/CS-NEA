## Summary
> New greenfoot images for bar and barfill
> Set up variables in class `healthbar` for health, max width etc
> New method `update`:
``` java 
public void update(){
	setImage( new GreenfootImage(healthbarWidth+2, healthbarHeight+2));
	getImage().setColor(Color.WHITE);
	getImage().drawRect(0, 0, healthbarWidth+1, healthbarHeight+1);
	getImage().setColor(Color.RED);
	getImage().fillRect(1, 1, health*pixelsperHealthPoint, healthbarHeight);
}
``` 
> Constructor for class `healthbar`
> Set up health bar getter&setter for other classes to interface with it
> Did the same with counter (score)
> Put all rocks under super class `AllRocks`
> Used this to check if ship is touching any rock and accordingly lower health.
> Added `you lose` method via healthbar getters to detect when health >= 0
> 