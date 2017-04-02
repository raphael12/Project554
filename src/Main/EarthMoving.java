import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class EarthMoving extends Planets{
    public double angle = 0;

    private Timer timer;
    public String curDir = new File("").getAbsolutePath();
    static int width = 1000;
    static int height = 700;

    public EarthMoving() { //это основной счетсчик
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
        Graphics2D g2d = (Graphics2D) g;
        Adding adding = new Adding();
        adding.addingPlanet(g2d,angle,earth);
        calc.Sun(width, height,g2d);//смотреть в расчетах
    }
    public void actionPerformed(ActionEvent e) {}//прост
}