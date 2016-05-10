package Manager;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;

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
    private Sprite sprite_wall;
    private Sprite sprite_wall_floor;
    private Sprite sprite_wall_window;
    private Sprite sprite_player;
    private Sprite sprite_player_walk;
    private Sprite sprite_player_walk2;
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
        System.out.println("Loading sprites...");
        // Sprite platform
        TextureManager txManager = TextureManager.getInstance();
        sprite_platform = new Sprite(txManager.getPlatformSheet());
        sprite_platform.setTextureRect(new IntRect(0,0,64,64));
        sprite_platform_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_angle.setTextureRect(new IntRect(0,64,64,64));
        sprite_platform_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_body.setTextureRect(new IntRect(0,128,64,64));
        sprite_platform_bouncy = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy.setTextureRect(new IntRect(192,0,64,64));
        sprite_platform_bouncy_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy_angle.setTextureRect(new IntRect(192,64,64,64));
        sprite_platform_bouncy_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_bouncy_body.setTextureRect(new IntRect(192,128,64,64));
        sprite_platform_breakable = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable.setTextureRect(new IntRect(128,0,64,64));
        sprite_platform_breakable_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable_angle.setTextureRect(new IntRect(128,64,64,64));
        sprite_platform_breakable_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_breakable_body.setTextureRect(new IntRect(128,128,64,64));
        sprite_platform_non_permanent = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent.setTextureRect(new IntRect(64,0,64,64));
        sprite_platform_non_permanent_angle = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent_angle.setTextureRect(new IntRect(64,64,64,64));
        sprite_platform_non_permanent_body = new Sprite(txManager.getPlatformSheet());
        sprite_platform_non_permanent_body.setTextureRect(new IntRect(64,128,64,64));
        sprite_player = new Sprite(txManager.getPlayerSheet());
        sprite_player.setTextureRect(new IntRect(0,0,64,64));

        // Sprite wall
        sprite_wall = new Sprite(txManager.getWallSheet());
        sprite_wall.setTextureRect(new IntRect(0,0,64,64));
        sprite_wall_floor = new Sprite(txManager.getWallSheet());
        sprite_wall_floor.setTextureRect(new IntRect(64,0,64,64));
        sprite_wall_window = new Sprite(txManager.getWallSheet());
        sprite_wall_window.setTextureRect(new IntRect(128,0,64,64));
        System.out.println("Sprites loaded");
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

    public Sprite getSprite_wall() {
        return sprite_wall;
    }

    public Sprite getSprite_wall_floor() {
        return sprite_wall_floor;
    }

    public Sprite getSprite_wall_window() {
        return sprite_wall_window;
    }

    public Sprite getSprite_player() {
        return sprite_player;
    }

    public Sprite getSprite_player_walk() {
        return sprite_player_walk;
    }

    public Sprite getSprite_player_walk2() {
        return sprite_player_walk2;
    }
}
