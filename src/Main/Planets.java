import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.MouseInfo;
import java.awt.Point;
public abstract class Planets extends JComponent implements ActionListener{//это скорее всего не понадобится
    static public boolean pulsing1 = true;
    static int width, height;
    static Image VeneraSmall, VeneraNormal, VeneraBig, PlanetWithAsteroidSmall, PlanetWithAsteroidNormal, PlanetWithAsteroidBig, earthSmall, earthNormal, earthBig, BackGround, Moon, RedGiand, Sun128, Sun96, Sun64, Sun32, Sun16;
    private static double angle;
    private  static String curDir = new File("").getAbsolutePath();
    private  static File VeneraSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraSmall.png");
    private static File VeneraNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraNormal.png");
    private static File VeneraBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\VeneraBig.png");
    private static File PlanetWithAsteroidSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidSmall.png");
    private static File PlanetWithAsteroidNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidNormal.png");
    private static File PlanetWithAsteroidBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\PlanetWithAsteroidBig.png");
    private static File earthSmallUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthsmall.png");
    private static File earthNormalUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthNormal.png");
    private  static File earthBigUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\earthBig.png");
    private  static File BackGroundUrl = new File(curDir.replace("\\", "\\\\") +"\\src\\Main\\res\\sky.GIF");
    private static File MoonUrl = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\moon.png");
    private static File RedGiandUrl = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\RedGiand.png");
    private  static File Sun128Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun.png");
    private  static File Sun96Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun96.png");
    private  static File Sun64Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun64.png");
    private  static File Sun32Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun32.png");
    private  static File Sun16Url = new File(curDir.replace("\\", "\\\\") + "\\src\\Main\\res\\sun16.png");



    public static void AddingImage(){
        try {
            VeneraSmall = ImageIO.read(VeneraSmallUrl);
            VeneraNormal = ImageIO.read(VeneraNormalUrl);
            VeneraBig = ImageIO.read(VeneraBigUrl);
            PlanetWithAsteroidSmall = ImageIO.read(PlanetWithAsteroidSmallUrl);
            PlanetWithAsteroidNormal = ImageIO.read(PlanetWithAsteroidNormalUrl);
            PlanetWithAsteroidBig = ImageIO.read(PlanetWithAsteroidBigUrl);
            earthSmall = ImageIO.read(earthSmallUrl);
            earthNormal = ImageIO.read(earthNormalUrl);
            earthBig = ImageIO.read(earthBigUrl);
            BackGround = ImageIO.read(BackGroundUrl);
            Moon = ImageIO.read(MoonUrl);
            RedGiand = ImageIO.read(RedGiandUrl);
            Sun128 = ImageIO.read(Sun128Url);
            Sun96 = ImageIO.read(Sun96Url);
            Sun64 = ImageIO.read(Sun64Url);
            Sun32= ImageIO.read(Sun32Url);
            Sun16 = ImageIO.read(Sun16Url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
