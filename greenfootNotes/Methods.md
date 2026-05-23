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

#### getKey()
#string
Returns the most recently pressed key since the last time this method was called. Returns `null` if no key has been pressed. Useful for detecting single key presses rather than held keys.

#### getMouseInfo()
#MouseInfo
Returns a [[#MouseInfo]] object containing information about the current mouse state (position, button, click count). Returns `null` if no mouse event has occurred.

#### mouseClicked(Object obj)
#boolean
True if the mouse has been clicked (pressed and released) on the given object. Pass `null` to check anywhere in the world.

#### mousePressed(Object obj)
#boolean
True if the mouse has been pressed (button down) on the given object. Pass `null` to check anywhere in the world.

#### mouseDragged(Object obj)
#boolean
True if the mouse is currently being dragged over the given object.

#### mouseDragEnded(Object obj)
#boolean
True if a mouse drag has just ended on the given object.

#### mouseMoved(Object obj)
#boolean
True if the mouse has been moved (without being dragged) over the given object.

#### getMicLevel()
#int
Returns the current microphone input level as a value from 0 to 100.

#### getRandomNumber(int limit)
#int
Returns a random integer between 0 (inclusive) and `limit` (exclusive). Useful for randomising spawn positions, events, and behaviour.

### Set Data

#### setSpeed(int speed)
#void
Sets the speed of the simulation execution. `speed` is a value from 1 (slowest) to 100 (fastest).

#### setWorld(World world)
#void
Sets the active world to the one given. Used to switch between scenes (e.g. from a menu world to a game world).

### Do
#### Act 
==[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]]
The basic unit of play. Every time this is called, the [[Methods#act()|act]] method is called.==

#### Run
==[[Video 1 - Adding Objects, If-Statement, Methods#Making An Actor Do Things|Link]]
This is a continuous version of [[Methods#Act|Act]]. This calls it 60 times per second.==

#### playSound(String soundFile)
#void
Plays a sound from a file once. A shorthand alternative to creating a [[#GreenfootSound]] object. The file should be in the project's `sounds` directory.

#### delay(int cycles)
#void
Delays execution by the given number of time steps (acts). Pauses the entire simulation, so use sparingly.

#### stop()
#void
Stops the simulation execution (equivalent to clicking the Stop button).

#### start()
#void
Runs (or resumes) the simulation execution (equivalent to clicking the Run button).



# World 
### Get Data

#### getBackground()
#GreenfootImage 
Returns the world's background image.

#### getColorAt(int x, int y)
#color 
Returns the colour at the centre of the cell at `(x, y)`.

#### getCellSize()
#int
Returns the size of a single cell in pixels.

#### getWidth()
#int
Returns the width of the world in number of cells.

#### getHeight()
#int
Returns the height of the world in number of cells.

#### getObjects(Class cls)
#list
Returns all objects in the world, or all objects of a particular class. Pass `null` to get all objects regardless of class.

#### getObjectsAt(int x, int y, Class cls)
#list
Returns all objects at the given cell coordinates. Pass `null` for `cls` to get all objects at that location.

#### numberOfObjects()
#int
Returns the total number of actors currently in the world.

### Set Data 

#### setBackground(GreenfootImage image)
#void 
Set a background image for the world. **Can also be passed with `String filename`**. If the image is larger than the world it is clipped; if smaller, it is tiled.

#### setActOrder(Class... classes)
#void
Sets the order in which objects act each cycle. Classes listed first act before those listed later. Objects whose class is not listed inherit the act order from their superclass.

#### setPaintOrder(Class... classes)
#void
Sets the order in which objects are painted (drawn) each cycle. Classes listed first are painted on top of those listed later.

#### showText(String text, int x, int y)
#void
Displays a text string centred at the given cell coordinates `(x, y)`. Passing `null` as the text clears any previously shown text at that location.

### Do

#### MyWorld
[[Video 1 - Adding Objects, If-Statement, Methods#World|Link]] #void
Default constructor for World. Controls data such as dimensions and pixel size.

#### World(int worldWidth, int worldHeight, int cellSize, boolean bounded)
#void
Alternate constructor that allows the option of creating an unbounded world. If `bounded` is `false`, actors can move outside the world boundaries without being restricted.

#### addObject(actor, int x, int y)
[[Video 1 - Adding Objects, If-Statement, Methods#Saving The World|Link]] #void
Adds an object with a location onto the world. Similar to [[#setLocation(int x, int y)|setLocation]]. 

#### removeObject(Actor object)
#void
Removes the given object from the world.

#### removeObjects(Collection objects)
#void
Removes a list of objects from the world in one call. More efficient than calling [[#removeObject(Actor object)|removeObject]] in a loop.

#### repaint()
#void
Forces the world to repaint immediately. Normally the world repaints automatically each act cycle.

#### act()
#void
Act method for the world, called once per act round before any actor's `act()`. Override in subclasses to add world-level behaviour each cycle.

#### started()
#void
Called by the Greenfoot system when execution starts (i.e. the Run button is clicked). Override to trigger behaviour at the start of a run.

#### stopped()
#void
Called by the Greenfoot system when execution stops. Override to trigger behaviour when the simulation is paused or stopped.

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
Similar to [[Methods#getObjectsAtOffset(int x, int y, Class class)|getObjectsAtOffset]] with the caveat being that it is all objects in a circle around the actor.

#### getIntersectingObjects(Class class)
#list 
Returns all objects intersecting the actor.

#### getOneIntersectingObject(Class class)
#actor 
The same as [[Methods#getIntersectingObjects(Class class)|getIntersectingObjects]] but only returns one object.

#### isTouching(Class class)
#boolean 
Checks if this actor is touching any of the given class.

#### isAtEdge()
#boolean 
Detects whether or not the actor is at the edge of the world. True if the actor is at or beyond the edge of the world.

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
Returns the world the actor is in cast to the given type. Returns `null` if the actor is not in a world of that type.

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



# GreenfootImage
An image to be shown on screen. Can be loaded from a file or created and drawn on programmatically. Used by both [[#Actor]] and [[#World]].

### Constructors

#### GreenfootImage(String filename)
#GreenfootImage
Creates an image from an image file. Supported formats are JPEG, GIF, and PNG. The filename should typically be a file in the project's `images` directory.

#### GreenfootImage(int width, int height)
#GreenfootImage
Creates an empty (fully transparent) image of the given size in pixels.

#### GreenfootImage(GreenfootImage image)
#GreenfootImage
Creates a copy of an existing GreenfootImage. Changes to the copy do not affect the original.

#### GreenfootImage(String text, int size, Color foreground, Color background)
#GreenfootImage
Creates an image with the given string drawn as text. `size` is the font height in pixels. Pass `null` for `foreground` to use black, or `null` for `background` for a transparent background.

#### GreenfootImage(String text, int size, Color foreground, Color background, Color outline)
#GreenfootImage
Same as above but also draws an outline around the text in the given `outline` colour. Pass `null` to draw no outline.

### Get Data

#### getWidth()
#int
Returns the width of the image in pixels.

#### getHeight()
#int
Returns the height of the image in pixels.

#### getColor()
#Color
Returns the current drawing colour used by draw methods.

#### getColorAt(int x, int y)
#Color
Returns the colour of the pixel at the given coordinates.

#### getFont()
#Font
Returns the current font used by [[#drawString(String string, int x, int y)|drawString]].

#### getTransparency()
#int
Returns the current transparency of the image as a value from 0 (fully transparent) to 255 (fully opaque).

#### getAwtImage()
#BufferedImage
Returns the underlying `java.awt.image.BufferedImage` backing this GreenfootImage. Changes to the returned image are reflected in the GreenfootImage.

### Set Data

#### setColor(Color color)
#void
Sets the current drawing colour used by all draw and fill methods.

#### setColorAt(int x, int y, Color color)
#void
Sets the colour of a single pixel at the given coordinates.

#### setFont(Font f)
#void
Sets the font used by [[#drawString(String string, int x, int y)|drawString]].

#### setTransparency(int t)
#void
Sets the transparency of the entire image. `t` is a value from 0 (fully transparent) to 255 (fully opaque).

### Do

#### clear()
#void
Clears the image, making all pixels fully transparent.

#### fill()
#void
Fills the entire image with the current drawing colour.

#### drawImage(GreenfootImage image, int x, int y)
#void
Draws another GreenfootImage onto this image at the given `(x, y)` offset.

#### drawLine(int x1, int y1, int x2, int y2)
#void
Draws a line between two points using the current drawing colour.

#### drawRect(int x, int y, int width, int height)
#void
Draws the outline of a rectangle using the current drawing colour.

#### fillRect(int x, int y, int width, int height)
#void
Draws a filled rectangle using the current drawing colour.

#### drawOval(int x, int y, int width, int height)
#void
Draws the outline of an oval bounded by the given rectangle.

#### fillOval(int x, int y, int width, int height)
#void
Draws a filled oval bounded by the given rectangle.

#### drawPolygon(int[] xPoints, int[] yPoints, int nPoints)
#void
Draws the outline of a closed polygon defined by arrays of x and y coordinates.

#### fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
#void
Draws a filled polygon defined by arrays of x and y coordinates.

#### drawShape(Shape shape)
#void
Draws any `java.awt.Shape` directly onto the image using the current drawing colour.

#### drawString(String string, int x, int y)
#void
Draws text onto the image at the given position using the current font and colour.

#### rotate(int degrees)
#void
Rotates the image around its centre by the given number of degrees.

#### scale(int width, int height)
#void
Scales the image to the given dimensions in pixels.

#### mirrorHorizontally()
#void
Flips the image horizontally (left becomes right).

#### mirrorVertically()
#void
Flips the image vertically (top becomes bottom).



# GreenfootSound
Represents audio that can be played in Greenfoot. Supports MP3 and WAV formats. Create an instance as a field so the sound is loaded into memory before it is needed.

### Constructors

#### GreenfootSound(String filename)
#GreenfootSound
Creates a new sound from the given file. The file should be in the project's `sounds` directory.

### Get Data

#### isPlaying()
#boolean
Returns `true` if the sound is currently playing.

#### getVolume()
#int
Returns the current volume of the sound as a value from 0 (silent) to 100 (loudest).

### Set Data

#### setVolume(int volume)
#void
Sets the volume of the sound. `volume` is a value from 0 (silent) to 100 (loudest).

### Do

#### play()
#void
Plays the sound once from the beginning. If already playing, restarts from the beginning.

#### playLoop()
#void
Plays the sound on a continuous loop until [[#stop()|stop()]] or [[#pause()|pause()]] is called.

#### pause()
#void
Pauses playback. The sound can be resumed from the same position using [[#play()|play()]].

#### stop()
#void
Stops playback and resets to the beginning of the sound.



# MouseInfo
Contains information about the current state of the mouse. Retrieve an instance via [[#getMouseInfo()|Greenfoot.getMouseInfo()]]. Returns `null` if no mouse event has occurred this act cycle.

### Get Data

#### getX()
#int
Returns the current x-coordinate of the mouse cursor in cell coordinates.

#### getY()
#int
Returns the current y-coordinate of the mouse cursor in cell coordinates.

#### getButton()
#int
Returns the number of the mouse button that was pressed or clicked. `1` = left button, `2` = middle button, `3` = right button.

#### getClickCount()
#int
Returns the number of clicks associated with this mouse event. Useful for detecting double-clicks.

#### getActor()
#Actor
Returns the actor (if any) that the current mouse event is related to. Returns `null` if the event did not occur on an actor.
