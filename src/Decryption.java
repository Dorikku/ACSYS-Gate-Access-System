import java.io.*;
import java.util.ArrayList;

public class Decryption
{
    public ArrayList<Character> shuffledList = new ArrayList<>();
    private ArrayList<Character> list = new ArrayList<>();
    int key;


    public void retrieveDec()
    {
        char firstCharacter = '\0'; // Variable to store the first character, initialized with null character
        String filePath = "C:/MainFile/school/2ndSem/ProgrammingLanguage/Outputs/Student-Gate-Access-System-in-Java/key.tj"; // Replace with the actual path to your text file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            // Read the first line and parse it as an integer
            String numberLine = reader.readLine();
            key = Integer.parseInt(numberLine);

            //Read the second line character by character
            String charLine = reader.readLine();
            for (int i = 0; i < charLine.length(); i++) {
                shuffledList.add(charLine.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        char character = ' ';
        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
    }

    public String decrypt(String encrypted)
    {
        char[] data = encrypted.toCharArray();

        for (int i = 0; i < data.length; i++) {
            data[i] -= key;
        }

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < shuffledList.size(); j++){
                if (data[i] == shuffledList.get(j)) {
                    data[i] = list.get(j);
                    break;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (char datum : data) {
            s.append(datum);
        }

        return s.toString();
    }
}