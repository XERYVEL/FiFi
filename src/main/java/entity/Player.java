package entity;

import main.gamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    gamePanel gp;
    KeyHandler keyH;

    public Player (gamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues() ;
        getPlayersImage();
    }
    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }
    //Metodo para usar las imagenes
    public void getPlayersImage(){
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Arriba_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Arriba_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Abajo_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Abajo_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Izquiera_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha_2.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    //Metodo para mandar los controles del jugador
    public void update() {
        if(keyH.upPressed == true) {
            direction = "Arriba";
            y -= speed;
        }
        else if(keyH.downPressed == true) {
            direction = "Abajo";
            y += speed;
        }
        else if(keyH.leftPressed == true) {
            direction = "Izquierda";
            x -= speed;
        }
        else if(keyH.rightPressed == true) {
            direction = "Derecha";
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        switch(direction) {
            case "Arriba":
                image = up1;
                break;
            case "Abajo":
                image = down1;
                break;
            case "Izquierda":
                image = left1;
                break;
            case "Derecha":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
