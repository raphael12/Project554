import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {

    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    static JButton button5 = new JButton();
    static JCheckBox checkBox1 = new JCheckBox();
    static JCheckBox checkBox2 = new JCheckBox();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JTextField textField3 = new JTextField();
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();
    static JPanel FinalPanel = new JPanel();
    static JComboBox Size = new JComboBox();
    static ButtonGroup setSize = new ButtonGroup();
    public static Integer i = 0;
    static JRadioButton Small = new JRadioButton("Small", false);
    static JRadioButton Normal = new JRadioButton("Normal", true);
    static JRadioButton Big = new JRadioButton("Big", false);
    public static void SettingsFrame() {
        panel1.setSize(400,100);
        panel2.setSize(400,100);
        panel3.setSize(400,100);
        panel2.add(checkBox1);
        panel2.add(checkBox2);
        button2.setPreferredSize(new Dimension(80, 20));
        button3.setPreferredSize(new Dimension(80, 20));
        button4.setPreferredSize(new Dimension(80, 20));
        button5.setPreferredSize(new Dimension(80, 20));
        textField1.setPreferredSize(new Dimension(80,20));
        textField2.setPreferredSize(new Dimension(80,20));
        textField3.setPreferredSize(new Dimension(80,20));
        panel3.add(textField1);
        panel3.add(button4);
        panel3.add(textField3);
        panel3.add(button5);
        panel1.add(SettingsFrame.textField2);
        panel1.add(SettingsFrame.button3);
        panel1.add(SettingsFrame.button2);
        button2.setText("Remove");
        button3.setText("Add");
        button4.setText("Width");
        button5.setText("Height");
        FinalPanel.setSize(400, EarthMoving.height);
        button3.addActionListener(new ActionListener() {//на кнопке add весит листенер и ждет пока произойдет действие
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {//добавляем планету и радиус в массив
                if (pulsing) {
                    if(new Double( textField2.getText()) != null) {
                        pulsing = true;
                        i += 1;//на эту i смотрит цикл добавления планет
                        Adding.RadiusList.add(new Double(textField2.getText()));//при нажатии в массив добавляется радиус который считывается из textField2, также переводим String в Double
                        Adding.numberOfMoons.add((byte) (Math.random() * Adding.maxNumOfMoons));
                        //Adding.Mass.add(new Long(textField1.getText())); //массу добаляем
                        textField2.setText(""); //обнуляем поле textField2
                    }
                } else {}
            }
        });
        button4.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if(pulsing) {
                    if(new Double(textField1.getText()) != null){
                        EarthMoving.width = new Integer(textField1.getText());
                    }
                }
            }
        });
        button5.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if(pulsing) {
                    if(new Double(textField3.getText()) != null){
                        EarthMoving.height = new Integer(textField3.getText());
                    }
                }
            }
        });
        button2.addActionListener(new ActionListener() {//удаляем планету и радиус из массива
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if(i!=0) {
                        pulsing = true;
                        Adding.RadiusList.remove(i - 1);
                        Adding.numberOfMoons.remove(i - 1);
                        i -= 1;
                    }
                } else {}
            }
        });

        setSize.add(Small);//добавляем в группу
        setSize.add(Normal);
        setSize.add(Big);
        panel2.setLayout(new GridBagLayout());
        panel2.add(Small);
        panel2.add(Normal);
        panel2.add(Big);

        panel3.setLayout(new GridLayout(2, 2));
        FinalPanel.setLayout(new GridLayout(12,1));//разбивает основную панел на 12 стречек и 1 столбец
        FinalPanel.add(panel1);
        FinalPanel.add(panel2);
        FinalPanel.add(panel3);
        FinalPanel.add(panel4);
    }}
