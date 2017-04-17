import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Расчёты {
    final static public double G = 6.67408 * Math.pow(10, -11);
    final static public double MassSun = 1.989 * Math.pow(10, 30);
    final static public double Kombo = Math.pow(10, 75);
    public static Integer i = 0;
    final static public double e = Math.random();
    private EarthMoving imagePoint = new EarthMoving();
    public double dt = 0.001;

    public void движение(double width, double height, double r, double angle, Graphics2D g2d, File file, byte numOfMoons) {
        int a;
        Image im = null;
        double x = 0.5 * width;//координаты центра
        double y = 0.5 * height;
        try {
            im = ImageIO.read(file);//кладем в im переданную картинку file
        } catch (IOException e) {//здесь можны вывести варнинги если картинка не прочиталась
        }
        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);

        g2d.setColor(Color.LIGHT_GRAY); //цвет орбиты
        r = r * SettingsFrame.indicatorSize / 1000000;
        if(SettingsFrame.checkBox2.isSelected()) {
            g2d.draw(circle(x, y, r, r));//рисует орбиту
        }
        double c = r * Math.sqrt(Adding.Vx.get(i)*Adding.Vx.get(i)+Adding.Vy.get(i)*Adding.Vy.get(i));
        double k = G * MassSun; // нужная константа
        double p = Kombo* c*c/k;
        double vi = angle; // угол истинной аномалии(Маркеев 245 стр)
        r = p/(1 + e * Math.cos(vi));
        y += r * Math.sin(angle);
        x += r * Math.cos(angle);
        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.drawImage(im, (int) (x - widthIm / 2), (int) (y - heightIm / 2), null);
        if (SettingsFrame.checkBox1.isSelected()) {
            for (a = 0; a < numOfMoons; a++) {
                if (r*Adding.TimerList.get(a) < r) {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a)*2, g2d, angle * Adding.TimerList.get(a));
                } else {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a), g2d, angle * Adding.TimerList.get(a));
                }
            }
        }
//        int a;
//        double r = Math.sqrt((x-width/2)*(x-width/2)+(y-width/2)*(y-width/2));
//        Image im = null;
//        double xAbs = 0.5 * width;//координаты центра
//        double yAbs = 0.5 * height;
//        double vx=0;
//        double vy=0;
//        double ax;
//        double ay;
//        try {
//            im = ImageIO.read(file);//кладем в im переданную картинку file
//        } catch (IOException e) {//здесь можны вывести варнинги если картинка не прочиталась
//        }
//        int widthIm = im.getWidth(null);
//        int heightIm = im.getHeight(null);
//        g2d.setColor(Color.lightGray); //цвет орбиты
//
//        deltaTetha += angle;
//        double tetha = getTheta(x- width/2, y - height/2);
//
//        ax = G * (x-width/2) * Adding.Mass.get(index)/ (r*r*r)*Math.cos(tetha+angle);
//        ay = G * (y-height/2) * Adding.Mass.get(index)/ (r*r*r)*Math.sin(tetha+angle);
//        vx = vx + ax*dt;
//        vy = vx + ay*dt;
//        x += vx*dt + ax*dt*dt/2;
//        y += vy*dt + ay*dt*dt/2;
////        y += y * Math.sin(angle);
////        x += x * Math.cos(angle);
//        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
//        g2d.setStroke(new BasicStroke(0.5f));//толщина круга, но как работает хз
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
//        if(SettingsFrame.checkBox2.isSelected()) {
//            g2d.draw(circle(xAbs, yAbs, x-width/2, y-height/2));//рисует орбиту
//        }
//        g2d.drawImage(im, (int) (x - (widthIm + width/ 2)), (int) (y - (heightIm + height)/ 2), null);
//        if (SettingsFrame.checkBox1.isSelected()) {
//            for (a = 0; a < numOfMoons; a++) {
//                if (r*Adding.TimerList.get(a) < r) {
//                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a)*2, g2d, angle * Adding.TimerList.get(a));
//                } else {
//                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a), g2d, angle * Adding.TimerList.get(a));
//                }
//            }
//        }
    }


    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle) {
        r = r * 3;
        Image im = null;
        try {
            im = ImageIO.read(imagePoint.Moon);
        } catch (IOException e) {
        }
        int widthIm = 0;
        int heightIm = 0;
        widthIm = im.getWidth(null);
        heightIm = im.getHeight(null);
        g2d.setColor(Color.RED);
        if(SettingsFrame.checkBox1.isSelected()) {
            g2d.draw(circle(x, y, r, r));
        }
        x += r * Math.sin(3 * angle);
        y += r * Math.cos(3 * angle);
        r = Math.max(0.1 * r, 5);
        g2d.drawImage(im, (int) (x - widthIm / 2), (int) (y - heightIm / 2), null);
    }

    static public void Sun(int width, int height /*long M (масса)*/, Graphics2D g2d) {
        int x = (int) (0.5 * width);//координаты центра
        int y = (int) (0.5 * height);
        Image im = null;
        try {
            if(SettingsFrame.indicatorSize == 1){
                im = ImageIO.read(EarthMoving.Sun96);
            } else if(SettingsFrame.indicatorSize == 1.2){
                im = ImageIO.read(EarthMoving.Sun128);
            } else if(SettingsFrame.indicatorSize >= 1.4){
                im = ImageIO.read(EarthMoving.RedGiand);
            } else if(SettingsFrame.indicatorSize <= 0.9 && SettingsFrame.indicatorSize >= 0.7){
                im = ImageIO.read(EarthMoving.Sun64);
            } else if(SettingsFrame.indicatorSize <= 0.7 && SettingsFrame.indicatorSize > 0.5){
                im = ImageIO.read(EarthMoving.Sun32);
            } else if(SettingsFrame.indicatorSize <= 0.5 && SettingsFrame.indicatorSize > 0){
                im = ImageIO.read(EarthMoving.Sun16);
            }



        } catch (IOException e) {
        }
        int widthIm = im.getWidth(null);//узнаем размер изображения
        int heightIm = im.getHeight(null);
        g2d.drawImage(im, x - widthIm / 2 , y - heightIm / 2, null);
    }

    private Shape circle(double x, double y, double a, double b) {

        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }

    public double getTheta(double yPos, double xPos) {
        double theta = Math.atan(yPos/xPos);
        if (xPos < 0)
            theta = Math.PI + theta;
        else if (xPos > 0 && yPos < 0)
            theta = 2*Math.PI + theta;
        return theta;
    }
    public  double  getK(double mass){
        return G*(mass + MassSun);
    }

    public double getA(double k, double v, double r){
        return k/(v*v - 2*k/r);
    }

}
