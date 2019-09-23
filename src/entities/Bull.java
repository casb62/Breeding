package entities;

import java.util.List;
import java.util.Scanner;

public class Bull extends Bovine {

    public Bull() {
    }
    
    public Bull(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }

    public Bull(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void declareBirth(){
        System.out.print("Digite o número da mãe deste macho: ");
        int idOfMother = sc.nextInt();
        char gender = 'M';
        boolean bornInFarm = true;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento deste macho: ");
        String dateOfBirth = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Bull bull = new Bull(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(bull);
        db.record(bovines);
    }//End of method declareBirth.
    
    @Override
    public void declarePurchase() {
        int idOfMother = 0;
        char gender = 'M';
        boolean bornInFarm = false;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento deste macho: ");
        String dateOfBirth = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Bull bull = new Bull(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(bull);
        db.record(bovines);
    }//End of method declarePurchase.

    @Override
    public void declareDeath() {
        

    }

    public void declareSale() {

    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Macho nº ");
        sb.append(getId());
        sb.append(", filho da vaca nº ");
        sb.append(getIdOfMother());
        sb.append(", nascido em ");
        sb.append(getDateOfBirth());
        sb.append(", tem ");
        sb.append(computeAge(getId()));
        sb.append(" dias de idade.");
        return sb.toString();
    }
}
