package entities;

import java.util.ArrayList;
import java.util.List;

public class Cow extends Bovine {

    private List<Breed> breeds = new ArrayList<>();

    public Cow(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfObit, dateOfSale);
    }

    public Cow(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfBrucellosis, String dateOfObit, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfBrucellosis, dateOfObit, dateOfSale);
    }
    
    public List<Breed> getBreeds() {
        return breeds;
    }

    public void addBreed(Breed breed) {
        breeds.add(breed);
    }

    public void removeBreed(Breed breed) {
        breeds.remove(breed);
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
