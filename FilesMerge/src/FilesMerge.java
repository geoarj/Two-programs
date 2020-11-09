import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FilesMerge {
//сначала открыть файл на запись
    // открвыть все отсальные файлы на чтение в цикле
    //читаю из файла и записываю в резалт


    private static ArrayList<File> listWithFiles = new ArrayList<>();
    static int inside;

    public static void main(String[] args) throws IOException {
        getListFiles("/Users/dhakon/Desktop/Test");

        try (FileWriter writer = new FileWriter("/Users/dhakon/Desktop/Test/result.txt", false)) {
            for (File txt : listWithFiles) {
                String result = txt.getName();
                if (result.contains("result.txt"))
                    continue;
                if (result.contains(".txt") || result.contains(".TXT")) {
                    try (FileReader reader = new FileReader(txt)) {
                        while ((inside = reader.read()) != -1) {
                            //System.out.println((char) inside); //
                            writer.append((char) inside);
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println(txt.getName());
                }
            }
            writer.flush();
            writer.close();
            System.out.println("Written successfully");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void getListFiles(String s) {
        File f = new File(s);
        for (File n : f.listFiles()) {
            if (n.isFile()) {
                listWithFiles.add(n);
            } else if (n.isDirectory()) {
                getListFiles(n.getAbsolutePath());
            }
        }
    }
}
