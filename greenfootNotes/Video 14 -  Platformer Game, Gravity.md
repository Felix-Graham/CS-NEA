## Summary 
> Create new player actor
> Create platform actor named Ground
> Reused maze code to have changing images for ground platforms.
> Increased world size
> Created player movement
> Created variables vertical speed and acceleration (private) as 0 and 1 respecitvely
> Create fall method:
``` java 
private void fall(){
	setLocation(getX(), getY()+verticalSpeed);
	vspeed += acceleration;
}
```
> Created boolean method `onGround` using:
``` java 
boolean onGround(){
	Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
	return under != null;
}
```
> Check falling:
``` java 
public void checkFalling(){
	if(onGround==false{
		fall();
	}
}
```
> Added jumping with reverse of falling code
``` java 
// in movecode
if(Greenfoot.isKeyDown("space")){
	vspeed = jumpHeight;
	fall();
}
```
> Conditional jumping to limit flight
` if(onGround()){ vspeed=0; }`
