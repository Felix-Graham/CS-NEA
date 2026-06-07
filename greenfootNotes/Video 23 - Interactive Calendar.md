## Summary
> Created a world called calendar 
> New  code:
``` java 
public MyWorld(){
	super(700, 600, 1)
	getBackground().setColor(Color.LIGHT_GRAY);
	getBackground().fill();
	drawCalendar();
	
}

public void drawCalendar(){
	// draw rows and columns 
	GreenfootImage column = new GreenfootImage(2, 600);
	GreenfootImage rows = new GreenfootImage(700, 2);
	column.setColor(Color.BLACK);
	rows.setColor(Color.BLACK);
	column.fillRect(0, 0, 1, 599);
	rows.fillRect(0, 0, 699, 1);
	for(int i=0; i<6; i++){
		getBackground().drawImage(column, i*100+100, 100);
	}
	for(int i=0; i<5; i++){
		getBackground().drawImage(rows, 0, i*100+100);
	}
	
	// draw month title
	getBackground().setColor(Color.GREEN);
	getBackground().fillRect(0, 0, 699, 100);
	GreenfootImage title = new GreenfootImage("JUKY", 90, Color.RED, Color.GREEN, Color.BLACK);
	getBackground().drawImage(title, 150, 0);
	
	// loop to draw dates in
	int dayCount=1;
	for(int week=0; week<5; week++){
		for(int days=0; days<7, days++){
			if(dayCount<32){
				showText(""+dayCount, days*100+90, week*100+110);
				dayCount++; 
			}
		}
	}
	
	
}


```
> Added new class button 
``` java 
public Button(Color color){
	this.color = color;
	getImage().setColor(color);
	getImage.scale(20, 50);
	getImage().fillRect(0, 0, 20, 50);
}
```
> In world:
``` java 
public void addButtons(){
	addObject(new Button(Color.RED), 20, 50);
}
```
