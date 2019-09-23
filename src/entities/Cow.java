package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cow extends Bovine {

    private List<Breed> breeds = new ArrayList<>();

    public Cow() {
    }
    
    public Cow(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }

    public Cow(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }
    
    Scanner sc = new Scanner(System.in);
    
    public List<Breed> getBreeds() {
        return breeds;
    }

    public void addBreed(Breed breed) {
        breeds.add(breed);
    }

    public void removeBreed(Breed breed) {
        breeds.remove(breed);
    }

    @Override
    public void declareBirth() {
        System.out.print("Digite o número da mãe desta fêmea: ");
        int idOfMother = sc.nextInt();
        char gender = 'F';
        boolean bornInFarm = true;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea: ");
        String dateOfBirth = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Cow cow = new Cow(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(cow);
        db.record(bovines);
    }//End of method declareBirth.

    @Override
    public void declarePurchase() {
        int idOfMother = 0;
        char gender = 'F';
        boolean bornInFarm = false;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea: ");
        String dateOfBirth = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Cow cow = new Cow(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(cow);
        db.record(bovines);
    }//End of method declarePurchase.

    public void declareDeath() {

    }
    
    public void declareSale(){
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fêmea nº ");
        sb.append(getId());
        sb.append(", filha da vaca nº ");
        sb.append(getIdOfMother());
        sb.append(", nascida em ");
        sb.append(getDateOfBirth());
        sb.append(", tem ");
        sb.append(computeAge(getId()));
        sb.append(" dias de idade.");
        return sb.toString();
    }
}
