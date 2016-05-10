package Entity;

import Manager.SpriteManager;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Window;

/**
 * Created by madjo on 25/04/2016.
 */
public class Player extends Mob {

    long time = -1;

    public Player(Vector2i coord) {
        super(coord,3,25);
    }

    public void render(RenderWindow window){
        Sprite s = SpriteManager.getInstance().getSprite_player();
        s.setPosition(getCoord().x,getCoord().y);
        window.draw(s);
    }

}
