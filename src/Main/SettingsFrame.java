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
    static JTextField textField5 = new JTextField();
    static JTextField textField6 = new JTextField();
    static JTextField textField7 = new JTextField();
    static JTextArea textArea = new JTextArea();
    static JTextArea textArea2 = new JTextArea();
    static JTextArea textArea3 = new JTextArea();
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
    static JPanel FinalPanel = new JPanel();
    static JComboBox Size = new JComboBox();
    static ButtonGroup setSize = new ButtonGroup();
    static public JFrame settingsFrame = new JFrame("Settings");
    public static Integer i = 0;
    static JRadioButton Small = new JRadioButton("Small", false);
    static JRadioButton Normal = new JRadioButton("Normal", true);
    static JRadioButton Big = new JRadioButton("Big", false);
    public static void SettingsFrame() {
        panel1.setSize(400,100);
        panel9.setSize(400,20);
        panel10.setSize(400, 20);
        panel11.setSize(400, 20);
        panel12.setSize(400, 20);
        panel13.setSize(400, 20);
        panel2.setSize(400,20);
        panel3.setSize(400,20);

       textArea.setText("Показать/скрыть спутники ");
       textArea2.setText("Показать/скрыть траекторию");
       textArea3.setText("Размер планет");
       panel9.add(textArea);
       panel10.add(textArea2);
       panel12.add(textArea3);
        panel2.add(checkBox1);
        panel11.add(checkBox2);
        panel6.add(button7);
        panel6.add(button8);
        //textArea.setPreferredSize(new Dimension(200, 20));
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
        textField5.setPreferredSize(new Dimension(120,20));
        textField6.setPreferredSize(new Dimension(120,20));
        textField7.setPreferredSize(new Dimension(120,20));
        panel3.add(textField1);
        panel3.add(button4);
        panel3.add(textField3);
        panel3.add(button5);
        panel1.add(SettingsFrame.textField2);
        panel1.add(SettingsFrame.button3);
        panel1.add(SettingsFrame.textField4);
        panel1.add(SettingsFrame.button2);
        panel7.add(textField5);
        panel7.add(textField6);
        panel8.add(textField7);

        button2.setText("Remove");
        button3.setText("Add M ");
        button4.setText("X");
        button5.setText("Y");
        button7.setText("ZoomIn");
        button8.setText("ZoomOut");
        textField1.setText(String.valueOf(EarthMoving.width/2));
        textField3.setText(String.valueOf(EarthMoving.height/2));
        FinalPanel.setSize(new Dimension(200, 400));
        button3.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            double x,y;
            public void actionPerformed(ActionEvent e) {//добавляем ма
                if (pulsing) {
                    x = Math.random()*EarthMoving.width;
                    y = Math.random()*EarthMoving.height;
                    Adding.coordinataX.add(x);
                    Adding.coordinataY.add(y);
                    Adding.Mass.add(new Long(textField2.getText())); //массу добаляем
                    Adding.Ax.add(MainParametr.GetAxVx(i));
                    Adding.Ay.add(MainParametr.GetAyVy(i));
                    double ext =  Math.random();
                    if(ext < 0.5){
                        Adding.E.add( ext + 0.4);
                    } else {
                        Adding.E.add(ext);
                    }
                    Adding.numberOfMoons.add((byte) (Math.random() * Adding.maxNumOfMoons));
                    textField2.setText("");
                    pulsing = true;
//                    Adding.K.add(MainParametr.getK(Adding.Mass.get(SettingsFrame.i)));
//                    Adding.H.add(MainParametr.getH(Math.sqrt(Adding.Vx.get(i)*Adding.Vx.get(i)+Adding.Vy.get(i)*Adding.Vy.get(i)), Adding.K.get(i), Adding.RadiusList.get(i)));
                    Adding.A.add(MainParametr.getA(i) );
                    Adding.B.add(MainParametr.getB(i));
//                 Adding.E.add(MainParametr.getExentrisitet(r,Adding.K.get(i), Adding.H.get(i)));
                    System.out.println(" A: " + Adding.A.get(i) +  "  B: " + Adding.B.get(i) + "  Ex: " + Adding.E.get(i) +  "  X: " + Adding.coordinataX.get(i) + "  Y: " + Adding.coordinataY.get(i) + "  Mass: " + Adding.Mass.get(i) );
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
                    if (indicatorSize < 0.3) {
                        indicatorSize +=0.01;
                    } else {
                        indicatorSize += 0.2;
                    }

                }
            }
        });
        button8.addActionListener(new ActionListener() {
            private boolean pulsing = true;
            public void actionPerformed(ActionEvent e) {
                if (pulsing) {
                    if (indicatorSize > 0) {
                        if (indicatorSize < 0.3) {
                            indicatorSize -=0.01;
                        } else {
                            indicatorSize -= 0.2;
                        }
                    }
                }
            }
        });
        textField1.setText(String.valueOf(EarthMoving.width / 2));
        textField3.setText(String.valueOf(EarthMoving.height / 2));

        setSize.add(Small);//добавляем в группу
        setSize.add(Normal);
        setSize.add(Big);
        panel13.setLayout(new GridBagLayout());
        panel13.add(Small);
        panel13.add(Normal);
        panel13.add(Big);

        panel3.setLayout(new GridLayout(2, 2, 10,10));
        panel6.setLayout(new GridLayout(1, 2, 10,10));
        FinalPanel.setLayout(new GridLayout(13,1));//разбивает основную панел на 13 стречек и 1 столбец
        FinalPanel.add(panel1);
        FinalPanel.add(panel9);
        FinalPanel.add(panel2);
        FinalPanel.add(panel10);
        FinalPanel.add(panel11);
        FinalPanel.add(panel12);
        FinalPanel.add(panel13);
        FinalPanel.add(panel3);
        FinalPanel.add(panel4);
        FinalPanel.add(panel6);
        FinalPanel.add(panel7);
        FinalPanel.add(panel8);
    }}
