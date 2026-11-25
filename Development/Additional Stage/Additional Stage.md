
In this stage I plan to work and and improve features in my game. This can cover any area and should contribute to either user experience or depth of the game. 

## To Do List 
### Features 
For each feature at least one test will be written to demonstrate its functionality. [[Additional Stage#Better Pausing]] 
- [x] Health and Stamina bars with fixed position [[Additional Stage#Fixed Position]]
- [x] Better pause command 
- [x] Directional knockback
- [ ] Enemy image changes as scaled 
- [ ] Better sprites and background
### Tests 
- [x] Bars do not move
- [x] Bars update 
- [x] Stamina overlay stays as it shoud
- [ ] Pressing '`p`' toggles the paused state of the game 
- [x] Knockback is applied to either Person away from the aggressor
- [ ] Enemy image changes when necessary with scale applied 
- [ ] Sprites rendered look professional and convey the feel of the game 
- [ ] Background makes the setting feel as the title implies 

## Designing 
### Fixed Position
Because the bars, as intended, follow player and enemy as is necessary they can often end up overshadowing each other and making it hard to interpret. This is because they do not have their own collision and move around constantly. This change would fix them to top left and right sides of the screen for player and enemy respectively. This would reduce visual clutter, make useful information easier to interpret and enhance the look and feel of my game. 
This design style takes inspiration for similar games which mine is designed to vaguely resemble. I have done this in order to appeal further to my target audience who would understand this layout and thus make my game feel intuitive and nostalgic as I set out to create. 

### Better Pausing
Currently the pausing works by the user clicking an actor which sits in the top right. This can be difficult if the player is focused on playing the game and does not want to lose. To fix this I will also allow the user to pause with the keybind `p`. 
This change should make the game more user friendly. 

## Methods 
### Fixed Position 
```
CLASS Bar // for any bar 
	FUNCTION act()
		IF NOT MyWorld.paused() THEN 
			update(heartbeat(), fg, this)
		ENDIF 
	ENDFUNCTION
ENDCLASS
```
Note that this is different to the current `act()` method of bars such as `Player_Health`:
``` java 
    public void act()
    {
        if(!MyWorld.paused()){
            follow(MyWorld.player, 30);
            update(heartbeat(), fg, this);
        }
    }
```
Where the new version removes the `follow()` method in favour of a static system.
After implementing this fix, here is the result:
![[static_bars.mp4]]
[[static_bars.mp4]]
### Better Pausing
I will implement a java equivalent for the following pseudocode:
``` pseudocode
FUNCTION act()
	IF MousePressed() OR ButtonPressed('p') THEN
		PAUSE 
	ENDIF 
ENDFUNCTION
```
#### Problems 
Whilst implementing this, I noticed that my pausing had stopped working, apart from directly at the start. I believe this to be the result of having a large proportion of the concerned attributes and methods being static. As a result when I thought that I was updating `MyWorld.paused` through encapsulated methods, nothing happened. 

I first started to fix this by minimising the number of static variables and methods, but this was difficult because by being static they could easily be referenced from almost anywhere. The alternative would force me to instantiate a new world every time I wanted to toggle the pause state. I thus reverted these changes. 

My next approach was to implement a local pause variable for all members of the Person class, Player and Enemy. This would be modified also in the `MyWorld.[un]pause[_toggle]()` methods. This resulted in the following code in `MyWorld`
``` java 
    // pause management
    public static void pause(){
        MyWorld.paused = true; // sets global access variable to true
        Person.local_pause = true;
    }

    public static boolean paused(){
        return MyWorld.paused; // encapsulation ensures that only this class can 
        // modify or directly access the variable, makes program more robust
    }

    public static void unpause(){
        MyWorld.paused = false;
        Person.local_pause = false;
    }

    public static void pause_toggle(){
        MyWorld.paused = !MyWorld.paused;
        Person.local_pause = !Person.local_pause;
    }
```
And in `PlayPause`:
``` java 
    private boolean p_pause = false;
    private int p_pause_cooldown = 10; 
    public void act()
    {
        if(p_pause_cooldown <= 0){
            p_pause_cooldown = 10; // for non-instant pause toggling with p

            if(Greenfoot.isKeyDown("p")){
                p_pause = !p_pause; // flips from true -> false or false -> true
            }
        } else {
            p_pause_cooldown--;
        }
        
        if(Greenfoot.mousePressed(this) || p_pause){ // mouse press or p press 
            MyWorld.pause_toggle();
        } 
        
        // sprite changing for obvious detected state 
        // makes debugging easier 
        if(MyWorld.paused() || Person.local_pause || p_pause){
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.RED);
            image.fill();
            this.setImage(image);
        } else{
            GreenfootImage image = new GreenfootImage(100, 100);
            image.setColor(Color.GREEN);
            image.fill();
            this.setImage(image);
        }
    }
```
Strangely this addition of `Person.local_pause = !Person.local_pause;` and other similar lines entirely fixed pausing by mouse press, but still not by `p`.

I then decided to re-implement the pause system from scratch. Here are some of the design choices I will make for this:
- static variables 
  This will allow me to use `MyWorld.<variable>` or `MyWorld.<method>` which is far easier than re-instantiating the world between pause states.
- encapsulation
  I will use public methods to return and set pause state (true/false). This will also restrict overlaying of states, ie it cannot be set incorrectly, acting as its own input sanitisation. 
- The default start state will be `true`, swapped after the `wait` period on new world. 
- It will be included in the `reset_values()` method in both `LoseScreen` and `WinScreen` because it will be static.
![[pausing_update.svg]]
After implementing this and removing all of the clutter, the pausing system is fully functional. I also kept the `pause_wait()` method, one which pauses for a specified number of `act()` calls before un-pausing. 
### Better GUI and Theming
#### Background 
I am aiming for a background which conveys a jaunty yet familiar sentiment. I have found three reference images, from each I have selected colours and features which I like and would like to incorporate in my game.  
##### Reference Image 1
![[pub1.png]]
I really like the warmth that this pub conveys with its yellowy tones. The symmetry is also perfect for a small game where I would probably be drawing it myself.  
###### Key Colours:
$#b9272a Chair #b9272a 

$#f89d40 Light #f89d40 

$#924a1a Light Wood #924a1a 

$5b1c0b Dark Wood #5b1c0b

##### Reference Image 2
![[pub2.png]]
This is a good reference for both the lighting and boards behind the bar. My original GUI Design:
![[GUI.png]]
features a board behind the bar which would have instructions for the user. As a result this is a helpful reference image. 
###### Key Colours 
$3e4148 Blackboard #3e4148

$f50400 Beer 1 #f50400

$0004cb Beer 2 #0004cb

$fdf403 Beer 3 #fdf403 

$c0cbc5 Chalk #c0cbc5 

$0c445b Mini-fridge Border #0c445b
##### Reference Image 3
![[pub 3.png]]
This image shows the iconic pub carpet which I would like in my game. Furthermore the leather chairs might feature in the background.
###### Key Colours 
$7f8a82  Carpet  #7f8a82 

$ac5d60 'Red' Carpet #ac5d60 

$b8a49d 'White' Carpet #b8a49d

$5b371f Dark Leather Chair #5b371f
##### Result 
![[pub background.jpg]]
#### Start Menu
I would like this to feel like the exterior of the venue, as if the play button is the player choosing to enter the pub and thus start the game. It will be a dark night, making the pub seem more inviting yet also dangerous. A few smashed windows would also add the the theme of combat for the game. 
##### Reference Image 1
![[out pub 1.png]]
I like the illuminated brickwork of the exterior of this pub. But the building itself looks far too nice to be the setting for my own. 
$582e20 Dark Brick 

$903509 Medium Brick 

$c0640d Light Brick 

##### Reference Image 2
![[out pub 2.png]]
This image is good for referencing the colour contrast between inside and outside, as well as the accent colour of the white-painted wood. 
$d8a258 Pale Light 

$b16f1b Strong Light 

$efd0b1 Windowsill 

$000910 Night Sky

$5d5d55 Cloud 

$403320 Lamp Holder 

$e9ebe6 Lamp Light 

##### Reference Image 3 
![[out pub 3.png]]
This is a good example of a Gothic atmosphere around the pub.  The perspective also adds to the feeling of the building looming over the user making it seem hostile, which is accurate for my game. 
$82817d Concrete Pavement 

$171715 Dark Bollard 

$593c36 Intimidating Red Brick 

$53564d Building Concrete Grey 
