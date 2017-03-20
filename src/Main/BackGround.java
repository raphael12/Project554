import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class BackGround extends JPanel {
    public void paintComponent(Graphics g) {
        Image im = null;
        try {
            im = ImageIO.read(new File("sky2.GIF"));
        } catch (IOException e) {
        }
        g.drawImage(im, 0, 0, null);
    }
}

