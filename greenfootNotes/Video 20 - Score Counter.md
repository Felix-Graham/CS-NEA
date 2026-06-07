## Summary 
> Added new debris
> New class `counter`
> Added constructor for Counter 
``` java 
int score = 0;
public Counter(){
	setImage(new GreenfootImage("score: "+score, Color.BLUE, Color.WHITE));
}
public void act(){
	setImage(new GreenfootImage("score: "+score, Color.BLUE, Color.WHITE));
}

public void addScore(){
	score++;
}
```
> In projectile added functionality to add score upon collision.
> Added "you win" in act method when no asteroids left.
> 