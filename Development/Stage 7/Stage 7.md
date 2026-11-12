Stage 7 involves implementing 'condition checks' to the game. Similar to Stage 6, some of these will have inevitably been implemented prior to this stage for the purpose of testing. Some of the largest and most prominent features will include a conclusion screen for if they win or lose and exponential stamina decrease. By the end of this stage the game should feel more or less complete, allowing later stages to focus on more advanced features. 
## To Do List 
### Features 
- [ ] Player death screen 
- [ ] Player victory screen 
- [ ] Removes actor from world when their health reaches 0 
- [ ] Stamina increases exponentially after a short interval 

### Tests 
- [ ] Actor removed from world when their health <= 0 
- [ ] Player/Enemy cannot attack when their stamina is 0 
- [ ] Player win when enemy health = 0
- [ ] Player lose when player health = 0
- [ ] Stamina regenerates exponentially after inactivity
- [ ] Player cannot attack when on cooldown 
## Methods 
### Player Win 
![[Player-win.svg]]
### Player Lose
![[Player-lose.svg]]
## Notes 
### Designing the Win Screen 
Whilst designing the win screen for my game, I came up with several prototypes. I ended up choosing the one below because of its simplicity which I feel is in tune with the game. The graphic of the player and enemy sprites conveys a dominance of the player over the enemy which they have beaten, making the user feel rewarded for beating that difficulty. 
![[win_screen.png]]
### Designing the Lose Screen 
The central theme of the lose image is designed to be brief humiliation and amusement. This nature for similar media is found in all sorts of games, but especially those which I have based mine upon. The aim of this method is to make the player laugh and thus enjoy playing the game even if they are losing. On the other hand it might encourage them to play again to beat this menace depicted in this image thus driving player engagement.
![[lose_screen.png]]