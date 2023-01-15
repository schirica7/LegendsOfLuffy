/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import main.GamePanel;
import main.KeyHandler;
import tile.TileManager;

/**
 * Player object for this game; user-controlled
 *
 * @author stefanchirica
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public static int villainCount;
    public TileManager tileM;

    /**
     * Creates new player
     *
     * @param gp = gamePanel to put player on
     * @param keyH = villainCount handler that controls player movement
     */
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 36;
        solidArea.height = 28;

        setDefaultValues();
        getPlayerImage();
    }

    /**
     * Places player in center of screen
     */
    public void setDefaultValues() {

        worldX = gp.worldWidth / 2 - gp.tileSize / 2;
        worldY = gp.worldHeight / 2 - gp.tileSize / 2;
        //speed = 4;
        direction = "right";
    }

    /**
     * Moves the player across the screen
     */
    public void update() {

        if (keyH.upPressed == true) {
            direction = "up";
            move();
            //speed = 4;
            //worldY -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            move();
            //worldY += speed;
        }
        if (keyH.leftPressed == true) {
            direction = "left";
            move();
            //worldX -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            move();
            //worldX += speed;
        }

        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // Check Object Collision
        int objIndex = gp.cChecker.checkObject(this, true);
        villainKill(objIndex);
    }

    /**
     * Player moves across the world if the tiles they are on are not solid
     */
    public void move() {
        if (collisionOn == false) {
            speed = 4;
            if (direction.equals("up")) {
                worldY -= speed;
            }
            if (direction.equals("down")) {
                worldY += speed;
            }
            if (direction.equals("left")) {
                worldX -= speed;
            }
            if (direction.equals("right")) {
                worldX += speed;
            }
        }
    }

    /**
     * Removes object from screen
     *
     * @param i = an integer; 999 if not an object
     */
    public int villainKill(int i) {

        //Just get rid of the object
        if (i != 999) {

            villainCount++;
            gp.playSE(1);
            gp.obj[i] = null;
            gp.ui.showMessage("You slayed a villain!");

            checkLevel();
            //This is where the game levels up

        }

        return villainCount;

    }

    /**
     * Levels up if there are 5 keys

 "Level up" = display new map, reset villainCount counter, and restart time
     */
    public void checkLevel() {
        if (villainCount == 5) {
            //System.out.println("no more fortnite :(\n");

            gp.level++;
            villainCount = 0;
            setDefaultValues();

            if (gp.level == 2) {
                gp.ui.showMessage("Level up!");
                gp.tileM.loadMap("/maps/map02.txt");
                //System.out.println(gp.level);
                gp.keySet();
            }

            if (gp.level == 3) {
                gp.ui.showMessage("Level up!");
                //System.out.println(gp.level);
                gp.tileM.loadMap("/maps/map03.txt");
            }
            if (gp.level == 4) {
                gp.ui.showMessage("Level up!");
                gp.maxWorldCol = 19;
                gp.maxWorldRow = 17;

                gp.tileM.mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
                //System.out.println(gp.level);
                gp.tileM.loadMap("/maps/map04.txt");
            }
            if (gp.level == 5) {
                gp.ui.showMessage("Level up!");
                gp.maxWorldCol = 32;
                gp.maxWorldRow = 23;

                gp.tileM.mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
                //System.out.println(gp.level);
                gp.tileM.loadMap("/maps/worldMap.txt");
            }

            if (gp.level == 6) {

                gp.stopMusic();
                gp.ui.gameFinished = true;

            }

            gp.keySet();

        }
    }

    /**
     * Draws player image depending on which direction it is facing
     *
     * @param g2 = 2D graphics
     */
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        if (direction.equals("up")) {
            image = up;
        }
        if (direction.equals("down")) {
            image = down;
        }
        if (direction.equals("left")) {
            image = left;
        }
        if (direction.equals("right")) {
            image = right;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize * 3 / 2, gp.tileSize * 3 / 2, null);
    }

    /**
     * Changes player image based on the direction of the player
     */
    public void getPlayerImage() {
        try {

            up = ImageIO.read(getClass().getResourceAsStream("/playerImages/dababy up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/playerImages/dababy down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/playerImages/dababy left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/playerImages/dababy right.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
