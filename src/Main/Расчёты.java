
public class Расчёты {

    public void расстояние(int x, int y, int X0, int Y0, double r){
        r = Math.sqrt((x - X0)^2+(y- Y0)^2);//рассчитываем расстояние до планеты
    }

    public void ускорение(int X0, int Y0, int x, int y, long G, long Mz, long Mp /* масса планеты*/,int T, double r, float ax, float ay){
        ax = (float) (Mz*G*Mp*(X0 - x)/(Math.pow(r, (double)3)));
        ay = (float) (Mz*G*Mp*(Y0 - y)/(Math.pow(r, (double)3)));
    }

    public void скорость(int ax, int ay, int vx, int vy, int T){
        vx = vx + T*ax;
        vy = vy + T*ay;
    }
    public void новаяКоордината(int vy, int vx, int x, int y, int T){
        x = x + T*vx;
        y = y + T*vy;
    }
}
