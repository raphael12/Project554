import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

public class Расчёты {

    public void движение(double width, double height, double r, double angle, Graphics2D g2d, Color color) {
        double x = 0.5 * width;//координаты центра
        double y = 0.5 * height;
        g2d.setColor(color); //цвет орбиты и круга
        g2d.draw(circle(x, y, r, r));//рисует орбиту
        y += r * Math.sin(angle);
        x += r * Math.cos(angle);
        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setStroke(new BasicStroke(1f));//толщина круга вроде но хз
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.fill(circle(x, y, r, r));//добавляем планету
        ДвижениеСпутника(x, y, r, g2d, angle);
    }

    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle) {
        r = r * 3;
        g2d.setColor(Color.RED);
        g2d.draw(circle(x, y, r, r));
        y += r * Math.sin(angle*3);
        x += r * Math.cos(angle*3);
        r = Math.max(0.1 * r, 5);
        g2d.fill(circle(x, y, r, r));//добавляем круг
    }
    public  void Sun(int width, int height /*long M масса*/ , Graphics2D g2d){
        int x = (int) (0.5 * width);//координаты центра
        int y = (int) (0.5 * height);
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Users\\user2\\Documents\\GitHub\\Project554\\src\\Main\\sun.png"));
        } catch (IOException e) {}
        g2d.drawImage(im, x-128/2, y-128/2, null);
    }

    //    public void ускорение(int X0, int Y0, int x, int y, long G, long Mz, long Mp /* масса планеты*/,int T, double r, float ax, float ay){
//        ax = (float) (Mz*G*Mp*(X0 - x)/(Math.pow(r, (double)3)));
//        ay = (float) (Mz*G*Mp*(Y0 - y)/(Math.pow(r, (double)3)));
//    }
//
//    public void скорость(int ax, int ay, int vx, int vy, int T){
//        vx = vx + T*ax;
//        vy = vy + T*ay;
//    }
//    public void новаяКоордината(int vy, int vx, int x, int y, int T){
//        x = x + T*vx;
//        y = y + T*vy;
//    }
    private Shape circle(double x, double y, double a, double b) {

        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }

}
