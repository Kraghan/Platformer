package Level;

import Manager.SpriteManager;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;

import java.io.Serializable;

/**
 * Created by Kraghan on 29/04/2016.
 */
public class WallBackground implements Serializable{
    private String name;
    private boolean luminous = false, animated = false;
    private int radius, nbSprite;

    public static WallBackground wall = new WallBackground("wall",false,0,false,1);
    public static WallBackground window = new WallBackground("window",true,10,false,1);


    public WallBackground(String name, boolean luminous, int radius, boolean animated, int nbSprite){
        this.name = name;
        this.luminous = luminous;
        this.radius = radius;
        this.animated = animated;
        this.nbSprite = nbSprite;
    }

    public void render(RenderWindow window,int x, int y){
        Sprite sprite = null;
        switch (name){
            case "wall":
                sprite = SpriteManager.getInstance().getSprite_wall();
                break;
            case "window":
                sprite = SpriteManager.getInstance().getSprite_wall_window();
                break;

            case "torch":
                //sprite = SpriteManager.getInstance().getSpriteWall();
                break;
        }
        if(sprite != null) {
            sprite.setPosition(x*64,y*64);
            window.draw(sprite);
        }
    }
}
