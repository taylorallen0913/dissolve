import java.io.*;

/**
 * This is a utility class utilized to do common file operations that is needed
 * for the editor.
 * 
 * @author Taylor Allen
 */
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

    public static void writeToFile(String filePath, String content) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(content);
        fw.close();
    }

}