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

    public void calculVitesse(Mouvement move){
        if(tempsDebutMouvement == -1)
            tempsDebutMouvement = System.currentTimeMillis()/250;

        int x = (int)(System.currentTimeMillis()/250 - tempsDebutMouvement );
        if(move == Mouvement.RIGHT){
            if(vitesse >= 0)
                vitesse = (x*x)*0.3+5;
            else {
                vitesse = vitesse - vitesse/10;
            }
            if(vitesse > vitesseMax){
                vitesse = vitesseMax;
            }
        }
        else if(move == Mouvement.LEFT){
            if(vitesse <= 0)
                vitesse = -(x*x)*0.3-5;
            else {
                vitesse = vitesse - vitesse/10;
            }
            if(vitesse < -vitesseMax){
                vitesse = -vitesseMax;
            }
        }
        else{
            if(vitesse == 0){
                tempsDebutMouvement = -1;
            }
            vitesse = vitesse - vitesse/10;

            if (Math.abs(vitesse) <= 2) {
                vitesse = 0;

            }
        }
    }

    public void move(){
        setCoord(new Vector2i(getCoord().x + (int)vitesse, getCoord().y));
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
}
