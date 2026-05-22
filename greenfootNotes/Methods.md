# Greenfoot
### Get Data
#### isKeyDown(str key) 
[[Video 1 - Adding Objects, If-Statement, Methods#If Statement|Link]] #boolean
Boolean data checks if a key is down. Helpful for movement controls. 

| Key             | Greenfoot Name |
| --------------- | -------------- |
| left arrow key  | left           |
| right arrow key | right          |
| up arrow key    | up             |
| down arrow key  | down           |
| 'letter' (eg w) | 'letter' (w)   |
| space           | space          |

### Set Data

### Do
#### Act 
==[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]]
The basic unit of play. Every time this is called, the [[Methods#act()|act]] method is called.==

#### Run
==[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]]
This is a continuous version of [[Methods#Act|Act]]. This calls it 60 times per second.== 



# World 
### Get Data

#### getBackground()
#GreenfootImage 
Returns the world's background image.

#### getColorAt(int x, int y)
#color 
Returns
### Set Data 

#### setBackground(GreenfootImage, image)
#void 
Set a background image for the world. **Can also be passed with `String filename`**.

#### 
### Do

#### MyWorld
[[Video 1 - Adding Objects, If-Statement, Methods#World|Link]] #void
Default constructor for World. Controls data such as dimensions and pixel size.

#### addObject(actor, int x, int y)
[[Video 1 - Adding Objects, If-Statement, Methods#Saving The World|Link]] #void
Adds an object with a location onto the world. Similar to [[#setLocation(int x, int y)|setLocation]]. 

#### prepare()
[[Video 1 - Adding Objects, If-Statement, Methods#Saving The World|Link]] #void
Creates the world with saved data. Involves methods such as [[#setLocation(int x, int y)|setLocation]] and [[#addObject(actor, int x, int y)|addObject]]. 

# Actor 
### Get Data

#### addedToWorld(World world)
#void
Called when actor is added to world. Similar to [[Methods#act()|act]].

#### getImage()
#GreenfootImage
Return the image used to represent the actor. Can be modified with [[Methods#setImage(String filename)|setImage]].

#### intersects(Actor other)
#boolean 
Checks if the actor intersects with another.

#### getNeighbours(int distance, boolean diagonal, Class class)
#list
Returns a list of nearby actors in a given distance.

#### getObjectsAtOffset(int x, int y, Class class)
#list 
Returns a list of objects intersecting the point `(x, y)` where `x` and `y` are the given parameters. **`x` and `y` are relative to the object's location**.

#### getOneObjectAtOffset(int x, int y, Class class)
#actor
Similar to [[Methods#getObjectsAtOffset(int x, int y, Class class)|getObjectsAtOffset]] but only returns one object. If two objects are possible candidates, one is chosen and returned.

#### getObjectsInRange(int radius, Class class)
#list 
Similar tp [[Methods#getObjectsAtOffset(int x, int y, Class class)|getObjectsAtOffset]] with the caveat being that it is all objects in a circle around the actor.

#### getIntersectingObjets(Class class)
#list 
Returns all objects intersecting the actor.

#### getOneIntersectingObject(Class class)
#actor 
The same as [[Methods#getIntersectingObjets(Class class)|getIntersectingObjects]] but only returns one object.

#### isTouching(Class class)
#boolean 
Checks if this actor is touching any of the given class.

#### isAtEdge()
#boolean 
Detects whether or not the actor is at the edge of the world. True of the actor is at or beyond the edge of the world.
#### getRotation()
#int
Returns the current rotation of an actor.

#### getX()
#int 
Returns the x-coordinate of the actor.

#### getY()
#int 
Returns the y-coordinate of the actor.

#### getWorld()
#world
Returns the world the actor is in.

#### getWorldOfType(Class worldClass)
#world 
Returns the world the actor is in. If none returns false.

### Set Data

#### setImage(String filename)
#void 
Used to set the image representing an actor. **Can also be passed #GreenfootImage**.  

#### setLocation(int x, int y)
[[Video 1 - Adding Objects, If-Statement, Methods#Saving The World|Link]] #void
Sets the location of an actor. Generally used in the [[Methods#prepare()|prepare()]] method to place an actor. 

#### setRotation(int rotation)
#void 
Set the rotation of the actor. `rotation` is a degree value from 0-359.


### Do
#### act()
[[Video 1 - Adding Objects, If-Statement, Methods|Link]] #void 
Called whenever the `Act` or `Run` button is clicked from the environment. Contains actions for the actor to fulfil such as [[#move(int x)|move]].

#### move(int x)
[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]] #void #movement
Moves the actor `x` pixels forward per [[#act()|act]].

#### turn(int r)
[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]] #void #movement 
Rotates the actor clockwise at `r`° per [[Methods#Run|Act]].

#### turnTowards(int x, int y)
#void 
Turns the actor toward the given coordinates.
#### removeTouching(Class class)
#void 
Similar to [[Methods#isTouching(Class class)|isTouching]] but removes all objects which fit this criteria.

#### sleepFor(int cycles)
#void 
Sets the actor to sleep for a given number of cycles. Potentially useful for [[Further Exploration of BarFight#Stun|stun]]. **A sleeping actor will not have [[Methods#act()|act()]] called for it as usual. The value `cycles` determines the number of acts missed.**  