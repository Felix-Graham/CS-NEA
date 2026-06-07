## Summary
> Reorganised enemy actors — renamed to `Enemy1`, `Enemy2`, `Enemy3` for clarity
> Removed player control from enemy classes — enemies now only move across screen (dodging game)
> Added `hitEnemy()` method in `Player` using `isTouching()`:
``` java
public void hitEnemy(){
	if(isTouching(Enemy.class)){
		getWorld().addObject(new YouLose(), 400, 300);
		getWorld().removeObject(this);
		Greenfoot.stop();
	}
}
```
> Note: nothing can execute after `removeObject(this)` except `Greenfoot.stop()` — adding objects to the world after removal causes `NullPointerException` / "actor not in world" error
> Created `YouLose` actor — imported custom image via "import from file"
> Added `youWin()` method — triggers when player reaches bottom of screen (Y >= 599):
``` java
public void youWin(){
	if(getY() >= 599){
		getWorld().addObject(new YouWin(), 400, 300);
		getWorld().removeObject(this);
		Greenfoot.stop();
	}
}
```
> Created `YouWin` actor with imported image
> Both `hitEnemy()` and `youWin()` called in `act()`
> Key reminders:
> - One `=` assigns a value; `==` checks equality in conditions
> - Methods use camelCase; classes use PascalCase — helps distinguish them at a glance
> - Always add new methods to `act()` or they will not run
