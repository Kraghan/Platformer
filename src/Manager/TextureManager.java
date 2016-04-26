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
    }

    public void loadTheme(Theme theme){
        this.theme = theme;
        String str = this.theme.name();

        try {
            platformSheet.loadFromFile(Paths.get("spritesheet/" + str + "platformsheet.png"));
            entitySheet.loadFromFile(Paths.get("spritesheet/" + str + "entitysheet.png"));
            mobSheet.loadFromFile(Paths.get("spritesheet/" + str + "mobsheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
