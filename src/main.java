import Manager.TextureManager;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import Level.*;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.event.SizeEvent;

/**
 * Created by madjo on 25/04/2016.
 */
public class main {
    public static void main(String[] args){
        Vector2f centreImage = new Vector2f(0,0);
        Vector2f tailleImage = new Vector2f(1360,768);

        RenderWindow window = new RenderWindow();
        window.create(new VideoMode((int)tailleImage.x,(int)tailleImage.y), "Super platformer !");

        TextureManager.loadTheme(Theme.TEMPLE);
        window.setFramerateLimit(60);
        View view = new View(new Vector2f(0,0),new Vector2f(1360, 768));
        window.setView(view);

        Level l = new Level(50,50);
        for(int x = 0; x < 50; x++){
            for(int y = 0; y < 50; y++) {
                l.setPlatformsMask(x, y, Platform.nonPermanentPlatform);
                l.setWallMask(x, y, WallBackground.wall);
            }
        }
        l.save("level0");

        Game game = new Game();

        while (window.isOpen()){
            for(Event event : window.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    window.close();
                }
                else if(event.type == Event.Type.RESIZED){
                    SizeEvent e = event.asSizeEvent();
                    tailleImage = new Vector2f(e.size.x,e.size.y);
                }
                else if(event.type == Event.Type.KEY_PRESSED){
                    KeyEvent e = event.asKeyEvent();
                    if(e.key == Keyboard.Key.UP || e.key == Keyboard.Key.Z) {
                        centreImage = new Vector2f(centreImage.x, centreImage.y - 10);
                    }
                    else if (e.key == Keyboard.Key.DOWN || e.key == Keyboard.Key.S) {
                        centreImage = new Vector2f(centreImage.x, centreImage.y + 10);
                    }
                    else if (e.key == Keyboard.Key.RIGHT || e.key == Keyboard.Key.D) {
                        centreImage = new Vector2f(centreImage.x + 10, centreImage.y);
                    }
                    else if (e.key == Keyboard.Key.LEFT || e.key == Keyboard.Key.Q) {
                        centreImage = new Vector2f(centreImage.x - 10, centreImage.y);
                    }
                    else if (e.key == Keyboard.Key.SPACE){

                    }
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
                game.render(window);
            }
            view.setCenter(centreImage);
            view.setSize(tailleImage);
            window.setView(view);
        }


    }
}
