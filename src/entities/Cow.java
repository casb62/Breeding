package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cow extends Bovine {

    private List<Breed> breeds = new ArrayList<>();

    public Cow() {
    }

    public Cow(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }

    public Cow(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void addBreed(Breed breed) {
        breeds.add(breed);
    }

    public void removeBreed(Breed breed) {
        breeds.remove(breed);
    }

    /**
     * Receives a female born in the farm.
     */
    @Override
    public void declareBirth() {
        System.out.print("Digite o número da mãe desta fêmea: ");
        int idOfMother = sc.nextInt();
        char gender = 'F';
        boolean bornInFarm = true;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        String dateOfPurchase = null;
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Cow cow = new Cow(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(cow);
        db.record(bovines);
    }//End of method declareBirth.

    /**
     * Receives a female bought to the farm.
     */
    @Override
    public void declarePurchase() {
        int idOfMother = 0;
        char gender = 'F';
        boolean bornInFarm = false;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        System.out.print("Digite a data de compra desta fêmea(dd/MM/yyyy): ");
        String dateOfPurchase = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Cow cow = new Cow(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(cow);
        db.record(bovines);
    }//End of method declarePurchase.

    /**
     * Sets deadInFarm to true and keeps this bovine in file.
     */
    @Override
    public void declareDeath() {
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        for (Bovine bovine : bovines) {
            System.out.println(bovine);
        }
        System.out.println();
        System.out.print("Qual o número da fêmea que deseja declarar a morte? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setDeadInFarm(Boolean.TRUE);
                System.out.print("Digite a data de óbito da fêmea(dd/MM/yyyy): ");
                String dateOfDeath = sc.next();
                bovine.setDateOfDeath(dateOfDeath);
                System.out.println("Declarada a morte da fêmea nº " + bovine.getId() + " em " + bovine.getDateOfDeath() + ".");
                System.out.println();
            }
        }
        db.record(bovines);
    }//End of method declareDeath.

    /**
     * Sets sold to true and keeps this bovine in file.
     */
    @Override
    public void declareSale() {
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        for (Bovine bovine : bovines) {
            System.out.println(bovine);
        }
        System.out.println();
        System.out.print("Qual o número da fêmea que deseja declarar a venda? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setSold(Boolean.TRUE);
                System.out.print("Digite a data de venda da fêmea(dd/MM/yyyy): ");
                String dateOfSale = sc.next();
                bovine.setDateOfSale(dateOfSale);
                System.out.println("Declarada a venda da fêmea nº " + bovine.getId() + " em " + bovine.getDateOfSale() + ".");
                System.out.println();
            }
        }
        db.record(bovines);
    }//End of method declareSale.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fêmea nº ");
        sb.append(getId());
        sb.append(", mãe nº ");
        sb.append(getIdOfMother());
        sb.append(", nascida no dia ");
        sb.append(getDateOfBirth());
        if (getBornInFarm() == true) {
            sb.append(", na propriedade");
        } else {
            sb.append(", comprada no dia ");
            sb.append(getDateOfPurchase());
        }
        if (getBrucellosis() == true) {
            sb.append(", vacinada contra brucelose no dia ");
            sb.append(getDateOfBrucellosis());
        } else {
            sb.append(", não recebeu vacina contra brucelose");
        }
        if (getSold() == true) {
            sb.append(", vendida no dia ");
            sb.append(getDateOfSale());
            sb.append(", com ");
            sb.append(computeAge(getId(), getDateOfSale()));
            sb.append(" dias de idade.");
        }
        if (getDeadInFarm() == true) {
            sb.append(", morta no dia ");
            sb.append(getDateOfDeath());
            sb.append(", com ");
            sb.append(computeAge(getId(), getDateOfDeath()));
            sb.append(" dias de idade.");
        }
        if (getSold() == false && getDeadInFarm() == false) {
            Date date = new Date();
            String finalDate = sdf.format(date);
            sb.append(", está com ");
            sb.append(computeAge(getId(), finalDate));
            sb.append(" dias de idade.");
        }
        return sb.toString();
    }//End of method toString.
}
