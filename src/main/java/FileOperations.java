import java.io.*;

public class FileOperations {

    public static String readFile(String filePath) throws IOException {
        String fileContents = "";

        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        while ((line = reader.readLine()) != null) {
            fileContents += line + "\n";
        }

        fr.close();
        reader.close();

        return fileContents;
    }
}