package LevelEditor;

import java.io.File;
import Level.Level;
/**
 * Created by Kraghan on 30/04/2016.
 */
public class LevelEditor {

    private Level level = null;
    private boolean enable;
    Editorframe frame;

    public static void main(String[] args){
        LevelEditor editor = new LevelEditor();

    }

    public LevelEditor(){
        frame = new Editorframe(this);
        enable = true;
    }

    public void load(File f){
        level = Level.load(f);
    }

    public void save(String name){
        level.save(name);
    }

    public void createNewLevel(int x, int y){
        level = new Level(x,y);
        System.out.println("New level created");
    }

    public void lock(){
        frame.setEnabled(false);
        System.out.println("Locked");
    }

    public void unlock(){
        frame.setEnabled(true);
        System.out.println("Unlocked");
    }
}
