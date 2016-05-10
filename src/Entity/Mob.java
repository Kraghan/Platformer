package Entity;

import org.jsfml.system.Vector2i;

/**
 * Created by madjo on 26/04/2016.
 */
public class Mob extends Entity {

    private boolean jump,fly;
    private int vitesse, vitesseMax;
    private long tempsDebutSaut;

    public Mob(Vector2i coord, int health, int vitesseMax) {
        super(coord, true, health);
        tempsDebutSaut = -1;
        this.vitesseMax = vitesseMax;
    }

    public void move(Mouvement move){
        if(move == Mouvement.RIGHT){
            if(vitesse >= 0)
                vitesse += vitesseMax-vitesse/3;
            else
                vitesse += vitesseMax - vitesse/2;
        }
        else if(move == Mouvement.LEFT){
            if(vitesse <= 0)
                vitesse -= vitesseMax-vitesse/3;
            else
                vitesse -= vitesseMax - vitesse/2;
        }
        else{
            vitesse = vitesse - vitesse/2;
        }
        if(vitesse > vitesseMax){
            vitesse = vitesseMax;
        }
        setCoord(new Vector2i(getCoord().x + vitesse, getCoord().y));
    }

    // Temps en ms, vitesse en
    public void jump(int gravite){
        if(tempsDebutSaut == -1){
            tempsDebutSaut = System.currentTimeMillis();
        }
        long temps = tempsDebutSaut - System.currentTimeMillis();
        setCoord(new Vector2i(getCoord().x + vitesse,getCoord().y + (int)(gravite-temps)));
    }


}
