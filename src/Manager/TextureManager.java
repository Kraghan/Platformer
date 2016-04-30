package Manager;

import Level.Theme;
import org.jsfml.graphics.Texture;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Kraghan on 26/04/2016.
 */
public class TextureManager {
    private Texture platformSheet;
    private Texture entitySheet;
    private Texture mobSheet;
    private Texture wallSheet;
    private Texture background;

    private Theme theme;
    private static TextureManager manager = null;

    public static TextureManager getInstance(){
        if(manager == null){
            manager = new TextureManager();
        }
        return manager;
    }

    private TextureManager(){
        platformSheet = new Texture();
        entitySheet = new Texture();
        mobSheet = new Texture();
        wallSheet = new Texture();
        background = new Texture();
    }

    public static void loadTheme(Theme theme){
        getInstance();
        manager.theme = theme;
        String str = manager.theme.name();
        System.out.println("Loading textures...");
        try {
            manager.platformSheet.loadFromFile(Paths.get("res/spritesheet/" + str + "platformsheet.png"));
            //entitySheet.loadFromFile(Paths.get("res/spritesheet/" + str + "entitysheet.png"));
            //mobSheet.loadFromFile(Paths.get("res/spritesheet/" + str + "mobsheet.png"));
            manager.wallSheet.loadFromFile(Paths.get("res/spritesheet/" + str + "wallsheet.png"));
            //manager.background.loadFromFile(Paths.get("res/spritesheet/" + str + "background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Textures loaded");
        SpriteManager.loadSprite();
    }

    public Texture getPlatformSheet() {
        return platformSheet;
    }

    public Texture getEntitySheet() {
        return entitySheet;
    }

    public Texture getMobSheet() {
        return mobSheet;
    }

    public Texture getWallSheet() {
        return wallSheet;
    }

    public Texture getBackground() {
        return background;
    }
}
