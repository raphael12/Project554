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
    public static ArrayList<Double> RadiusList = new ArrayList<Double>();
    public  static  ArrayList<Double> TimerList = new ArrayList<Double>();
    double k;

    public void addingPlanet(Graphics2D g2d, double angle, File file){
        for(k = 0; k < 10; k++){
            TimerList.add(k/10+0.5);
        }
        for(int a = 0; SettingsFrame.i > a; a++){
            calc.движение(EarthMoving.width, EarthMoving.height, RadiusList.get(a), angle*TimerList.get(a), g2d, file);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
}
