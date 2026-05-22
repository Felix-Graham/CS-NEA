import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground("maze.png");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        WallHeightSmall wallHeightSmall = new WallHeightSmall();
        addObject(wallHeightSmall,345,124);
        WallHeightSmall wallHeightSmall2 = new WallHeightSmall();
        addObject(wallHeightSmall2,245,134);
        wallHeightSmall2.setLocation(245,128);
        WallHeightSmall wallHeightSmall3 = new WallHeightSmall();
        addObject(wallHeightSmall3,352,226);
        WallHeightSmall wallHeightSmall4 = new WallHeightSmall();
        addObject(wallHeightSmall4,405,270);
        WallHeightSmall wallHeightSmall5 = new WallHeightSmall();
        addObject(wallHeightSmall5,446,327);
        WallHeightSmall wallHeightSmall6 = new WallHeightSmall();
        addObject(wallHeightSmall6,348,380);
        WallHeightSmall wallHeightSmall7 = new WallHeightSmall();
        addObject(wallHeightSmall7,205,320);
        WallHeightSmall wallHeightSmall8 = new WallHeightSmall();
        addObject(wallHeightSmall8,203,466);
        WallHeightSmall wallHeightSmall9 = new WallHeightSmall();
        addObject(wallHeightSmall9,251,524);
        WallHeightSmall wallHeightSmall10 = new WallHeightSmall();
        addObject(wallHeightSmall10,350,530);
        WallHeightSmall wallHeightSmall11 = new WallHeightSmall();
        addObject(wallHeightSmall11,452,184);
        WallHeightBig wallHeightBig = new WallHeightBig();
        addObject(wallHeightBig,651,163);
        WallHeightMedium wallHeightMedium = new WallHeightMedium();
        addObject(wallHeightMedium,554,113);
        wallHeightMedium.setLocation(551,127);
        WallHeightMedium wallHeightMedium2 = new WallHeightMedium();
        addObject(wallHeightMedium2,401,417);
        WallHeightMedium wallHeightMedium3 = new WallHeightMedium();
        addObject(wallHeightMedium3,199,200);
        removeObject(wallHeightMedium3);
        WallHeightBig wallHeightBig2 = new WallHeightBig();
        addObject(wallHeightBig2,648,443);
        WallHeightBig wallHeightBig3 = new WallHeightBig();
        addObject(wallHeightBig3,499,250);
        WallHeightBig wallHeightBig4 = new WallHeightBig();
        addObject(wallHeightBig4,154,128);
        WallHeightBig wallHeightBig5 = new WallHeightBig();
        addObject(wallHeightBig5,150,330);
        wallHeightBig5.setLocation(151,338);
        wallHeightBig5.setLocation(149,369);
        WallHeightBig wallHeightBig6 = new WallHeightBig();
        addObject(wallHeightBig6,149,369);
        wallHeightBig5.setLocation(150,392);
        WallHeightBig wallHeightBig7 = new WallHeightBig();
        addObject(wallHeightBig7,305,121);
        wallHeightBig7.setLocation(305,129);
        removeObject(wallHeightBig7);
        WallHeightMedium wallHeightMedium30 = new WallHeightMedium();
        addObject(wallHeightMedium30,303,141);
        wallHeightMedium30.setLocation(305,128);
        WallHeightBig wallHeightBig70 = new WallHeightBig();
        addObject(wallHeightBig70,601,210);
        wallHeightBig70.setLocation(603,230);
        WallHeightMedium wallHeightMedium4 = new WallHeightMedium();
        addObject(wallHeightMedium4,448,490);
        WallHeightMedium wallHeightMedium5 = new WallHeightMedium();
        addObject(wallHeightMedium5,500,450);
        removeObject(wallHeightMedium5);
        WallHeightSmall wallHeightSmall12 = new WallHeightSmall();
        addObject(wallHeightSmall12,552,388);
        wallHeightSmall12.setLocation(550,417);
        WallHeightSmall wallHeightSmall13 = new WallHeightSmall();
        addObject(wallHeightSmall13,550,417);
        WallHeightSmall wallHeightSmall14 = new WallHeightSmall();
        addObject(wallHeightSmall14,500,418);
        WallHeightSmall wallHeightSmall15 = new WallHeightSmall();
        addObject(wallHeightSmall15,500,482);
        wallHeightSmall15.setLocation(502,467);
        WallHeightSmall wallHeightSmall16 = new WallHeightSmall();
        addObject(wallHeightSmall16,301,278);
        WallHeightSmall wallHeightSmall17 = new WallHeightSmall();
        addObject(wallHeightSmall17,651,282);
        wallHeightSmall17.setLocation(651,268);
        wallHeightMedium2.setLocation(402,473);
        WallHeightSmall wallHeightSmall18 = new WallHeightSmall();
        addObject(wallHeightSmall18,402,473);
        WallHeightSmall wallHeightSmall19 = new WallHeightSmall();
        addObject(wallHeightSmall19,200,180);
        WallHeightSmall wallHeightSmall20 = new WallHeightSmall();
        addObject(wallHeightSmall20,200,220);
        WallWidthLong wallWidthLong = new WallWidthLong();
        addObject(wallWidthLong,302,546);
        wallHeightSmall9.setLocation(252,546);
        WallWidthLong wallWidthLong2 = new WallWidthLong();
        addObject(wallWidthLong2,252,546);
        WallWidthLong wallWidthLong3 = new WallWidthLong();
        addObject(wallWidthLong3,428,551);
        wallWidthLong3.setLocation(526,552);
        WallWidthLong wallWidthLong4 = new WallWidthLong();
        addObject(wallWidthLong4,526,552);
        WallWidthLong wallWidthLong5 = new WallWidthLong();
        addObject(wallWidthLong5,352,49);
        wallWidthLong5.setLocation(255,48);
        WallWidthLong wallWidthLong6 = new WallWidthLong();
        addObject(wallWidthLong6,255,48);
        WallWidthLong wallWidthLong7 = new WallWidthLong();
        addObject(wallWidthLong7,555,50);
        WallWidthLong wallWidthLong8 = new WallWidthLong();
        addObject(wallWidthLong8,283,347);
        wallWidthLong8.setLocation(254,348);
        removeObject(wallWidthLong8);
        WallWidthMedium wallWidthMedium = new WallWidthMedium();
        addObject(wallWidthMedium,575,401);
        removeObject(wallWidthMedium);
        WallWidthMedium wallWidthMedium67 = new WallWidthMedium();
        addObject(wallWidthMedium67,300,448);
        WallWidthMedium wallWidthMedium2 = new WallWidthMedium();
        addObject(wallWidthMedium2,285,352);
        WallWidthMedium wallWidthMedium3 = new WallWidthMedium();
        addObject(wallWidthMedium3,346,301);
        WallWidthMedium wallWidthMedium4 = new WallWidthMedium();
        addObject(wallWidthMedium4,535,304);
        WallWidthMedium wallWidthMedium5 = new WallWidthMedium();
        addObject(wallWidthMedium5,419,152);
        WallWidthMedium wallWidthMedium6 = new WallWidthMedium();
        addObject(wallWidthMedium6,488,101);
        wallWidthMedium6.setLocation(485,103);
        WallWidthMedium wallWidthMedium7 = new WallWidthMedium();
        addObject(wallWidthMedium7,567,508);
        WallWidthMedium wallWidthMedium8 = new WallWidthMedium();
        addObject(wallWidthMedium8,326,202);
        WallWidthSmall wallWidthSmall = new WallWidthSmall();
        addObject(wallWidthSmall,228,96);
        WallWidthSmall wallWidthSmall2 = new WallWidthSmall();
        addObject(wallWidthSmall2,213,401);
        wallWidthSmall2.setLocation(184,402);
        WallWidthSmall wallWidthSmall3 = new WallWidthSmall();
        addObject(wallWidthSmall3,184,402);
        WallWidthSmall wallWidthSmall4 = new WallWidthSmall();
        addObject(wallWidthSmall4,326,403);
        WallWidthSmall wallWidthSmall5 = new WallWidthSmall();
        addObject(wallWidthSmall5,570,450);
        WallWidthSmall wallWidthSmall6 = new WallWidthSmall();
        addObject(wallWidthSmall6,599,397);
        WallWidthSmall wallWidthSmall7 = new WallWidthSmall();
        addObject(wallWidthSmall7,476,399);
        WallWidthSmall wallWidthSmall8 = new WallWidthSmall();
        addObject(wallWidthSmall8,287,503);
        WallWidthSmall wallWidthSmall9 = new WallWidthSmall();
        addObject(wallWidthSmall9,175,497);
        WallWidthSmall wallWidthSmall10 = new WallWidthSmall();
        addObject(wallWidthSmall10,184,300);
        WallWidthSmall wallWidthSmall11 = new WallWidthSmall();
        addObject(wallWidthSmall11,228,247);
        wallHeightSmall16.setLocation(286,247);
        WallWidthSmall wallWidthSmall12 = new WallWidthSmall();
        addObject(wallWidthSmall12,286,247);
        WallWidthSmall wallWidthSmall13 = new WallWidthSmall();
        addObject(wallWidthSmall13,424,247);
        WallWidthSmall wallWidthSmall14 = new WallWidthSmall();
        addObject(wallWidthSmall14,574,248);
        wallWidthMedium3.setLocation(275,296);
        WallWidthSmall wallWidthSmall15 = new WallWidthSmall();
        addObject(wallWidthSmall15,275,296);
        WallWidthSmall wallWidthSmall16 = new WallWidthSmall();
        addObject(wallWidthSmall16,210,146);
        wallHeightSmall19.setLocation(190,153);
        WallWidthSmall wallWidthSmall17 = new WallWidthSmall();
        addObject(wallWidthSmall17,190,153);
        WallWidthMedium wallWidthMedium10 = new WallWidthMedium();
        addObject(wallWidthMedium10,405,54);
        wallWidthMedium4.setLocation(335,296);
        WallWidthMedium wallWidthMedium11 = new WallWidthMedium();
        addObject(wallWidthMedium11,335,296);
        WallHeightSmall wallHeightSmall21 = new WallHeightSmall();
        addObject(wallHeightSmall21,399,383);
        WallHeightSmall wallHeightSmall22 = new WallHeightSmall();
        addObject(wallHeightSmall22,554,381);
        WallWidthSmall wallWidthSmall18 = new WallWidthSmall();
        addObject(wallWidthSmall18,217,400);
        wallHeightBig3.setLocation(509,303);
        WallWidthMedium wallWidthMedium12 = new WallWidthMedium();
        addObject(wallWidthMedium12,509,303);
    }
}
