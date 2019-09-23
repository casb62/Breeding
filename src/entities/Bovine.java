package entities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    private String dateOfBrucellosis;
    private String dateOfDeath;
    private String dateOfSale;
    //private double peso;
    //private double valor;
    //Pode ter um atributo que chama outra classe: Classe variável = new classe().

    public Bovine() {
    }

    public Bovine(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        this.id = ++sequence;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfDeath = dateOfDeath;
        this.dateOfSale = dateOfSale;
        Database.setSequence(this.id);
    }

    public Bovine(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        this.id = id;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
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
    
    public static int computeAge(int id){
        int idadeInt = 0;
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dn = sdf.parse(bovine.getDateOfBirth());
                    long dataNascimento = dn.getTime();
                    Date date = new Date();
                    long dataAtual = date.getTime();
                    long idade = ((dataAtual - dataNascimento) / (1000 * 60 * 60 * 24)) + 1;
                    idadeInt = (int) idade;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return idadeInt;
    }//End of method computeAge.
    
    public abstract void declareBirth();
    
    public abstract void declarePurchase();

    public abstract void declareDeath();

    public abstract void declareSale();
}
