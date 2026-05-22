https://www.youtube.com/watch?v=a3PZp66AEmU&list=PLmwzeqwf733_hpzeDcgW6VUSZciqwkh2S

## Methods
Methods are inbuilt in Greenfoot and can be found in the API wiki page shown by double clicking the main classes, eg `World` or `Actor`.
#### World 
The [[Methods#MyWorld|constructor of MyWorld]] can be modified to change the size and look of one's world. 
``` Java
public MyWorld()
{
	// 600x400 cells; cell size of 1px
	super(600, 400, 1);
}
```
##### Graphically Editing World
To set the background image of a world graphically, **right click on the ``MyWorld`` class, select `Set image...` and either choose from a set of built in options or upload one**.

##### Saving The World
By **right clicking the displayed world and selecting `Save the world`** Greenfoot creates a method in [[Methods#MyWorld|MyWorld]] called [[Methods#prepare()|prepare]]. This stores data such as the locations of actors and their states. On calling it, which happens automatically on startup, it loads the world in the saved state.

#### Actor 
Creating a new Actor, such as a player or enemy, involves **right clicking on the graphical option `Actor` and selecting `New subclass`. This opens a menu where one can name the actor and select a sprite for it**. Best practice involves choosing an obvious name with proper capitalisation of classes. This reduces confusion.

##### Instancing a New Actor
This is done in the prepare function created in [[#Saving The World]]. It works as the following:
``` Java 
// Class objectName = new ClassConstructor(arg1...)
Actor actor1 = new Actor();
```

##### Making An Actor Do Things 
This is done in the [[Methods#act()|act]] method. It allows the programmer to control the actions of an actor through various commands like [[Methods#move(int x)|move]]. **By pressing `<ctrl>+space`, a menu is opened displaying possible methods**. Most methods are `void`, meaning that they do not return data, whilst others such as [[Methods#isTouching(Class)|isTouching]] are `boolean` and return `true` or `false`.

## If Statement
``` Java
if (Greenfoot.isKeyDown("right")){
	move(2);
}
```
