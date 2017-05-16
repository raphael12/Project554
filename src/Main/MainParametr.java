import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainParametr {
    final static public double MassSun = 5000000;
    final static public double G = 10;

    public static double getTheta(double yPos, double xPos) {
        double theta = Math.atan(yPos/xPos);
        if (xPos < 0)
            theta = Math.PI + theta;
        else if (xPos > 0 && yPos < 0)
            theta = 2*Math.PI + theta;
        return theta;
    }
    public static double  getK(double mass){
        return G*MassSun;
    }

    public static double getA( int index){
        double r = (Adding.coordinataX.get(index)-EarthMoving.width/2) * (Adding.coordinataX.get(index) - EarthMoving.width/2) + (Adding.coordinataY.get(index)-EarthMoving.height/2) * (Adding.coordinataY.get(index)-EarthMoving.height/2);
        double c = r * Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        double p =c*c/(G*(MassSun +Adding.Mass.get(index)));

        if((p/(1 - Adding.E.get(index)*Adding.E.get(index))) > 30000){
            return Adding.A.get(index-1)+100;
        } else if((p/(1 - Adding.E.get(index)*Adding.E.get(index))) > 12000) {
            return p/(10*(1 - Adding.E.get(index)*Adding.E.get(index)));
        } else {
            return p / (1 - Adding.E.get(index) * Adding.E.get(index));
        }
    }
    public static double getB( int index){
        double r = (Adding.coordinataX.get(index)-EarthMoving.width/2) * (Adding.coordinataX.get(index) - EarthMoving.width/2) + (Adding.coordinataY.get(index)-EarthMoving.height/2) * (Adding.coordinataY.get(index)-EarthMoving.height/2);

        double c = r*Math.sqrt(Adding.Vx.get(index)*Adding.Vx.get(index)+Adding.Vy.get(index)*Adding.Vy.get(index));
        double p =c*c/(G*(Adding.Mass.get(index) + MassSun));
        if((p / (Math.sqrt(1 -  Adding.E.get(index)*Adding.E.get(index))) > 30000)) {
            return Adding.B.get(index-1)+100;
        }else if(p /Math.sqrt(1 -  Adding.E.get(index)*Adding.E.get(index)) > 12500) {
            return p / (10*Math.sqrt(1 - Adding.E.get(index)*Adding.E.get(index)));
        } else {
            return p / (Math.sqrt(1 -  Adding.E.get(index)*Adding.E.get(index)));
        }
    }

    public static double GetAxVx(int index){
        double r = Math.sqrt( (Adding.coordinataX.get(index)-EarthMoving.width/2) * (Adding.coordinataX.get(index)-EarthMoving.width/2) + (Adding.coordinataY.get(index)-EarthMoving.height/2) * (Adding.coordinataY.get(index)-EarthMoving.height/2));
        double Ax;
        double theta = Расчёты.getTheta(Adding.coordinataX.get(index), Adding.coordinataY.get(index));
        Ax =  G * MassSun*Math.cos(theta + Math.PI) / (r*r);
        return   Ax;
    }
    public static double GetAyVy(int index){
        double r = Math.sqrt( (Adding.coordinataX.get(index)-EarthMoving.width/2) * (Adding.coordinataX.get(index)-EarthMoving.width/2) + (Adding.coordinataY.get(index)-EarthMoving.height/2) * (Adding.coordinataY.get(index)-EarthMoving.height/2));
        double Ay;
        double theta = Расчёты.getTheta(Adding.coordinataX.get(index), Adding.coordinataY.get(index));
        Ay = G * MassSun *Math.sin(theta + Math.PI) / (r*r);
        return  Ay;
    }
    public static double getH(double v, double k, double r){
        return v*v-2*k/r;
    }

}
