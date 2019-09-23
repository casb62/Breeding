package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    //private final Path path1 = Paths.get("C:/Users/Battistuzzo/Documents/NetBeansProjects/Breeding/src/util/bovines.txt");
    //private final Charset utf8a = StandardCharsets.UTF_8;

    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Receives a list of bovines and record it to a file.
     *
     * @param bovines
     */
    public void record(List<Bovine> bovines) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\bovines.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Bovine bovine: bovines) {
                bw.write(bovine.getId() + ";" + bovine.getIdOfMother() + ";" + bovine.getGender() + ";" + bovine.getBornInFarm() + ";" + bovine.getDeadInFarm() + ";" + bovine.getSold() + ";" + bovine.getBrucellosis() + ";" + bovine.getDateOfBirth() + ";" + bovine.getDateOfObit() + ";" + bovine.getDateOfSale() + ";" + bovine.getDateOfBrucellosis() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method record.

    /**
     * Recovers all bovines from file.
     *
     * @return
     */
    public List<Bovine> recover() {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\bovines.txt";
        List<Bovine> bovines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] t = line.split(";");
                if (t[2].charAt(0) == 'M') {
                    Bull bull = new Bull(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), Boolean.parseBoolean(t[3]), Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), t[7], t[8], t[9], t[10]);
                    bovines.add(bull);
                } else if (t[2].charAt(0) == 'F') {
                    Cow cow = new Cow(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), Boolean.parseBoolean(t[3]), Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), t[7], t[8], t[9], t[10]);
                    bovines.add(cow);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        return bovines;
    }//End of method recoverBovines.

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
