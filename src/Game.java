import Entity.Player;
import Level.Level;

/**
 * Created by madjo on 25/04/2016.
 */
public class Game {
    Level level = null;
    Player player = null;

    public Game(boolean modeAventure){
        level = Level.load(1);
    }

    public void save(){

    }

    public void load(){

    }

    public void render(){
        level.render();
    }
}
