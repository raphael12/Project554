import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public abstract class Planets extends JComponent implements ActionListener{//это скорее всего не понадобится
    static int width, height;
    Graphics2D g2d;
    private static double angle;
    private Timer timer;
    public static String curDir = new File("").getAbsolutePath();
    public static File venera = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\venera.jpg");
    File earth = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earth.png");
    File BackGround = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\sky.GIF");
    File Moon = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\moon.png");
    File Sun = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun.png");
    private final byte maxNumOfMoons = 4;
    public byte numOfMoons;
    public Planets() {
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                angle += 0.1;
                repaint();
            }
        });
        timer.start();
    }
    public void start() {
        timer.start();
    }//запускает счетсчик
    public void stop() {
        timer.stop();}//останавливает таймер
    static public boolean pulsing1 = true;
    @Override
    protected void paintComponent(Graphics g) {
        Расчёты calc = new Расчёты();//создаем переменную класса Расчёты
        Image im = null;

        try {
            im = ImageIO.read(BackGround);//в im кладем фон
        } catch (IOException e) {}
        g.fillRect(0, 0, width, height); //создает квадрат нужной величины(google в помощь)
        g.drawImage(im, 0, 0, null);//кидаем фон
        if (pulsing1 != false) {
        } else {
            calc.движение(width, height, new Double(SettingsFrame.textField2.getText()), angle / 3, g2d, earth, numOfMoons);//color нужен только для орбиты, нужно от него избатиься
        }
        g2d=(Graphics2D) g;
        calc.Sun(width, height,g2d);//смотреть в расчетах
        g2d.setStroke(new BasicStroke(0.2f));//толщина круга, но как работает хз
    }

}
