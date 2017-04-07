import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Frame {

    static JButton button1 = new JButton();



    static void Frame() {
                JFrame frame = new JFrame("Point on circle");
                button1.setPreferredSize(new Dimension(80,20));
                button1.setText("Settings");
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(1,5,0,0));
                panel.setPreferredSize(new Dimension(800, 30));
                panel.add(button1);
                final EarthMoving point = new EarthMoving();
                frame.add(point);
                final JButton button = new JButton("Stop");
                button1.setPreferredSize(new Dimension(80,30));
                button.setPreferredSize(new Dimension(80, 30));
                button.addActionListener(new ActionListener() {
                    private boolean pulsing = true;
                    public void actionPerformed(ActionEvent e) {//пауза
                        if (pulsing) {
                            pulsing = false;
                            point.stop();
                            button.setText("Start");
                        } else {
                            pulsing = true;
                            point.start();
                            button.setText("Stop");
                        }
                    }
                });
                button1.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    SettingsFrame settingsFrame = new SettingsFrame();
                    public void actionPerformed(ActionEvent e) {
                        if(pulsing) {
                            pulsing = false;
                            SettingsFrame.SettingsFrame();//открываем фрейм c настройками
                        } else {
                            pulsing = true;
                        }
                    }
                });
                panel.add(button, BorderLayout.NORTH);
                frame.add(panel, BorderLayout.NORTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                frame.setSize(1000, 800);
                frame.setVisible(true);


    }
}
