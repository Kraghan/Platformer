import Entity.Player;
import Level.Level;

/**
 * Created by madjo on 25/04/2016.
 */
public class Game {
    Level level = null;
    Player player = null;
    GameState state;

    public Game(){
        state = GameState.MAIN_MENU;
    }

    public void save(){

    }

    public void load(){

    }

    public void render(){
        level.render();
    }

    public GameState getGameState(){
        return state;
    }
}
