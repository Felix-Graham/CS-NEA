## Description and Goals
This stage is responsible for creating the HUD (Heads Up Display) for the game. This will consist of the following elements:
- Player health bar
- Enemy health bar 
- Player stamina bar 
- Player cooldown bar (shown only when necessary)
- Pause/Play button
These are designed to make the experience of playing the game easier because the person playing the game will be able to properly visualise the value of their health. This will allow them to make informed decisions about attacking. The result should resemble the image below:
![[GUI.png]]
## To Do List 
### Features 
- [x] Player Health Bar 
- [x] Player Stamina Bar 
- [x] Player Cooldown Bar (visible when necessary)
- [x] Enemy Health Bar 
- [x] Play/Pause button
### Tests 
- [ ] Does the HUD display accurate data for the health of either character?
- [ ] Does the HUD display a stamina bar for the player, updated in real time?
- [x] Does the HUD dynamically display the player's cooldown as a bar?
- [x] Does the HUD display a play/pause button is the top left corner for the user?
- [ ] Do all of the bars show relevant information which is consistently updated?
## Methods 
Many of these methods will be reused/repurposed for other classes. For example, I will use `Player Health Bar Draw` for other bars such as player stamina and enemy health. The same goes for the update function.
###  Bar Draw
``` pseudocode
CLASS Bar 
	FUNCTION Bar(fill)
		THIS.fill = fill
	ENDFUNCTION
	
	
	FUNCTION draw()
		Bar health_bar = new Bar()
		health_bar.fill(fill, "red")
	ENDFUNCTION
ENDCLASS
```
### Player Health Bar Update 
![[health_bar_update.svg]]
### Player Cooldown Bar 
The following is an example of how a bar might be constructed.
![[cooldown_bar.svg]]
### Bar Following Player/Enemy 
![[bar_movement.svg]]
### Pause 
![[pause.svg]]

## Notes 
### Creating the Bars 
![[One_red_bar.png]]
I decided that it would be best to use a parent class for the bars, meaning that they could all inherit methods such as `draw()` and `update()`. The above image shows me testing the constructor of `enemy_health` bar, producing a large red bar. This point in development was part of my iterative testing, allowing me to ensure that I would be able to create a bar of any dimensions and colour.

### Bar Movement Method and Its Problems 
``` java 
public void follow(Person p){
        // passes person such that can follow with p.getX() and p.getY()
        int x = getX();
        int y = getY();
        int next_x = p.getX();
        int next_y = p.getY() + this.hover_space;
        // the goal is to have a slow-ish speed at which to follow the person over their head
        // this will thus have a separate function called `move_request()` to handle gradual movement
        // via the act method.
        int tdx = x - next_x; // total displacement x
        int tdy = y - next_y;
        // these values will be constantly updated via the act method
        // move_request() will be called to move incrementally to the next_x/y location
        while(x != next_x && y != next_y){
            move_request(10, 10);
        }
    }
    
    public void move_request(int dx, int dy){
        setLocation(getX()+dx, getY()+dy);
    }
```
This is the state of the bar `follow()` method as of the 12th of October. As explained in the comments, the method calls the `move_request()` method to move the bar. This avoids errors which I have previously had with motion such as jumping or changing image, where Greenfoot finishes the entire loop instantly, removing the smooth movement which I would like. 
I have since fixed this with the following solution:
``` java 
    public void follow(Person p){
        // passes person such that can follow with p.getX() and p.getY()
        int x = getX();
        int y = getY();
        int next_x = p.getX();
        int next_y = p.getY() - hover_space;
        // the goal is to have a slow-ish speed at which to follow the person over their head
        // this will thus have a separate function called `move_request()` to handle gradual movement
        // via the act method.
        int tdx = x - next_x; // total displacement x
        int tdy = y - next_y;
        // these values will be constantly updated via the act method
        // move_request() will be called to move incrementally to the next_x/y location
        if(x != next_x && y != next_y){
            if(x > next_x){
                // next to the left
                move_request(-10, 0);
            }
            if(y > next_y){
                // next higher up
                move_request(0, -10);
            }
            if(y < next_y){
                move_request(0, 10);
            }
            if(x < next_x){
                move_request(10, 0);
            }
        }
    }
    
    public void move_request(int dx, int dy){
        setLocation(getX()+dx, getY()+dy);
    }
```
This fix allowed the bars to properly follow the player and enemy as below:
![[health_bars_follow_people.png]]

### Damage Fixing 
Whilst testing my bars' code, I realised that due to a poor choice of method for damaging an opponent, damage is only truly applied if both player and enemy are directly intersecting. This is because of the method which I have used (`getOneIntersectingObject(Enemy.class)`) one returns `enemy` if they are intersecting. To remedy this, I will change my `punch()` and `kick()` method from 
``` java 
    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){
            if(cooldown == 0){
                try{
                    Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
                    enemy.damage(DAMAGE_PUNCH);
                    enemy.knockback(KNOCKBACK_PUNCH);

                } catch(Exception e){

                }

                setImage("player_punch.png");
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                //cooldown(COOLDOWN_PUNCH, this);
                cooldown = cooldown + Person.round(COOLDOWN_PUNCH*60, "###");
            }
        }
        imgState = 0;
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(cooldown == 0){
                try{
                    Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
                    enemy.damage(DAMAGE_KICK);
                    enemy.knockback(KNOCKBACK_KICK);
                } catch(Exception e) {

                }

                setImage("player_kick.png");
                stamina = stamina - STAMINA_DRAIN_KICK;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_KICK*60, "###");
            }
        }
        imgState = 0;
    }
```
to 
``` java 
    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){
            if(cooldown == 0){
            
                if(MyWorld.enemy.getX() < 5){
	                MyWorld.enemy.damage(PUNCH_DAMAGE);
	                MyWorld.enemy.knockback(KNOCKBACK_PUNCH);
                }
                
                setImage("player_punch.png");
                stamina = stamina - STAMINA_DRAIN_PUNCH;
                //cooldown(COOLDOWN_PUNCH, this);
                cooldown = cooldown + Person.round(COOLDOWN_PUNCH*60, "###");
            }
        }
        imgState = 0;
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){
            if(cooldown == 0){
            
                if(MyWorld.enemy.getX() < 5){
	                MyWorld.enemy.damage(KICK_DAMAGE);
	                MyWorld.enemy.knockback(KNOCKBACK_KICK);
                }

                setImage("player_kick.png");
                stamina = stamina - STAMINA_DRAIN_KICK;
                //cooldown(COOLDOWN_KICK, this);
                cooldown = cooldown + Person.round(COOLDOWN_KICK*60, "###");
            }
        }
        imgState = 0;
    }
```
#### Variable Shadowing 
After a lot of research and smoke testing, I discovered that the root cause of this problem was because of something called variable shadowing (![[references#Variable Shadowing]]). This became obvious when inspecting either the player or enemy characters and finding an extra field which went undeclared in their code:
![[wtf_health_variables.png]]
![[no_health_references.png]]
As I found out, this was the result of declaring `health` and `cooldown` in the parent class, despite this being used to write the methods for both player and enemy. 
``` java 
public class Person extends Actor
{
    int cooldown;
    int health;
    
    .
    .
    .
    
    public void damage(int d, Person p){
        p.health = p.health-d;
    }
    
```
As of 19/10/2026, I have fixed this. I did so by declaring the `damage()` method in both `Enemy` and `Player` classes following a polymorphic approach. 
![[damage_in_player.png]]
This allowed damage to be applied directly to either Persons' static `health` variable as such:
![[health_not_hidden_working.png]]
Because of this, I was able to fully implement a dynamically updating health bar for both classes:
![[accurate_bar_update.png]]
My research about this error comes from the following two sites. No code from either was copied.
https://www.geeksforgeeks.org/java/shadowing-in-java/
https://codingtechroom.com/question/understanding-variable-shadowing-java
### Damage Below A Threshold 
Whilst testing, I discovered that I had a small logic error for when the value of health is less than 0. This stemmed from the code:
``` java 
private int player_heartbeat(){
	int pc = 100-MyWorld.player.health;
	return pc;
}
```
If `MyWorld.player.health` is less than 0, the following would happen:
$$
\text{Let } MyWorld.player.health = -50

$$
$$
pc = 100-(-50) = 150
$$
$$
\therefore \text{ Health Bar would overfill to 150 }
$$
To prevent this, I implemented the following check into the `damage` method:
``` java 
public void damage(int d){
	if(this.health-d <= 0){
		this.health = 0;
	} else{
		this.health = this.health-d;
	}
}
```
