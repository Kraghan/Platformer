package LevelEditor;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Kraghan on 01/05/2016.
 */
public class FileBrowser extends JFrame {

    private JPanel panel;
    private JList<File> jlist;
    private JTextField filename;
    private JButton action, supprimer, annuler;

    public FileBrowser(){
        initWidget();

        setSize(1020,576);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void initWidget(){
        panel = new JPanel(null);

        File dir = new File("res/levels/");
        if(!dir.isDirectory()){
            dir.mkdir();
        }

        File[] files = dir.listFiles();
        jlist = new JList<>(files);

        JLabel label = new JLabel("File : ");
        filename = new JTextField();
        action = new JButton("Load");
        supprimer = new JButton("Delete");
        annuler = new JButton("Cancel");

        jlist.setBounds(20,10,970,450);
        label.setBounds(20,470,50,25);
        filename.setBounds(65,470,930,25);
        panel.add(jlist);
        panel.add(label);
        panel.add(filename);

        action.setBounds(680,506,100,25);
        supprimer.setBounds(790,506,100,25);
        annuler.setBounds(900,506,100,25);

        panel.add(action);
        panel.add(supprimer);
        panel.add(annuler);

        setContentPane(panel);
    }


}
