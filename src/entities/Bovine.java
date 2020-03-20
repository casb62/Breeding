package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Bovine {

    private static int sequence = Database.getSequence();

    private Integer id;
    private Integer idOfMother;
    private Character gender;
    private Boolean bornInFarm;
    private Boolean brucellosis;
    private Boolean deadInFarm;
    private Boolean sold;
    private String dateOfBirth;
    private String dateOfPurchase;
    private String dateOfBrucellosis;
    private String dateOfDeath;
    private String dateOfSale;
    //private double peso;
    //private double valor;
    //Pode ter um atributo que chama outra classe: Classe variável = new classe().

    public Bovine() {
    }

    public Bovine(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        this.id = ++sequence;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfDeath = dateOfDeath;
        this.dateOfSale = dateOfSale;
        Database.setSequence(this.id);
    }

    public Bovine(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        this.id = id;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfDeath = dateOfDeath;
        this.dateOfSale = dateOfSale;
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getIdOfMother() {
        return idOfMother;
    }

    public void setIdOfMother(Integer idOfMother) {
        this.idOfMother = idOfMother;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Boolean getBornInFarm() {
        return bornInFarm;
    }

    public void setBornInFarm(Boolean bornInFarm) {
        this.bornInFarm = bornInFarm;
    }

    public Boolean getBrucellosis() {
        return brucellosis;
    }

    public void setBrucellosis(Boolean brucellosis) {
        this.brucellosis = brucellosis;
    }

    public Boolean getDeadInFarm() {
        return deadInFarm;
    }

    public void setDeadInFarm(Boolean deadInFarm) {
        this.deadInFarm = deadInFarm;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDateOfBrucellosis() {
        return dateOfBrucellosis;
    }

    public void setDateOfBrucellosis(String dateOfBrucellosis) {
        this.dateOfBrucellosis = dateOfBrucellosis;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    /**
     * Receives a bovine's id and a final date to compute age. Returns an age.
     * @param id
     * @param date
     * @return
     */
    public static int computeAge(int id, String date) {
        int ageInt = 0;
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dob = sdf.parse(bovine.getDateOfBirth());
                    long dateOfBirth = dob.getTime();
                    Date fd = sdf.parse(date);
                    long finalDate = fd.getTime();
                    long age = ((finalDate - dateOfBirth) / (1000 * 60 * 60 * 24)) + 1;
                    ageInt = (int) age;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return ageInt;
    }//End of method computeAge.
    
    /**
     * Receives a bovine's id and shows its data.
     */
    public static void searchBovine() {
        System.out.print("\nDigite o número do animal que deseja pesquisar: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                System.out.println(bovine);
            }
        }
    }//End of method searchBovine.

    public abstract void declareBirth();

    public abstract void declarePurchase();

    public abstract void declareDeath();

    public abstract void declareSale();
}
