import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Bomb will come radomly and will cause a decrease of HP level
 * 
 * @author Yuvia 
 * @version December 2023
 */
public class Bomb extends Actor
{
    int speed = 1;
    
    // constructor
    public Bomb()
    {
        // adjust bomb size
        GreenfootImage bomb = new GreenfootImage("bomb.png");
        bomb.scale(100, 100);
        setImage(bomb);
        
    }
    
    /**
     * Act - do whatever the bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // remove the bomb if it hits the ground
        
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
