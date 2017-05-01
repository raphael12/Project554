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
    static String curDir = new File("").getAbsolutePath();
     static File VeneraSmall = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraSmall.png");
    static File VeneraNormal = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraNormal.png");
    static File VeneraBig = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraBig.png");
    static File PlanetWithAsteroidSmall = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidSmall.png");
    static File PlanetWithAsteroidNormal = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidNormal.png");
    static File PlanetWithAsteroidBig = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidBig.png");
    static File earthSmall = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthsmall.png");
    static File earthNoraml = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthNormal.png");
    static File earthBig = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthBig.png");
    static File BackGround = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\sky.GIF");
    static File Moon = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\moon.png");
    static File RedGiand = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\RedGiand.png");
    static File Sun128 = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun.png");
    static File Sun96 = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun96.png");
    static File Sun64 = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun64.png");
    static File Sun32 = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun32.png");
    static File Sun16 = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun16.png");
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
          //  calc.движение(width, height, new Double(SettingsFrame.textField2.getText()), angle / 3, g2d, earthSmall, numOfMoons);//color нужен только для орбиты, нужно от него избатиься
        }
        g2d=(Graphics2D) g;
        g2d.setStroke(new BasicStroke(0.2f));//толщина круга, но как работает хз
    }

}
