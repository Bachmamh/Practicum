import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE;


public class PersonGenerator {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String ID;
        String FirstName;
        String LastName;
        String Title;
        int YearOfBirth;
        Boolean YesNo;
        ArrayList<People> PersonList = new ArrayList<>();

        do {
            //get person info


            ID = SafeInput.getNonZeroLenString(input, "Enter your ID");

            FirstName = SafeInput.getNonZeroLenString(input, "Enter your first name");

            LastName = SafeInput.getNonZeroLenString(input, "Enter your last name");

            Title = SafeInput.getNonZeroLenString(input, "Enter your title");

            YearOfBirth = SafeInput.getInt(input, "Enter your year of birth");

            YesNo = SafeInput.getYNConfirm(input, "Enter another name?");

            //actually create person
            People person = new People(ID, FirstName, LastName, Title, YearOfBirth);
            PersonList.add(person);
        }
        while (YesNo);

        String fileName;
        fileName = SafeInput.getNonZeroLenString(input, "Enter file name");

        //Making Text File

//        for (String p: Person)
//        {
//            System.out.println(p);
//        }
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getAbsolutePath() + "\\" + fileName + ".txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for ( People Person : PersonList)
            {
                String PersonString = Person.toString();
                writer.write(PersonString, 0, PersonString.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}