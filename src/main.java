import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

/**
 * Created by madjo on 25/04/2016.
 */
public class main {
    public static void main(String[] args){
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Super platformer !");

        window.setFramerateLimit(60);

        Menu menu = new Menu();
        Game game = new Game();

        while (window.isOpen()){
            for(Event event : window.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    window.close();
                }
            }

            // On est en menu
            if(menu.isActive()){
                menu.render();
            }
            // On est en jeu
            else{
                game.render();
            }

        }
    }
}
