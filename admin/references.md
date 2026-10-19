## Image Resizing 
I have used https://imageresizer.com/ to resize my player sprites at 14:28 on the 29/09/2026. I did this because after drawing them on my laptop, they were too large to have effectively in my game. Had I not done this, the player sprite would have been too large to play and therefore been a detriment to player experience.
## How to round to an integer
https://www.geeksforgeeks.org/java/java-program-to-round-a-number-to-n-decimal-places/
Accessed at 10:28 on the 28th of September 2026.
### Notes 
I looked at this article because I needed to convert the product of `t*60`
``` java 
public void cooldown(double t){
	this.cooldown = t*60;
```
where `t` is a double. This is because I would like to have the cooldown of my punch attack to be 0.2 seconds. The issue with this is that Greenfoot cannot iterate for a fractional number, something becoming problematic in the tail end of that method:
``` java 
for(int c = this.cooldown; c>=0; c--){
	this.cooldown--;
}
```
To resolve this, I decided to round the product of `t*60` to the nearest whole number, which is why I looked up this article.

From this article, I learnt from the example:
``` java 
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GFG {
    public static void main(String[] args) {
        double number = 9.97869896;

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.FLOOR);

        System.out.println(df.format(number));
    }
}
```
how to use the `DecimalFormat` library to round a decimal. This led me to come up with the following for my own situation:
``` java 
import java.math.RoundingMode;
import java.text.DecimalFormat;

public void cooldown(double t){
	double unrounded_cooldown = t*60;
	DecimalFormat df = new DecimalFormat("###"); // where unused digits are 0
	df.setRoundingMode(RoundingMode.CEILING); // rounds up from t*60
	this.cooldown = df.format(unrounded_cooldown); // sets the cooldown to appropriate integer
	for(int c = this.cooldown; c>=0; c--){ // same logic as if it were an int
	  this.cooldown--;
    }
}
```

## Accessing Data From Another Class
Whilst implementing the enemy `Damage Multiplier`, I forgot how to reference data from another class, being `Player`. I looked at https://www.greenfoot.org/topics/2241 to resolve this. This allowed me to implement the following 
``` java 
Player p = (Player) getWorld().getObjects(Player.class).get(0);
int x = p.getX(); // test 
```
Note, I ended up not using this after 05/10/2026 when I decided to pass the player class directly to the enemy class, thus removing this error.
## Removing Image Backgrounds 
I used https://remove.bg  to remove the backgrounds of the player sprites. This means that their previously white backgrounds do not block out the other player sprite. Had I not done this it would have been hard to see the other character when they were close.

## Using `try catch` to avoid Null Pointer Errors 
As a result of my player code's attack methods defining the enemy with 
``` java 
Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
```
my game would often throw a null pointer exception because the enemy object's methods were to be called. This caused the problem because if the player was not intersecting with the enemy, no object would be returned from `getOneIntersectingObject()` and the rest of the code 
``` java 
enemy.damage(DAMAGE_KICK);
```
would not work.
I knew that I could fix this with either `try/catch` or an `if` clause to check if `Enemy` was null. I chose to use the first of these due to it allowing a further split. An if statement would have still executed the code after it whilst this method would have two possible outcomes unique to both scenarios.
I have used try/catch before in other languages such as C and Python, but I needed to look up how to implement something similar in Java. I learnt how from this web page:
> [!link]
> https://www.w3schools.com/java/java_try_catch.asp

## Variable Shadowing 
I learnt about what variable shadowing is and how it happens from this article:
https://medium.com/tuanhdotnet/master-variable-shadowing-and-hiding-in-java-uncovering-key-nuances-and-pitfalls-b6eab3d2a41c
