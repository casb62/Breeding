package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {

    public Database() {
    }

    /**
     * Receives a list of bovines and records it to the file.
     * @param bovines
     */
    public void recordBovines(List<Bovine> bovines) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\bovines.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Bovine bovine : bovines) {
                bw.write(bovine.getId() + ";" + bovine.getIdOfMother() + ";" + bovine.getGender() + ";" + bovine.getBornInFarm() + ";" + bovine.getBrucellosis() + ";" + bovine.getDeadInFarm() + ";" + bovine.getSold() + ";" + bovine.getDateOfBirth() + ";" + bovine.getDateOfPurchase() + ";" + bovine.getDateOfBrucellosis() + ";" + bovine.getDateOfDeath() + ";" + bovine.getDateOfSale() + ";" + bovine.getCauseOfDeath() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method recordBovines.
    
    /**
     * Receives a list of users and records it to the file.
     * @param users
     */
    public void recordUsers(List<User> users){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\users.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(User user: users){
                bw.write(user.getCpf() + ";" + user.getPassword() + ";" + user.getName() + ";" + user.getUserValidated() + ";");
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }//End of method recordUsers.
    
    /**
     * Receives a list of farms and records it to the file.
     * @param farms
     */
    public void recordFarms(List<Farm> farms){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\farms.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(Farm farm: farms){
                bw.write(farm.getId() + ";" + farm.getName() + ";" + farm.getStateRegistry() + ";" + farm.getOwner() + ";" + farm.getCpfOwner() + ";" + farm.getCounty() + ";" + farm.getState() + ";");
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }//End of method recordFarms.

    /**
     * Recovers all bovines from the file.
     * @return
     */
    public List<Bovine> recoverBovines() {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\bovines.txt";
        List<Bovine> bovines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] t = line.split(";");
                if (t[2].charAt(0) == 'M') {
                    Bull bull = new Bull(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), Boolean.parseBoolean(t[3]), Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), t[7], t[8], t[9], t[10], t[11], t[12]);
                    bovines.add(bull);
                } else if (t[2].charAt(0) == 'F') {
                    Cow cow = new Cow(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), Boolean.parseBoolean(t[3]), Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), t[7], t[8], t[9], t[10], t[11], t[12]);
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
     * Recovers all users from the file.
     * @return
     */
    public List<User> recoverUsers(){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\users.txt";
        List<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] t = line.split(";");
                User user = new User(t[0],t[1],t[2],Boolean.parseBoolean(t[3]));
                users.add(user);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }//End of method recoverUsers.
    
    /**
     * Recovers all farms from the file.
     * @return
     */
    public List<Farm> recoverFarms(){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\farms.txt";
        List<Farm> farms = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] t = line.split(";");
                Farm farm = new Farm(Integer.parseInt(t[0]),t[1],t[2],t[3],t[4],t[5],t[6]);
                farms.add(farm);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return farms;
    }//End of method recoverFarms.
    
    /**
     * Method that returns next bovine's number to be recorded.
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
    }//End of method getSequence.

    /**
     * Method that records the current bovine's number.
     * @param id
     */
    public static void setSequence(Integer id) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\sequence.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(id.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method setSequence.
}