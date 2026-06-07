## Summary
> Added actor `Spider` — used as the player character
> Added `followMouse()` method using `Greenfoot.getMouseInfo()` to turn towards cursor:
``` java
int mouseX, mouseY;

public void followMouse(){
	if(Greenfoot.getMouseInfo() != null){
		mouseX = Greenfoot.getMouseInfo().getX();
		mouseY = Greenfoot.getMouseInfo().getY();
		turnTowards(mouseX, mouseY);
	}
}
```
> Note: variables declared outside the `if` block to avoid scope issues — default to 0 until mouse is on screen
> Added `fireProjectile()` — spawns projectile on mouse click, inheriting spider's current rotation:
``` java
public void fireProjectile(){
	if(Greenfoot.mouseClicked(null)){
		Projectile p = new Projectile();
		getWorld().addObject(p, getX(), getY());
		p.setRotation(getRotation());
	}
}
```
> Note: `mouseClicked(null)` fires on any click regardless of target object
> Added `Projectile` actor with `move(10)` in `act()`
> Added keyboard movement to spider:
``` java
if(Greenfoot.isKeyDown("left"))  setLocation(getX()-5, getY());
if(Greenfoot.isKeyDown("right")) setLocation(getX()+5, getY());
if(Greenfoot.isKeyDown("up"))    setLocation(getX(), getY()-5);
if(Greenfoot.isKeyDown("down"))  setLocation(getX(), getY()+5);
```
> Added actor `Door` — touching it transitions to a second world:
``` java
if(isTouching(Door.class)){
	Greenfoot.setWorld(new Level2());
}
```
> Created new world `Level2` with a different background texture
> Note: static variables do not reset when switching worlds — data transfer between worlds may require extra handling
