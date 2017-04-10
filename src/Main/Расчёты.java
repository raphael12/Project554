import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Расчёты {
    private EarthMoving imagePoint = new EarthMoving();
    double dt = 0.001;

    public void движение(double width, double height, double r, double angle, Graphics2D g2d, File file, byte numOfMoons) {
        int a;
        Image im = null;
        double x = 0.5 * width;//координаты центра
        double y = 0.5 * height;
        double vx=0;
        double vy=0;
        double ax;
        double ay;
        try {
            im = ImageIO.read(file);//кладем в im переданную картинку file
        } catch (IOException e) {//здесь можны вывести варнинги если картинка не прочиталась
        }
        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);
        g2d.setStroke(new BasicStroke(0.1f));//толщина круга, но как работает хз
        g2d.setColor(Color.LIGHT_GRAY); //цвет орбиты
        r = r * SettingsFrame.indicatorSize;
        if(SettingsFrame.checkBox2.isSelected()) {
            g2d.draw(circle(x, y, x, y));//рисует орбиту
        }
        ax = x / (r*r*r);
        ay = y / (r*r*r);
        vx += ax;
        vy += ay;
        x += vx;
        y += vy;
        y += y * Math.sin(angle);
        x += x * Math.cos(angle);
        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setStroke(new BasicStroke(0.5f));//толщина круга, но как работает хз
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
        g2d.setColor(Color.LIGHT_GRAY);
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
        g2d.drawImage(im, x - widthIm / 2, y - heightIm / 2, null);
    }

    private Shape circle(double x, double y, double a, double b) {

        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }

}
