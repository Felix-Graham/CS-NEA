``` pseudocode
class Player extends Fighter 
  
  function keybindings()
    key_down = Greenfoot.getKeyDown
    switch key_down {
      case d:
        move(2)
      case a:
        move(-1)
      case <space>:
        move(up 3)
      case w:
        hit(10)
      case s:
        hit(20)
      default:
        continue
    }
    endswitch
  endfunction
```