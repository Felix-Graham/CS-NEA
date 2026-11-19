Stage 7 involves implementing 'condition checks' to the game. Similar to Stage 6, some of these will have inevitably been implemented prior to this stage for the purpose of testing. Some of the largest and most prominent features will include a conclusion screen for if they win or lose and exponential stamina decrease. By the end of this stage the game should feel more or less complete, allowing later stages to focus on more advanced features. 
## To Do List 
### Features 
- [x] Player death screen 
- [x] Player victory screen 
- [x] Removes actor from world when their health reaches 0 
- [x] Stamina increases exponentially after a short interval 

### Tests 
- [x] Actor removed from world when their health <= 0 
- [x] Player/Enemy cannot attack when their stamina is 0 
- [x] Player win when enemy health = 0
- [x] Player lose when player health = 0
- [x] Stamina regenerates exponentially after inactivity
- [x] Player cannot attack when on cooldown 
## Methods 
### Player Win 
![[Player-win.svg]]
### Player Lose
![[Player-lose.svg]]
### Stamina Increase 
![[Stamina_increase.svg]]
## Notes 
### Designing the Win Screen 
Whilst designing the win screen for my game, I came up with several prototypes. I ended up choosing the one below because of its simplicity which I feel is in tune with the game. The graphic of the player and enemy sprites conveys a dominance of the player over the enemy which they have beaten, making the user feel rewarded for beating that difficulty. 
![[win_screen.png]]
### Designing the Lose Screen 
The central theme of the lose image is designed to be brief humiliation and amusement. This nature for similar media is found in all sorts of games, but especially those which I have based mine upon. The aim of this method is to make the player laugh and thus enjoy playing the game even if they are losing. On the other hand it might encourage them to play again to beat this menace depicted in this image thus driving player engagement.
![[lose_screen.png]]
### Setting To Each Screen 
The code for changing from the main world to each win/lose screen was really easy. It just involved having a polling check in the World's act method to check if either character's health was 0. If this was the case it would change to the corresponding world. 
One small issue was that I set it up such that each win/lose screen would move to the start menu once clicked in order to make the game more playable for longer periods of time. This was slightly problematic because the player would be rapidly clicking whilst playing the game and might skip past the message. 
To avoid this, I planned to add a short duration in which clicking has no effect. 

### Stamina Exponential Increase 
![[stamina_movement.mp4]]
[[stamina_movement.mp4]]
The video above is proof that my stamina system works with exponential increase. 