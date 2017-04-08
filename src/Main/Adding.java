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
    private double k;
    public final static byte maxNumOfMoons = 4;
    public byte numOfMoons;

    public void addingPlanet(Graphics2D g2d, double angle, File file) {
        numOfMoons = (byte) (Math.random() * maxNumOfMoons);
        for (k = 0; k < 50; k++) {
            TimerList.add(k / 10 + 0.5);//создаем массив коэффициентов
        }
        for (int a = 0; SettingsFrame.i > a; a++) {//добаляем итое-1 количество планет
            if (SettingsFrame.Small.isSelected()) {
                if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.earthSmall, numberOfMoons.get(a));//добавляем планету
                } else if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.VeneraSmall, numberOfMoons.get(a));
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.PlanetWithAsteroidSmall, numberOfMoons.get(a));
                }
            } else if (SettingsFrame.Normal.isSelected()) {
                if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.earthNoraml, numberOfMoons.get(a));//добавляем планету
                } else if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.VeneraNormal, numberOfMoons.get(a));
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.PlanetWithAsteroidNormal, numberOfMoons.get(a));
                }
            } else if (SettingsFrame.Big.isSelected()) {
                if (a % 2 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.earthBig, numberOfMoons.get(a));//добавляем планету
                } else if (a % 3 == 0) {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.VeneraBig, numberOfMoons.get(a));
                } else {
                    calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle * TimerList.get(a), g2d, EarthMoving.PlanetWithAsteroidBig, numberOfMoons.get(a));
                }
            }
        }
    }


    public void actionPerformed(ActionEvent e) {

    }
}
