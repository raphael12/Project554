import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame {
    public static void Frame() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame frame1 = new JFrame();
                JFrame frame = new JFrame("Point on circle");

                JButton button1 = new JButton();
                JButton button2 = new JButton();
                JButton button3 = new JButton();
                button2.setPreferredSize(new Dimension(60,20));
                button1.setPreferredSize(new Dimension(80,20));
                button3.setPreferredSize(new Dimension(60,20));
                button1.setText("Settings");
                button2.setText("Nothing");
                JTextField textField1 = new JTextField();
                JTextField textField2 = new JTextField();
                textField1.setPreferredSize(new Dimension(60,20));
                JPanel panel = new JPanel();
                final JPanel panel1 = new JPanel();
                panel.setLayout(new GridLayout(1,2,0,0));
                panel.setPreferredSize(new Dimension(800, 30));

                panel.add(button1);
                panel1.setLayout(new GridLayout(4,4,0,0));
                panel1.add(button2);
                panel1.add(textField1);
                panel1.add(button3);
                panel1.add(textField2);

                final PointOnCircle point = new PointOnCircle();
                frame.add(point);
                final JButton button = new JButton("Stop");
                button1.setPreferredSize(new Dimension(80,30));
                button.setPreferredSize(new Dimension(80, 30));

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
                button1.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    public void actionPerformed(ActionEvent e) {
                        if(pulsing) {
                            pulsing = false;
                            frame1.add(panel1);
                            frame1.setSize(200, 200);
                            frame1.setVisible(true);
                        } else {
                            pulsing = true;
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
