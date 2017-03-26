import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.net.*;
import java.io.IOException;
import java.net.URL;
import java.applet.*;

class PointOnCircle extends JComponent implements ActionListener {
    private double angle;
    private Timer timer;
    private Applet applet = new Applet();
    public String curDir = new File("").getAbsolutePath();
    File earth = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earth.png");//сделайте чтоб было без ссылок!!!!!
    File BackGround = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\sky.GIF");
    File Moon = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\moon.png");
    public PointOnCircle() { //это основной счетсчик
        angle = 0;
        timer = new Timer(10, new ActionListener() {
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
        timer.stop();
    }//останавливает таймер
    @Override
    protected void paintComponent(Graphics g) {
        Расчёты calc = new Расчёты();//создаем переменную класса Расчёты
        int width = 1000;
        int height = 700;
        Image im = null;
        try {
            //im = Toolkit.getDefaultToolkit().createImage("sky3.jpg"); это попытки избавиться от ссылки
          //  URL url = new URL(applet.getCodeBase(), "sky3.jpg");
           // im = applet.getImage(applet.getCodeBase(), "sky3.jpg");
            im = ImageIO.read(BackGround);//в im кладем фон
        } catch (IOException e) {}
        g.fillRect(0, 0, width, height); //создает квадрат нужной величины(google в помощь)
        g.drawImage(im, 0, 0, null);//кидаем фон
        Graphics2D g2d = (Graphics2D) g;
        calc.движение(width,height,250, angle/3, g2d, Color.red, earth);//color нужен только для орбиты, нужно от него избатиься
        calc.Sun(width, height,g2d);//смотреть в расчетах
    }
    public void actionPerformed(ActionEvent e) {}//прост
}