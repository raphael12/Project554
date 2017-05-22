import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.MouseInfo;
import java.awt.Point;

public class SettingsFrame extends JFrame {
    static int i = 0;
    static public double indicatorSize = 1;
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    static JButton button5 = new JButton();
    static JButton button7 = new JButton();
    static JButton button8 = new JButton();
    static JButton button9 = new JButton();
    static JCheckBox checkBox1 = new JCheckBox();
    static JCheckBox checkBox2 = new JCheckBox();
    static JCheckBox checkBox3 = new JCheckBox();
    static JCheckBox checkBox4 = new JCheckBox();
    static JCheckBox checkBox5 = new JCheckBox();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JTextField textField3 = new JTextField();
    static JTextField textField4 = new JTextField();
    static JTextField textField5 = new JTextField();
    static JTextField textField6 = new JTextField();
    static JTextField textField7 = new JTextField();
    static JTextArea textArea = new JTextArea();
    static JTextArea textArea2 = new JTextArea();
    static JTextArea textArea3 = new JTextArea();
    static JTextArea textArea4 = new JTextArea();
    static JTextArea textArea5 = new JTextArea();
    static JTextArea textArea6 = new JTextArea();
    static JTextArea textArea7 = new JTextArea();
    static JTextArea textArea8 = new JTextArea();
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();
    static JPanel panel6 = new JPanel();
    static JPanel panel7 = new JPanel();
    static JPanel panel8 = new JPanel();
    static JPanel panel9 = new JPanel();
    static JPanel panel10 = new JPanel();
    static JPanel panel11 = new JPanel();
    static JPanel panel12 = new JPanel();
    static JPanel panel13 = new JPanel();
    static JPanel panel14 = new JPanel();
    static JPanel panel15 = new JPanel();
    static JPanel panel16 = new JPanel();
    static JPanel FinalPanel = new JPanel();
    static JComboBox Size = new JComboBox();
    static ButtonGroup setSize = new ButtonGroup();
    static JRadioButton Small = new JRadioButton("Small", false);
    static JRadioButton Normal = new JRadioButton("Normal", true);
    static JRadioButton Big = new JRadioButton("Big", false);


    public static void SettingsFrame() {
        panel1.setSize(400,100);
        panel9.setSize(400,20);
        panel14.setSize(400,20);
        panel15.setSize(400,20);
        panel10.setSize(400, 20);
        panel11.setSize(400, 20);
        panel12.setSize(400, 20);
        panel13.setSize(400, 20);
        panel2.setSize(400,20);
        panel16.setSize(400,20);
        panel3.setSize(400,20);
       
        textArea.setText("Размер планет ");
        textArea2.setText("Координата Солнца");
        textArea3.setText("Увеличить/уменьшить");
        button9.setText("Изменить массу Солнца");
        textArea4.setText("Показать/скрыть спутники");
        textArea5.setText("Линия планет");
        textArea6.setText("Линия Солнца");
        textArea7.setText("Показать данные");
        textArea8.setText("Центр планеты");
        
       panel9.add(textArea);
        panel7.add(textArea6);
        panel10.add(textArea2);
        panel12.add(textArea3);
        panel13.add(textArea4);
        panel15.add(textArea5);
        panel14.add(textArea7);
        panel16.add(textArea8);
        panel7.setSize(400,10);
        panel1.setSize(400, 100);
        panel2.setSize(400, 100);
        panel3.setSize(400, 100);
        panel6.setSize(400,20);
        panel12.add(textArea3);
//        panel2.add(checkBox1);
//        panel2.add(checkBox2);
//        panel2.add(checkBox3);
        panel6.add(button7);
        panel6.add(button8);
        //textArea.setPreferredSize(new Dimension(200, 20));
        button2.setPreferredSize(new Dimension(110, 20));
        button3.setPreferredSize(new Dimension(110, 20));
        button4.setPreferredSize(new Dimension(80, 20));
        button5.setPreferredSize(new Dimension(80, 20));
        button7.setPreferredSize(new Dimension(90, 40));
        button8.setPreferredSize(new Dimension(90, 40));
        button9.setPreferredSize(new Dimension(80, 20));
        textField1.setPreferredSize(new Dimension(80, 20));
        textField2.setPreferredSize(new Dimension(80, 20));
        textField3.setPreferredSize(new Dimension(80, 20));
        textField4.setPreferredSize(new Dimension(80, 20));
        textField5.setPreferredSize(new Dimension(120, 20));
        textField6.setPreferredSize(new Dimension(120, 20));
        textField7.setPreferredSize(new Dimension(120, 20));
        panel3.add(textField1);
        panel3.add(button4);
        panel3.add(textField3);
        panel3.add(button5);
//        panel1.add(SettingsFrame.textField2);
//        panel1.add(SettingsFrame.button3);
//        panel1.add(SettingsFrame.textField4);
        panel1.add(SettingsFrame.button2);
        panel13.add(checkBox1);
        panel15.add(checkBox2);
        panel7.add(checkBox3);
        panel14.add(checkBox4);
        panel16.add(checkBox5);
        panel11.add(textField7);

        panel8.add(button9);
        button2.setText("Remove");
        button3.setText("");
        button4.setText("X");
        button5.setText("Y");
        button7.setText("ZoomIn");
        button8.setText("ZoomOut");
        textField1.setText(String.valueOf(EarthMoving.width / 2));
        textField3.setText(String.valueOf(EarthMoving.height / 2));
        FinalPanel.setSize(new Dimension(200, 400));
        button4.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;

            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (new Double(textField1.getText()) != null) {
                        EarthMoving.width = 2 * (new Integer(textField1.getText()));
                    }
                }
            }
        });
        button5.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;

            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (new Double(textField3.getText()) != null) {
                        EarthMoving.height = 2 * new Integer(textField3.getText());
                    }
                }
            }
        });
        button2.addActionListener(new ActionListener() {//удаляем планету и радиус из массива
            private boolean pulsing = true;

            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (i != 0) {
                        pulsing = true;
                        Adding.numberOfMoons.remove(i - 1);
                        Adding.coordinataX.remove(i - 1);
                        Adding.coordinataY.remove(i - 1);
                        Adding.Ax.remove(i - 1);
                        Adding.Ay.remove(i - 1);
                        Adding.Vx.remove(i - 1);
                        Adding.Vy.remove(i - 1);
                        Adding.Mass.remove(i - 1);
                        i -= 1;
                    }
                } else {
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            private boolean pulsing = true;

            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (indicatorSize <= 0.3) {
                        indicatorSize += 0.02;
                    } else {
                        indicatorSize += 0.2;
                    }
                    button8.setEnabled(true);
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            private boolean pulsing = true;

            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (indicatorSize >= 0.2) {
                        if (indicatorSize <= 0.3) {
                            indicatorSize -= 0.02;
                        } else {
                            indicatorSize -= 0.2;
                        }
                    } else {
                        button8.setEnabled(false);
                    }
                }
            }
        });


        textField7.setText(String.valueOf(Расчёты.MassSun));
        button9.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    Расчёты.MassSun = (new Double(textField7.getText()));
                }
            }
        });
        textField1.setText(String.valueOf(EarthMoving.width / 2));
        textField3.setText(String.valueOf(EarthMoving.height / 2));

        setSize.add(Small);//добавляем в группу
        setSize.add(Normal);
        setSize.add(Big);
        panel2.setLayout(new GridBagLayout());
        panel2.add(Small);
        panel2.add(Normal);
        panel2.add(Big);

        panel3.setLayout(new GridLayout(2, 2, 10, 10));
        panel6.setLayout(new GridLayout(1, 2, 10, 10));
        //FinalPanel.setLayout(new GridLayout(12, 1));//разбивает основную панел на 12 стречек и 1 столбец
        FinalPanel.add(panel4);
        FinalPanel.add(panel1);
        FinalPanel.add(panel9);
        FinalPanel.add(panel2);
        FinalPanel.add(panel10);
        FinalPanel.add(panel3);
        FinalPanel.add(panel12);
        FinalPanel.add(panel6);
        FinalPanel.add(panel13);
        FinalPanel.add(panel15);
        FinalPanel.add(panel7);
        FinalPanel.add(panel14);
        FinalPanel.add(panel16);
        FinalPanel.add(panel8);
        FinalPanel.add(panel11);
    }
}
