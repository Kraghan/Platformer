import Manager.SpriteManager;
import Manager.TextureManager;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.ContextActivationException;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import Level.*;

/**
 * Created by madjo on 25/04/2016.
 */
public class main {
    public static void main(String[] args){
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Super platformer !");

        TextureManager.loadTheme(Theme.TEMPLE);
        window.setFramerateLimit(60);


        Level l = new Level(50,50);
        for(int x = 0; x < 50; x++){
            int y = x/4;
            if(x >= 25)
                y = x/4;
            l.setPlatformsMask(x,y,Platform.platform);
        }
        l.save("level0");


        Game game = new Game();

        while (window.isOpen()){
            for(Event event : window.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    window.close();
                }
                else if(event.type == Event.Type.KEY_PRESSED){

                }
                else if(event.type == Event.Type.JOYSTICK_BUTTON_PRESSED){

                }
            }

            // On est en menu
            if(game.getGameState() == GameState.MAIN_MENU){
                Menu.getInstance().renderMainMenu();
            }
            // On est en pause
            else if(game.getGameState() == GameState.PAUSE){
                Menu.getInstance().renderPause();
            }
            // On est en jeu
            else if(game.getGameState() == GameState.RUNNING){
                System.out.println("Game is running");
                game.render(window);
            }

        }


    }
}
