import javax.swing.*;
import java.awt.*;


public class StudUI extends JFrame {
    panel P;

    StudUI(People student)
    {
        //image icon
        Image logo = new ImageIcon("logo.png").getImage();
        setIconImage(logo);
        setTitle("Student Information");//title frame

        P = new panel(student);
        add(P);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        setResizable(false);//no resizing of frame
    }


}
