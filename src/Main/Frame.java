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

                JButton button1 = new JButton();
                JButton button2 = new JButton();
                JButton button3 = new JButton();
                button2.setPreferredSize(new Dimension(60,20));
                button1.setPreferredSize(new Dimension(60,20));
                button3.setPreferredSize(new Dimension(60,20));
                button1.setText("xZ");
                button2.setText("xz");
                button3.setText("xz");
                JTextField textField = new JTextField();
                textField.setPreferredSize(new Dimension(60,20));
                JPanel panel = new JPanel();
                panel.setSize(800,80);
                panel.add(button1);
                panel.add(button2);
                panel.add(button3);
                panel.add(textField);

                final PointOnCircle point = new PointOnCircle();
                frame.add(point);
                final JButton button = new JButton("Stop");
                button1.setPreferredSize(new Dimension(60,20));
                button.setPreferredSize(new Dimension(60, 20));

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
                panel.add(button, BorderLayout.NORTH);
                frame.add(panel, BorderLayout.NORTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 800);
                frame.setVisible(true);
                panel.setVisible(true);
            }
        });
    }
}
