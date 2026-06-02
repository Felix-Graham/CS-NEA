## Summary
> Added enemy2
> Added projecting class and shooting [[Methods]] 
> Made projectile move
> Added reload time
	using:
``` java 
// class player 
boolean canFire = true;
public void fireProjectile(){
	if(Greenfoot.isKeyDown("space") && canFire == true){
		getWorld().addObject(new Projectile, getX(), getY()-30);
		canFire = false;
	}
	else if(!Greenfoot.isKeyDown("space")){
		canFire = true;
	}
}
```
> Kill projectile when hits end of world
> Did the same for enemy 
> Detect is hits enemy:
``` java 
// class projecting 
public void hitEnemy(){
	Actor enemy = getOneIntersectingObject(Enemy.class);
	if(enemy != null){
		getWorld().removeObject(enemy);
		getWorld().removeObject(this);
	}
}
```
> This checks if bullet hits enemy and if so removes it.