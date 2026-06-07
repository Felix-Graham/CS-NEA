## Summary
> Added actor `MazeBlock` (50x50 tile image) — used to draw maze by hand, then saved world
> Reset cell size back to 1x1 after saving, then multiplied all saved coordinates by 50 in `prepare()` to correct positions
> Added actor `MazeRunner` (mouse image) — scaled to 1/2 size in constructor:
``` java
public MazeRunner(){
	getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
}
```
> Created superclass hierarchy: `Actor → Movers → Players → MazeRunner`
>  Also: `Actor → Movers → Enemies → EnemyFlyer / EnemyWalker`
> This allows shared methods (e.g. `hitWalls`, `hitEnemy`) to be inherited by both players and enemies
> Added `slideAround()` in `MazeRunner` for wall-sliding movement (no rotation):
``` java
int speed = 4;

public void slideAround(){
	int x = getX(); int y = getY();
	if(Greenfoot.isKeyDown("right")) setLocation(x+speed, y);
	if(Greenfoot.isKeyDown("left"))  setLocation(x-speed, y);
	if(Greenfoot.isKeyDown("up"))    setLocation(x, y-speed);
	if(Greenfoot.isKeyDown("down"))  setLocation(x, y+speed);
}
```
> Added `hitWalls()` boolean method in `Movers` — returns true if touching `MazeBlock`:
``` java
public boolean hitWalls(){
	if(isTouching(MazeBlock.class)){ return true; }
	else { return false; }
}
```
> Used `hitWalls()` in `slideAround()` to push player back when hitting a wall (equal and opposite displacement)
> Added `collectBoost()` in `Movers` — touching `SpeedBoost` increments speed and removes it:
``` java
public void collectBoost(){
	if(isTouching(SpeedBoost.class)){
		speed++;
		removeTouching(SpeedBoost.class);
	}
}
```
> Added `maxSpeed()` method — caps speed at 7:
``` java
public void maxSpeed(){
	if(speed >= 7){ speed = 7; }
}
```
> Added actor `EnemyFlyer` — moves forward at speed 5 and wraps at edge:
``` java
public void wrapAtEdge(){
	int worldWidth = getWorld().getWidth()-1;
	int worldHeight = getWorld().getHeight()-1;
	if(getX() >= worldWidth) setLocation(1, getY());
	if(getX() <= 0) setLocation(worldWidth-1, getY());
	if(getY() >= worldHeight) setLocation(getX(), 1);
	if(getY() <= 0) setLocation(getX(), worldHeight-1);
}
```
> Added actor `EnemyWalker` — constructor takes boolean `upDown` parameter to set movement axis:
``` java
public EnemyWalker(boolean upDown){
	this.upDown = upDown;
}
```
> `EnemyWalker` bounces off walls and edges using `|` (OR) operator:
``` java
public void enemyHitWalls(){
	if(hitWalls() || atEdge()){
		speed = -speed;
	}
}
```
> Added `hitEnemy()` boolean in `Movers` — returns true if touching `Enemies` class
> Used in `MazeRunner` to relocate back to start on contact:
``` java
public void mazeRunnerHit(){
	if(hitEnemy()){ setLocation(45, 60); }
}
```
> Added lives system in `MazeRunner` constructor with `int mazeRunnerLives` parameter:
``` java
public MazeRunner(int lives){
	this.mazeRunnerLives = lives;
}

public void loseLife(){
	mazeRunnerLives--;
}
```
> Added `youLose()` — triggers when `mazeRunnerLives == 0`:
``` java
public void youLose(){
	if(mazeRunnerLives == 0){
		getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
		Greenfoot.stop();
	}
}
```
> Added `YouWinPlatform` actor at end of maze — `youWin()` method in `Players` triggers on touch:
``` java
public void youWin(){
	if(isTouching(YouWinPlatform.class)){
		getWorld().addObject(new YouWinScreen(), getWorld().getWidth()/2, getWorld().getHeight()/2);
		Greenfoot.stop();
	}
}
```
> Note: `loseLife()` must be called *before* `mazeRunnerHit()` in `act()` — otherwise relocation resets the collision check before lives can decrement
> Note: `Greenfoot.stop()` prevents repeated win/lose objects from stacking up each frame
