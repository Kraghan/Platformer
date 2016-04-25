package Entity;

import org.jsfml.system.Vector2i;

/**
 * Created by madjo on 25/04/2016.
 */
public abstract class Entity {
    private Vector2i coord = null;
    private boolean mobile;

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
}
