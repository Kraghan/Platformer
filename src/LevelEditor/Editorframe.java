package LevelEditor;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kraghan on 01/05/2016.
 */
public class Editorframe extends JFrame {

    JSplitPane splitPane;
    JScrollPane panelDroit, panelGauche;
    JMenuBar menuBar;
    LevelEditor editor = null;
    DimensionSelector ds;

    public Editorframe(LevelEditor editor) {

        initWidget();
        this.editor = editor;

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

        nouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 ds = new DimensionSelector(editor);
            }
        });

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

    public void initListener(){

    }
}
