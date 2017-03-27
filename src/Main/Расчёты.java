import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Расчёты {

    public void движение(double width, double height, double r, double angle, Graphics2D g2d, Color color, File file) {

        Image im = null;
        double x = 0.5 * width;//координаты центра
        double y = 0.5 * height;
        try {
            im = ImageIO.read(file);//кладем в im переданную картинку file
        } catch (IOException e) {//здесь можны вывести варнинги если картинка не прочиталась
        }
        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);
        g2d.setColor(color); //цвет орбиты
        g2d.draw(circle(x, y, r, r));//рисует орбиту
        y += r * Math.sin(angle);
        x += r * Math.cos(angle);
        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setStroke(new BasicStroke(0.2f));//толщина круга, но как работает хз
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.drawImage(im,(int) (x-widthIm/2), (int)(y-heightIm/2), null);
        ДвижениеСпутника(x, y, r, g2d, angle);
    }




    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle) {
        r = r * 3;
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Users\\user2\\Documents\\GitHub\\Project554\\src\\Main\\res\\moon.png"));
        } catch (IOException e) {
        }
        int widthIm = 0;
        int heightIm = 0;
        widthIm = im.getWidth(null);
        heightIm = im.getHeight(null);
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(0.1f));
        g2d.draw(circle(x, y, r, r));
        x += r * Math.sin(3*angle);
        y += r * Math.cos(3*angle);
        r = Math.max(0.1 * r, 5);
        g2d.drawImage(im, (int) (x-widthIm/2), (int)(y - heightIm/2), null);
    }

    public void Sun(int width, int height /*long M (масса)*/, Graphics2D g2d) {
        int x = (int) (0.5 * width);//координаты центра
        int y = (int) (0.5 * height);
        Image im = null;
        try {
            im = ImageIO.read(new File("C:\\Users\\user2\\Documents\\GitHub\\Project554\\src\\Main\\res\\sun.png"));
        } catch (IOException e) {
        }
        int widthIm = im.getWidth(null);//узнаем размер изображения
        int heightIm = im.getHeight(null);
        g2d.drawImage(im, x - widthIm/2, y - heightIm/2, null);
    }

    private Shape circle(double x, double y, double a, double b) {

        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }

}
