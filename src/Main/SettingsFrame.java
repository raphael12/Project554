import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SettingsFrame extends JFrame {

    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    static JCheckBox checkBox1 = new JCheckBox();
    static JCheckBox checkBox2 = new JCheckBox();
    static JCheckBox checkBox3 = new JCheckBox();
    static JCheckBox checkBox4 = new JCheckBox();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static public JFrame settingsFrame = new JFrame("Settings");
    public static Integer i = 0;
    public static void SettingsFrame() {
        panel1.setSize(400,50);
        panel2.setSize(400,50);
        panel2.add(new TextField("Добавить спутник"));
        panel2.add(checkBox1);
//        panel2.add(checkBox2);
//        panel2.add(checkBox3);
//        panel2.add(checkBox4);
        button2.setPreferredSize(new Dimension(80, 20));
        button3.setPreferredSize(new Dimension(80, 20));
        button4.setPreferredSize(new Dimension(80, 20));
        textField1.setPreferredSize(new Dimension(80,20));
        textField2.setPreferredSize(new Dimension(80,20));
        //panel1.add(SettingsFrame.textField1);
        panel1.add(SettingsFrame.textField2);
        panel1.add(SettingsFrame.button3);
        panel1.add(SettingsFrame.button2);
        //panel1.add(SettingsFrame.button4);
        button2.setText("Remove");
        button3.setText("Add");
        button3.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    pulsing = true;
                    i+=1;
                    Adding.RadiusList.add(new Double(textField2.getText()));
                    textField2.setText("");
                } else {}
            }
        });
        button2.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    pulsing = true;
                    Adding.RadiusList.remove(i);
                    i-=1;
                } else {}
            }
        });
        settingsFrame.add(panel1, BorderLayout.NORTH);
        settingsFrame.add(panel2,BorderLayout.CENTER);
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.setSize(400, 100);
        settingsFrame.setVisible(true);
    }}
