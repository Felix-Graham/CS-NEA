In the assumption that this is done in Greenfoot, certain features may prove harder to implement. Thus this document seeks to preemptively address difficulties.
## Features List
| Must Include                       | Should Include          | Could Include                 |
| ---------------------------------- | ----------------------- | ----------------------------- |
| [[#Bots]] to play against          | Different attacks       | Interactive Environment/Props |
| Bar like setting                   | Multiple enemies        | Alcohol                       |
| [[#Stamina bar]]                   | Consecutive hit counter | Powerups                      |
| Hit delay                          |                         | Impact frames                 |
| Small [[#Stun]] upon receiving hit |                         |                               |
| Health                             |                         |                               |

# Bots
The easiest thing to do for this, or the bare minimum, would be to have them swing randomly.
This could be extended by making them **react on certain conditions**, such as the relative distance of the player. This could be expanded on by having these methods and attributes in a `bot` class. It would have limiting attributes such as **reaction time**. This would run a for loop to represent hesitation.  
The most extreme fulfilment of this idea would be to use libraries to train the ai. ==This may not be possible due to the limitations of Greenfoot.== 

# Stamina Bar
As something for both players, this would be an attribute stored in a fighter class, housing **both the player and the bot**.
The most reasonable method of implementation for this would be to impose an **ability cost** to each. For example performing an uppercut may cost an arbitrary 10 `stamina`. 

# Stun
This would be similar to the **hesitation loop** from the bot. 
The easy implementation would be identical to stamina control, with each attack adding to a `player_stun` attribute.
In extending this, multiple attacks in combination could continue to increase this stun number to a threshold. This would hinge on the condition of `time_since_hit > X`. Then the loop would commence, stunning the player.

## Punch 
This would be a significant challenge due to animating in Greenfoot. Not only this, but it should have collision. My idea for this is that it would come in two parts: one player animation, and one created projectile with collision. To avoid the activating player from also colliding with this, I would have a class for attacks, split by [[Player]] and [[Bot]]. The movement for this "attack" object largely depends on the intended complexity. It could simply move 5 units in a straight line an then disappear. The alternative is to have it loosely follow gravity, posing its velocity as a vector such as `10i-2j`. 


