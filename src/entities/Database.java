package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Database {

    private final Path path1 = Paths.get("C:/Users/Battistuzzo/Documents/NetBeansProjects/Breeding/src/util/sequence.txt");
    private final Charset utf8a = StandardCharsets.UTF_8;

    /**
     * Method that returns next bovine's number to be recorded.
     *
     * @return
     */
    public static int getSequence() {
        File file = new File("C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\sequence.txt");
        Scanner sc = null;
        int sequence = 0;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sequence = Integer.parseInt(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return sequence;
    }//End of getSequence method.

    /**
     * Method that records the current bovine's number.
     *
     * @param id
     */
    public static void setSequence(Integer id) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\sequence.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(id.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of setSequence method.
}
