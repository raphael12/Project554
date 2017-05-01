import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Расчёты {
    //final static public double G = 6.67408 * Math.pow(10, -11);
    //final static public double MassSun = 1.989 * Math.pow(10, 2);
    //final static public double Kombo = Math.pow(10, 75);
    final static public double MassSun = 5000;
    final static public double G = 1;
    public double dt = 0.001;
    private EarthMoving imagePoint = new EarthMoving();

    static public void Sun(int width, int height , Graphics2D g2d) {
        int x = (int) (0.5 * width);//координаты центра
        int y = (int) (0.5 * height);
        Image im = null;
            if(SettingsFrame.indicatorSize == 1){
                im = EarthMoving.Sun96;
            } else if(SettingsFrame.indicatorSize == 1.2){
                im = EarthMoving.Sun128;
            } else if(SettingsFrame.indicatorSize > 1.2){
                im = EarthMoving.RedGiand;
            } else if(SettingsFrame.indicatorSize <= 0.9 && SettingsFrame.indicatorSize >= 0.7){
                im = EarthMoving.Sun64;
            } else if(SettingsFrame.indicatorSize <= 0.7 && SettingsFrame.indicatorSize > 0.5){
                im = EarthMoving.Sun32;
            } else if(SettingsFrame.indicatorSize <= 0.5 && SettingsFrame.indicatorSize > 0){
                im =EarthMoving.Sun16;
            }
        int widthIm = im.getWidth(null);//узнаем размер изображения
        int heightIm = im.getHeight(null);
        g2d.drawImage(im,    x - widthIm / 2 , y - heightIm / 2, null);
    }

    static public double Energy(double Vx, double Vy, double x, double y){
        return 0.5 * (Vx * Vx + Vy * Vy) - G * MassSun / Math.sqrt(x*x+y*y);
    }

    static public double Momentum (double Vx, double Vy, double x, double y){
        return x * Vy - y * Vx;
    }

    public void движение(double width, double height, double angle1,double angle2, Graphics2D g2d, Image file, byte numOfMoons, int index) {

        int a;
        Image im = null;
        double X0 = 0.5 * width;//координаты центра
        double Y0 = 0.5 * height;
        double Vx = 0;
        double Vy = 0;
        double r = Math.sqrt( (Adding.coordinataX.get(index)-width/2) * (Adding.coordinataX.get(index) - width/2) + (Adding.coordinataY.get(index)-height/2) * (Adding.coordinataY.get(index)-height/2));
        double c = r*Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        double p =c*c/(G*(Adding.Mass.get(index) + MassSun));
        //r = r/(1 + Adding.E.get(index) * Math.cos(angle1));
        SettingsFrame.textField7.setText(String.format("%(.2f",(r)));

            im = file;

        double x = X0;
        double y = Y0;
        x += 50*Adding.A.get(index)*SettingsFrame.indicatorSize* Math.cos(angle1);
        y += 50*Adding.B.get(index)*SettingsFrame.indicatorSize* Math.sin(angle1);

//        double Ax = - G * MassSun * x / (r*r*r);
//        double Ay = - G * MassSun * y / (r*r*r);
//        SettingsFrame.textField6.setText(String.format("%(.4f",Ax));
       // SettingsFrame.textField7.setText(String.valueOf(Ay));
//         Vx += Ax * (angle1 - angle2);
//         Vy += Ay * (angle1 - angle2);

        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);
        g2d.setColor(Color.LIGHT_GRAY); //цвет орбиты

        if(SettingsFrame.checkBox2.isSelected()) {
            g2d.draw(circle(X0-50*Adding.A.get(index)*Adding.E.get(index)*SettingsFrame.indicatorSize, Y0, 50*Adding.A.get(index)*SettingsFrame.indicatorSize, 50*Adding.B.get(index)*SettingsFrame.indicatorSize));//рисует орбиту
        }
        //r = r * SettingsFrame.indicatorSize;
        //double c = r * Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        //double p = c*c/Adding.K.get(index);

        //y += Adding.B.get(index)*SettingsFrame.indicatorSize * Math.sin(angle);
        //x += Adding.A.get(index)*SettingsFrame.indicatorSize * Math.cos(angle);

        double E0 = Energy(Vx, Vy , Adding.coordinataX.get(index), Adding.coordinataY.get(index));
        double Lo = Momentum(Vx, Vy, Adding.coordinataX.get(index), Adding.coordinataY.get(index));

        r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.drawImage(im, (int) ((-50*Adding.A.get(index)*Adding.E.get(index)*SettingsFrame.indicatorSize + x - widthIm / 2)), (int) ((y - heightIm / 2)), null);
        if (SettingsFrame.checkBox1.isSelected()) {
            for (a = 0; a < numOfMoons; a++) {
                if (r*Adding.TimerList.get(a) < r) {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a)*2, g2d, angle1 * Adding.TimerList.get(a));
                } else {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a), g2d, angle1 * Adding.TimerList.get(a));
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
        im = EarthMoving.Moon;
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

    private Shape circle(double x, double y, double a, double b) {
        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }


}
