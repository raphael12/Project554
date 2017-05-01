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
    static File VeneraSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraSmall.png");
    static File VeneraNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraNormal.png");
    static File VeneraBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraBig.png");
    static File PlanetWithAsteroidSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidSmall.png");
    static File PlanetWithAsteroidNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidNormal.png");
    static File PlanetWithAsteroidBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidBig.png");
    static File earthSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthsmall.png");
    static File earthNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthNormal.png");
    static File earthBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthBig.png");
    static File BackGroundUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\sky.GIF");
    static File MoonUrl = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\moon.png");
    static File RedGiandUrl = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\RedGiand.png");
    static File Sun128Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun.png");
    static File Sun96Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun96.png");
    static File Sun64Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun64.png");
    static File Sun32Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun32.png");
    static File Sun16Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun16.png");
    static Image VeneraSmall, VeneraNormal, VeneraBig, PlanetWithAsteroidSmall, PlanetWithAsteroidNormal, PlanetWithAsteroidBig, earthSmall, earthNormal, earthBig, BackGround, Moon, RedGiand, Sun128, Sun96, Sun64, Sun32, Sun16;

    public static void AddingImage(){
        try {
            VeneraSmall = ImageIO.read(VeneraSmallUrl);
            VeneraNormal = ImageIO.read(VeneraNormalUrl);
            VeneraBig = ImageIO.read(VeneraBigUrl);
            PlanetWithAsteroidSmall = ImageIO.read(PlanetWithAsteroidSmallUrl);
            PlanetWithAsteroidNormal = ImageIO.read(PlanetWithAsteroidNormalUrl);
            PlanetWithAsteroidBig = ImageIO.read(PlanetWithAsteroidBigUrl);
            earthSmall = ImageIO.read(earthSmallUrl);
            earthNormal = ImageIO.read(earthNormalUrl);
            earthBig = ImageIO.read(earthBigUrl);
            BackGround = ImageIO.read(BackGroundUrl);
            Moon = ImageIO.read(MoonUrl);
            RedGiand = ImageIO.read(RedGiandUrl);
            Sun128 = ImageIO.read(Sun128Url);
            Sun96 = ImageIO.read(Sun96Url);
            Sun64 = ImageIO.read(Sun64Url);
            Sun32= ImageIO.read(Sun32Url);
            Sun16 = ImageIO.read(Sun16Url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




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
        im = BackGround;
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
