import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class SettingsFrame extends JFrame {

    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    static JCheckBox checkBox1 = new JCheckBox();
    static JCheckBox checkBox2 = new JCheckBox();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static public JFrame settingsFrame = new JFrame("Settings");
    public static Integer i = 0;
    public static void SettingsFrame() {
        panel1.setSize(400,50);
        panel2.setSize(400,50);
        panel2.add(checkBox1);
        button2.setPreferredSize(new Dimension(80, 20));
        button3.setPreferredSize(new Dimension(80, 20));
        button4.setPreferredSize(new Dimension(80, 20));
        textField1.setPreferredSize(new Dimension(80,20));
        textField2.setPreferredSize(new Dimension(80,20));
        panel3.add(textField1);//для ввода массы
        panel3.add(button4);
        panel1.add(SettingsFrame.textField2);
        panel1.add(SettingsFrame.button3);
        panel1.add(SettingsFrame.button2);
        button2.setText("Remove");
        button3.setText("Add");
        button3.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {//добавляем планету и радиус в массив
                if (pulsing) {
                    pulsing = true;
                    i+=1;
                    Adding.RadiusList.add(new Double(textField2.getText()));
                    Adding.numberOfMoons.add((byte)(Math.random()*Adding.maxNumOfMoons));
                   //Adding.Mass.add(new Long(textField1.getText())); //массу добаляем
                    textField2.setText("");
                } else {}
            }
        });
        button2.addActionListener(new ActionListener() {//удаляем планету и радиус из массива
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    pulsing = true;
                    Adding.RadiusList.remove(i-1);
                    Adding.numberOfMoons.remove(i-1);
                    i-=1;
                } else {}
            }
        });

        settingsFrame.setLayout(new GridLayout(3,1));
        settingsFrame.add(panel1);
        settingsFrame.add(panel2);
        settingsFrame.add(panel3);
        settingsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        settingsFrame.setSize(400, 200);
        settingsFrame.setVisible(true);
    }}
