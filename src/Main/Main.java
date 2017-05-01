import javax.swing.*;

public class Main {
    public static void main(String[] args){
        EarthMoving.AddingImage();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame.Frame();
            }
        });

    }
}
