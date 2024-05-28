import java.io.*;
import java.sql.BatchUpdateException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    static InFrame inFrame = new InFrame();
    public static List <People> list = new LinkedList<People>();
    static List <Log> loglist = new LinkedList<Log>();
    static People nygard = new People();
    static String TUPid;
    static DateTime dateTime = new DateTime();
    static StudUI studUI;
    public static Decryption decryption = new Decryption();

    public static void main(String[] args) {

        LoadingScreen loadingScreen = new LoadingScreen();
        TapIDFrame tapIDFrame = new TapIDFrame();
        createLogs_list();
        retrieve();

        while (true) {
            if (found()) {
                Log tmp = new Log();
                File fp = new File("D:/dataID.txt");

                try {
                    TUPid = new Scanner(fp).nextLine();
                } catch (FileNotFoundException | NoSuchElementException ignored) {}

                if (searchID(TUPid)) {
                    try {
                        studUI.setVisible(false);
                    }
                    catch (NullPointerException ignored){}
                    //System.out.println(nygard.id);
                    studUI = new StudUI(nygard);

                    studUI.setVisible(true);

                    if (checkID(nygard.id))
                        tmp.type = "OUT";
                    else tmp.type = "IN";
                    inFrame.type = tmp.type;
                    studUI.P.setType(tmp.type);

                    studUI.repaint();

                    tmp.id = nygard.id;
                    tmp.date = dateTime.getDate();
                    tmp.time = dateTime.getTIme();

                    loglist.add(tmp);
                    saveLogs(tmp);
                }

                inFrame.setVisible(true);
                inFrame.pause(3000);
                inFrame.dispose();
            }
        }
    }

    private static boolean checkID(String id) {
        int counter = 0;

        for (Log p:loglist) {
            if (id.equals(p.id)) {
                counter++;
            }
        }

        return (counter % 2) != 0;
    }

    public static boolean found() {
        boolean ioExceptionOccurred = false;

        do {
            try {
                FileWriter fp = new FileWriter("D:/detect.txt");
                fp.close();
            } catch (IOException e) {
                ioExceptionOccurred = true;
                return false;
            }
        } while (ioExceptionOccurred);

        return true;
    }

    public static void retrieve() {
        //String filePath = "C:/MainFile/school/2ndSem/ProgrammingLanguage/Outputs/adminSystem/mainDB.txt";
        String filePath = "mainDB.txt";
        //String filePath = "C:/try/mainDB.txt";

        decryption.retrieveDec();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");

                    People tmp = new People();
                    tmp.name = decryption.decrypt(data[0].trim());
                    tmp.course = decryption.decrypt(data[1].trim());
                    tmp.gs = decryption.decrypt(data[2].trim());
                    tmp.id = decryption.decrypt(data[3].trim());
                    tmp.contact = decryption.decrypt(data[4].trim());
                    tmp.address = decryption.decrypt(data[5].trim());

                    list.add(tmp);
                    //System.out.println(tmp.name);

            }
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }
    }
    
    static boolean searchID(String id) {
        for (People p : list) {
            //System.out.println(p.id);
            if (p.id.equals(id)) {
                nygard = p;
                return true;
            }
        }
        System.out.println(nygard.id);
        return false;
    }

    static void createLogs_list() {
        String date = new DateTime().getDate();
        String file_name = date.replace('/','-') + ".txt";

        try {
            File fp = new File(file_name);

            if (!fp.exists()) {
                fp.createNewFile();
            }

            Scanner scan = new Scanner(fp);
            scan.useDelimiter("\t");

            while (scan.hasNextLine()) {
                Log temp = new Log();

                temp.id = scan.next();
                temp.date = scan.next();
                temp.time = scan.next();
                temp.type = scan.nextLine();

                loglist.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void saveLogs(Log b) {
        String content = b.id + "\t" + b.date + "\t" + b.time + "\t" + b.type + "\n";
        String file_name = b.date.replace('/','-') + ".txt";

        try {
            FileWriter fp = new FileWriter(file_name,true);
            fp.write(content);
            fp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class People{
    String name,course, id, gs, contact, address;
}

class Log {
    String id, date, time, type;
}

