import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTest {
    public static String readFile(String filename) {
        StringBuilder resultRead = new StringBuilder();
        StringBuilder result = new StringBuilder();
        try(InputStream inputStream = new FileInputStream(filename)) {
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                resultRead.append((char) b);
            }
            int marker= 0;
            while (resultRead.length()>marker) {
                result.append(Character.toString(Integer.parseInt(resultRead.substring(marker,marker+7),2)));
                marker+=7;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("/Users/artembelmeha/Desktop/15.txt"));
    }
}
