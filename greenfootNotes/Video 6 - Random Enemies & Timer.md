## Summary
> Created new enemy actor and added to [[Methods#prepare()|prepare()]] function.
> Explained method [[Methods#getRandomNumber(int limit)|getRandomNumber()]] and used to edit [[Methods#prepare()|prepare()]] function's placement of enemy.
> Added a simple movement subroutine to the enemy. This consisted of [[Methods#move()|move(3)]] and [[Methods#turn()|turn(3)]].   
> Added check if player hits enemy.
> Wrote a function called `youLose()` to add an actor with an appropriate message and [[Methods#stop()|Greenfoot.stop()]].
> 
> For the time element, he added a constantly elevating integer variable. Added logic:
``` java
if(time % 120 == 0){
	addObject(new Enemy(), Greenfoot.getRandomNumber(750), Greenfoot.getRandomNumber(550));
}
```
Resulting in a new enemy every 3 seconds.
**This is based on the idea that [[Methods#act()|act()]] is called 60 time per second** 
