## Description and Goals
Stage 1 involves creating the player with adequate movement abilities. This extends to attacks, which for now just involves changing the sprite.
## To Do List 
### Features
- [x] Player 
  - [x] Can move with keyboard input (left, right, jump)
  - [x] Can attack with keyboard input 
  - [x] Player returns to ground after jumping 
### Tests 
- [x] Player sprite displayed?
- [x] Accurate movement?
- [ ] Attack animation displayed?
- [x] Gravity?
- [x] Health Values?

## Class Diagram 
![[PlayerClassDiagram.svg]]
This class diagram holds all of the attributes and methods for my player. I have produced this because it will be incredibly useful to know all of the methods which I will need to implement and attributes to declare. Please note that this would not include all variables. Ideally, I would have some declared like constants to make it easier to modify data such as horizontal acceleration.  

## Methods 
### punch()
![[punchFlowChart.svg]]

### kick()
![[kickFlowChart.svg]]
### movement()
![[movementFlorChart.svg]]
### knockback()
![[knockbackFlowChart.svg]]

### damage()
``` pseudocode
function damage(int hp) then
	this.health = this.health - hp;
	end function 
```

## Attributes 
### Health 
Attribute to control the character's health. When `player.health == 0`, game over.
### Stamina 
Controls whether or not the player is allowed to attack. 
### Cooldown
Same as `stamina` but with more direct consequences. Stamina is designed to limit and restrict against attacking relentlessly, whilst `cooldown` should stop the player from being able to attack every frame (too fast).

## Notes 
[[references#How to round to an integer]]
### Pixel Rounding Error 
![[pixel_overload_error_averted.png]]
This is the first major error which I encountered. I was overambitious in my designing of a jump method, and wanted it to be physically accurate, using equations of motion. The problem with this was that Greenfoot would not have been able to move an object a fractional number of pixels, meaning that my `JUMP_VELOCITY_INIT` and `GRAVITY` variables would not be viable, even if I were to round them. I tried to solve this by multiplying the number of pixels in the world by 100, in order to do the same to the variables and reduce the rounding errors. This would not work due to Greenfoot's own limit on pixels. This led to me having to scrap this idea.
### Moving and Jumping Proof
![[moving_and_jumping.mp4]]
In this video (moving_and_jumping.mp4), we can see the player moving and jumping, through the inherited move method from the parent class `Person`. The jumping is quite janky because of the use of `setLocation(getX(), getY()-JUMP)`. I tried to incorporate a gradual increase such as 
``` java 
while(getY()>=FLOOR-JUMP){
	setLocation(getX(), getY()-5);
}
while(getY()<FLOOR){
	setLocation(getX(), getY()+5);
}
```
But this became a problem with Greenfoot. I am still unsure why, but it would cause the program to crash. The current solution is now a compromise.
### Old Cooldown Method 

![[old_cooldown_method.png]]
This method was the old `cooldown` method before the new one 
(
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
). As can be seen, `this.cooldown` is incorrectly assigned as `t*60`. This is because I had forgotten my initial plan to have the punch cooldown as 0.2 seconds. This adjustment was the reason which I had to change to an algorithm with explicit rounding. 

### With regards to Knockback
I have at present chosen not to implement the full `Knockback` method as was planned in my flowchart.
![[knockbackFlowChart.svg]]
This is because I think that finding out which way the player was facing (especially in Greenfoot), would take quite a lot of time. Therefore, I have at present left this either for the future or permanence. The current method stands at:
``` java 
public void knockback(int k){
	move(-k);
}
```
This takes a heuristic approach, assuming that the player will always be on the left, attacking right. It is far more concise than the flow chart demands it be, which is why I have decided that it is currently the best option.