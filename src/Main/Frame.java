import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user2 on 26.03.2017.
 */
public class Frame {
    public static void Frame() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Point on circle");
                final PointOnCircle point = new PointOnCircle();
                frame.add(point);
                final JButton button = new JButton("Stop");
                button.setPreferredSize(new Dimension(20, 20));
                button.addActionListener(new ActionListener() {
                    private boolean pulsing = true;

                    public void actionPerformed(ActionEvent e) {
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
                frame.add(button, BorderLayout.NORTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 700);
                frame.setVisible(true);
            }
        });
    }
}
