package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Bovine {

    private static int sequence = Database.getSequence();

    private Integer id;
    private Integer idOfMother;
    private Character gender;
    private String race;
    private Boolean bornInFarm;
    private Boolean brucellosis;
    private Boolean deadInFarm;
    private Boolean sold;
    private String dateOfBirth;
    private String dateOfPurchase;
    private String dateOfBrucellosis;
    private String dateOfDeath;
    private String dateOfSale;
    private String causeOfDeath;
    //private double peso;
    //private double valor;
    //Pode ter um atributo que chama outra classe: Classe variável = new classe().

    public Bovine() {
    }

    public Bovine(Integer idOfMother, Character gender, String race, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale, String causeOfDeath) {
        this.id = ++sequence;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.race = race;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfDeath = dateOfDeath;
        this.dateOfSale = dateOfSale;
        this.causeOfDeath = causeOfDeath;
        Database.setSequence(this.id);
    }

    public Bovine(Integer id, Integer idOfMother, Character gender, String race, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale, String causeOfDeath) {
        this.id = id;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.race = race;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfDeath = dateOfDeath;
        this.dateOfSale = dateOfSale;
        this.causeOfDeath = causeOfDeath;
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
    
    public String getRace(){
        return race;
    }
    
    public void setRace(String race){
        this.race = race;
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

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
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
     * Receives a bovine's id and adds its data to a list to be printed.
     */
    public static List<Bovine> getBovine() {
        System.out.print("\nDigite o número do animal que deseja pesquisar: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        List<Bovine> selectedBovines = new ArrayList<>();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                selectedBovines.add(bovine);
            }
        }
        return selectedBovines;
    }//End of method getBovine.
    
    /**
     * It searchs animals by race in the file and adds their data to a list to be printed.
     */
    public static List<Bovine> getByRace(){
        System.out.print("\nDigite a raça que deseja pesquisar: ");
        Scanner sc = new Scanner(System.in);
        String race = sc.nextLine();
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        List<Bovine> selectedBovines = new ArrayList<>();
        for(Bovine bovine: bovines){
            if(bovine.getDeadInFarm() == false && bovine.getSold() == false && bovine.getRace().equals(race)){
                selectedBovines.add(bovine);
            }  
        }
        return selectedBovines;
    }//End of method getByRace.
    
    /**
     * It catches all bovines in the file and prints their data.
     * @param bovines
     */
    public static void printBovines(List<Bovine> bovines){
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| nº |sexo|     raça     | mãe |nascido na fazenda|data de nascimento| idade |brucelose|    data    | idade |comprado|    data    | idade | morto |    data    | idade |   causa da morte   | vendido |    data    | idade |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Bovine bovine: bovines) {
            Date date = new Date();
            String finalDate = sdf.format(date);
            int idade = Bovine.computeAge(bovine.getId(), finalDate);
            Boolean purchased = false;
            int brucAge = 0;
            if(bovine.getDateOfBrucellosis().equals("null")) {
                brucAge = 0;
            }else{
                brucAge = Bovine.computeAge(bovine.getId(), bovine.getDateOfBrucellosis());
            }
            if (bovine.getBornInFarm().equals(false)) {
                purchased = true;
            }else if(bovine.getBornInFarm().equals(true)){
                purchased = false;
            }
            int purchaseAge = 0;
            if(bovine.getDateOfPurchase().equals("null")){
                purchaseAge = 0;
            }else{
                purchaseAge = Bovine.computeAge(bovine.getId(), bovine.getDateOfPurchase());
            }
            int deathAge = 0;
            if(bovine.getDateOfDeath().equals("null")){
                deathAge = 0;
            }else{
                deathAge = Bovine.computeAge(bovine.getId(), bovine.getDateOfDeath());
            }
            int saleAge = 0;
            if(bovine.getDateOfSale().equals("null")){
                saleAge = 0;
            }else{
                saleAge = Bovine.computeAge(bovine.getId(), bovine.getDateOfSale());
            }
            System.out.print(String.format("%3s%5s%15s%6s%14s%22s%11s%9s%14s%7s%9s%14s%7s%9s%13s%7s%23s%8s%14s%7s\n",bovine.getId(),bovine.getGender(),bovine.getRace(),bovine.getIdOfMother(),bovine.getBornInFarm(),bovine.getDateOfBirth(),idade,bovine.getBrucellosis(),
            bovine.getDateOfBrucellosis(),brucAge,purchased,bovine.getDateOfPurchase(),purchaseAge,bovine.getDeadInFarm(),bovine.getDateOfDeath(),deathAge,bovine.getCauseOfDeath(),bovine.getSold(),bovine.getDateOfSale(),saleAge));
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println("\nTotal: " + bovines.size() + " animais.");
    }//End of method printBovines.

    public abstract void declareBirth();

    public abstract void declarePurchase();

    public abstract void declareDeath();

    public abstract void declareSale();
}