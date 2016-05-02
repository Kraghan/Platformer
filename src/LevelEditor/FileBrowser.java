package LevelEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Kraghan on 01/05/2016.
 */
public class FileBrowser extends JFrame {

    private JPanel panel;
    private JList<File> jlist;
    private JTextField filename;
    private JButton action, supprimer, annuler;
    private boolean save;

    public FileBrowser(boolean save){
        initWidget(save);
        this.save = save;
        setSize(1020, 576);
        setResizable(false);
        setVisible(true);
        setTitle("Load file");
        if(save)
            setTitle("Save file");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void initWidget(boolean save){
        panel = new JPanel(null);

        File dir = new File("res/levels/");
        if(!dir.isDirectory()){
            dir.mkdir();
        }

        File[] files = dir.listFiles();
        jlist = new JList<>(files);

        JLabel label = new JLabel("Level number : ");
        filename = new JTextField();
        action = new JButton("Load");
        if (save)
            action = new JButton("Save");
        supprimer = new JButton("Delete");
        annuler = new JButton("Cancel");

        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jlist.getSelectedValue() != null){
                    jlist.getSelectedValue().delete();
                    jlist.setListData(dir.listFiles());
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(panel, "File deleted", "Success", JOptionPane.OK_OPTION);
                }
                else{
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(panel, "No file selected","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if(save){
                    String file = filename.getText();
                    if(file.matches("^[0-9]+$")) {
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        File f = new File("res/levels/" + file + ".ser");
                        try {
                            f.createNewFile();
                        } catch (IOException e) {
                            System.err.println("Error : can't create " + file + ".ser");
                            e.printStackTrace();
                        }
                        try {
                            fos = new FileOutputStream(f);
                            oos = new ObjectOutputStream(fos);
                        } catch (FileNotFoundException e) {
                            System.err.println("Error : can't open " + file + ".ser");
                        } catch (IOException e) {
                            System.err.println("Error : can't create outputstream");
                        } finally {
                            if (oos != null) {
                                try {
                                    oos.writeObject(this);
                                    oos.flush();
                                    oos.close();
                                } catch (IOException e) {
                                    System.err.println("Error : save fails ");
                                }
                            }
                        }
                    }
                }
                else{
                    jlist.getSelectedValue();
                }
            }
        });

        jlist.setBounds(20,10,970,450);
        label.setBounds(20,470,100,25);
        filename.setBounds(120,470,50,25);
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
