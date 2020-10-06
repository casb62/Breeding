package services;

import entities.Database;
import entities.Lot;
import java.util.Scanner;

public class LotService {
    
    private Labor labor;
    
    public LotService(Labor labor) {
        this.labor = labor;
    }
    
    public Labor getLabor() {
        return labor;
    }

    public void setLabor(Labor labor) {
        this.labor = labor;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void printLot(Lot lot){
        System.out.println("\nIndicadores produtivos\n");
        System.out.println("Os pesos em kg referem-se ao peso vivo.\n" + 
                "Os pesos em @ referem-se ao peso de carcaça.");
        System.out.println("Data de início do ciclo " + lot.getStartingDate());
        System.out.println("Data de final de ciclo " + lot.getFinalDate());
        int daily = labor.dailyCalcutation(lot.getStartingDate(), lot.getFinalDate());
        System.out.println("Quantidade de diárias " + daily);
        System.out.printf("Ciclo produtivo(meses) %.1f\n", labor.productiveCycle(daily));
        double initialWeightKg = labor.weightKg(lot.getStartingAliveWeight(), lot.quantityBovines());
        System.out.printf("Peso inicial(kg) %.1f\n", initialWeightKg);
        double initialWeightAr = labor.initialWeightAr(lot.getStartingAliveWeight(), lot.quantityBovines());
        System.out.printf("Peso inicial(@) %.1f\n", initialWeightAr);
        System.out.println("Rendimento de carcaça na entrada(%) 50");
        System.out.println("Peso ideal do boi para abate 520,0 kg ou 17,0 @");
        double finalWeightKg = labor.weightKg(lot.getFinalAliveWeight(), lot.quantityBovines());
        System.out.printf("Peso final (kg) %.1f\n", finalWeightKg);
        double finalWeightAr = labor.finalWeightAr(lot.getFinalCarcassWeight(), lot.quantityBovines());
        System.out.printf("Peso final (@) %.1f\n", finalWeightAr);
        System.out.printf("Ganho de peso por animal em kg %.1f\n", labor.weightGainKg(initialWeightKg, finalWeightKg));
        System.out.printf("Quantidade de @ produzidas por animal %.1f\n", labor.weightGainAr(initialWeightAr, finalWeightAr));
        System.out.printf("Receita por animal %.2f\n", labor.revenueByAnimal(lot.getLotFinalValue(), lot.quantityBovines()));
        System.out.printf("Quantidade de @ produzidas por animal por mês %.1f\n", labor.arPerAnimalPerMonth(initialWeightAr, finalWeightAr, daily));
        System.out.println("Ganho de Peso Total - GPT");
        System.out.printf("GPT do lote em kg %.1f\n", labor.totalWeightGainKg(initialWeightKg, finalWeightKg, lot.quantityBovines()));
        System.out.printf("GPT do lote em @ %.1f\n", labor.totalWeightGainAr(initialWeightAr, finalWeightAr, lot.quantityBovines()));
        System.out.println("Ganho Médio Diário - GMD");
        System.out.printf("GMD (kg/animal/dia) %.3f\n", labor.kgPerAnimalPerDay(initialWeightKg, finalWeightKg, daily));
        System.out.printf("GMD em carcaça (kg/carcaça/dia) %.3f\n", labor.kgCarcassPerDay(initialWeightAr, finalWeightAr, daily));
        System.out.printf("Dias para ganhar 1 @ %.1f\n", labor.daysToGainAr(initialWeightAr, finalWeightAr, daily));
        System.out.printf("Total de @ no final do período %.1f\n", labor.totalAr(finalWeightAr, lot.quantityBovines()));
        double carcassYield = labor.carcassYield(finalWeightAr, finalWeightKg);
        System.out.printf("Rendimento de carcaça no final do ciclo %.1f%s\n", carcassYield, " %");
        System.out.println("Rendimento do ganho é a porção do ganho de peso vivo que se converte em carcaça.");
        double gainYield = labor.gainYield(lot.getStartingCarcassWeight(), lot.getFinalCarcassWeight(), lot.getStartingAliveWeight(), lot.getFinalAliveWeight());
        System.out.printf("Rendimento do ganho %.1f%s\n", gainYield, " %");
        System.out.printf("Valor da arroba de entrada %.2f\n", labor.arInitialValue(lot.getLotStartingValue(), lot.getStartingCarcassWeight()));
        System.out.printf("Valor da arroba de saída %.2f\n", labor.arFinalValue(lot.getLotFinalValue(), lot.getFinalCarcassWeight()));
        System.out.printf("Quantidade de @ produzidas por Ha %.1f\n", labor.arPerHectare(initialWeightAr, finalWeightAr, lot.quantityBovines(), lot.getMeadow().getArea()));
        System.out.println("A taxa de ocupação ideal é de 1,2 UA/Ha");
        System.out.printf("Taxa de ocupação UA/Ha %.1f\n", labor.occupancyRate(lot.getFinalAliveWeight(), lot.getMeadow().getArea()));
    }
    
    public void simulateLot(Lot lot){
        printLot(lot);
        System.out.println("\nDeseja salvar este lote(y,n)? ");
        String answer1 = "y";
        String answer2 = "n";
        String answer3 = sc.next();
        if (answer3.equalsIgnoreCase(answer1)) {
            Database.conection(lot);
        }
    }
}