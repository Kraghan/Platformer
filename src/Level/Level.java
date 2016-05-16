package Level;

import Entity.Collide;
import Entity.Mob;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2i;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level implements Serializable{
    private int heigth = 0, width = 0, gravity = 10;
    private Platform[][] platformsMask = null;
    private WallBackground[][] wallMask = null;
    private Theme theme;
    ArrayList<Mob> mobs = null;

    public Level(int heigth, int width){
        this.heigth = heigth;
        this.width = width;

        platformsMask = new Platform[width][heigth];
        wallMask = new WallBackground[width][heigth];

        mobs = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Platform getPlatforms(int x, int y) {
        return platformsMask[x][y];
    }

    public void setPlatformsMask(int x, int y, Platform p) {
        this.platformsMask[x][y] = p;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void render(RenderWindow window){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < heigth; y++){
                if(wallMask[x][y] != null) {
                    /*boolean borderLeft = true, borderRight = true;

                    if (isInBound(x - 1, y) && platformsMask[x][y].equals(platformsMask[x - 1][y])) {
                        borderLeft = false;
                    }
                    if (isInBound(x + 1, y) && platformsMask[x][y].equals(platformsMask[x + 1][y])) {
                        borderRight = false;
                    }*/
                    wallMask[x][y].render(window,x,y);
                }
                if(platformsMask[x][y] != null) {
                    boolean borderLeft = true, borderRight = true;

                    if (isInBound(x - 1, y) && platformsMask[x][y].equals(platformsMask[x - 1][y])) {
                        borderLeft = false;
                    }
                    if (isInBound(x + 1, y) && platformsMask[x][y].equals(platformsMask[x + 1][y])) {
                        borderRight = false;
                    }
                    platformsMask[x][y].render(window,x,y,borderLeft,borderRight);
                }
            }
        }
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public static Level load(int numberLevel){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File f = new File("res/levels/level"+numberLevel+".ser");
        Level level = null;
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.err.println("Error : can't create inputstream");
            e.printStackTrace();
        }
        finally {
            if(ois != null){
                try {
                    level = (Level) ois.readObject();
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Error : load fails ");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return level;
    }

    public static Level load(File f){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Level level = null;
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.err.println("Error : can't create inputstream");
            e.printStackTrace();
        }
        finally {
            if(ois != null){
                try {
                    level = (Level) ois.readObject();
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Error : load fails ");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return level;
    }

    public void save(String file){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File f = new File("res/levels/"+file+".ser");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.err.println("Error : can't create "+file+".ser");
            e.printStackTrace();
        }
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        } catch (FileNotFoundException e) {
            System.err.println("Error : can't open " + file + ".ser");
        } catch (IOException e) {
            System.err.println("Error : can't create outputstream");
        }
        finally {
            if(oos != null){
                try {
                    oos.writeObject(this);
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    System.err.println("Error : save fails ");
                }
            }
        }

    }

    public boolean isInBound(int x, int y){
        return x < width && x >= 0 && y < heigth && y >= 0;
    }

    public void setWallMask(int x, int y, WallBackground wall) {
        this.wallMask[x][y] = wall;
    }

    public ArrayList<Collide> collide(Vector2i coord){
        int x = coord.x;
        int y = coord.y;
        int casex = x/64;
        int casey = y/64;
        int posxSurCase = x%64;
        int posySurCase = y%64;
        ArrayList<Collide> res = new ArrayList<>();

        if(x < 0){
            res.add(Collide.LEFT);
        }
        if(y < 0){
            res.add(Collide.UP);
        }
        if(x+64 >= width*64){
            res.add(Collide.RIGHT);
        }
        if(y+64 >= heigth*64){
            res.add(Collide.DOWN);
        }
        if(platformsMask[casex][casey] != null){
            // Tester si case autour non null
            if(posxSurCase-32 > 32 && posySurCase+64 >){
                res.add(Collide.DOWN);
            }
        }
        return res;
    }
}
