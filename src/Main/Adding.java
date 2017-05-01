import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class Adding extends JComponent implements ActionListener {
    private Расчёты calc = new Расчёты();
    private Frame frame = new Frame();
    private EarthMoving options = new EarthMoving();
    public static ArrayList<Long> Mass = new ArrayList<Long>();//массив для массы
    public static ArrayList<Double> RadiusList = new ArrayList<Double>();//массив для радиусов
    public static ArrayList<Double> TimerList = new ArrayList<Double>();//массив для коэффициентов
    public static ArrayList<Byte> numberOfMoons = new ArrayList<Byte>();
    public  static ArrayList<Double> coordinataX = new ArrayList<Double>();
    public  static ArrayList<Double> coordinataY = new ArrayList<Double>();
    public  static ArrayList<Double> Vx = new ArrayList<Double>();
    public  static ArrayList<Double> Vy = new ArrayList<Double>();
    public  static ArrayList<Double> Ax = new ArrayList<Double>();
    public  static ArrayList<Double> Ay = new ArrayList<Double>();
    public  static ArrayList<Double> A = new ArrayList<Double>();
    public  static ArrayList<Double> B = new ArrayList<Double>();
    public  static ArrayList<Double> H = new ArrayList<Double>();
    public  static ArrayList<Double> K = new ArrayList<Double>();
    public  static ArrayList<Double> E = new ArrayList<Double>();
     private double k;
    public final static byte maxNumOfMoons = 4;
    public byte numOfMoons;

    public void addingPlanet(Graphics2D g2d, double angle1,double angle2,  Image file) {

        numOfMoons = (byte) (Math.random() * maxNumOfMoons);
        TimerList = new ArrayList<Double>();
        for (k = 0; k < 50; k++) {
            TimerList.remove(k);
            TimerList.add(k / 10 + 0.5);//создаем массив коэффициентов
        }
        for (int a = 0; SettingsFrame.i > a; a++) {//добаляем итое-1 количество планет, здесь i смотриться из SettingsFrame
            if (SettingsFrame.Small.isSelected()) {//смотрит какая RadioButton выбран
                if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2 , g2d, EarthMoving.earthSmall, numberOfMoons.get(a), a);//добавляем планету
                } else if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2 , g2d, EarthMoving.VeneraSmall, numberOfMoons.get(a), a);
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2  , g2d, EarthMoving.PlanetWithAsteroidSmall, numberOfMoons.get(a), a);
                }
            } else if (SettingsFrame.Normal.isSelected()) {
                if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2 , g2d, EarthMoving.earthNormal, numberOfMoons.get(a), a);//добавляем планету
                } else if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, angle1, angle2 , g2d, EarthMoving.VeneraNormal, numberOfMoons.get(a), a);
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height, angle1, angle2  , g2d, EarthMoving.PlanetWithAsteroidNormal, numberOfMoons.get(a), a);
                }
            } else if (SettingsFrame.Big.isSelected()) {
                if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2  , g2d, EarthMoving.earthBig, numberOfMoons.get(a), a);//добавляем планету
                } else if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, angle1, angle2  , g2d, EarthMoving.VeneraBig, numberOfMoons.get(a), a);
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height,  angle1, angle2 , g2d, EarthMoving.PlanetWithAsteroidBig, numberOfMoons.get(a), a);
                }
            }
        }
    }


    public void actionPerformed(ActionEvent e) {

    }
}
