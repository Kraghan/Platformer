package Manager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;

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
    private static SpriteManager manager = null;

    public static SpriteManager getInstance(){
        if(manager == null){
            manager = new SpriteManager();
        }
        return manager;
    }

    public static void loadSprite(){
        SpriteManager.getInstance().load();
    }

    private void load(){
        System.out.println("Sprites loaded");
        TextureManager txManager = TextureManager.getInstance();
        sprite_platform = new Sprite(txManager.getPlatformSheet());
        sprite_platform.setTextureRect(new IntRect(0,0,64,64));
        sprite_platform.setOrigin(32,32);
        sprite_platform_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent_body = new Sprite(txManager.getPlatformSheet());
    }

    public Sprite getSprite_platform() {
        return sprite_platform;
    }

    public Sprite getSprite_platform_angle() {
        return sprite_platform_angle;
    }

    public Sprite getSprite_platform_body() {
        return sprite_platform_body;
    }

    public Sprite getSprite_platform_breakable() {
        return sprite_platform_breakable;
    }

    public Sprite getSprite_platform_breakable_angle() {
        return sprite_platform_breakable_angle;
    }

    public Sprite getSprite_platform_breakable_body() {
        return sprite_platform_breakable_body;
    }

    public Sprite getSprite_platform_non_permanent() {
        return sprite_platform_non_permanent;
    }

    public Sprite getSprite_platform_non_permanent_angle() {
        return sprite_platform_non_permanent_angle;
    }

    public Sprite getSprite_platform_non_permanent_body() {
        return sprite_platform_non_permanent_body;
    }

    public Sprite getSprite_platform_bouncy() {
        return sprite_platform_bouncy;
    }

    public Sprite getSprite_platform_bouncy_angle() {
        return sprite_platform_bouncy_angle;
    }

    public Sprite getSprite_platform_bouncy_body() {
        return sprite_platform_bouncy_body;
    }
}
