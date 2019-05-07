/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xochiadventure;

import java.awt.image.BufferedImage;

/**
 *
 * @author
 *      - Alberto García Viegas                 A00822649
 *      - Melba Geraldine Consuelos Fernández   A01410921
 *      - Humberto González Sánchez             A00822594
 *      - Benjamín Váldez Rodríguez             A00822027
 */
public class Assets {
    // Images
    public static BufferedImage background;                 // to store background image
    public static BufferedImage player;                     // to store the player image
    public static BufferedImage shot;                       // to store flask color
    public static BufferedImage heart;                      // to store the taco heart image

    public static BufferedImage titleScreen;                // to store the title screen
    public static BufferedImage menu;                       // to store the menu image
    public static BufferedImage options;                    // to store the options screen image
    public static BufferedImage controls;                   // to store the instructions screen image
    public static BufferedImage select;                     // to store the red rectangle image
    public static BufferedImage recipies;                   // to store the recipies screen image
    public static BufferedImage chile;                      // to store the chile image
    public static BufferedImage platform;                   // to store the platform image
    public static BufferedImage powerup;                    // to store the power
    public static BufferedImage rectangle;
    public static BufferedImage fuente;
    public static BufferedImage xochiIdle;                  // to store the xochi image
    public static BufferedImage xochiAnim[];                // to store the frames for xochi animation
    public static BufferedImage ingredientesEnchiladas[];
    public static BufferedImage ingredientesMole[];
    public static BufferedImage ingredientesQuecas[];

    // Power-Ups
    public static BufferedImage atole;                      // to store the atole image
    public static BufferedImage atoleAnim[];                // to store the frames for atole animation
    public static BufferedImage dulce;                      // to store the dulce image

    // Sounds
    public static SoundClip laser;
    public static SoundClip selectSnd;
    public static SoundClip atoleSnd;
    public static SoundClip dulceSnd;
    public static SoundClip loseSnd;
    public static SoundClip hurtSnd;
    public static SoundClip shootSnd;
    public static SoundClip winSnd;
//
    /**
     * initializing the images of the game
     */
    public static void init() {
        //selectSnd = new SoundClip("/sounds/Retro_8-Bit_Game-Powerup_Achievement_05.wav");

        // Loading of sounds
        selectSnd = new SoundClip("/sounds/selectSound.wav");
        // selectSnd = new SoundClip("/sounds/select.wav"); OTRA OPCION NO SE CUAL ES MEJOR LOS TKM
        atoleSnd = new SoundClip("/sounds/powerUp.wav");
        dulceSnd = new SoundClip("/sounds/powerUp1.wav");
        loseSnd = new SoundClip("/sounds/lose.wav");
        hurtSnd = new SoundClip("/sounds/hurt.wav");
        shootSnd = new SoundClip("/sounds/shoot.wav");
        winSnd = new SoundClip("/sounds/win.wav");

        // Loading of images of menu screens
        titleScreen = ImageLoader.loadImage("/images/pantallas/titlescreen.png");
        menu = ImageLoader.loadImage("/images/pantallas/mainMenu.jpg");
        options = ImageLoader.loadImage("/images/pantallas/MenuOpciones.jpg");
        controls = ImageLoader.loadImage("/images/pantallas/controles.jpg");
        select = ImageLoader.loadImage("/images/select.png");
        recipies = ImageLoader.loadImage("/images/pantallas/Recetario.png");

        // Loading of images of game objects
        chile = ImageLoader.loadImage("/images/chile.png");
        platform = ImageLoader.loadImage("/images/brick_barro.png");
        powerup = ImageLoader.loadImage("/images/flask2.png");
        rectangle = ImageLoader.loadImage("/images/192.png");
        fuente = ImageLoader.loadImage("/images/fountain_beta.png");
        heart = ImageLoader.loadImage("/images/tacoHeart.png");
        shot = ImageLoader.loadImage("/images/bubble.png");

        // Loading of images of ingredients for the enchiladas
        ingredientesEnchiladas = new BufferedImage[7];
        ingredientesEnchiladas[0] = ImageLoader.loadImage("/images/comida/enchiladas/Tortillas.png");
        ingredientesEnchiladas[1] = ImageLoader.loadImage("/images/comida/enchiladas/biggieCheese.png");
        ingredientesEnchiladas[2] = ImageLoader.loadImage("/images/comida/enchiladas/chile_collectable.png");
        ingredientesEnchiladas[3] = ImageLoader.loadImage("/images/comida/enchiladas/tomatoB.png");
        ingredientesEnchiladas[4] = ImageLoader.loadImage("/images/comida/enchiladas/crema.png");
        ingredientesEnchiladas[5] = ImageLoader.loadImage("/images/comida/enchiladas/oil.png");
        ingredientesEnchiladas[6] = ImageLoader.loadImage("/images/comida/enchiladas/CebollaBlack.png");

        // Loading of images of ingredients for the mole
        ingredientesMole = new BufferedImage[0];
        ingredientesMole[0] = ImageLoader.loadImage("/images/comida/mole/poyo.png");

        // Loading of images of ingredients for the quesadillas
        ingredientesQuecas = new BufferedImage[7];
        ingredientesQuecas[0] = ImageLoader.loadImage("/images/comida/quecas/Ajo.png");
        ingredientesQuecas[1] = ImageLoader.loadImage("/images/comida/quecas/CebollaBlack.png");
        ingredientesQuecas[2] = ImageLoader.loadImage("/images/comida/quecas/Champinon.png");
        ingredientesQuecas[3] = ImageLoader.loadImage("/images/comida/quecas/Cilantro.png");
        ingredientesQuecas[4] = ImageLoader.loadImage("/images/comida/quecas/Quesadilla.png");
        ingredientesQuecas[5] = ImageLoader.loadImage("/images/comida/quecas/tomatoB.png");
        ingredientesQuecas[6] = ImageLoader.loadImage("/images/comida/quecas/Tortillasb.png");


        // Loading of animations
        atole = ImageLoader.loadImage("/images/atole.png");
        SpreadSheet atoleSpriteSheet = new SpreadSheet(atole);         // spritesheet of the atole
        atoleAnim = new BufferedImage[3];                              // the sprites of the atole animation

        dulce = ImageLoader.loadImage("/images/dulce.png");

        xochiIdle = ImageLoader.loadImage("/images/Xochi/AxolotlIdle.png");
        xochiAnim = new BufferedImage[4];
        xochiAnim[0] = ImageLoader.loadImage("/images/Xochi/Axolotl1.png");
        xochiAnim[1] = ImageLoader.loadImage("/images/Xochi/Axolotl2.png");
        xochiAnim[2] = ImageLoader.loadImage("/images/Xochi/Axolotl3.png");
        xochiAnim[3] = ImageLoader.loadImage("/images/Xochi/Axolotl4.png");


        // cropping the pictures from the atole sheet into the array
        for (int i = 0; i < 3; i++) {
            atoleAnim[i] = atoleSpriteSheet.crop(i * 200, 0, 200, 200);
        }
    }

}
