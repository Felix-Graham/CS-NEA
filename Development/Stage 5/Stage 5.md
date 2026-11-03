This stage is about designing and creating the start menu. It should feature a difficulty slider and start button. I plan to accomplish this my having a separate `World` class called `Start`. 
![[start_menu_gui.png]]
## To Do List 
### Features 
- [x] Start Screen Menu
- [x] Difficulty Slider 
- [x] Difficulty Value 
- [x] Start Button
### Tests 
- [x] Start Button starts game 
- [x] Start Screen Menu loads first when running the game 
- [x] Start Screen Menu holds Start Button and Difficulty Slider 
- [x] Difficulty Slider alters Difficulty Value 

## Methods 
### Start Game
![[start game.svg]]
### Difficulty Slider 
#### Cursor Follow 
![[cursor follow.svg]]
#### Update Value
![[update value.svg]]
## Notes 
### Start Button Alteration
After implementing my start button, I realised that the transition from menu to action is too fast. To remedy this, I came up with the following amendment to the [[start game.svg |start game flowchart ]]:
![[start game amendment.svg]]
The `wait 3 seconds` would make use of the Greenfoot `act()` method being called 60 times per second. The waiting would happen because after it had changed worlds, it would set the global `paused` to `true` whilst 3 seconds has not passed. 
This idea was sadly flawed due to what turned out to be Greenfoot's entity permanence. After the start button changed the world, the object was destroyed and thus - having paused the world - would not resume. To fix this, I introduced two new methods into the `MyWorld`, being `wait_please()` and `are_we_unpausing()`. The static method `wait_please()` takes `t` as a parameter, which is the number of `act()` calls. This is used as a setter  to modify a variable in `MyWorld` called `wait`. Following this, the method `are_we_unpausing()` is called each `MyWorld` `act()` run. It is a very simple check to see if the `wait` variable is equal to or less than 0. I have decided that it should be its own method for simplicity in the act method and ease of reading, with both new methods next to each other. This produced working code as follows:
![[start_delay.mp4]]
[start_delay.mp4]
### Difficulty Slider 
This went without much trouble. I even had time to implement a colour change for more visual feedback to the user based on their chosen difficulty level. 
![[difficulty_slider.mp4]]
[difficulty_slider.mp4]
It can be moved both with the mouse and keyboard. 
With this finished I was able to move onto my testing, where all of my tests passed.