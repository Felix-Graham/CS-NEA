``` pseudocode
class Bot extends Fighter
    int reaction_time = 50
	bool player_near
	bool player_moving
	
	function react(reaction_time:byval)
	  for i=0 -> i=reaction_time 
	    continue
	  next i
	endfunction
	
	function update_player_near(player_near:byref)
	  if(getPlayerDistance() > 5) then
	    player_near = false
	  else 
	    player_near = true
	  endif
	endfunction
	
	function update_player_moving(player_moving:byref)
	  player_location = getPlayerDistance()
	  for i=0 -> i=10 
	    continue
	  if(player_location != getPlayerDistance()) then
	    player_moving = true
	  else
	    player_moving = false 
	  endif 
	endfunction
	
	function near_attack(player_near)
	  if(player_near == true) then 
	    react()
	    punch()
	  endif 
	endfunction
	
	function move_to_player(player_moving)
	  if(player_moving != true) then
	    move_to_player()
	  endif
	endfunction

```