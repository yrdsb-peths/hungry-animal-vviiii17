import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Yuvia
 * @version November 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,286,246);
        elephant.setLocation(494,120);
        Label label = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label,220,257);
        label.setLocation(293,243);
        Label label2 = new Label("Press <space> to Start", 40);
        addObject(label2,267,324);
        label2.setLocation(338,314);
        label2.setLocation(290,310);
        titleLabel.setLocation(232, 120);
    }
}
