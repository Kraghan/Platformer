package LevelEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kraghan on 03/05/2016.
 */
public class DimensionSelector extends JFrame {

    JPanel panel;
    JButton confirm, cancel;
    JTextField height, width;
    LevelEditor editor;

    public DimensionSelector(LevelEditor le){
        editor = le;
        editor.lock();

        initWidget();

        setTitle("Select level size");
        setSize(250,180);
        setResizable(false);
        setAlwaysOnTop(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setLocation(gd.getDisplayMode().getWidth()/3,gd.getDisplayMode().getHeight()/4);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(height.getText().matches("^[0-9]+$") && width.getText().matches("^[0-9]+$")){
                    int h = Integer.parseInt(height.getText());
                    int w = Integer.parseInt(width.getText());

                    editor.createNewLevel(w, h);
                    editor.setLevelname(null);
                    dispose();
                }
                else{
                    JOptionPane d = new JOptionPane();
                    d.showMessageDialog(panel, "Width and height must be positive integer","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void initWidget(){
        panel = new JPanel(null);

        JLabel labelWidth = new JLabel("Width : ");
        JLabel labelHeigth = new JLabel("Height : ");

        height = new JTextField();
        width = new JTextField();

        confirm = new JButton("Create");
        cancel = new JButton("Cancel");

        labelWidth.setBounds(20,20,50,20);
        width.setBounds(80,20,130,20);
        labelHeigth.setBounds(20,50,50,20);
        height.setBounds(80,50,130,20);

        confirm.setBounds(20,90,90,30);
        cancel.setBounds(125,90,90,30);

        panel.add(labelWidth);
        panel.add(labelHeigth);
        panel.add(width);
        panel.add(height);
        panel.add(confirm);
        panel.add(cancel);

        setContentPane(panel);

    }

    public void dispose(){
        editor.unlock();
        super.dispose();
    }
}
