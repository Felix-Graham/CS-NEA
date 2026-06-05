## Summary
> Added new { "Rocks" "Projectile" } under super actor class `SpaceActors`.
> In Greenfoot world used random for positioning of rock.
> Added rock movement from player with random initialisation of variables `verticalSpeed`...
> Added `Rocks` constructor class for allowing negative speeds
``` java 
public Rocks(){
	if(Greenfoot.getRandomNumber(2)==1){
		horizontalSpeed = -horizontalSpeed
	}
	if(Greenfoot.getRandomNumber(2)==1){
		verticalSpeed = -verticalSpeed
	}
}
```
> Added projectile firing capability to ship:
``` java 
boolean fire=false;

public void fireOnCommand(){
	if(Greenfoot.isKeyDown("f")){
		getWorld().addObject(new Projectile, getX(), getY());
		fire=true;
	}
	if(!Greenfoot.isKeyDown("f")){
		fire=false;
	}
}
```
> Added projectile class
> New boolean called `fire` to restrict continuous firing.
> Made projectiles move in ship direction with:
``` java 
// in class Ship 

public void fireOnCommand(){
	Projectile projectile = new Projectile()
	if(Greenfoot.isKeyDown("f")){
		getWorld().addObject(projectile, getX(), getY());
		projectile.setRotation(getRotation());
		fire=true;
	}
	if(!Greenfoot.isKeyDown("f")){
		fire=false;
	}
}
```
> Added projectile destroy rocks:
> `Actor rocks - getOneIntersectingObject(Rocks.class);`
> `if(rocks!=null){ getWorld().removeObject(rocks);
> 	`getWorld().removeObject(this); }`
> Added new object `Debris` to appear after `rocks` destroyed by projectile. 
> Uses image from `rocks` but scaled down
> Debris movevement as non-random at speed 3
> Added spread to debris via `setRotation()` with random X and Y
> 