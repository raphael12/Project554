import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Расчёты {

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
        double x = Adding.coordinataX.get(index);
        double y = Adding.coordinataY.get(index);
        double r = Math.sqrt((Adding.coordinataX.get(index) - EarthMoving.width / 2) * (Adding.coordinataX.get(index) - EarthMoving.width / 2) + (Adding.coordinataY.get(index) - EarthMoving.height / 2) * (Adding.coordinataY.get(index) - EarthMoving.height / 2));
        int widthIm = im.getWidth(null);
        int heightIm = im.getHeight(null);
        g2d.drawImage(im, (int) (x - widthIm / 2), (int) (y - heightIm / 2), null);
        if (SettingsFrame.checkBox1.isSelected()) {
            for (a = 0; a < numOfMoons; a++) {
                if (r * Adding.TimerList.get(a) < r) {
                    ДвижениеСпутника(x, y, widthIm * Adding.TimerList.get(a) * 2, g2d, angle1 * Adding.TimerList.get(a));
                } else {
                    ДвижениеСпутника(x, y, widthIm * Adding.TimerList.get(a), g2d, angle1 * Adding.TimerList.get(a));
                }
            }
        }
        double theta = getTheta(Adding.coordinataY.get(index) - EarthMoving.height / 2, Adding.coordinataX.get(index) - EarthMoving.width / 2);
        double F = Force(index, r);
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
        String K = Integer.toString((int) getKE(index));
        String P = Integer.toString((int) getPE(index));
        if(SettingsFrame.checkBox4.isSelected()) {
            g2d.setColor(Color.WHITE);
            g2d.drawString("K = " + K, (int) x + 20, (int) y);
            g2d.drawString("P = " + P, (int) x + 20, (int) y + 15);
            g2d.setColor(Color.RED);
        }
        int vectoAx = ((int) (x+ Ax));
        int vectoAy = ((int) (y+ Ay));
        if(SettingsFrame.checkBox5.isSelected()) {
            g2d.setStroke(new BasicStroke(4.0f));
            double l = 10;
            double alfa = 30;
            double betta = getTheta(Math.abs(y-vectoAy-y), Math.abs(x-vectoAx - x));
            g2d.drawLine((int) x, (int) y, vectoAx, vectoAy);
            g2d.drawLine(vectoAx, vectoAy, vectoAx, vectoAy );
            g2d.setStroke(new BasicStroke(0.3f));
        }
        if (SettingsFrame.i != 0) {
            for (int i = 0; i < SettingsFrame.i; i++) {
                    if(i != index) {
                        double thetta = getTheta(( Math.abs(Adding.coordinataY.get(i) - Adding.coordinataY.get(index))), Math.abs(Adding.coordinataX.get(i) - Adding.coordinataX.get(index)));
                        double Axcor = Adding.Ax.get(index) - G * Adding.Mass.get(i)*Math.cos(thetta + Math.PI) / DistHost(index, i);
                        double Aycor = Adding.Ay.get(index) - G * Adding.Mass.get(i) *Math.sin(thetta + Math.PI)/ DistHost(index, i);
                        double Vxcor = Adding.Vx.get(index) + Axcor * dt;
                        double Vycor = Adding.Vy.get(index) + Aycor * dt;
                        double X = Adding.coordinataX.get(index) + Vxcor * dt + Axcor * dt * dt / 2;
                        double Y = Adding.coordinataY.get(index) + Vycor * dt + Aycor * dt * dt / 2;
                        if(SettingsFrame.checkBox3.isSelected()){
                            g2d.drawLine((Adding.coordinataX.get(index).intValue()), (Adding.coordinataY.get(index).intValue()), EarthMoving.width/2, EarthMoving.height/2);
                        }
                        if(SettingsFrame.checkBox2.isSelected()) {
                             g2d.drawLine(Adding.coordinataX.get(i).intValue() , (Adding.coordinataY.get(i).intValue()), (Adding.coordinataX.get(index).intValue()), (Adding.coordinataY.get(index).intValue()));
                        }
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

    /**
     * The method getKE returns the kinetic energy of the planet in arbitrary
     * units.
     */
    public double getKE(int index) {
        return Adding.Mass.get(index)*(Adding.Vx.get(index)*Adding.Vx.get(index) + Adding.Vy.get(index)*Adding.Vy.get(index))/2;
    }
    /**
     * The method getPE returns the potential energy of the planet in arbitrary
     * units.
     */
    public double getPE(int index) {
        return Adding.Mass.get(index)*Math.sqrt(Adding.Ax.get(index)*Adding.Ax.get(index) + Adding.Ay.get(index)*Adding.Ay.get(index))*DistHost(index,index);
    }

    static public double DistHost(int i, int k) {
        if(i != k) {
            double res, X, Y;
            X = Math.abs(Adding.coordinataX.get(i) - Adding.coordinataX.get(k));
            Y = Math.abs(Adding.coordinataY.get(i) - Adding.coordinataY.get(k));
            res = X * X + Y * Y;
            return res;
        } else {
            double res, X, Y;
            X = Math.abs(Adding.coordinataX.get(i) - EarthMoving.width/2);
            Y = Math.abs(Adding.coordinataY.get(i) - EarthMoving.height/2);
            res = X * X + Y * Y;
            return res;
        }
    }

    public void ДвижениеСпутника(double x, double y, double r, Graphics2D g2d, double angle) {
        Image im;
        im = EarthMoving.Moon;
        int widthIm = 0;
        int heightIm = 0;
        widthIm = im.getWidth(null);
        heightIm = im.getHeight(null);
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
