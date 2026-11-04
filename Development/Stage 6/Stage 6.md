In this stage I had previously aimed to add the the attacks feature in my game. However I have previously made the decision to incorporate this into an earlier stage along with the addition of the character. I chose to do this because it made testing additional features such as the health-bars immensely easier. 
As a result of this, I plan to re-purpose this stage into several fixes between the player and enemy, focusing on elements such as collision and tracking. My resultant features and test plan are below. The majority of these fixes feature in my final test plan and have not been assigned a proper stage; this stage should fix that.

## To Do List 
### Features 
- [ ] Player and Enemy collision
- [ ] Enemy-Player tracking 
- [ ] Accurate attack ranges 
### Tests 
- [ ] One character moving into the other (stationary) pushes them
- [ ] Characters moving toward each other are stopped at an appropriate distance
- [ ] Collision is applied in both directions for each character
- [ ] A jumping character cannot jump into another 
- [ ] Enemy can detect player when they are to their left
- [ ] Enemy can detect player when they are to their right
- [ ] An attack is only applied when the target is within an appropriate range 

## Methods 
### Collision 
Unlike some other methods, the solution for this is not obvious. To develop a method to implement effective collision, I had to explore several possible methods of execution, as demonstrated by several diagrams below.
#### Collision by X-Value
![[collision_by_x_diff.svg]]
The issue is that the given x-value would only be for one side. My current knowledge of Greenfoot leads me to believe that a sprite/image's coordinate system works like this:
![[sprite_coordinates.svg]]
This would make this approach problematic for judging accurate displacement.
#### $\Delta$Centre
We can solve the above problem with an approach like this:
![[sprite_centre_coord.svg]]
This solution would allow for each x 'bar' to be calculated with 
$$
X_{n}=\frac{1}{2}w\pm \frac{1}{2}w+x 
$$
$$
\text{where }X_{n}\text{ is the bar; }w\text{ is the sprite width; }x\text{ is the value returned with `getX()'}
$$

We could then calculate collision with the same method as proposed above:
![[collision_by_x_diff.svg]]
Where $x$ would be an adjustable variable for collision difference.
With this, each actor involved in collision would have its own public variables for `x1` and `x2`.  
``` pseudocode
CLASS Player 
	...
	FUNCTION update_bars()
		THIS.x1 = 0.5(getWidth())-0.5(getWidth)+getX()
		THIS.x2 = 0.5(getWidth())+0.5(getWidth)+getX()
	ENDFUNCTION
ENDCLASS

CLASS Person
	...
	FUNCTION get_collision(Person player, Person enemy)
		IF player.getX() > enemy.getX() THEN 
			dx = player.x1 - enemy.x2 
		ELSE 
			dx = enemy.x1 - player.x2 
		ENDIF 
		
		RETURN dx
	ENDFUNCTION
ENDCLASS
```
The `collide()` method would work like so
``` pseudocode
CLASS Person
	...
	FUNCTION collide(Person p, Person e)
		dx = get_collision
		IF p.getX() > e.getX() THEN
			WHILE dx <= collision_limit THEN
				p.setLocation(p.getX()+1)
				e.setLocation(e.getX()-1)
			ENDWHILE
		ELSE
			WHILE dx <= collision_limit THEN
				p.setLocation(p.getX()-1)
				e.setLocation(e.getX()+1)
			ENDWHILE
	ENDFUNCTION
ENDCLASS
```
The function is based on a heuristic, assuming that a full collision where `Player` is mapped entirely onto `Enemy` never occurs. This also fulfills the feature of pushing:
$$
\text{Assume a particle A is moving with velocity +5m/s, with a second particle B stationary.}
$$
$$
\text{The resultant collision force acting on both particles is -1m/s}
$$

$$
\text{Therefore if we assume the driving force for particle A is constant and thus has acceleration of 0,}
$$
$$
\text{we can see that the new velocity of B upon collision would be -1m/s, thus moving it back, whilst A's }
$$
$$
\text{would be 4m/s, keeping it moving forward at a reduced weight.}
$$

## Notes 