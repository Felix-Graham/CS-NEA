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
