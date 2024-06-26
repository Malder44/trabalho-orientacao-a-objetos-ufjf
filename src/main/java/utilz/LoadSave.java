//Leonorico Eduardo de Paula Borges (202135032)
//Lucas Henrique de Araujo Cardoso (202135038)
//Pedro Lucas Botelho Freitas (202135040)

package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadSave {
    
    public static final String PLAYER_ATLAS = "player_sprites.png"; //No lugar do name colocar o arquivo imagem JOGADOR (Ex: player_sprites.png)
    public static final String LEVEL_ATLAS = "outside_sprites.png"; //No lugar do name colocar o arquivo imagem CENARIO(Ex: outside_sprites.png)
    public static final String MENU_BUTTONS = "button_atlas.png";
    public static final String MENU_BACKGROUND = "menu_background.png";
    public static final String PAUSE_BACKGROUND = "pause_menu.png";
    public static final String SOUND_BUTTONS = "sound_button.png";
    public static final String URM_BUTTONS = "urm_buttons.png";
    public static final String PLAYING_BG_IMG = "playing_bg_img.png"; // ADICIONAR ARQUIVO DO BCKGROUND AQUI
    public static final String COMPLETED_IMG = "completed_sprite.png";// ADICIONAR ARQUIVO DE COMPLETED
    public static final String CRABBY_SPRITE = "crabby_sprite.png";
    public static final String STATUS_BAR = "health_power_bar.png";
    
    public static BufferedImage GetSpriteAtlas(String nomeArquivo) {
        
        BufferedImage img = null;
        File file = new File("res/" + nomeArquivo);
        try{
            //importa o arquivo de sprites do personagem
            img = ImageIO.read(file);
        }
        catch(IOException e){
            e.printStackTrace();
        } 
        return img;
    }
    
    public static BufferedImage[] GetAllLevels(){

        //importando o pacote lvls com suas devidas excecoes evitando erro  
        //TOFIX: existe um problema nessa parte, pois as imagens que são importadas tem width maior que o game width, e como o lvldata está com array
        //fixado no game width, que é 26, dá conflito. mudar a dimensao do array lvl data ou mudar a dimensao das imagens das fases.  
        
        File file = new File("res/lvls");
        File[] files = file.listFiles();
        File[] filesSorted = new File[files.length];
       
        //Sorteia qual nivel sera executado no jogo de forma que os niveis ficam ordenados de 1 a n
        for (int i = 0; i < filesSorted.length; i++)
            for(int j=0; j< files.length; j++){
                if(files[j].getName().equals((i +1) + ".png"))
                    filesSorted[i] = files[j];
            }
        
        BufferedImage[] imgs = new BufferedImage[filesSorted.length];

        for(int i = 0; i < imgs.length; i++)
             try {
                 imgs[i] = ImageIO.read(filesSorted[i]);
             } catch (IOException ex) {
                 ex.printStackTrace();
             }

        return imgs;
    }
   
    
}
