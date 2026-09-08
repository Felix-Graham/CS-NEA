## Tests Per Stage

| Stage             | Test                                                                                                                                                                                                                                                                               | Result (Desired)      |
| ----------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------- |
| 1:CreatingPlayer  | - Player sprite displayed<br>- Player movement with inputs<br>- Player basic attacks with inputs <br>- Player returns to ground after jumping                                                                                                                                      | True for all          |
| 2:DataCollection  | - Methods return information about Player-Enemy distance<br>- Methods return information about Player stamina/health                                                                                                                                                               | Accurate data for all |
| 3:CreatingEnemy   | - Enemy sprite displayed<br>- Enemy can move<br>- Enemy registers and reacts to data events<br>- Enemy attacks with events                                                                                                                                                         | True for all          |
| 4:HUD             | - HUD displays health bars for each character <br>- HUD displays stamina bar for each character<br>- HUD displays cooldown bar for player <br>- HUD displays pause/resume button for player<br>- Bars show accurate information which is updated as necessary                      | True for all          |
| 5:StartMenu       | - Game starts with a start menu<br>- Menu includes start button, difficulty slider<br>- Difficulty slider modifies `difficulty` value to effect enemy power<br>- Start starts game                                                                                                 | True for all          |
| 6:Conditions      | - Player wins if enemy health is 0<br>- Player loses if their health reaches 0<br>- Player cannot attack if they stamina is 0<br>- Stamina increases exponentially until full after not being recently depleted <br>- Player cannot use a certain attack if `cooldown` is not full | True for all          |
| 7:EnemyExpansion  | - Enemy loads with random variables in accordance with `difficulty`                                                                                                                                                                                                                | True for all          |
| 8:AttacksExtended | - Attacks also have value for knockback<br>- Knockback knocks a character back<br>- Enemy knockback random as above                                                                                                                                                                | True for all          |

## Final Tests


| Test                                                      | Purpose                                                                                                                        |
| --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| Player Enemy collision                                    | Tests if the player and enemy are capable of colliding.                                                                        |
| Appropriate knockback levels for attacks                  | Tests if the level of knockback applied is suitable for player and enemy.                                                      |
| Appropriate health values in correspondence with damage   | Tests how long the average game could last and is this is consistent with my analysis and planning.                            |
| The player dying ends the game                            | To check if there is an appropriate response to inform the player that they have lost.                                         |
| The start screen starts the game correctly                | To ensure that random values for the enemy are correctly created with reference to the difficulty slider.                      |
| The gravity of the game works to achieve a pseudo realism | To see how the game feels to play for a player. A lower gravity could make for a slower game, with more time spent in the air. |
