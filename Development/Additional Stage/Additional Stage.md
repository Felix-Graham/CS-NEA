In this stage I plan to work and and improve features in my game. This can cover any area and should contribute to either user experience or depth of the game. 

## To Do List 
### Features 
For each feature at least one test will be written to demonstrate its functionality. 
- [ ] Health and Stamina bars with fixed position [[Additional Stage#Fixed Position]]
### Tests 
- [ ] ...

## Designing 
### Fixed Position
Because the bars, as intended, follow player and enemy as is necessary they can often end up overshadowing each other and making it hard to interpret. This is because they do not have their own collision and move around constantly. This change would fix them to top left and right sides of the screen for player and enemy respectively. This would reduce visual clutter, make useful information easier to interpret and enhance the look and feel of my game. 
This design style takes inspiration for similar games which mine is designed to vaguely resemble. I have done this in order to appeal further to my target audience who would understand this layout and thus make my game feel intuitive and nostalgic as I set out to create. 

## Methods 
### Fixed Position 
```
CLASS Bar // for any bar 
	FUNCTION act()
		IF NOT MyWorld.paused() THEN 
			update(heartbeat(), fg, this)
		ENDIF 
	ENDFUNCTION
ENDCLASS
```
Note that this is different to the current `act()` method of bars such as `Player_Health`:
``` java 
    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 30);
            update(heartbeat(), fg, this);
        }
    }
```
Where the new version removes the `follow()` method in favour of a static system.

player health 91 126 
player stam 116 148
enemy health 512 126
overlay 18 148