## Summary
> Added money reset cheat — clicking `MoneyDisplay` resets `MyWorld.money` to 100
> Added enemy detection in `Tower` using a list and `getObjectsInRange()`:
``` java
List<Enemy> enemies = getObjectsInRange(100, Enemy.class);
for(Enemy eachEnemy : enemies){
	// fire at each detected enemy
}
```
> Created new actor `Projectile` — moves forward at speed 10
> Tower fires projectile aimed at each detected enemy via `turnTowards()`:
``` java
Projectile projectile = new Projectile();
getWorld().addObject(projectile, getX(), getY());
projectile.turnTowards(eachEnemy.getX(), eachEnemy.getY());
```
> Added fire rate limiter using a counter — fires every 10 frames:
``` java
int fireRate = 0;
// in enemyDetector():
fireRate++;
if(fireRate > 9){
	// fire projectile
	fireRate = 0;
}
```
> Organised enemy movement into `public void moveAlongPath()`
> Added `hitByProjectile()` method in `Enemy` using `getOneIntersectingObject()`:
``` java
public void hitByProjectile(){
	Actor projectile = getOneIntersectingObject(Projectile.class);
	if(projectile != null){
		getWorld().removeObject(projectile);
		health--;
	}
	if(health < 1){
		getWorld().removeObject(this);
	}
}
```
> Added `int health = 5` to `Enemy` — destroyed after 5 hits
> Killing an enemy rewards money via static reference:
``` java
MyWorld world = new MyWorld();
world.money += 50;
```
> Added world timer `int worldTime` incrementing each frame in `act()`
> Added `spawnWave()` — spawns enemy every 20 frames using modulo:
``` java
public void spawnWave(){
	if(worldTime % 20 == 0){
		addObject(new Enemy(waveNumber), 1, 90);
	}
}
```
> Added `int waveNumber = 1` — increments every 400 frames to switch enemy type
> Added `Enemy(int level)` constructor — sets image based on level:
``` java
public Enemy(int level){
	if(level == 1){ setImage("spider.png"); }
	if(level == 2){ setImage("snake2.png"); }
}
```
> Enemies spawned at x=1 so `atEdge()` can detect and remove them when they reach the far side:
``` java
// in act(), after hitByProjectile():
else if(atEdge()){
	getWorld().removeObject(this);
}
```
> Part 3 will add: tower shop menu, multiple tower types, wave-based spawning with pauses between levels
