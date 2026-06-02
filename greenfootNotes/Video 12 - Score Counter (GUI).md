## Summary 
> Fixed reload code from [[Video 11 - Score Counter, Health Bar, Timer#Summary|video 11]].
> Created enemy1 method `hitByProjectile()`
``` java 
// class enemy
public void hitByProjectile(){
	Actor projectile = getOneIntersectingObject(Projectile.class);
	if(projectile != null){
		getWorld().removeObject(this);
		getWorld().removeObject(projectile);
	}
}
```
> Did the same for enemy2 but added variable for `hitCount`. Enemy2 killed after 2 hits.
> Created counter method:
> 	New actor
> 	No image
> 	In act:
``` java 
// class Counter 
public void act(){
	setImage(new GreenfootImage("Score", 50, Color.GREEN, Color.BLACK));
//                   Displayed Text | Size: 50 | FG: Green | BG: Black
}
```
> 	Added int var score at 0;
> 	New constructor method `Counter()`
``` java 
// class Counter
int score = 0;
public Counter(){
	setImage(new GreenfootImage("Score"+score, 50, Color.GREEN, Color.BLACK));
}
```
>	