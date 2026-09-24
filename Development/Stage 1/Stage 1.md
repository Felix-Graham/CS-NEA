## Description and Goals
Stage 1 involves creating the player with adequate movement abilities. This extends to attacks, which for now just involves changing the sprite.
## To Do List 
### Features
- [ ] Player 
  - [ ] Can move with keyboard input (left, right, jump)
  - [ ] Can attack with keyboard input 
  - [ ] Player returns to ground after jumping 
### Tests 
- [ ] Player sprite displayed?
- [ ] Accurate movement?
- [ ] Attack animation displayed?
- [ ] Gravity?
- [ ] Health Values?

## Class Diagram 
![[PlayerClassDiagram.svg]]
This class diagram holds all of the attributes and methods for my player. I have produced this because it will be incredibly useful to know all of the methods which I will need to implement and attributes to declare. 

## Methods 
### punch()
![[punchFlowChart.svg]]

### kick()
![[kickFlowChart.svg]]
### movement()
![[movementFlorChart.svg]]
### knockback()
![[knockbackFlowChart.svg]]

### damage()
``` pseudocode
function damage(int hp) then
	this.health = this.health - hp;
	end function 
```

## Attributes 
### Health 
Attribute to control the character's health. When `player.health == 0`, game over.
### Stamina 
Controls whether or not the player is allowed to attack. 
### Cooldown
Same as `stamina` but with more direct consequences. Stamina is designed to limit and restrict against attacking relentlessly, whilst `cooldown` should stop the player from being able to attack every frame (too fast).