## Description and Goals
This stage is responsible for creating the HUD (Heads Up Display) for the game. This will consist of the following elements:
- Player health bar
- Enemy health bar 
- Player stamina bar 
- Player cooldown bar (shown only when necessary)
- Pause/Play button
These are designed to make the experience of playing the game easier because the person playing the game will be able to properly visualise the value of their health. This will allow them to make informed decisions about attacking. The result should resemble the image below:
![[GUI.png]]
## To Do List 
### Features 
- [ ] Player Health Bar 
- [ ] Player Stamina Bar 
- [ ] Player Cooldown Bar (visible when necessary)
- [ ] Enemy Health Bar 
- [ ] Play/Pause button
### Tests 
- [ ] Does the HUD display accurate data for the health of either character?
- [ ] Does the HUD display a stamina bar for the player, updated in real time?
- [ ] Does the HUD dynamically display the player's cooldown as a bar?
- [ ] Does the HUD display a play/pause button is the top left corner for the user?
- [ ] Do all of the bars show relevant information which is consistently updated?
## Methods 
Many of these methods will be reused/repurposed for other classes. For example, I will use `Player Health Bar Draw` for other bars such as player stamina and enemy health. The same goes for the update function.
### Player Health Bar Draw
``` pseudocode
CLASS Player_Health_Bar 
	FUNCTION Player_Health_Bar(fill)
		THIS.fill = fill
	ENDFUNCTION
	
	
	FUNCTION draw()
		Bar health_bar = new Bar()
		health_bar.fill(fill, "red")
	ENDFUNCTION
ENDCLASS
```
### Player Health Bar Update 
![[health_bar_update.svg]]
### Player Cooldown Bar 
![[cooldown_bar.svg]]
### Pause 
![[pause.svg]]

## Notes 