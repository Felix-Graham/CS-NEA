## Description and Goals 
Stage 2 plans to implement the enemy to the game, allowing further stages with it involved. It will take a large quantity of player methods.

## To Do List 
### Features 
- [x] Create enemy class 
- [x] Enemy has appropriate attributes
- [x] Enemy movement (with keyboard)
- [x] Enemy attacks (with keyboard)
### Tests 
- [x] Enemy can move 
- [x] Enemy can attack 
- [x] Enemy can take damage 
- [x] Enemy can give damage 
- [x] Enemy can be knocked back 
- [x] Enemy can knock back
## Class Diagram 

![[EnemyClassDiagram.svg]]

## Methods 
### Decide
![[DecisionFlowChart.svg]]
### runToward()
![[runToward.svg]]

## Attributes 
Identical to player with modification in the constructor with a scalar modifier which will allow a difficulty slider to be implemented.

## Notes 
### Null Pointer Errors
Due to this character's creation and actions hinging on the `player` class, for detection and attribute initiation, I had to reference this class a lot. This became challenging after receiving quite a few `null pointer exception`'s. I ended up fixing this by passing the created player into `enemy`'s constructor in the `prepare()` method in the `World` class. 
``` java 
private void prepare()
    {

        Player player = new Player();
        addObject(player,PlayerStartX,PlayerStartY);
        // int SPEED, int JUMP, int SM, int DM, int KM
        Enemy enemy = new Enemy(5, 200, 100, 2, 3, player);
        addObject(enemy,395,306);
    }
```
With the enemy constructor looking like this:
``` java 
public Enemy(int SPEED, int JUMP, int SM, int DM, int KM, Player nemesis){
        this.SPEED = SPEED;
        this.JUMP = JUMP;
        this.STAMINA_MAX = SM;
        this.p = nemesis;
        // DM stands for Damage Multiplier and takes 1 as player attributes

        this.DAMAGE_PUNCH = round((Player.DAMAGE_PUNCH * DM), "###");
        this.DAMAGE_KICK = round((Player.DAMAGE_KICK * DM), "###");
        // KM stands for knockback multiplier and takes from player 
        this.KNOCKBACK_PUNCH = round((Player.KNOCKBACK_PUNCH * DM), "###");
        this.KNOCKBACK_KICK = round((Player.KNOCKBACK_KICK * DM), "###");

    }
```
By passing in the player and storing it as a private global attribute, I could always reference the desired object from anywhere in the code. Because of this I decided that using a global variable to store this object would be the most appropriate way to avoid null pointer exceptions. 

### Decision Based Fighting
![[fighting.mp4]]
In this video (fighting.mp4), the enemy, in red, is attacking the player, black. This is achieved by the checking of conditions as outlined above 
![[#Decide]]
The issue with some of this is that I did not foresee the repetition of the basic `punch` attack after stamina is below a threshold. This happens because the enemy is constantly checking if its stamina is high enough to kick, which it is not due to its barrage of attacks. I am hoping that this is rectified in future with  a fix to the cooldown system.