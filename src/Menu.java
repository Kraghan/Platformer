/**
 * Created by madjo on 25/04/2016.
 */
public class Menu {
    private boolean active = false;
    private static Menu menu = null;

    public static Menu getInstance(){
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }

    private Menu(){
        active = true;

    }

    public boolean isActive() {
        return active;
    }

    public void renderMainMenu(){

    }

    public void renderPause(){

    }
}
