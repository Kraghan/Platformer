package Entity;

import org.jsfml.system.Vector2i;

/**
 * Created by madjo on 25/04/2016.
 */
public abstract class Entity {
    private Vector2i coord = null;
    private boolean mobile;
    private int health;

    public Entity(Vector2i coord, boolean mobile, int health){
        this.coord = coord;
        this.mobile = mobile;
        this.health = health;
    }

    public Vector2i getCoord() {
        return coord;
    }

    public void setCoord(Vector2i coord) {
        this.coord = coord;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isDestroyed(){
        return health <= 0;
    }

    // Add x to coord.x and y to coord.y
    public void move(int x, int y){
        if(mobile) {
            coord = new Vector2i(coord.x + x, coord.y + y);
        }
    }


}
