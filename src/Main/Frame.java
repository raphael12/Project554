import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Frame {

    private static JButton button = new JButton("Stop");


    static void Frame() {
        JFrame frame = new JFrame("Point on circle");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5, 0, 0));
        panel.setPreferredSize(new Dimension(200, 400));
        final EarthMoving point = new EarthMoving();
        frame.add(point);
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
        SettingsFrame.SettingsFrame();
        SettingsFrame.panel4.add(button);
        panel.add(SettingsFrame.FinalPanel);
        frame.add(panel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(EarthMoving.width + 200, EarthMoving.height));
        frame.setVisible(true);
    }
}
