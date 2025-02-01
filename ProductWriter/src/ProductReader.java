import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        String rec = " ";


        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                try (InputStream in = new BufferedInputStream(Files.newInputStream(target));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
                {

                    // Finally we can read the file LOL!
                    int aline = 0;

                    while (reader.ready()) {
                        rec = reader.readLine();
                        aline++;
                        // echo to screen
                        System.out.printf("\n %4d %-60s ", aline, rec);
                    }
                    System.out.println("\n\nData file read!");
                }
                while (inFile.hasNextLine()) ;
                {
                    line = inFile.nextLine();
                    System.out.println(line);
                }
                inFile.close();
            } else {
                System.out.println("Sorry, you must select a file. Terminating.");
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}