# Development Plan


| Stage | Involves                                | Success Criteria                                                                                                                                                                                                                                                                                                                                                              | Success Indicator                                                                                                                                                                                      | desirable essential                                         |
| ----- | --------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------- |
| 1     | Creating the player.                    | They should be able to move left, right and up with corresponding input keys. They should also be able to use attacks which briefly change the sprite. The data such as power and knockback of these attacks would not be of concern at this stage.                                                                                                                           | - [ ] Player Can move<br>- [ ] Player can attack <br>- [ ] Player jumps and returns to ground                                                                                                          | essential                                                   |
| 2     | Creating Enemy                          | The Enemy actor is added to the scenario with basic movement and abilities to match the player. Its actions such as `move` should be controlled by monitored events such as Player proximity.                                                                                                                                                                                 | - [ ] Enemy can move<br>- [ ] Enemy can attack <br>- [ ] Enemy responds to Player events                                                                                                               | essential                                                   |
| 3     | Setting up environment data collection. | Greenfoot world contains getters for data such as player health, stamina and distance from enemy. This is so that the enemy class can use these as events to act upon.                                                                                                                                                                                                        | - [ ] Getters return accurate information about Player                                                                                                                                                 | essential                                                   |
| 4     | Creating HUD                            | The game should now have a HUD to display the player and enemy's health and stamina . The bar should deplete the lower the value represented. The health bars should hover above each characters' head. The stamina and cooldown bar (unique to player) should sit in the top right hand corner. A pause/play button be added also in the top left to start or stop the game. | - [ ] Health Bar follows player/enemy <br>- [ ] Stamina bar in corner<br>- [ ] Cooldown bar shown when necessary (in use)<br>- [ ] Bars show accurate information<br>- [ ] Game can be stopped/started | essential with desirable aspects such as floating healthbar |
| 5     | Start Menu                              | The game should load into the `Start Menu`, with options including start the game, change difficulty and quit. Difficulty slider should modify variables in Enemy class such as strength, speed, stamina. Start starts game.                                                                                                                                                  | - [ ] Start button starts game<br>- [ ] Difficulty slider increases enemy power                                                                                                                        | essential                                                   |
| 6     | Better Attacks                          | Attack functions are populated with data for damage and knockback. For the player this is a base value, for the enemy this is random as above. Damage and knockback are to be taken using setters such that Player can apply knockback to Enemy.                                                                                                                              | - [ ] Attack from either lowers health<br>- [ ] Attack from either has damage proportional knockback                                                                                                   | desirable                                                   |
| 7     | Condition Checking                      | Basic condition checking such as `if(player.health < 0){player.die;}`. Extends to stamina (limit attack), cooldown.                                                                                                                                                                                                                                                           | - [ ] Characters die<br>- [ ] Attacks remove stamina such that they cannot be used constantly<br>- [ ] Attacks have effective cooldowns                                                                | essential                                                   |
| 8     | Enemy Expansion                         | The enemy loads in with random variables within an appropriate range. This includes size (Greenfoot.imageSize), strength (within bounds relative to difficulty) and speed.                                                                                                                                                                                                    | - [ ] Enemy size varies <br>- [ ] Enemy speed varies <br>- [ ] Enemy strength varies                                                                                                                   | desirable                                                   |

# Justifications 
### 1
This is the most crucial stage, due to it being the crux of the whole game. By doing this first, I will be able to test almost everything else. 
### 2
This stage is necessary for properly wiring the enemy. For testing, this will allow me to test mechanisms such as attacking, character-character collision.
### 3
By doing this, I can properly wire up the enemy. Furthermore, the data from the getters I plan to implement will serve as useful tests to ensure that everything is going as I'd like. The conditions in the enemy's code coming from here would make the game officially playable.
### 4
The HUD is the most stylistic element, and while helpful, not crucial to play-ability. This is why I have left this until the characters are set up. As well as this, by leaving this after the 3rd (data collection), all of the methods for returning data to be shown will be available, making this a theoretically smooth experience.
### 5 
Like the HUD, this is not the most important element, hence it has been left to this cycle. I have also positioned it after designing the HUD so that the memory of the necessary code and methods to create a basic GUI will still be fresh in my memory. 
### 6
The better attacks stage plans to populate the attacks with damage and knockback. This enables the stage after it, whilst also testing the health-bar. It does not go directly after the addition of the health-bar, allowing cycle 5 to take that place. This is because of the obvious link between both GUI based stages.  
### 7
This stage is the final one until the game is entirely functional. It plans to introduce death and a limit on attacks enforced by stamina and cooldown. This stage is being implemented as one of the later stages due to it completing the structure of the game. 
### 8
As the final stage, it represents a very small and slightly unnecessary aspect of the game, hence its position. This stage would be what I would like, and was lightly desired in my consumer research survey. Unfortunately, it cannot be justified to take precedence over the stages coming before it. 

# GUI 
# Main Screen 
![[GUI.png]]
The above is a rough outline of what I hope my project might become. As of this, details such as non-important colours including background and player sprites are not shown above. 
This screen is the most detailed, because it will be displayed the majority of the time.
## Bars 
Above each will be coloured bars to display data about metrics corresponding to each character. The amount of the bar coloured in would be the percentage of the metric from full, for example if the player had 40 health remaining down from 100, the health bar would be 40% full. 
### Colours
The colours for each bar have been chosen to match the aesthetic of my game, whilst taking inspiration from other games of similar genres or categories. As such health would be red; stamina tan/peach; cooldown blue. 
### Visibility
As is above, more data would be available for the player's character than for the enemy. This adds more challenge to the game as well as authenticity with the player not knowing some data about their opponent such as stamina. 
Furthermore, the cooldown bar would only be temporarily displayed. This being when it is needed (not 0). This would increase the player's view by only showing data useful at that moment. 
### Size Variance
The larger the value for a character's maximum or starting health, the larger the bar for that should be. In practice this would affect only the enemy once the relevant development cycle is complete. 

## Play/Pause Button 
This button will sit in the top left corner, as my market research has led me to conclude is standard, due to the space freed up on the screen. Upon clicking, it will pause the game and change its sprite to reflect the state. In practice, pausing will look like stopping the movement of either player or enemy and halting the regeneration of stamina or cooldown.
## Characters
The game will feature two characters, being the player and the enemy, both visible on the screen. Their movement will be shown live, making the game playable. I plan to draw sprites for each, matching them to the overall look of the game. The examples shown above are rough outlines of what I hope mine become. The size difference between the player and enemy character is intended, and hopefully will reflect plays with a higher difficulty, where the enemy is larger than the player. 
## Controls Screen 
In the background of the scene will be a small display in the style of a bar's menu. It will have on it the various controls to perform basic actions such as move, punch, etc. I have chosen this style because it will reflect the general style of the game. This will increase the continuity of the game, making it feel better tuned and stylised. 
## Background 
The background in the image above is a rough simplification. I plan to keep elements like the bottles, shelves and drinks, but with a more full scene. The scene created by it should feel dark and quite moody, like a small pub. 


# Start Menu 
![[start_menu_gui.png]]
Like the main game GUI mock up, this is an abstraction of what I hope the actual thing looks like. Some features above are exaggerated so that they are quicker to find, and more obvious to make. Furthermore, there is no background image, hence the white background.
I have this main menu in order to bridge the gap between loading the game and fighting. This allows the player to spend time selecting a difficulty and preparing themselves.

## Difficulty Slider 
The difficulty slider above is coloured based on its difficulty. The cursor/selector would be set at medium by default, making the colour system intuitive to the user. The idea of moving the selector with arrow keys may be a little confusing, or not explicitly obvious, so I would like to have a label for this information. I also have deliberately put it on the left, such that the start screen is dominated by itself and the play buttons - the two main features of my start screen. As well as this, the position of the difficulty slider echoes games of a similar category, and the colour scheme would demonstrate this further. The result is a dynamic looking menu, with a clear colour scheme which evidences itself to its genre.

## Start Button
The large size of the start button is designed to reflect its significance in the menu. It is on the right because my target audience will likely read from left to right, meaning that they will see the difficulty slider first and respond to that before pressing play. The triangle inside the play button is designed as the general symbol for 'play', in music, video or games. Due to this being so universal, I will likely remove the label above it. This would further centre it and remove unnecessary detail.
## Title 
The title sits above everything else, making it the first thing seen. Its audacity is similar to its competitors, thus it should make the game better known. The font above is a placeholder font for what would either be a hand drawn title, or a better font. 

## Tests Per Stage
### Stage 1 - Player Creation 

| Test ID | Test                                                                 | Test Data   | Outcome                                                                                | Actual Outcome |
| ------- | -------------------------------------------------------------------- | ----------- | -------------------------------------------------------------------------------------- | -------------- |
| 1A      | Is the player sprite displayed?                                      | Run program | Player sprite should be displayed at the player's location.                            |                |
| 1B      | Is the player able to move, corresponding to keyboard input?         | Run program | The player moves upon keyboard input. This accurately covers all necessary directions. |                |
| 1C      | Can the player attack?                                               | Run program | The attack animation is displayed after the relevant keyboard input.                   |                |
| 1D      | Does the player fall to the ground after jumping?                    | Run program | The player falls from the air after jumping, giving the impression of gravity.         |                |
| 1E      | Does the player have values for `health`, `stamina` and `knockback`? | Run program | Yes, with relevant methods to get this data.                                           |                |
### Stage 2 - Enemy Creation 
A class called `Enemy` would have been created in order for above stages. This stage populates that class with data, actions and methods.

| Test ID | Test                                                              | Test Data   | Outcome                                                                | Actual Outcome |
| ------- | ----------------------------------------------------------------- | ----------- | ---------------------------------------------------------------------- | -------------- |
| 2A      | Is the enemy sprite displayed at their location?                  | Run program | The sprite is displayed wherever the enemy is.                         |                |
| 2B      | Is the enemy able to move?                                        | Run program | The enemy can move when commanded with keyboard input.                 |                |
| 2C      | Is the enemy able to move in response to data about the player?   | Run program | The enemy uses the getter methods from stage 2 to decide when to move. |                |
| 2D      | Can the enemy attack and decide when to through received data?    | Run program | The enemy uses data such as player proximity to "decide" to attack.    |                |
| 2E      | Does the enemy have data for `health`, `stamina` and `knockback`? | Run program | Yes, with methods to return them.                                      |                |
### Stage 3 - Data Collection

| Test ID | Test                                                                                                               | Test Data   | Outcome                                                           | Actual Outcome |
| ------- | ------------------------------------------------------------------------------------------------------------------ | ----------- | ----------------------------------------------------------------- | -------------- |
| 3A      | Do methods for returning data for character attributes such as `Health` and `Stamina` return accurate information? | Run program | The methods used to find and return data are accurate.            |                |
| 3B      | Is the method to calculate and return the distance between the player and enemy accurate?                          | Run program | The method is accurate, returning data in a form which is usable. |                |

### Stage 4 - HUD

| Test ID | Test                                                                           | Test Data   | Outcome                                                                                                                                                      | Actual Outcome |
| ------- | ------------------------------------------------------------------------------ | ----------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------------- |
| 4A      | Does the HUD displays accurate data for the health of either character?        | Run program | The HUD displays coloured bars which display either characters' health in real time.                                                                         |                |
| 4B      | Does the HUD display a stamina bar for either character, updated in real time? | Run program | The HUD displays coloured bars which display either characters' stamina in real time.                                                                        |                |
| 4C      | Does the HUD dynamically display the player's cooldown as a bar?               | Run program | The HUD displays the player's cooldown value, in real time, showing only it when necessary (cooldown is not zero).                                           |                |
| 4D      | Does the HUD display a play/pause button is the top left corner for the user?  | Run program | A play/pause button is displayed in the appropriate region. On clicking it the icon/sprite changes to reflect the state, with the game being paused/resumed. |                |
| 4E      | Do all of the bars show relevant information which is consistently updated?    | Run program | Yes.                                                                                                                                                         |                |
### Stage 5 - Start Menu 

| Test ID | Test                                                                                           | Test Data   | Outcome                                                                           | Actual Outcome |
| ------- | ---------------------------------------------------------------------------------------------- | ----------- | --------------------------------------------------------------------------------- | -------------- |
| 5A      | Does the game start with a menu?                                                               | Run program | The game loads with a menu with the option to start the game.                     |                |
| 5B      | Does this start menu include a difficulty slider?                                              | Run program | Yes.                                                                              |                |
| 5C      | Does the difficulty slider accurately update a value which affects the difficulty of the game? | Run program | Yes.                                                                              |                |
| 5D      | Does the start button start the game?                                                          | Run program | On click, the start button begins the game with both the player and enemy set up? |                |
### Stage 6 - Better Attacks

| Test ID | Test                                                                | Test Data   | Outcome | Actual Outcome |
| ------- | ------------------------------------------------------------------- | ----------- | ------- | -------------- |
| 6A      | Do attacks have a value for knockback as well as damage?            | Run program | Yes.    |                |
| 6B      | Is knockback applied accurately to either character when necessary? | Run program | Yes.    |                |
### Stage 7 - Condition Checks

| Test ID | Test                                                                           | Test Data   | Outcome                                                                         | Actual Outcome |
| ------- | ------------------------------------------------------------------------------ | ----------- | ------------------------------------------------------------------------------- | -------------- |
| 7A      | Does the player win when the enemy's health is 0?                              | Run program | The player wins the game and an appropriate screen is displayed to convey this. |                |
| 7B      | Does the player lose the game when their health is 0?                          | Run program | The enemy wins and a message is shown to display this.                          |                |
| 7C      | Can the player attack when their stamina is 0?                                 | Run program | The player cannot attack until their stamina is sufficiently regenerated.       |                |
| 7D      | Does the stamina amount regenerate exponentially after a period of inactivity? | Run program | Yes.                                                                            |                |
| 7E      | Can the player use an attack when it is on `Cooldown`?                         | Run program | No, they must wait until the `Cooldown` timer has ended.                        |                |
| 7F      | Is a character removed when their health is 0?                                 | Run program | The character is removed from the scene.                                        |                |

### Stage 8 - Better Enemies

| Test ID | Test                                                                                    | Test Data   | Outcome | Actual Outcome |
| ------- | --------------------------------------------------------------------------------------- | ----------- | ------- | -------------- |
| 8A      | Does the enemy load with random strength and knockback in accordance with `difficulty`? | Run program | Yes.    |                |
| 8B      | Does the enemy have a random size in accordance with `difficulty`?                      | Run program | Yes.    |                |


## Final Tests


| Test ID | Test                                                      | Test Data   | Purpose                                                                                                                        | Actual Outcome |
| ------- | --------------------------------------------------------- | ----------- | ------------------------------------------------------------------------------------------------------------------------------ | -------------- |
| F1      | Player Enemy collision                                    | Run program | Tests if the player and enemy are capable of colliding.                                                                        |                |
| F2      | Appropriate knockback levels for attacks                  | Run program | Tests if the level of knockback applied is suitable for player and enemy.                                                      |                |
| F3      | Appropriate health values in correspondence with damage   | Run program | Tests how long the average game could last and is this is consistent with my analysis and planning.                            |                |
| F4      | The player dying ends the game                            | Run program | To check if there is an appropriate response to inform the player that they have lost.                                         |                |
| F5      | The start screen starts the game correctly                | Run program | To ensure that random values for the enemy are correctly created with reference to the difficulty slider.                      |                |
| F6      | The gravity of the game works to achieve a pseudo realism | Run program | To see how the game feels to play for a player. A lower gravity could make for a slower game, with more time spent in the air. |                |
# Post Development Questions
Once each of my stages have been implemented, and I have alpha tested, I would like to ask some of my friends and peers to beta test my game. In order for this to be effective and a good use of time, I will put together series of questions to ask them once they have played the game on each difficulty setting. 

My questions should aim to cover information about the following:
- User friendliness
- Intuitive design
- Likeability of the design
- Difficulty of each setting
- How long each difficulty took them 
- The usability of the controls
- Did the game perform well (high frames per second, etc)
In light of this, my questions will probably look something like this:
1. On a scale of 1 to 10, how user friendly is the game?
2. On a scale of 1 to 10, how intuitive would you describe the design?
3. Did you like the design?
4. On a scale of 1 to 10, how hard was the hardest setting?
5. On a scale of 1 to 10, how hard was the default setting?
6. On a scale of 1 to 10, how hard was the easiest setting?
7. How long did the hardest difficulty take you?
8. How long did the default difficulty take you?
9. How long did the easiest difficulty take you?
10. Did you find the controls to be easy to learn and use?
11. Would you say the game performed well on your system?
12. Did you encounter any bugs/glitches?
My hope is that the beta testers will enjoy the game and give constructive feedback to work on before it is finished. 
This questionnaire will most likely be sent via Microsoft Forms, due to the Microsoft Office Suite being available to my college. This would make it the easiest form of communication with integrated data graphics.