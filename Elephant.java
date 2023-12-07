import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Yuvia
 * @version November 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("bombDrop.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    // Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    // Speed the elephant moves at
    int speed = 2;
    
    /**
     * Constructor - The code that gets run on time when object is created
     */
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        
        // Initial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
            facing = "right";
        }
        
        // Remove apple if elephant eats it
        eat();
        
        // Remove bomb and decrease HP leve if elephant catches it
        bombing();
        
        // Animate the elephant
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
            if(world.score % 5 == 0)
            {
                speed++;
            }
        }
    }
    
    /**
     * HP level deacreases 1 if an bomb is catched
     */
    public void bombing()
    {
        if(isTouching(Bomb.class))
        {
            removeTouching(Bomb.class);
            MyWorld world = (MyWorld) getWorld();
            world.act();
            world.hpDecrease();
            bombSound.play();
        }
    }
}
