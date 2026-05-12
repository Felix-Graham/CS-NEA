``` pseudocode
class Fighter 
  int stamina = 100
  int health = 100
  int stun_length = 0
  bool is_stunned = false
  
  function take_damage(int num)
    health = health-num
  endfunction
  
  function do_hit() 
    if(getEnemyDistance < 5 and stamina > 10) then
      enemy.take_damage(10)
      stamina = stamina - 10
    endif
  endfunction
  
function check_hit(stun_length:byref)
    if(is_hit == true) then 
      stun_length = stun_length + 10
    endif 
  endfunction
  
  function be_stunned(stun_length:byref, is_stunned:byref)
	is_stunned = true
	for i=stun_length -> i=0
	  continue
	next i
	stun_length = 0
	is_stunned = false
  endfunction
  
```