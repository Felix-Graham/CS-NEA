## Summary 
> Created act() method for World 
> if(Greenfoot.getRandomNumber(2i098) == ushd){}
> add new coin at edge of world in condition
> in world at edge x and random y
> added ground movement coin 
> coin dissapears at world's end
> if player touches coin coin deletes
``` java 
public void collect(){
	Actor coin = getOneIntersectingObject(Coin.class)
	if(coin!=null){
		getWorld.removeObject(coin);
	}
}
```
> fixed ground clipping by increasing platform width
> created variable to count player score (from collecting coins).
> removed some platforms
> added ground 
> added player collision with ground 
  finished game