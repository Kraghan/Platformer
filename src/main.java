import Level.Level;
import Level.Platform;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

/**
 * Created by madjo on 25/04/2016.
 */
public class main {
    public static void main(String[] args){
        /*RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Super platformer !");

        window.setFramerateLimit(60);

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
                game.render();
            }

        }*/

        Level level = new Level(50,50);
        for(int i = 0; i < level.getWidth();i++){
            int j = 24 - i;
            if(i >= 25)
                j = i - 24;
            level.setPlatformsMask(i,j, Platform.platform);
        }
        level.save("test");
    }
}
