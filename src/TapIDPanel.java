import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TapIDPanel extends JPanel implements ActionListener{

    Image card, backgroundImage, wave1, wave2;
    int x = 140, y = 200;
    double xScale = 1, yScale = 1;
    double scaleValue = 0.0015;
    boolean setVisible = false;
    Timer timer;

    TapIDPanel() {
        setPreferredSize(new Dimension(500,400));
        setBackground(new Color(0xf6e8e8));

        card = new ImageIcon("handcard.png").getImage();
        backgroundImage = new ImageIcon("bg.png").getImage();
        wave1 = new ImageIcon("wave1.png").getImage();
        wave2 = new ImageIcon("wave2.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); // paint background
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(backgroundImage, 0, 0,null);

        if (setVisible) {
            g2d.drawImage(wave1,50,150,null);
            g2d.drawImage(wave2, 400,150,null);
        }

        g2d.rotate(-0.28);
        g2d.scale(xScale,yScale);

        g2d.drawImage(card, x, y, 223, 338, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (xScale > 1)
            scaleValue *= -1;
        else if (xScale > 0.88)
            setVisible = false;
        else if (xScale < 0.855)
            setVisible = true;

        if (xScale < 0.85)
            scaleValue *= -1;

        xScale -= scaleValue;
        yScale -= scaleValue;

        repaint();
    }
}
