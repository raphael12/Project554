import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Point on circle");
                final PointOnCircle point = new PointOnCircle();
                frame.add(point);
                final JButton button = new JButton("Start");
                button.setPreferredSize(new Dimension(20,20));
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
                frame.add(button,BorderLayout.NORTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(750, 900);
                frame.setVisible(true);
            }
        });
    }
}
