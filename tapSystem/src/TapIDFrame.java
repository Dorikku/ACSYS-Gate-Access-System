import javax.swing.*;
import java.awt.*;

public class TapIDFrame extends JFrame {
    TapIDFrame() {
        Image logo = new ImageIcon("logo.png").getImage();
        TapIDPanel panel = new TapIDPanel();

        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);

        pack();
        setLocation(850,60);
        setLayout(null);
        setTitle("Tap ID");
        setIconImage(logo);
        setVisible(true);
    }
}
