package LevelEditor;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Kraghan on 01/05/2016.
 */
public class Editorframe extends JFrame {

    JSplitPane splitPane;
    JScrollPane panelDroit, panelGauche;
    JMenuBar menuBar;

    public Editorframe() {

        initWidget();

        setSize(1360,768);
        setMinimumSize(new Dimension(400,200));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initWidget(){
        // Init barre menu
        menuBar = new JMenuBar();
        JMenu fichier = new JMenu("File");
        JMenuItem nouveau = new JMenuItem("New level");
        JMenuItem enregistrerSous = new JMenuItem("Save as");
        JMenuItem enregistrer = new JMenuItem("Save");
        JMenuItem charger = new JMenuItem("Load");
        fichier.add(nouveau);
        fichier.add(charger);
        fichier.add(enregistrerSous);
        fichier.add(enregistrer);
        menuBar.add(fichier);

        // Init pane
        Dimension minimumSize = new Dimension(200,50);
        panelDroit = new JScrollPane();
        panelGauche = new JScrollPane();
        panelGauche.setMinimumSize(minimumSize);
        panelDroit.setMinimumSize(minimumSize);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelGauche,panelDroit);
        splitPane.setDividerLocation(1160);
        splitPane.setContinuousLayout(true);

        //Add to frame
        setJMenuBar(menuBar);
        setContentPane(splitPane);

    }
}
