## Summary
> Added actor as a spaceship and resized image using `getImage().scale(x,y)`
> Set up movement for a space (0 grav.) setting.
``` java 
int horizontalSpeed=0;
int verticalSpeed=0;

public void act(){
	accelerateOnCommand()
	turn()
	setLocation(getX()+horizontalSpeed, getY()+verticalSpeed);
}

public void turn(){
	if(Greenfoot.isKeyDown("right")){
		setRotation(0);
	}
	if(Greenfoot.isKeyDown("left")){
		setRotation(180);
	}
	if(Greenfoot.isKeyDown("up")){
		setRotation(90);
	}
	if(Greenfoot.isKeyDown("down")){
		setRotation(270);
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
```
> Included wrap at edge and bounce at edge or educational purposes.
``` java 
public void wrapAtEdge(){
	if(getX()==0){
		setLocation(100, getY());
	}
	if(getY()==0){
		setLocation(getX(), 140);
	}
	if(getX()==898){
		setLocation(1, getY());
	}
	if(getY()==648){
		setLocation(getX(), 649);
	}
}

public void bounceAtEdge(){
	if(getX()==0){
		horizontalSpeed = -horizontalSpeed;
	}
	if(getY()==0){
		verticalSpeed = -verticalSpeed
	}
	if(getX()==898){
		horizontalSpeed = -horizontalSpeed;
	}
	if(getY()==648){
		verticalSpeed = -verticalSpeed
	}
}
```
