import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

class PointOnCircle extends JComponent implements ActionListener {
    private double angle;
    private Timer timer;
    public PointOnCircle() {
        angle = 0;
        timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                angle += 0.1;
                repaint();
            }
        });
        timer.start();
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    @Override
    protected void paintComponent(Graphics g) {
        int width = 750;
        int height = 750;
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Users\\user2\\Documents\\GitHub\\Project554\\src\\Main\\sky3.jpg"));//картинку на фон
        } catch (IOException e) {}
        g.fillRect(0, 0, width, height);
        g.drawImage(im, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
        Расчёты calc = new Расчёты();
        calc.движение(width,height,200, angle, g2d, Color.black);
        calc.движение(width,height,150, angle, g2d, Color.white);
        calc.Sun((int)width, (int)height,g2d);
    }
    public void actionPerformed(ActionEvent e) {}
}