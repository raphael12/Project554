import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

class PointOnCircle extends JComponent {
    private double angle;

    public PointOnCircle() {
        angle = 0;
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                angle += 0.08;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = 750;
        int height = 750;
        g.setColor(Color.lightGray);//цвет фона
        g.fillRect(0, 0, width, height);
        Graphics2D g2d = (Graphics2D) g;
        Расчёты calc = new Расчёты();
        calc.движение(width,height,200, angle + 1, g2d, Color.black);
        calc.движение(width,height,150, angle + 2, g2d, Color.white);
        calc.движение(width,height,100, angle + 3, g2d, Color.blue);
        calc.движение(width,height,250, angle + 1.2, g2d, Color.gray);
        calc.движение(width,height,50, angle + 2.2, g2d , Color.green);


    }
}