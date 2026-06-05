## Summary
> Create int health in new actor class "Healthbar".
> Defined also attributes for bar such as height,width and PixelsPerPoint.
> Asigned relevant values to these attributes.
> New method `update` and healthbar constructor 
> Update:
``` java 
public void update(){
	setImage(new GreenfootImage(healthBarWidth, healthBarHeight));
	Greenfoot myImage = getImage();
	// draw rectangle 
	myImage.setColor(Color.WHITE);
	myImage.drawRect(0, 0, healthBarWidth + 2, healthBarHeight+1);
	myImage.setColor(Color.RED);
	myImage.fillRect(1, 1, health*PixelsPerPoint, healthBarHeight);
}
```
> Created method `loseHealth` in healthbar class.
> Linked with code from counter class to detect loss of health via the world class.
> Added world check for if health <= 0
> Added corresponding "youLose" screen. 
> Added boss with greater health 
> 