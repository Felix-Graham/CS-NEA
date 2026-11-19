This is the stage in which I plan to add dynamic enemies scaling with the difficulty slider. Currently the slider changes a public global variable in MyWorld. This will allow me to access this in the Enemy constructor to modify its behaviour and attributes.

## To Do List 
### Features 
- [x] Random strength from appropriate range
- [x] Random knockback from appropriate range
- [x] Random size from appropriate range
### Tests 
- [x] Does the enemy load with random strength and knockback in accordance with difficulty?
- [x] Does the enemy have a random size in accordance with difficulty?
## Methods 
### Get Random In Range
For this method I will have to research how to generate random numbers in Java. I imagine that, similar to other languages, there will be a built in library which I can import.
#### [[references|References]]:
![[references#Random Numbers]]
### Enemy Constructor
``` pseudocode
CLASS Enemy EXTENDS Person 
	FUNCTION Enemy(player, difficulty)
		IF difficulty == 1 THEN 
			lower = 0.2
			upper = 1
		ELSE IF difficulty == 2 THEN 
			lower = 0.7
			upper = 1.3
		ELSE IF difficulty == 3 THEN 
			lower = 1.2
			upper = 2
		ENDIF 
		
		THIS.strenth = player.strength * get_random(lower, upper)
		THIS.stamina = player.stamina * get_random(lower, upper)
		THIS.size = player.size * get_random(lower, upper)
	ENDFUNCTION 
ENDCLASS 
```

## Notes 
### Random Enemy Attributes
Whilst writing the constructor for Enemy, I decided to also include variables such as speed. Furthermore I made the game more playable by adding the enemy attribute `REACTION_TIME`, an integer which forces the enemy to wait before calling the next `decide()`. This leads to the perception of a delayed reaction where the enemy will not attack instantly when the attack condition is true. This attribute also scales with difficulty.