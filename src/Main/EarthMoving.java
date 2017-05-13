import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class EarthMoving extends Planets{

    public double angle1 = 0;
    public double angle2 = -0.01;

    private Timer timer;
    static int width = 1100;
    static int height = 700;

    public EarthMoving() { //это основной счетсчик
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                angle1 += 0.1;
                angle2 += 0.1;
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

    @Override
    protected void paintComponent(Graphics g) {
        Расчёты calc = new Расчёты();//создаем переменную класса Расчёты
        Image im = null;
        im = BackGround;
        g.fillRect(0, 0, width, height); //создает квадрат нужной величины(google в помощь)
        g.drawImage(im, 0, 0, null);//кидаем фон
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(0.5f));
        Adding adding = new Adding();
        adding.addingPlanet(g2d,angle1,angle2,earthSmall);
        calc.Sun(width, height,g2d);//смотреть в расчетах
    }
    public void actionPerformed(ActionEvent e) {}//прост
}

