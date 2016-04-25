package Level;

/**
 * Created by madjo on 25/04/2016.
 */
public class Level {
    private int heigth = 0, width = 0, gravity = 10;
    private Platform[][] platformsMask = null;
    private Theme theme;

    public Level(int heigth, int width){
        this.heigth = heigth;
        this.width = width;

        platformsMask = new Platform[width][heigth];
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

    public void render(){

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

        return null;
    }

    public static Level generateLevel(){

        return null;
    }
}
