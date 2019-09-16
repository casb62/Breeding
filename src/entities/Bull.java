package entities;

import java.util.Date;

public class Bull extends Bovine {

    public Bull(Character gender, Date dateOfBirth, Integer idOfMother, Boolean bornInFarm, Boolean deadInFarm, Boolean sold, Date dateOfObit, Date dateOfSale) {
        super(gender, dateOfBirth, idOfMother, bornInFarm, deadInFarm, sold, dateOfObit, dateOfSale);
    }

    @Override
    public void declararCompra() {

    }

    @Override
    public void declararMorte() {

    }

    @Override
    public void declararVenda() {

    }
}
