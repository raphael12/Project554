import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Frame {

    private static JButton button = new JButton("Stop");
    static MouseListener mouseAdapter = new MouseAdapter() {
        boolean smth = false;
        @Override
        public void mouseClicked(MouseEvent e) {
            double x = e.getPoint().x;
            double y = e.getPoint().y;
            double Vx = 10 * Math.random();
            double Vy = 10 * Math.random();
            String vvod = JOptionPane.showInputDialog("Введите массу");
            Adding.Mass.add(new Long(vvod));
            Adding.numberOfMoons.add((byte) (Math.random() * Adding.maxNumOfMoons));
            SettingsFrame.textField2.setText("");
            if (Adding.Mass.get(SettingsFrame.i) != 0){
                Adding.coordinataX.add(x);
                Adding.coordinataY.add(y);
                Adding.Ax.add(MainParametr.GetAxVx(SettingsFrame.i));
                Adding.Ay.add(MainParametr.GetAyVy(SettingsFrame.i));
                Adding.Vx.add(Vx);
                Adding.Vy.add(Vy);
                System.out.println("Ax: " + Adding.Ax.get(SettingsFrame.i) + "  Ay: " + Adding.Ay.get(SettingsFrame.i) + " Vx: " + Adding.Vx.get(SettingsFrame.i) + " Vy: " + Adding.Vy.get(SettingsFrame.i) + "  X: " + Adding.coordinataX.get(SettingsFrame.i) + "  Y: " + Adding.coordinataY.get(SettingsFrame.i) + "  Mass: " + Adding.Mass.get(SettingsFrame.i));
                SettingsFrame.i += 1;
            }
        }
    };
    final static EarthMoving point = new EarthMoving();
    static void Frame() {
        JFrame frame = new JFrame("Point on circle");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 5, 0, 0));
        panel.setPreferredSize(new Dimension(200, 400));
        frame.add(point);
        frame.addMouseListener(mouseAdapter);
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
