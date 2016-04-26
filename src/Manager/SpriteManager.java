package Manager;

import Level.Theme;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/**
 * Created by Kraghan on 26/04/2016.
 */
public class SpriteManager {
    private Sprite sprite_platform;
    private Sprite sprite_platform_angle;
    private Sprite sprite_platform_body;
    private Sprite sprite_platform_breakable;
    private Sprite sprite_platform_breakable_angle;
    private Sprite sprite_platform_breakable_body;
    private Sprite sprite_platform_non_permanent;
    private Sprite sprite_platform_non_permanent_angle;
    private Sprite sprite_platform_non_permanent_body;
    private Sprite sprite_platform_bouncy;
    private Sprite sprite_platform_bouncy_angle;
    private Sprite sprite_platform_bouncy_body;
    private Theme theme;
    private static SpriteManager manager = null;

    public static SpriteManager getInstance(){
        if(manager == null){
            manager = new SpriteManager();
        }
        return manager;
    }

    private SpriteManager(){
        TextureManager txManager = TextureManager.getInstance();
        sprite_platform = new Sprite();
        sprite_platform_angle = new Sprite();
        sprite_platform_body = new Sprite();
        sprite_platform_bouncy = new Sprite();
        sprite_platform_bouncy_angle = new Sprite();
        sprite_platform_bouncy_body = new Sprite();
        sprite_platform_breakable = new Sprite();
        sprite_platform_breakable_angle = new Sprite();
        sprite_platform_breakable_body = new Sprite();
        sprite_platform_non_permanent = new Sprite();
        sprite_platform_non_permanent_angle = new Sprite();
        sprite_platform_non_permanent_body = new Sprite();
    }
}
