package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cow extends Bovine {

    private Boolean brucellosis;
    private List<Breed> breeds = new ArrayList<>();

    public Cow(Character gender, Date dateOfBirth, Integer idOfMother, Boolean bornInFarm, Boolean deadInFarm, Boolean sold, Date dateOfObit, Date dateOfSale, Boolean brucellosis) {
        super(gender, dateOfBirth, idOfMother, bornInFarm, deadInFarm, sold, dateOfObit, dateOfSale);
        this.brucellosis = brucellosis;
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
