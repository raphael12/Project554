import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Расчёты {

    public void движение (double width, double height,double r, double angle, Graphics2D g2d, Color color){
        double x = 0.5 * width;//координаты центра
        double y = 0.5 * height;
        g2d.setColor(color); //цвет орбиты и груга
        g2d.draw(circle(x, y, r));//рисует орбиту
        y += r * Math.sin(angle);
        x += r * Math.cos(angle);
        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setStroke(new BasicStroke(1f));//толщина круга вроде но хз
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.fill(circle(x ,y ,r));//добавляем круг
        ДвижениеСпутника(x,y,r,g2d,10);
    }
    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle){
        r = r*3;
        g2d.setColor(Color.RED);
        g2d.draw(circle(x,y,r));
        y += r * Math.sin(angle);
        x += r * Math.cos(angle);
        r = Math.max(0.1 * r, 5);
        g2d.fill(circle(x ,y ,r));//добавляем круг
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
private Shape circle(double x, double y, double r) {

        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r); //что - то прописанное в библиотеке
}

}
