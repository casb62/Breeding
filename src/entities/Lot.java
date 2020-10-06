package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lot {
    
    private Integer id;
    private String goal;
    private String startingDate;
    private String finalDate;
    private Double startingAliveWeight;//Use total weight of the lot.
    private Double finalAliveWeight;//Use total weight of the lot.
    private Double startingCarcassWeight;//Use total weight of the lot.
    private Double finalCarcassWeight;//Use total weight of the lot.
    private Double lotStartingValue;
    private Double lotFinalValue;
    private List<Integer> bovines;
    
    private Meadow meadow;

    public Lot() {
    }

    public Lot(Integer id, String goal, String startingDate, String finalDate, Double startingAliveWeight, Double finalAliveWeight, Double startingCarcassWeight, Double finalCarcassWeight, Double lotStartingValue, Double lotFinalValue, List<Integer> bovines, Meadow meadow) {
        this.id = id;
        this.goal = goal;
        this.startingDate = startingDate;
        this.finalDate = finalDate;
        this.startingAliveWeight = startingAliveWeight;
        this.finalAliveWeight = finalAliveWeight;
        this.startingCarcassWeight = startingCarcassWeight;
        this.finalCarcassWeight = finalCarcassWeight;
        this.lotStartingValue = lotStartingValue;
        this.lotFinalValue = lotFinalValue;
        this.bovines = bovines;
        this.meadow = meadow;
    }

    Scanner sc = new Scanner(System.in);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public Double getStartingAliveWeight() {
        return startingAliveWeight;
    }

    public void setStartingAliveWeight(Double startingAliveWeight) {
        this.startingAliveWeight = startingAliveWeight;
    }

    public Double getFinalAliveWeight() {
        return finalAliveWeight;
    }

    public void setFinalAliveWeight(Double finalAliveWeight) {
        this.finalAliveWeight = finalAliveWeight;
    }

    public Double getStartingCarcassWeight() {
        return startingCarcassWeight;
    }

    public void setStartingCarcassWeight(Double startingCarcassWeight) {
        this.startingCarcassWeight = startingCarcassWeight;
    }

    public Double getFinalCarcassWeight() {
        return finalCarcassWeight;
    }

    public void setFinalCarcassWeight(Double finalCarcassWeight) {
        this.finalCarcassWeight = finalCarcassWeight;
    }

    public Double getLotStartingValue() {
        return lotStartingValue;
    }

    public void setLotStartingValue(Double lotStartingValue) {
        this.lotStartingValue = lotStartingValue;
    }

    public Double getLotFinalValue() {
        return lotFinalValue;
    }

    public void setLotFinalValue(Double lotFinalValue) {
        this.lotFinalValue = lotFinalValue;
    }

    public List<Integer> getBovines() {
        return bovines;
    }

    public void setBovines(List<Integer> bovines) {
        this.bovines = bovines;
    }
     
    //getter and setter to Meadow's objects 
    public Meadow getMeadow() {
        return meadow;
    }

    public void setMeadow(Meadow meadow) {
        this.meadow = meadow;
    }
    
    //Four methods to manipulate the list.
    public void addBovine(Integer integer){
        bovines.add(integer);
    }
    
    public int quantityBovines(){
        return bovines.size();
    }
    
    public void deleteBovine(Integer integer){
        bovines.remove(integer);
    }
    
    public Integer getBovine(int position){
        return bovines.get(position);
    }
    
    /**
     * It creates a lot of animals.
     * @return
     */
    public Lot createLot(){
        System.out.print("Digite um número para este lote: ");
        int id = sc.nextInt();
        System.out.print("Qual a finalidade deste lote de animais(cria, recria, engorda)? ");
        String goal = sc.next(); 
        System.out.print("Qual a quantidade de animais que vão compor este lote? ");
        int number = sc.nextInt();
        List<Integer> bovines = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            System.out.print("Digite o número do animal: ");
            int bovine = sc.nextInt();
            bovines.add(bovine);
        }
        System.out.print("Qual a data inicial para este lote? ");
        String startingDate = sc.next();
        System.out.print("Qual a data final para este lote? ");
        String finalDate = sc.next();
        System.out.print("Digite o peso vivo inicial em kilos para este lote: ");
        Double startingAliveWeight = sc.nextDouble();
        System.out.print("Digite o peso vivo final em kilos para este lote: ");
        Double finalAliveWeight = sc.nextDouble();
        Double startingCarcassWeight = startingAliveWeight * 0.5;
        System.out.print("Digite o peso de carcaça final em kilos para este lote (peso do frigorífico): ");
        Double finalCarcassWeight = sc.nextDouble();
        System.out.print("Digite o valor de compra deste lote R$: ");
        Double lotStartingValue = sc.nextDouble();
        System.out.print("Digite o valor de venda deste lote R$: ");
        Double lotFinalValue = sc.nextDouble();
        
        System.out.print("Digite a área do piquete em hectares: ");
        Double area = sc.nextDouble();
        Meadow meadow = new Meadow();
        meadow.setArea(area);
        Lot lot = new Lot(id, goal, startingDate, finalDate, startingAliveWeight, finalAliveWeight, startingCarcassWeight, finalCarcassWeight, lotStartingValue, lotFinalValue, bovines, meadow);
    return lot;
    }//End of method createLot.
    
    /**
     * It searchs all lots in the file and shows their data.
     */
    public void searchLots() {
        System.out.println();
        Database db = new Database();
        List<Lot> lots = db.recoverLots();
        for (Lot lot : lots) {
            System.out.println(lot);
        }
    }//End of method searchLots.
    
    @Override
    public String toString(){
        return  this.getId() + "," + this.getGoal() + "," + this.getStartingDate() + "," + this.getFinalDate() + "," + this.getStartingAliveWeight() + "," + this.getFinalAliveWeight() + "," + this.getStartingCarcassWeight() + "," + this.getFinalCarcassWeight() + "," + this.getLotStartingValue() + "," + this.getLotFinalValue() + "," + this.getBovines();
    }
}