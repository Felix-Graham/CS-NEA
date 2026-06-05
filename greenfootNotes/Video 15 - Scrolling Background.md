## Summary
> Added moving clouds accross screen top
> Copied player moveset for clouds with reversed movement for realistic panning
> Did the same for the ground
> Removed player movement in favour of world moving around player.
> Wrapped with logic:
``` java 
if(getX()==0){
	setLocation(getWorld().getWidth()-1);
}
```
> Similary for clouds with random Y distribution in a range to appear new.