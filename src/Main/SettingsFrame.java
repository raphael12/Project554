import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {
    static public double indicatorSize = 1;
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static JButton button4 = new JButton();
    static JButton button5 = new JButton();
    static JButton button7 = new JButton();
    static JButton button8 = new JButton();
    static JCheckBox checkBox1 = new JCheckBox();
    static JCheckBox checkBox2 = new JCheckBox();
    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();
    static JTextField textField3 = new JTextField();
    static JTextField textField4 = new JTextField();
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();
    static JPanel panel6 = new JPanel();
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
        panel6.add(button7);
        panel6.add(button8);
        button2.setPreferredSize(new Dimension(110, 20));
        button3.setPreferredSize(new Dimension(110, 20));
        button4.setPreferredSize(new Dimension(80, 20));
        button5.setPreferredSize(new Dimension(80, 20));
        button7.setPreferredSize(new Dimension(80, 20));
        button8.setPreferredSize(new Dimension(80, 20));
        textField1.setPreferredSize(new Dimension(80,20));
        textField2.setPreferredSize(new Dimension(80,20));
        textField3.setPreferredSize(new Dimension(80,20));
        textField4.setPreferredSize(new Dimension(80,20));
        panel3.add(textField1);
        panel3.add(button4);
        panel3.add(textField3);
        panel3.add(button5);
        panel1.add(SettingsFrame.textField2);
        panel1.add(SettingsFrame.button3);
        panel1.add(SettingsFrame.textField4);
        panel1.add(SettingsFrame.button2);
        button2.setText("Remove");
        button3.setText("Add M *10^6");
        button4.setText("X");
        button5.setText("Y");
        button7.setText("ZoomIn");
        button8.setText("ZoomOut");
        textField1.setText(String.valueOf(EarthMoving.width/2));
        textField3.setText(String.valueOf(EarthMoving.height/2));
        FinalPanel.setSize(400, 400);
        button3.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            double x,y;
            public void actionPerformed(ActionEvent e) {//добавляем ма
                if (pulsing) {
                    //                        pulsing = true;
//                        i += 1;//на эту i смотрит цикл добавления планет
//                        Adding.RadiusList.add(new Double(textField2.getText()));//при нажатии в массив добавляется радиус который считывается из textField2, также переводим String в Double
//                        Adding.numberOfMoons.add((byte) (Math.random() * Adding.maxNumOfMoons));
//                        //Adding.Mass.add(new Long(textField1.getText())); //массу добаляем
//                        textField2.setText(""); //обнуляем поле textField2


                    x = Math.random()*EarthMoving.width*1000000/2;
                    y = Math.random()*EarthMoving.height*1000000/2;
                    Adding.coordinataX.add(x);
                    Adding.coordinataY.add(y);
                    double r = Math.sqrt((x-EarthMoving.width/2)*(x-EarthMoving.width/2)+(y-EarthMoving.width/2)*(y-EarthMoving.width/2));
                    Adding.Mass.add(new Long(textField2.getText())); //массу добаляем
                    Adding.Ax.add(Расчёты.G * (x - EarthMoving.width / 2) * Adding.Mass.get(i) / (r * r * r));
                    Adding.Ay.add(Расчёты.G *(y - EarthMoving.width / 2) * Adding.Mass.get(i) / (r * r * r));
                    Adding.Vx.add(i, Adding.Ax.get(i) * 0.001 );
                    Adding.Vy.add(i, Adding.Ay.get(i) * 0.001 );
                    Adding.RadiusList.add(r);
                    Adding.numberOfMoons.add((byte) (Math.random() * Adding.maxNumOfMoons));
                    textField2.setText("");
                    pulsing = true;
                    Adding.K.add(MainParametr.getK(Adding.Mass.get(SettingsFrame.i)));
                    Adding.H.add(MainParametr.getH(Math.sqrt(Adding.Vx.get(i)*Adding.Vx.get(i)+Adding.Vy.get(i)*Adding.Vy.get(i)), Adding.K.get(i), Adding.RadiusList.get(i)));
                    Adding.A.add(MainParametr.getA(Adding.K.get(i), Math.sqrt(Adding.Vx.get(i)*Adding.Vx.get(i)+Adding.Vy.get(i)*Adding.Vy.get(i)), Adding.RadiusList.get(i)));
                    Adding.B.add(MainParametr.getB(Math.sqrt(Adding.Vx.get(i)*Adding.Vx.get(i)+Adding.Vy.get(i)*Adding.Vy.get(i)),Adding.RadiusList.get(i), Adding.K.get(i)));
                    Adding.E.add(MainParametr.getExentrisitet(r,Adding.K.get(i), Adding.H.get(i)));
                    System.out.println(" A: " + Adding.A.get(i) +  "  B: " + Adding.B.get(i) + "  H: " + Adding.H.get(i) + "  Ex: " + Adding.E.get(i) + "  K: " + Adding.K.get(i) + "  R: " + Adding.RadiusList.get(i) + "  X: " + Adding.coordinataX.get(i) + "  Y: " + Adding.coordinataY.get(i) + "  Mass: " + Adding.Mass.get(i));
                    i += 1;
                } else {}
            }
        });
        button4.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if(pulsing) {
                    if(new Double(textField1.getText()) != null){
                        EarthMoving.width = 2*(new Integer(textField1.getText()));
                    }
                }
            }
        });
        button5.addActionListener(new ActionListener() {//координаты центра
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if(pulsing) {
                    if(new Double(textField3.getText()) != null){
                        EarthMoving.height = 2*new Integer(textField3.getText());
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
                       // Adding.RadiusList.remove(i - 1);
                        Adding.numberOfMoons.remove(i - 1);
                        i -= 1;
                    }
                } else {}
            }
        });

        button7.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    indicatorSize += 0.2;
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (indicatorSize > 0) {
                        indicatorSize -= 0.2;
                    }
                }
            }
        });
        textField1.setText(new String(String.valueOf(EarthMoving.width/2)));
        textField3.setText(new String(String.valueOf(EarthMoving.height/2)));
        setSize.add(Small);//добавляем в группу
        setSize.add(Normal);
        setSize.add(Big);
        panel2.setLayout(new GridBagLayout());
        panel2.add(Small);
        panel2.add(Normal);
        panel2.add(Big);

        panel3.setLayout(new GridLayout(2, 2, 10,10));
        panel6.setLayout(new GridLayout(1, 2, 10,10));
        FinalPanel.setLayout(new GridLayout(12,1));//разбивает основную панел на 12 стречек и 1 столбец
        FinalPanel.add(panel1);
        FinalPanel.add(panel2);
        FinalPanel.add(panel3);
        FinalPanel.add(panel4);
        FinalPanel.add(panel6);
    }}
