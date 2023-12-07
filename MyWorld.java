import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in.
 * 
 * @author Yuvia
 * @version November 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel = new Label(0, 80);
    int level = 1;
    int hp = 3;
    int appleCounter = 0;
    Label hpLevel = new Label("hp:" + hp , 50);

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        // Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        hpLevel = new Label("hp: " + hp , 50);
        addObject(hpLevel, 170, 50);
        
        createApple();
        
    }
    
    /**
     * bomb have 50% chance to appear around every 5 apple
     */
    
    public void act()
    {
        if (appleCounter >= 5 && Greenfoot.getRandomNumber(100) < 50) 
        {
            createBomb();
            appleCounter = 0;   // reset the number of apples
        }
    }
    
    /**
     * End the game and draw 'Game Over'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Decrease HP if apple hits the ground within 3 times
     */
    public void hpDecrease()
    {
        hp--;
        hpLevel.setValue("hp: " + hp);
        
        if(hp == 0)
        {
            gameOver();
        }
        else
        {
            createApple();
        }
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        appleCounter++;
    }
    
    /**
     *  Create a new apple at random
     */
    public void createBomb()
    {
        Bomb bomb = new Bomb();
        bomb.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bomb, x, y);
        
    }
}
