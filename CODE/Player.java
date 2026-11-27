import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // constant variables
    // By declaring these here, the program is easier to tweak because the variables are easier to see.
    public final int SPEED = 5;
    public final int JUMP = 70;
    public final int STAMINA_MAX = 100;
    public final static int DAMAGE_PUNCH = 10;
    public final int STAMINA_DRAIN_PUNCH = 10;
    public final double COOLDOWN_PUNCH = 0.2;
    public final double COOLDOWN_KICK = 0.5;
    public final int STAMINA_DRAIN_KICK = 20;
    public final static int DAMAGE_KICK = 5;
    public final static int KNOCKBACK_PUNCH = 15;
    public final static int KNOCKBACK_KICK = 25;
    public final static int RANGE_KICK = 130;
    public final static int RANGE_PUNCH = 120;
    // all as public so that they can be drawn off by Enemy

    // image scale 1 (not modified)
    final static int IMAGE_SCALE =1;

    // Mutable variables
    public int stamina = 100;
    public int cooldown = 0;

    public static int health = 100; // static for Person `damage()` method therefore 
    // can be accessed from almost anywhere

    private int imgState = 0; // 0 as default, 1 for punch, 2 for kick

    private int imgCountdown = 0; /* theoretically should limit time for image 
    change. Each act method this will increment and thus change the image for the 
    sprite.
     */

    private GreenfootImage stand_sprite;
    private GreenfootImage kick_sprite; // populated with spriting() method called in constructor 
    private GreenfootImage punch_sprite;

    public int x_bar1;
    public int x_bar2; // collision bounds

    public boolean inhibited_movement = false; // force collision

    private void spriting(){ // not from Person via inheritance becuase images and scaling are unique to this class
        // in this way I decided against polymorphism
        this.stand_sprite = new GreenfootImage("ginger.png"); // sets global variable as the relevant image
        this.punch_sprite = new GreenfootImage("ginger_punch.png");
        this.kick_sprite = new GreenfootImage("ginger_kick.png");
    }

    public Player(){
        // player constructor
        // adds self to world reference variable for simplicity
        MyWorld.player = this;
        spriting(); // assigns sprites
    }

    int stamina_increase_delay = 0; // decrease every act(); when 0 increase stamina and set to 30
    int stamina_increase_amount = 2;
    int stamina_increase_init_delay = 10;
    int stamina_comparison = -1; // starts as impossible value so that it cannot meet any unwanted conditions
    // impossible as in it will only be this at the start
    public void act()
    {
        if(!MyWorld.pause_state()){ // if the world is not paused

            if(cooldown > 0){ // if attack cooldown is greater than 0 decrement 
                cooldown--;
            }

            // stamina increase 
            if(!(this.stamina >= this.STAMINA_MAX)){ // if stamina is not full

                if(this.stamina_comparison == -1){ // variable to check if stamina has decreased
                    this.stamina_comparison = this.stamina;
                }

                if(this.stamina < this.stamina_comparison){ // stamina has decreased 
                    this.stamina_increase_init_delay = 60; // resets to start value 
                    this.stamina_increase_delay = 20;
                    this.stamina_comparison = this.stamina;
                } else { // stamina has not lowered                   
                    if(this.stamina_increase_init_delay <= 0){ // past initial delay
                        if(this.stamina_increase_delay <= 0){ // can increase
                            stamina = stamina + this.stamina_increase_amount; // increase stamina
                            this.stamina_increase_amount = this.stamina_increase_amount*this.stamina_increase_amount; // exponential increase
                            this.stamina_increase_delay = 20; // reset
                        } else{ // wait for further increase
                            this.stamina_increase_delay--;
                        }

                        if(this.stamina >= this.STAMINA_MAX){ // stamina full .: reset all values
                            this.stamina_increase_init_delay = 60;
                            this.stamina_increase_delay = 20;
                            this.stamina_increase_amount = 2;
                            this.stamina_comparison = -1;
                        }

                    } else{ // not past initial delay
                        this.stamina_increase_init_delay--;
                    }
                }

            }

            // image changes 
            imgCountdown++; // increment image change cooldown for changing images
            if(imgCountdown == 30){
                changeImage();
                imgCountdown = 0;
            }

            // methods
            movement(SPEED, JUMP, -1); // passes constant parameters to inherited method `movement`
            attacks();
            force_collision(this);
        }
    }

    public void damage(int d){ // public to be called from anywhere with reference (enemy)
        if(this.health - d <= 0){ // if would go below 0, stop at 0
            this.health = 0;
        } else{
            this.health = this.health-d; // decrement health as necessary
        }
    }

    public void collide(){ // encapsulation for movement method inherited from Person
        inhibited_movement = true;
    }

    private void attacks(){
        MouseInfo mouse = Greenfoot.getMouseInfo(); // calls Greenfoot's MouseInfo class for data such as follows 
        if(mouse != null && mouse.getButton() == 1){ // 1 for left mouse button, 2 for middle, 3 for right 
            // if left mouse button clicked:
            imgState = 1; // set punch image
            punch();
        } 
        else if(mouse != null && mouse.getButton() == 3){ // in this and above, != null is used because Greenfoot has that as default value
            imgState = 2; // set kick image
            kick();
        } else{
            imgState = 0; // otherwise default standing image
        }
    }

    private void changeImage(){
        int s = this.imgState; // for easier reference
        switch(s){ // switch case removes need for innefficient if/else
            case 0:
                setImage(this.stand_sprite); 
                break;
            case 1:
                setImage(this.punch_sprite);
                break;
            case 2:
                setImage(this.kick_sprite);
            default:
                setImage(this.stand_sprite);
                break;
        }
        // now instead of changing image in a method (happens ~instantly),
        // changes image in act method via this method.
    }

    private void punch(){
        if(stamina >= STAMINA_DRAIN_PUNCH){ // if has enough stamina
            if(cooldown == 0){ // if not on cooldown
                if(MyWorld.modulus((MyWorld.enemy.getX()-getX())) < RANGE_PUNCH){  // enemy in range
                    MyWorld.enemy.damage(DAMAGE_PUNCH); // damage enemy through public encapsulative method
                    MyWorld.enemy.knockback(KNOCKBACK_PUNCH, this); // knockback enemy 
                }

                setImage(this.punch_sprite); // set relevant image
                stamina = stamina - STAMINA_DRAIN_PUNCH; // decrease stamina by as necessary
                cooldown = cooldown + MyWorld.round(COOLDOWN_PUNCH*60, "###"); // add cooldown; 60*n for seconds (act() called 60 times per second)
            }
        }
        imgState = 0; // back to default image
    }

    private void kick(){
        if(stamina >= STAMINA_DRAIN_KICK){ // enough stamina
            if(cooldown == 0){ // not on cooldown
                if(MyWorld.modulus((MyWorld.enemy.getX()-getX())) < RANGE_KICK){ // enemy in range
                    MyWorld.enemy.damage(DAMAGE_KICK); // apply damage
                    MyWorld.enemy.knockback(KNOCKBACK_KICK, this); // apply knockback
                }

                setImage(this.kick_sprite); // set relevant image
                stamina = stamina - STAMINA_DRAIN_KICK; // decrement stamina
                cooldown = cooldown + MyWorld.round(COOLDOWN_KICK*60, "###"); // add cooldown
            }
        }
        imgState = 0;
    }

    public GreenfootImage sprite_scale(GreenfootImage image){
        // method to return the scaled image from global IMAGE_SCALE
        int w = MyWorld.round(image.getWidth()*this.IMAGE_SCALE, "###");
        int h = MyWorld.round(image.getHeight()*this.IMAGE_SCALE, "###"); // scales by given factor with rounding method preventing fractional values
        image.scale(w, h);
        return image; //return image
    }
}
