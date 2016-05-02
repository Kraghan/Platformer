package LevelEditor;

import java.io.File;
import Level.Level;
/**
 * Created by Kraghan on 30/04/2016.
 */
public class LevelEditor {

    private Level level = null;

    public static void main(String[] args){
        LevelEditor editor = new LevelEditor();
        Editorframe frame = new Editorframe(editor);
    }

    public LevelEditor(){

    }

    public void load(File f){
        level = Level.load(f);
    }

    public void save(String name){
        level.save(name);
    }
}
