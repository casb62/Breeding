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
     * Receives a list of addresses and records it to the file.
     *
     * @param addresses
     */
    public void recordAddresses(List<Address> addresses) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\addresses.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Address address : addresses) {
                bw.write(address.getType() + ";" + address.getPublicPlace() + ";" + address.getNumber() + ";" + address.getComplement() + ";" + address.getMailbox() + ";" + address.getNeighborhood() + ";" + address.getCity() + ";" + address.getState() + ";" + address.getCountry() + ";" + address.getCep() + ";" + address.getCoordinates() + ";" + address.getFone() + ";" + address.getFax() + ";" + address.getEmail() + ";" + address.getPersonId() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method recordAddresses.

    /**
     * Receives a list of bovines and records it to the file.
     *
     * @param bovines
     */
    public void recordBovines(List<Bovine> bovines) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\bovines.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Bovine bovine : bovines) {
                bw.write(bovine.getId() + ";" + bovine.getIdOfMother() + ";" + bovine.getGender() + ";" + bovine.getRace() + ";" + bovine.getBornInFarm() + ";" + bovine.getBrucellosis() + ";" + bovine.getDeadInFarm() + ";" + bovine.getSold() + ";" + bovine.getDateOfBirth() + ";" + bovine.getDateOfPurchase() + ";" + bovine.getDateOfBrucellosis() + ";" + bovine.getDateOfDeath() + ";" + bovine.getDateOfSale() + ";" + bovine.getCauseOfDeath() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method recordBovines.

    /**
     * Receives a list of farms and records it to the file.
     *
     * @param farms
     */
    public void recordFarms(List<Farm> farms) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\farms.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Farm farm : farms) {
                bw.write(farm.getId() + ";" + farm.getName() + ";" + farm.getStateRegistry() + ";" + farm.getAddressId() + ";" + farm.getPersonId() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method recordFarms.

    /**
     * Receives a list of Persons and records it to the file.
     *
     * @param persons
     */
    public void recordPersons(List<Person> persons) {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\persons.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Person person : persons) {
                bw.write(person.getId() + ";" + person.getName() + ";" + person.getAddressId() + ";" + person.getFarmId() + ";" + person.getPassword() + ";" + person.getUserValidated() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//End of method recordLegalPersons.
    
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
    }//End of method setSequence.
    
    /**
     * Recovers the address from the file.
     * @return
     */
    public Address recoverAddress(){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\addresses.txt";
        Address address = null;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String[] t = line.split(";");
            address = new Address(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4],t[5],t[6],t[7],t[8],t[9],t[10],t[11],t[12],t[13],t[14],t[15]);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return address;
    }//End of method recoverAddress.

    /**
     * Recovers all addresses from the file.
     *
     * @return
     */
    public List<Address> recoverAddresses() {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\addresses.txt";
        List<Address> addresses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] t = line.split(";");
                Address address = new Address(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11], t[12], t[13], t[14],t[15]);
                addresses.add(address);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return addresses;
    }//End of method recoverAddresses.

    /**
     * Recovers all bovines from the file.
     *
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
                    Bull bull = new Bull(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), t[3], Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), Boolean.parseBoolean(t[7]), t[8], t[9], t[10], t[11], t[12], t[13]);
                    bovines.add(bull);
                } else if (t[2].charAt(0) == 'F') {
                    Cow cow = new Cow(Integer.parseInt(t[0]), Integer.parseInt(t[1]), t[2].charAt(0), t[3], Boolean.parseBoolean(t[4]), Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), Boolean.parseBoolean(t[7]), t[8], t[9], t[10], t[11], t[12], t[13]);
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
     * Recovers the farm from the file.
     * @return
     */
    public Farm recoverFarm(){
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\farms.txt";
        Farm farm = null;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            String[] t = line.split(";");
            farm = new Farm(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4]);
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return farm;
    }//End of method recoverFarm.

    /**
     * Recovers all farms from the file.
     *
     * @return
     */
    public List<Farm> recoverFarms() {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\farms.txt";
        List<Farm> farms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] t = line.split(";");
                Farm farm = new Farm(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4]);
                farms.add(farm);
                line = br.readLine();    
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return farms;
    }//End of method recoverFarms.
    
    /**
     * Recovers all persons from de file.
     *
     * @return
     */
    public List<Person> recoverPersons() {
        String path = "C:\\Users\\Battistuzzo\\Documents\\NetBeansProjects\\Breeding\\src\\util\\persons.txt";
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] t = line.split(";");
                if (t[0].length() == 18) {
                    LegalPerson lp = new LegalPerson(t[0], t[1], t[2], Integer.parseInt(t[3]), t[4], Boolean.parseBoolean(t[5]));
                    persons.add(lp);
                } else if (t[0].length() == 14) {
                    PhysicalPerson pp = new PhysicalPerson(t[0], t[1], t[2], Integer.parseInt(t[3]), t[4], Boolean.parseBoolean(t[5]));
                    persons.add(pp);
                } else if (t[0].length() == 14 && t[4] != null) {
                    User user = new User(t[0], t[1], t[2], Integer.parseInt(t[3]), t[4], Boolean.parseBoolean(t[5]));
                    persons.add(user);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return persons;
    }//End of method recoverPersons.

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
    }//End of method getSequence.
    
    public static void conection(Address address){
        Database db = new Database();
        List<Address> addresses = db.recoverAddresses();
        addresses.add(address);
        db.recordAddresses(addresses);
    }
    
    public static void conection(Bull bull){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        bovines.add(bull);
        db.recordBovines(bovines);
    }
    
    public static void conection(Cow cow){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        bovines.add(cow);
        db.recordBovines(bovines);
    }
    
    public static void conection(Farm farm){
        Database db = new Database();
        List<Farm> farms = db.recoverFarms();
        farms.add(farm);
        db.recordFarms(farms);
    }
    
    public static void conection(Person person){
        Database db = new Database();
        List<Person> persons = db.recoverPersons();
        persons.add(person);
        db.recordPersons(persons);
    }
}
