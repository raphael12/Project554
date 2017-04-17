import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainParametr {
    final static public double G = 6.67408 * Math.pow(10, -11);
    final static public double MassSun = 1.989 * Math.pow(10, 30);

    public static double getTheta(double yPos, double xPos) {
        double theta = Math.atan(yPos/xPos);
        if (xPos < 0)
            theta = Math.PI + theta;
        else if (xPos > 0 && yPos < 0)
            theta = 2*Math.PI + theta;
        return theta;
    }
    public static double  getK(double mass){
        return G*(mass * 1000000 + MassSun);
    }

    public static double getA(double k, double v, double r){
        return k/(v*v - 2*k/r);
    }
    public static double getB(double v, double r, double k){
        return 1000/(-v*v + 2*k/r);// где c число
    }
    public static double getH(double v, double k, double r){
        return v*v-2*k/r;
    }
    public static double getExentrisitet(double r, double k, double h){
        return Math.sqrt(1+h/(k*k));
    }
}
