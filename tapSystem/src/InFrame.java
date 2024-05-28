import javax.swing.*;
import java.awt.*;

public class InFrame extends JFrame {

    JPanel inPanel = new JPanel();
    String type="";
    Image blink1, blink2;
    InFrame() {
        Image logo = new ImageIcon("logo.png").getImage();
        blink1 = new ImageIcon("blink1.png").getImage();
        blink2 = new ImageIcon("blink2.png").getImage();

        inPanel.setPreferredSize(new Dimension(500,400));
        inPanel.setBackground(new Color(0xf6e8e8));


        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(inPanel);
        pack();
        setLocation(850,60);
        setLayout(null);
        setTitle("Tap ID");
        setIconImage(logo);
        setVisible(false);



    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = 100, y = 62;

        g2d.setStroke(new BasicStroke(100));
        g2d.setFont(new Font("Arial", Font.BOLD,100));

        if (type.equals("IN")) {
            g2d.setPaint(new Color(0,150,0));
            // Display word "IN"
            g2d.drawString(type,200,240);
        }
        else if (type.equals("OUT")) {
            g2d.setPaint(new Color(200,0,0));
            // Display word "IN"
            g2d.drawString(type,150,240);
        }
        else {
            g2d.setPaint(new Color(0xC4203A));
            g2d.drawRect(0,0,500,400);

            g2d.drawImage(blink1,x,y,null);
            pause(600);

            g2d.drawImage(blink2,x,y,null);
            pause(600);

            g2d.drawImage(blink1,x,y,null);
            pause(600);
        }

        //Draw green rectangle outline
        g2d.drawRect(0,0,500,400);


    }

    void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
