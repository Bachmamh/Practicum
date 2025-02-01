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
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String ID;
        String Name;
        String Description;
        double Cost;
        Boolean YesNo;
        ArrayList<Products> ProductList = new ArrayList<>();

        do {

            ID = SafeInput.getNonZeroLenString(input, "Enter product ID");

            Name = SafeInput.getNonZeroLenString(input, "Enter product name");

            Description = SafeInput.getNonZeroLenString(input, "Enter product description");

            Cost = SafeInput.getDouble(input, "Enter product cost");

            YesNo = SafeInput.getYNConfirm(input, "Enter another product?");


            Products Product = new Products(ID, Name, Description, Cost);
            ProductList.add(Product);
        }
        while (YesNo);

        String fileName;
        fileName = SafeInput.getNonZeroLenString(input, "Enter file name");


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getAbsolutePath() + "\\" + fileName + ".txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for ( Products Product : ProductList)
            {
                String ProductString = Product.toString();
                writer.write(ProductString, 0, ProductString.length());
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
