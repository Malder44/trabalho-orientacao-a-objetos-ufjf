/*
Neste enum contém os conjuntos de constantes que vão representar o que está acontecendo no jogo
 */
package gamestates;

/**
 *
 * @author lucas
 */
public enum Gamestate {
    
    PLAYING, MENU, OPTIONS, QUIT;
    
    public static Gamestate state = MENU;
}
