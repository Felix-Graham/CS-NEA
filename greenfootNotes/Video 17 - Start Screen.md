## Summary
> Added new actor `door`
> Added condition for coin collection count such that when `collection = 10`; add door to world
> Wrote boolean `collectedEnough` for the above condition.
> 
``` java 
public void SecondLevel(){
	Actor secretDoor = getOneIntersectingObject(SecretDoor.class);
	if(secretDoor!=null){
		Greenfoot.setWorld(new Background2());
	}
}
```
> Added code to world `StartScreen` to onSpace go to main world.

