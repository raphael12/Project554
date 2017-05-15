import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Расчёты {
    //final static public double G = 6.67408 * Math.pow(10, -11);
    //final static public double MassSun = 1.989 * Math.pow(10, 2);
    //final static public double Kombo = Math.pow(10, 75);
    static public double MassSun = 5000000;
    final static public double G = 10;
    public double dt = 0.001;
    private EarthMoving imagePoint = new EarthMoving();

    static public void Sun(int width, int height, Graphics2D g2d) {
        int x = (int) (0.5 * width);//координаты центра
        int y = (int) (0.5 * height);
        Image im = null;
        if (SettingsFrame.indicatorSize < 1.05 && SettingsFrame.indicatorSize > 0.9) {
            im = EarthMoving.Sun96;
        } else if (SettingsFrame.indicatorSize >= 1.05 && SettingsFrame.indicatorSize <= 1.25) {
            im = EarthMoving.Sun128;
        } else if (SettingsFrame.indicatorSize > 1.25) {
            im = EarthMoving.RedGiand;
        } else if (SettingsFrame.indicatorSize <= 0.9 && SettingsFrame.indicatorSize > 0.7) {
            im = EarthMoving.Sun64;
        } else if (SettingsFrame.indicatorSize <= 0.7 && SettingsFrame.indicatorSize > 0.5) {
            im = EarthMoving.Sun32;
        } else if (SettingsFrame.indicatorSize <= 0.5 && SettingsFrame.indicatorSize > 0) {
            im = EarthMoving.Sun16;
        }
        int widthIm = im.getWidth(null);//узнаем размер изображения
        int heightIm = im.getHeight(null);
        g2d.drawImage(im, x - widthIm / 2, y - heightIm / 2, null);
    }

    static public double Force(int index, double r) {
        return G * (MassSun * Adding.Mass.get(index)) / (r * r);
    }

    //    static public double ForceY(int index, double r){
//        double theta = getTheta(Math.abs(Adding.coordinataX.get(index) - EarthMoving.width/2), (Math.abs(Adding.coordinataY.get(index) - EarthMoving.height/2)));
//        return G*(MassSun * Adding.Mass.get(index))*Math.sin(theta + Math.PI)/(r*r);
//    }
    static public double getTheta(double yPos, double xPos) {//будут передаваться в точке отсчета Солнца
        double theta = Math.atan(yPos / xPos);
        if (xPos < 0)
            theta = Math.PI + theta;
        else if (xPos > 0 && yPos < 0)
            theta = 2 * Math.PI + theta;
        return theta;
    }

    static public double EnergyConst(double Vx, double Vy, double x, double y, int index) {
        return -0.5 * (Vx * Vx + Vy * Vy) - G * (MassSun) / Math.sqrt((x * x + y * y));
    }

    static public double Energy(double Vx, double Vy, double x, double y, int index) {
        return -0.5 * (Vx * Vx + Vy * Vy) - G * (MassSun) / Math.sqrt(x * x + y * y);
    }

    static public double GetW(double x, double y, int index, double E0) {
        return Math.sqrt((2 * G * (MassSun)) / Math.pow((x * x + y * y), 3 / 2) + 2 * E0 / ((x * x + y * y)));
    }

    static public double Momentum(double Vx, double Vy, double x, double y) {
        return x * Vy - y * Vx;
    }

    public void движение(double width, double height, double angle1, double angle2, Graphics2D g2d, Image im, byte numOfMoons, int index) {
        int a;
        double X0 = 0.5 * width;//координаты центра
        double Y0 = 0.5 * height;
        //double r;
        //double c = r*Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        // double p =c*c/(G*(Adding.Mass.get(index) + MassSun));
        //r = r/(1 + Adding.E.get(index) * Math.cos(angle1));
        // SettingsFrame.textField7.setText(String.format("%(.2f",(r)));
        //double Lo = Momentum(Vx, Vy, Adding.coordinataX.get(index), Adding.coordinataY.get(index));
//        x =X0 + 50*Adding.A.get(index)*SettingsFrame.indicatorSize* Math.cos(angle1/5);
//        y =Y0 + 50*Adding.B.get(index)*SettingsFrame.indicatorSize* Math.sin(angle1/5);
        double x = Adding.coordinataX.get(index);
        double y = Adding.coordinataY.get(index);
        double r = Math.sqrt((Adding.coordinataX.get(index) - EarthMoving.width / 2) * (Adding.coordinataX.get(index) - EarthMoving.width / 2) + (Adding.coordinataY.get(index) - EarthMoving.height / 2) * (Adding.coordinataY.get(index) - EarthMoving.height / 2));
        //double E0 = EnergyConst(Adding.Vx.get(index), Adding.Vy.get(index) , Adding.coordinataX.get(index), Adding.coordinataY.get(index), index);
        //SettingsFrame.textField4.setText(String.format("%(.2f",(E0)));
//        double Ax = - G * MassSun * x / (r*r*r);
//        double Ay = - G * MassSun * y / (r*r*r);
//        SettingsFrame.textField6.setText(String.format("%(.4f",Ax));
        // SettingsFrame.textField7.setText(String.valueOf(Ay));
//         Vx += Ax * (angle1 - angle2);
//         Vy += Ay * (angle1 - angle2);
//        double w = Adding.W.get(index);
//         w +=GetW(x,y,index,E0);
//        SettingsFrame.textField6.setText(String.format("%(.2f",w));
//        Adding.W.remove(index);
//        Adding.W.add(index, w);
//        x = X0 + 50*Adding.A.get(index)*SettingsFrame.indicatorSize*( Math.cos((w + angle1)/3));
//        y = Y0 + 50*Adding.B.get(index)*SettingsFrame.indicatorSize*( Math.sin((w + angle1)/3));
//        r = Math.sqrt((x-X0)*(x-X0)+(y-Y0)*(y-Y0));
//        SettingsFrame.textField7.setText(String.format("%(.2f", r));
//        SettingsFrame.textField5.setText(String.format("%(.2f", angle1))
        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);
//        g2d.setColor(Color.RED); //цвет орбиты
//        if(SettingsFrame.checkBox2.isSelected()) {
//            g2d.draw(circle(X0-30*Adding.A.get(index)*Adding.E.get(index)*SettingsFrame.indicatorSize, Y0, 50*Adding.A.get(index)*SettingsFrame.indicatorSize, 50*Adding.B.get(index)*SettingsFrame.indicatorSize));//рисует орбиту
//        }
        //r = r * SettingsFrame.indicatorSize;
        //double c = r * Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        //double p = c*c/Adding.K.get(index);

        //y += Adding.B.get(index)*SettingsFrame.indicatorSize * Math.sin(angle);
        //x += Adding.A.get(index)*SettingsFrame.indicatorSize * Math.cos(angle);
        //r = Math.max(0.1 * r, 5);//превращает радиус орбиты в радиус круга
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//что это?!!!!!
        g2d.drawImage(im, (int) (x - widthIm / 2), (int) (y - heightIm / 2), null);
        if (SettingsFrame.checkBox1.isSelected()) {
            for (a = 0; a < numOfMoons; a++) {
                if (r * Adding.TimerList.get(a) < r) {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a) * 2, g2d, angle1 * Adding.TimerList.get(a));
                } else {
                    ДвижениеСпутника(x, y, r * Adding.TimerList.get(a), g2d, angle1 * Adding.TimerList.get(a));
                }
            }
        }
        double theta = getTheta(Adding.coordinataY.get(index) - EarthMoving.height / 2, Adding.coordinataX.get(index) - EarthMoving.width / 2);
        double F = Force(index, r);
//        double Fy = ForceY(index, r);
        double Ax = F * Math.cos(theta + Math.PI) / MassSun;
        double Ay = F * Math.sin(theta + Math.PI) / MassSun;
        Adding.Ax.remove(index);
        Adding.Ay.remove(index);
        Adding.Ax.add(index, Ax);
        Adding.Ay.add(index, Ay);
        double Vx = Adding.Vx.get(index) + Ax * dt;
        double Vy = Adding.Vy.get(index) + Ay * dt;
        Adding.Vx.remove(index);
        Adding.Vy.remove(index);
        Adding.Vx.add(index, Vx);
        Adding.Vy.add(index, Vy);
        x = Adding.coordinataX.get(index) + Vx * dt + Ax * dt * dt / 2;
        y = Adding.coordinataY.get(index) + Vy * dt + Ay * dt * dt / 2;
        Adding.coordinataX.remove(index);
        Adding.coordinataY.remove(index);
        Adding.coordinataX.add(index, x);
        Adding.coordinataY.add(index, y);
        if (SettingsFrame.i != 0) {
            for (int i = 0; i < SettingsFrame.i; i++) {
                    if(i != index) {
                        double Axcor = Adding.Ax.get(index) + G * Adding.Mass.get(i) / DistHost(index, i);
                        double Aycor = Adding.Ay.get(index) + G * Adding.Mass.get(i) / DistHost(index, i);
                        double Vxcor = Adding.Vx.get(index) + Axcor * dt;
                        double Vycor = Adding.Vy.get(index) + Aycor * dt;
                        double X = Adding.coordinataX.get(index) + Vxcor * dt + Axcor * dt * dt / 2;
                        double Y = Adding.coordinataY.get(index) + Vycor * dt + Aycor * dt * dt / 2;
                        Adding.coordinataX.remove(index);
                        Adding.coordinataY.remove(index);
                        Adding.Ax.remove(index);
                        Adding.Ay.remove(index);
                        Adding.Vx.remove(index);
                        Adding.Vy.remove(index);
                        Adding.coordinataX.add(index, X);
                        Adding.coordinataY.add(index, Y);
                        Adding.Vx.add(index, Vxcor);
                        Adding.Vy.add(index, Vycor);
                        Adding.Ax.add(index, Axcor);
                        Adding.Ay.add(index, Aycor);
                    }
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


    static public double DistHost(int i, int k) {
        double res, X, Y;
        X = Math.abs(Adding.coordinataX.get(i) - Adding.coordinataX.get(k));
        Y = Math.abs(Adding.coordinataY.get(i) - Adding.coordinataY.get(k));
        res = X * X + Y * Y;
        return res;
    }

    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle) {
        r = r * 3;
        Image im;
        im = EarthMoving.Moon;
        int widthIm = 0;
        int heightIm = 0;
        widthIm = im.getWidth(null);
        heightIm = im.getHeight(null);
        g2d.setColor(Color.RED);
        if (SettingsFrame.checkBox1.isSelected()) {
            g2d.draw(circle(x, y, r, r));
        }
        x += r * Math.sin(angle);
        y += r * Math.cos(angle);
        g2d.drawImage(im, (int) (x - widthIm / 2), (int) (y - heightIm / 2), null);
    }

    private Shape circle(double x, double y, double a, double b) {
        return new Ellipse2D.Double(x - a, y - b, 2 * a, 2 * b); //что - то прописанное в библиотеке
    }


}
