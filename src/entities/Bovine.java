package entities;

import java.util.Date;

public abstract class Bovine {

    private static int sequence = Database.getSequence();

    private Integer id;
    private Character gender;
    private Date dateOfBirth;
    private Integer idOfMother;
    private Boolean bornInFarm;
    private Boolean deadInFarm;
    private Boolean sold;
    private Date dateOfObit;
    private Date dateOfSale;
    //private double peso;
    //private double valor;
    //Pode ter um atributo que chama outra classe: Classe variável = new classe().

    public Bovine(Character gender, Date dateOfBirth, Integer idOfMother, Boolean bornInFarm, Boolean deadInFarm, Boolean sold, Date dateOfObit, Date dateOfSale) {
        this.id = ++sequence;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.idOfMother = idOfMother;
        this.bornInFarm = bornInFarm;
        this.deadInFarm = deadInFarm;
        this.sold = sold;
        this.dateOfObit = dateOfObit;
        this.dateOfSale = dateOfSale;
        Database.setSequence(this.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getIdOfMother() {
        return idOfMother;
    }

    public void setIdOfMother(Integer idOfMother) {
        this.idOfMother = idOfMother;
    }

    public Boolean getBornInFarm() {
        return bornInFarm;
    }

    public void setBornInFarm(Boolean bornInFarm) {
        this.bornInFarm = bornInFarm;
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

    public Date getDateOfObit() {
        return dateOfObit;
    }

    public void setDateOfObit(Date dateOfObit) {
        this.dateOfObit = dateOfObit;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public abstract void declararCompra();

    public abstract void declararMorte();

    public abstract void declararVenda();
}
