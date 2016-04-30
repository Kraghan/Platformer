package Level;

import Manager.SpriteManager;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;

import java.io.Serializable;

/**
 * Created by madjo on 25/04/2016.
 */
public class Platform implements Serializable{
    protected boolean isSolid = false,isBreakable = false,isBouncy = false,isPermanent = true;
    protected int health = 0, timeBeforeFall = 0, bouncyness = 0;
    protected String nom;

    public static Platform platform = new Platform("platform",true,false,false,true,0,0,0);
    public static Platform breakablePlatform = new Platform("breakableplatform",true,true,false,true,10,0,0);
    public static Platform nonPermanentPlatform = new Platform("nonpermanentplatform",true,false,false,false,0,3,0);
    public static Platform bouncyPlatform = new Platform("bouncyplatform",true,false,true,true,0,0,10);
    public static Platform nonSolidPlatform = new Platform("nonsolidplatform",false,false,false,true,0,0,0);

    public Platform(String nom,boolean isSolid, boolean isBreakable, boolean isBouncy, boolean isPermanent,
                    int health, int timeBeforeFall, int bouncyness){
        this.isBouncy = isBouncy;
        this.isSolid = isSolid;
        this.isBreakable = isBreakable;
        this.isPermanent = isPermanent;
        this.nom = nom;

        if(isBouncy){
            this.bouncyness = bouncyness;
        }

        if(isBreakable){
            this.health = health;
        }

        if(!isPermanent){
            this.timeBeforeFall = timeBeforeFall;
        }
    }

    public boolean isSolid() {
        return isSolid;
    }

    public void setSolid() {
        this.isSolid = true;
    }

    public void unsetSolid() {
        this.isSolid = false;
    }

    public boolean isBreakable() {
        return isBreakable;
    }

    public void setBreakable(int health) {
        this.isBreakable = true;
        setHealth(health);
    }

    public void unsetBreakable() {
        this.isBreakable = false;
        setHealth(0);
    }

    public boolean isBouncy() {
        return isBouncy;
    }

    public void setBouncy(int bouncyness) {
        this.isBouncy = true;
        setBouncyness(bouncyness);
    }

    public void unsetBouncy() {
        this.isBouncy = false;
        setBouncyness(0);
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent() {
        this.isPermanent = true;
        setTimeBeforeFall(0);
    }

    public void unsetPermanent(int timeBeforeFall) {
        this.isPermanent = false;
        setTimeBeforeFall(timeBeforeFall);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTimeBeforeFall() {
        return timeBeforeFall;
    }

    public void setTimeBeforeFall(int timeBeforeFall) {
        this.timeBeforeFall = timeBeforeFall;
    }

    public int getBouncyness() {
        return bouncyness;
    }

    public void setBouncyness(int bouncyness) {
        this.bouncyness = bouncyness;
    }

    public String getNom(){
        return nom;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Platform)){
            return false;
        }
        Platform p = (Platform) o;
        return this.nom.equals(p.getNom());
    }

    public void render(RenderWindow window, int x, int y, boolean borderLeft, boolean borderRight){

        Sprite sprite = null;



        if (getNom().equals("platform")) {
            if(borderLeft && borderRight){
                sprite = SpriteManager.getInstance().getSprite_platform();
            }
            else if(borderLeft){
                sprite = SpriteManager.getInstance().getSprite_platform_angle();
            }
            else if(borderRight) {
                sprite = SpriteManager.getInstance().getSprite_platform_angle();
                sprite.setOrigin(64,0);
                sprite.scale(-1.f,1.f);
            }
            else{
                sprite = SpriteManager.getInstance().getSprite_platform_body();
            }
        }
        if (getNom().equals("breakableplatform")) {
            if(borderLeft && borderRight){
                sprite = SpriteManager.getInstance().getSprite_platform_breakable();
            }
            else if(borderLeft){
                sprite = SpriteManager.getInstance().getSprite_platform_breakable_angle();
            }
            else if(borderRight) {
                sprite = SpriteManager.getInstance().getSprite_platform_breakable_angle();
                sprite.setOrigin(64,0);
                sprite.scale(-1.f,1.f);
            }
            else{
                sprite = SpriteManager.getInstance().getSprite_platform_breakable_body();
            }
        }
        if (getNom().equals("nonpermanentplatform")) {
            if(borderLeft && borderRight){
                sprite = SpriteManager.getInstance().getSprite_platform_non_permanent();
            }
            else if(borderLeft){
                sprite = SpriteManager.getInstance().getSprite_platform_non_permanent_angle();
            }
            else if(borderRight) {
                sprite = SpriteManager.getInstance().getSprite_platform_non_permanent_angle();
                sprite.setOrigin(64,0);
                sprite.scale(-1.f,1.f);
            }
            else{
                sprite = SpriteManager.getInstance().getSprite_platform_non_permanent_body();
            }
        }
        if (getNom().equals("bouncyplatform")) {
            if(borderLeft && borderRight){
                sprite = SpriteManager.getInstance().getSprite_platform_bouncy();
            }
            else if(borderLeft){
                sprite = SpriteManager.getInstance().getSprite_platform_bouncy_angle();
            }
            else if(borderRight) {
                sprite = SpriteManager.getInstance().getSprite_platform_bouncy_angle();
                sprite.setOrigin(64,0);
                sprite.scale(-1.f,1.f);
            }
            else{
                sprite = SpriteManager.getInstance().getSprite_platform_bouncy_body();
            }
        }
        if(sprite != null) {
            sprite.setPosition(x*64, y*64);
            window.draw(sprite);
            if(borderRight) {
                sprite.scale(-1.f, 1.f);
                sprite.setOrigin(0,0);
            }
        }
    }
}
