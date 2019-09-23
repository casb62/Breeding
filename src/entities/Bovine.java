package entities;

import java.util.Date;

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
    private String dateOfObit;
    private String dateOfSale;
    //private double peso;
    //private double valor;
    //Pode ter um atributo que chama outra classe: Classe variável = new classe().

    public Bovine(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        this.id = ++sequence;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfObit = dateOfObit;
        this.dateOfSale = dateOfSale;
        Database.setSequence(this.id);
    }

    public Bovine(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        this.id = id;
        this.idOfMother = idOfMother;
        this.gender = gender;
        this.bornInFarm = bornInFarm;
        this.brucellosis = brucellosis;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfBirth = dateOfBirth;
        this.dateOfBrucellosis = dateOfBrucellosis;
        this.dateOfObit = dateOfObit;
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

    public String getDateOfObit() {
        return dateOfObit;
    }

    public void setDateOfObit(String dateOfObit) {
        this.dateOfObit = dateOfObit;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public abstract void declararMorte();

    public abstract void declararVenda();
}
