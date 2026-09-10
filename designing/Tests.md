## Tests Per Stage
### Stage 1

| Test                                                         | Outcome                                                                                |
| ------------------------------------------------------------ | -------------------------------------------------------------------------------------- |
| Is the player sprite displayed?                              | Player sprite should be displayed at the player's location.                            |
| Is the player able to move, corresponding to keyboard input? | The player moves upon keyboard input. This accurately covers all necessary directions. |
| Can the player attack?                                       | The attack animation is displayed after the relevant keyboard input.                   |
| Does the player fall to the ground after jumping?            | The player falls from the air after jumping, giving the impression of gravity.         |
|                                                              |                                                                                        |
### Stage 2

| Test                                                                                                               | Outcome                                                           |
| ------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------- |
| Do methods for returning data for character attributes such as `Health` and `Stamina` return accurate information? | The methods used to find and return data are accurate.            |
| Is the method to calculate and return the distance between the player and enemy accurate?                          | The method is accurate, returning data in a form which is usable. |
### Stage 3

| Test                                                            | Outcome                                                                |
| --------------------------------------------------------------- | ---------------------------------------------------------------------- |
| Is the enemy sprite displayed at their location?                | The sprite is displayed wherever the enemy is.                         |
| Is the enemy able to move?                                      | The enemy can move when commanded with keyboard input.                 |
| Is the enemy able to move in response to data about the player? | The enemy uses the getter methods from stage 2 to decide when to move. |
| Can the enemy attack and decide when to through received data?  | The enemy uses data such as player proximity to "decide" to attack.    |
|                                                                 |                                                                        |
### Stage 4

| Test                                                                           | Outcome                                                                                                                                                      |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Does the HUD displays accurate data for the health of either character?        | The HUD displays coloured bars which display either characters' health in real time.                                                                         |
| Does the HUD display a stamina bar for either character, updated in real time? | The HUD displays coloured bars which display either characters' stamina in real time.                                                                        |
| Does the HUD dynamically display the player's cooldown as a bar?               | The HUD displays the player's cooldown value, in real time, showing only it when necessary (cooldown is not zero).                                           |
| Does the HUD display a play/pause button is the top left corner for the user?  | A play/pause button is displayed in the appropriate region. On clicking it the icon/sprite changes to reflect the state, with the game being paused/resumed. |
| Do all of the bars show relevant information which is consistently updated?    | Yes.                                                                                                                                                         |
### Stage 5

| Test                                                                                           | Outcome                                                                           |
| ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| Does the game start with a menu?                                                               | The game loads with a menu with the option to start the game.                     |
| Does this start menu include a difficulty slider?                                              | Yes.                                                                              |
| Does the difficulty slider accurately update a value which affects the difficulty of the game? | Yes.                                                                              |
| Does the start button start the game?                                                          | On click, the start button begins the game with both the player and enemy set up? |
### Stage 6

| Test                                                                           | Outcome                                                                         |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------- |
| Does the player win when the enemy's health is 0?                              | The player wins the game and an appropriate screen is displayed to convey this. |
| Does the player lose the game when their health is 0?                          | The enemy wins and a message is shown to display this.                          |
| Can the player attack when their stamina is 0?                                 | The player cannot attack until their stamina is sufficiently regenerated.       |
| Does the stamina amount regenerate exponentially after a period of inactivity? | Yes.                                                                            |
| Can the player use an attack when it is on `Cooldown`?                         | No, they must wait until the `Cooldown` timer has ended.                        |
| Is a character removed when their health is 0?                                 | The character is removed from the scene.                                        |
### Stage 7

| Test                                                                | Outcome |
| ------------------------------------------------------------------- | ------- |
| Do attacks have a value for knockback as well as damage?            | Yes.    |
| Is knockback applied accurately to either character when necessary? | Yes.    |

### Stage 8

| Test                                                                                    | Outcome |
| --------------------------------------------------------------------------------------- | ------- |
| Does the enemy load with random strength and knockback in accordance with `difficulty`? | Yes.    |
| Does the enemy have a random size in accordance with `difficulty`?                      | Yes.    |


## Final Tests


| Test                                                      | Purpose                                                                                                                        |
| --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| Player Enemy collision                                    | Tests if the player and enemy are capable of colliding.                                                                        |
| Appropriate knockback levels for attacks                  | Tests if the level of knockback applied is suitable for player and enemy.                                                      |
| Appropriate health values in correspondence with damage   | Tests how long the average game could last and is this is consistent with my analysis and planning.                            |
| The player dying ends the game                            | To check if there is an appropriate response to inform the player that they have lost.                                         |
| The start screen starts the game correctly                | To ensure that random values for the enemy are correctly created with reference to the difficulty slider.                      |
| The gravity of the game works to achieve a pseudo realism | To see how the game feels to play for a player. A lower gravity could make for a slower game, with more time spent in the air. |
