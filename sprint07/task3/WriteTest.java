import java.io.*;
import java.nio.file.Paths;

public class WriteTest {
    public static void writeFile(String filename, String text) {
        try(OutputStream outputStream = new FileOutputStream(filename)) {
            StringBuilder result = new StringBuilder();
            char[] chars = text.toCharArray();
            for (char aChar : chars) {
                result.append(
                        String.format("%7s", Integer.toBinaryString(aChar))
                                .replaceAll(" ", "0")
                );
            }
            outputStream.write(String.valueOf(result).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        writeFile("/Users/artembelmeha/Desktop/15.txt",
                "Example of text for test case #1");
    }

}

