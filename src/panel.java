import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class panel extends JPanel {
    private Image bg = new ImageIcon("bg2.png").getImage();
    private Image image;
    Font LeagueSpartan;
    Font GlacialBold, GlacialRegular;
    public String surname,type;
    String fName = "";
    String filename;
    People people = new People();

    panel(People student)
    {
        this.setPreferredSize(new Dimension(840,504));
        System.out.println(student.id);
        //filename = "C:/MainFile/school/2ndSem/ProgrammingLanguage/Outputs/Student-Gate-Access-System-in-Java/ID Photos/" + student.id;
        filename = student.id;

        try {
            image = new ImageIcon(filename + ".png").getImage();

        } catch (Exception e) {
            image = new ImageIcon(filename + ".jpg").getImage();

        }

        String [] nameParts = student.name.split(" ");
        surname = nameParts[nameParts.length - 1].toUpperCase();

        for (int i = 0; i < nameParts.length -1; i++) {
            fName = fName.concat(nameParts[i]);
            fName = fName.concat(" ");
        }
        people = student;
    }
    public void setType(String t) {
        type = t;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        includeTheseFonts();
        // Draw the background image
        g2d.drawImage(bg, 0, 0, null);
        g2d.drawImage(image, 82,126,251,251,null);

        g2d.setFont(LeagueSpartan.deriveFont(50f));
        g2d.setPaint(new Color(0xC4203A));//text color
        g2d.drawString(surname,400,170);//should be variable to be changed

        g2d.setFont(GlacialRegular.deriveFont(35f));
        g2d.setPaint(new Color(0xC4203A));//text color
        g2d.drawString(fName,402,200);//should be variable to be changed

        g2d.setFont(GlacialRegular.deriveFont(15f));
        g2d.setPaint(new Color(0xC8754B));//text color
        g2d.drawString(people.id,403,215);//should be variable to be changed

        g2d.setFont(GlacialBold.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString("YR. & SECTION",403,275);

        g2d.setFont(GlacialRegular.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString(people.gs,403,300);//should be variable to be changed

        g2d.setFont(GlacialBold.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString("ADDRESS",403,350);

        g2d.setFont(GlacialRegular.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString(people.address,403,375);//should be variable to be changed

        g2d.setFont(GlacialBold.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString("CONTACT",650,350);

        g2d.setFont(GlacialRegular.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString(people.contact,650,375);//should be variable to be changed

        g2d.setFont(GlacialBold.deriveFont(25f));
        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString("STATUS :",135,450);

        g2d.setFont(GlacialBold.deriveFont(25f));
        g2d.setPaint(new Color(0xC8754B));//text color
        g2d.drawString(type,250,450);//should be variable to be changed


        // ------------------------- TIME ----------------------
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String timeString = currentTime.format(formatter);

        g2d.setPaint(new Color(0x6B1623));//text color
        g2d.drawString("TIME : ",403,450);

        g2d.setPaint(new Color(0xC8754B));//text color
        g2d.drawString(timeString,480,450);

    }

    private void includeTheseFonts() {
        try{
            LeagueSpartan = Font.createFont(Font.TRUETYPE_FONT,new File("LeagueSpartan-Bold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LeagueSpartan-Bold.otf")));

            GlacialRegular = Font.createFont(Font.TRUETYPE_FONT,new File("GlacialIndifference-Regular.otf")).deriveFont(35f);
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GlacialIndifference-Regular.otf")));

            GlacialBold = Font.createFont(Font.TRUETYPE_FONT,new File("GlacialIndifference-Bold.otf")).deriveFont(25f);
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GlacialIndifference-Bold.otf")));
        }
        catch(IOException | FontFormatException exception) {}
    }
}