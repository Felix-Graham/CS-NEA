## Summary
> Measured background tiles as 60x60 pixels, set world to 840x600 (10x10 grid + menu column)
> Added new actor `Tower` scaled to 60x60 to fit grid cells:
``` java
public Tower(){
	getImage().scale(60, 60);
}
```
> Added actor `Menu` — gray box scaled to 240x600 — positioned at (720, 300) as sidebar
> Added actor `Road` scaled to 60x60
> Designed map using a 2D int array in `MyWorld`:
``` java
int[][] map = {
	{0,0,1,0,...},
	// 10 rows x 10 columns
	// 1 = road tile
};
```
> Looped through map array in `levelOne()` to place road tiles:
``` java
for(int i=0; i<10; i++){
	for(int j=0; j<10; j++){
		if(map[i][j]==1){
			addObject(new Road(), 30+j*60, 30+i*60);
		}
	}
}
```
> Added click-to-place tower system in world `act()` — uses integer division to snap towers to grid:
``` java
public void addTowers(){
	if(Greenfoot.mouseClicked(null)){
		if(Greenfoot.getMouseInfo().getActor()==null){
			int x = (Greenfoot.getMouseInfo().getX()/60)*60+30;
			int y = (Greenfoot.getMouseInfo().getY()/60)*60+30;
			addObject(new Tower(), x, y);
		}
	}
}
```
> Towers cannot be placed on roads or other actors (checked via `getMouseInfo().getActor()==null`)
> Added static money system with tower cost:
``` java
public static int money = 100;
public static int basicTowerPrice = 50;
```
> Deducts `basicTowerPrice` on tower placement; blocks purchase if insufficient funds
> Created `MoneyDisplay` actor class with transparent-background text image, reads `MyWorld.money` via static reference
> Added `Road` constructor overloads — boolean `straight` and int `turn` parameter variants:
``` java
public Road(boolean straight){ this.straight = straight; }
public Road(int turn){ this.turn = turn; }
```
> Map values 2–5 represent turning roads (90°, 0°, 270°, 180°)
> Added `Enemy` actor (spider image) with `move(3)` and road-detection logic using `getObjectsAtOffset()` and a list per direction:
``` java
List<Road> road90 = getObjectsAtOffset(0, -30, Road.class);
for(Road roads : road90){
	if(!roads.straight && getRotation()==0){
		setRotation(roads.turn);
	}
}
// repeated for road0, road180, road270
```
> Enemy follows the path by detecting turning road tiles and updating its rotation accordingly
> Part 2 will add: tower firing, enemy waves, and earning money from destroying enemies
