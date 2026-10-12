### Damage 
Currently methods for punch and kick use 
![[greenfootNotes/Methods#getOneObjectAtOffset(int x, int y, Class class)]]
This means that damage is only applied if both are directly intersecting, which goes against plans for collision.

### Enemy Player Detection
The enemy cannot detect the player if they move to the right.
![[DecisionFlowChart.svg]]
This is because methods "run_towards" and "run away" have uni-directional movement. The fix would be to **constantly get player location and move toward player** like the following pseudocode:
``` pseudocode
FUNCTION get_player_loc(){
	player_x = MyWorld.player.getX();
	dir = 
}
```