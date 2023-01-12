/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

//import Object.SuperObject;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Key object for game
 * @author stefanchirica
 */
public class Key extends SuperObject{
    
    public Key() {
        
        name = "Key";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objectImages/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        collision = true;
    }
}
