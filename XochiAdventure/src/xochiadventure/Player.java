/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xochiadventure;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Set;

/**
 *
 * @author Alberto García Viegas A00822649 | Melba Geraldine Consuelos Fernández A01410921
 */
public class Player extends Item{

    private int lives;
    private int maxLives;
    private int water;
    private boolean inTheAir;

    /**
     * to create direction, width, height, speed in the x axis, and game
     * @param x to set the x of the player
     * @param y to set the y of the player
     * @param width to set the width of the player
     * @param height  to set the height of the player
     * @param speedX to set the speed in the x axis of the player
     * @param game to set the game of the player
     */
    public Player(int x, int y, int width, int height, int speedX, int lives, Game game) {
        super(x, y, width, height, speedX, game);
        this.maxLives = lives;
        this.lives = maxLives;
        this.water = 100;
        this.inTheAir = false;
    }

    // GETS ------------------------------------------------------------------

    /**
     *
     * @return
     */
    public int getLives() {
        return lives;
    }

    public int getMaxLives() {
        return maxLives;
    }

    /**
     *
     * @return
     */
    public boolean isInTheAir() {
        return inTheAir;
    }

    // SETS ------------------------------------------------------------------

    /**
     *
     * @param lives
     */
    public void setLives(int lives){
        this.lives = lives;
    }

    /**
     *
     * @param inTheAir
     */
    public void setInTheAir(boolean inTheAir) {
        this.inTheAir = inTheAir;
    }

    // Carga la información del objeto desde un string ------------------------------------------------------------------
    /**
     * To set the value of the position in the x axis and the width of the player from the file that was loaded
     * @param datos to set all the variables
     */
    @Override
    public void loadFromString(String[] datos) {
        this.x = Integer.parseInt(datos[0]);
        this.width = Integer.parseInt(datos[1]);
    }

    /**
     * To get all the variable that need to be stored in the file as a string
     * @return an <code>String</code> value with all the information of the variables
     */
    @Override
    public String intoString(){
        return (x +" " + width);
    }

    // tick y render ------------------------------------------------------------------

    @Override
    public void tick() {
        // moving player depending on flags
       if (game.getKeyManager().lastLeft || game.getKeyManager().a) {
          setX(getX() - 8);
       }
       if (game.getKeyManager().lastRight || game.getKeyManager().d) {
          setX(getX() + 8);
       }

       if (game.getKeyManager().lastUp) {
          y -= 8;
       }

       if (game.getKeyManager().lastDown) {
          y += 8;
       }

       if (game.getKeyManager().lastSpace && !inTheAir) {
          speedY = 40;
          inTheAir = true;
       }
       if (game.getKeyManager().z || game.getKeyManager().o) {
         //attack
       }

       if (inTheAir) {
         y -= speedY;
         if (speedY > -20) {
           speedY -= 2;
         }
       }

       // hacer que xochi ataque

        // checks that the object does not goes out of the bounds
        // if (getX() + getWidth() >= game.getWidth()) {
        //     setX(game.getWidth() - this.getWidth());
        // }
        // else if (getX() <= 0) {
        //     setX(0);
        // }
    }

    @Override
    public void render(Graphics g) {
      /**
       * Como estamos simulando una camara que siga al jugador, tenemos que dibujar al jugador siempre en medio
       * pero vamos a tener un caso en el que no va a pasar esto: cuando el jugador esté cerca de las orillas del nivel
       * En este caso el jugador se dibujara en su respectiva 'x' y 'y' (dependiendo del caso)
       */
      // aqui hay que agregar una condicional para cuando este mero abajo del nivel, pero tenemos que acabar de diseñar el nivel para sacar bien las alturas
      if (x < game.getPlayerX()) { // aquí también hay que agregar una condicional para cuando esté hasta la mera derecha, pero al igual que la condicional de la "y", tenemos que terminar de diseñar bien los niveles para poder sacar bien las distancias
        g.drawImage(Assets.player, x, game.getPlayerY(), getWidth(), getHeight(), null);
      } else {
        g.drawImage(Assets.player, game.getPlayerX(), game.getPlayerY(), getWidth(), getHeight(), null);
      }

        // g.drawImage(Assets.comida, getX(), getY(), getWidth(), getHeight(), null);
        // g.drawImage(Assets.player, game.getWidth() / 2 - getWidth() / 2, game.getHeight() / 2 - getHeight() / 2, getWidth(), getHeight(), null);
        // g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
}
