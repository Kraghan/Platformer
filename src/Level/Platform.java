package Level;

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
}
