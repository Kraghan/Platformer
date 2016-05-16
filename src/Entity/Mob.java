package Entity;

import org.jsfml.system.Vector2i;

/**
 * Created by madjo on 26/04/2016.
 */
public class Mob extends Entity {

    private boolean jump,fly;
    private double vitesse, vitesseMax;
    private long tempsDebutSaut, tempsDebutMouvement;

    public Mob(Vector2i coord, int health, int vitesseMax) {
        super(coord, true, health);
        tempsDebutSaut = tempsDebutMouvement = -1;
        this.vitesseMax = vitesseMax;
    }

    public void calculVitesse(boolean left, boolean right,boolean run){
        if(tempsDebutMouvement == -1)
            tempsDebutMouvement = System.currentTimeMillis()/250;

        if(vitesse >= -1 && vitesse <= 1){
            if(left && right){
                vitesse = 0;
            }
            else if (left){
                tempsDebutMouvement = System.currentTimeMillis()/250;
                int x = (int)(System.currentTimeMillis()/250 - tempsDebutMouvement );
                vitesse = -(x*x)*0.35-4;
            }
            else if (right){
                tempsDebutMouvement = System.currentTimeMillis()/250;
                int x = (int)(System.currentTimeMillis()/250 - tempsDebutMouvement );
                vitesse = (x*x)*0.35+4;
            }

        }
        else if (vitesse > 0){

            if (right){
                int x = (int)(System.currentTimeMillis()/250 - tempsDebutMouvement );
                vitesse = (x*x)*0.35+4;
            }else{
                tempsDebutMouvement = System.currentTimeMillis()/250;
                vitesse = vitesse - vitesse/10;
            }
        }
        else{

            if (left){
                int x = (int)(System.currentTimeMillis()/250 - tempsDebutMouvement );
                vitesse = -(x*x)*0.35-4;
            }
            else{
                tempsDebutMouvement = System.currentTimeMillis()/250;
                vitesse = vitesse - vitesse/10;
            }
        }

        if(run) {
            if (vitesse > vitesseMax) {
                vitesse = vitesseMax;
                tempsDebutMouvement = (long)(System.currentTimeMillis()/250 - vitesseMax);
            } else if (vitesse < -vitesseMax) {
                vitesse = -vitesseMax;
                tempsDebutMouvement = (long)(System.currentTimeMillis()/250 - vitesseMax);
            }
        }
        else{
            if (vitesse > vitesseMax - 10) {
                vitesse = vitesseMax - 10;
                tempsDebutMouvement = (long)(System.currentTimeMillis()/250 - vitesseMax-10);
            } else if (vitesse < -vitesseMax + 10) {
                vitesse = -vitesseMax + 10;
                tempsDebutMouvement = (long)(System.currentTimeMillis()/250 - vitesseMax-10);
            }
        }
        System.out.println(tempsDebutMouvement);
    }

    public void move(boolean onTheGround, int gravity){
        if(onTheGround)
            setCoord(new Vector2i(getCoord().x + (int)vitesse, getCoord().y));
        else
            setCoord(new Vector2i(getCoord().x + (int)vitesse,getCoord().y+gravity));
    }

    // Temps en ms
    public void jump(int gravite){
        if(tempsDebutSaut == -1){
            tempsDebutSaut = System.currentTimeMillis()/50;
        }
        long temps = System.currentTimeMillis()/50 - tempsDebutSaut;
        System.out.println(gravite - temps);
        setCoord(new Vector2i(getCoord().x + (int)vitesse,getCoord().y - (int)(gravite-temps)));
    }

    public long getTempsDebutSaut() {
        return tempsDebutSaut;
    }

    public boolean isJumping(){
        return tempsDebutSaut != -1;
    }

    public void stopJump(){
        tempsDebutSaut = -1;
    }

    public void stopMoving(){
        vitesse = 0;
        tempsDebutMouvement = -1;
    }

    public double getVitesse() {
        return vitesse;
    }
}
