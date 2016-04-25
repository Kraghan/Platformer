import Entity.Player;
import Level.Level;

/**
 * Created by madjo on 25/04/2016.
 */
public class Game {
    Level level = null;
    Player player = null;
    boolean modeAventure;

    public Game(boolean modeAventure){
        this.modeAventure = modeAventure;
        if(modeAventure){
            level = Level.load(1);
        }
        else{
            Level.generateLevel();
        }
    }

    public void save(){

    }

    public void load(){

    }

    public void render(){
        level.render();
    }
}
