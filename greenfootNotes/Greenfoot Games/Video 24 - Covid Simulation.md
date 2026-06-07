## Summary
> Added new actor `Person` with image scaled via constructor:
``` java
public Person(){
	getImage().scale(40, 40);
	setRotation(Greenfoot.getRandomNumber(360));
}
```
> Added random movement and edge bouncing to `act()` method:
``` java
public void movement(){
	move(4);
	turn(Greenfoot.getRandomNumber(9) - 4);
	if(atEdge()){
		turn(30);
	}
}
```
> Added world method `populate(int population)` using nested loop and `Greenfoot.getRandomNumber()` for random placement
> Created `Button` class with transparent/text-based `GreenfootImage` for UI labels
> Used `JOptionPane.showInputDialog()` to get population count from user at runtime
> Added static variables to `MyWorld` for global state:
> `public static int population`, `numInfected`, `numRecovered`
> Added infection system with `contractVirus()` method using `getObjectsInRange()`:
``` java
public void contractVirus(){
	List<Person> persons = getObjectsInRange(infectRadius, Person.class);
	for(Person persons : persons){
		if(persons.infected && !infected){
			infected = true;
			MyWorld.numInfected++;
		}
	}
}
```
> Added recovery timer — after 200 frames, infected person calls `heal()` and turns green
> Added `numRecovered` and `numVulnerable` (= `population - numInfected - numRecovered`) counters displayed via `showText()`
> Added social distancing toggle button — when enabled, persons detect others within radius 60 and turn away:
``` java
public void socialDistance(boolean enabled){
	List<Person> persons = getObjectsInRange(60, Person.class);
	for(Person persons : persons){
		if(enabled){
			turn(Greenfoot.getRandomNumber(19) - 9);
		}
	}
}
```
> Added mask toggle button — reduces `infectRadius` from 20 to 10 and draws a white oval on the person image
> Added a frame-based timer displayed at top of screen: `time / 60` = seconds elapsed
> Challenged viewers to add a `Gloves` button (further reducing `infectRadius` to 1) and a `Reset` button
