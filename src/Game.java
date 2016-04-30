import Entity.Player;
import Level.Level;
import org.jsfml.graphics.RenderWindow;

public class Game {
    Level level = null;
    Player player = null;
    GameState state;

    public Game(){
        state = GameState.RUNNING;
        level = Level.load(0);
    }

    public void save(){

    }

    public void load(){

    }

    public void render(RenderWindow window){
        window.clear();
        level.render(window);
        window.display();
    }

    public GameState getGameState(){
        return state;
    }
}
