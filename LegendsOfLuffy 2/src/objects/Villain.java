/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

//import Object.SuperObject;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Villain object for game
 */
public class Villain extends SuperObject{
    
    public Villain() {
        
        name = "Villain";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectImages/villain.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        collision = true;
    }
}
