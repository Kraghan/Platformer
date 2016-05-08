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
        setTitle("Level editor");
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

        enregistrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editor.getLevel() == null){
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(splitPane, "No level edited","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!editor.save()){
                    FileBrowser fb = new FileBrowser(true,editor);
                }
            }
        });

        enregistrerSous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editor.getLevel() == null){
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(splitPane, "No level edited","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                FileBrowser fb = new FileBrowser(true,editor);
            }
        });

        charger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editor.getLevel() != null){
                    JOptionPane d = new JOptionPane();
                    String[] option = {"Yes","No"};
                    int response = d.showOptionDialog(splitPane, "Are you sure to load a new level ? All unsaved changes will be lost","Warning ! ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
                    if(response == JOptionPane.YES_OPTION){
                        FileBrowser fb = new FileBrowser(false,editor);
                    }
                    return;
                }
                FileBrowser fb = new FileBrowser(false,editor);
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
