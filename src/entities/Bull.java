package entities;

public class Bull extends Bovine {

    public Bull(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfObit, dateOfSale);
    }

    public Bull(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfObit, dateOfSale);
    }
    
    //@Override
    public void declararCompra() {

    }

    @Override
    public void declararMorte() {

    }

    @Override
    public void declararVenda() {

    }
}
