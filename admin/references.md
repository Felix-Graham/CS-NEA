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
