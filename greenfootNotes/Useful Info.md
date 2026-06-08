### Creating and Removing Objects
``` java 
// to add object of class [[Player]]
getWorld().addObject(new Player, x, y);
// remove current object 
getWorld().removeObject(this);
```

### General Information & Data 
- Act() calls per second = 60

### Referencing an Object Externally
``` java 
Class World{
	private Object2 object2; // instance variable; held as long as World exists
	World(){
		super(600, 400, 1);
		addObject(Object1, x, y); // add object 1 to interface with object 2
		object2 = new Object2();
		addObject(Object2, x, y); // and vice versa
	}
}
```
``` java 
Class Object2{
	public Object2 getThis(){
		return data;
	}
	public int method(){
		return 0;
	}
}
```
``` java 
Class Object1{
	void method(){
		World world = (World) getWorld();
		Object2 object2 = world.getThis();
		data = object2.method();
	}
}
```
https://www.greenfoot.org/doc/howto-1