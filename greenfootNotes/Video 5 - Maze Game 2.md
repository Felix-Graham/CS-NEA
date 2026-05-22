## Summary
> Spent 5 mins fixing his code
> Finished mapping walls to image
> Created move set for player (mouse) using [[Methods#setLocation(int x, int y)|setLocation()]].
> Created method called "[[#hitWall()]]" to detect if player hits a wall whilst moving
> Expanded on moveset with boolean method "[[#hitWall()]]" to limit incorrect movement
> Created actor "cheese" and manually placed on world
> Checks if mouse(player) eats cheese with [[Methods#getOneIntersectingObject(Class class)|getOneIntersectingObject(Cheese.class)]]  
> Thus invokes `getWorld.removeObject(Cheese.class)`.
> Created global variable `int speed` to control player speed. This is updated with methods to act as a boost.


##### hitWall(){
	if(isTouching(Walls.class)){
		return true;
	} else{
		return false;
	}
} 