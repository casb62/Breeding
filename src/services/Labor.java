package services;

public interface Labor {
    
    int dailyCalcutation(String initialDate, String finalDate);
    double productiveCycle(int dailyInt);
    double weightKg(double lotWeight, int bovines);
    double initialWeightAr(double lotWeight, int bovines);
    double finalWeightAr(double lotWeight, int bovines);
    double weightGainKg(double initialWeightKg, double finalWeightKg);
    double weightGainAr(double initialWeightAr, double finalWeightAr);
    double revenueByAnimal(double lotFinalValue, int bovines);
    double arPerAnimalPerMonth(double initialWeightAr,double finalWeightAr, int dailyInt);
    double totalWeightGainKg(double initialWeightKg, double finalWeightKg, int bovines);
    double totalWeightGainAr(double initialWeightAr, double finalWeightAr, int bovines);
    double kgPerAnimalPerDay(double initialWeightKg, double finalWeightKg, int dailyInt);
    double kgCarcassPerDay(double initialWeightAr, double finalWeightAr, int dailyInt);
    double daysToGainAr(double initialWeightAr, double finalWeightAr, int dailyInt);
    double totalAr(double finalWeightAr, int bovines);
    double carcassYield(double finalWeightAr, double finalWeightKg);
    double gainYield(double lotInitialCarcassWeight, double lotFinalCarcassWeight, double lotInitialAliveWeight, double lotFinalAliveWeight);
    double arInitialValue(double lotStartingValue, double lotStartingCarcassWeight);
    double arFinalValue(double lotFinalValue, double lotFinalCarcassWeight);
    double arPerHectare(double initialWeightAr, double finalWeightAr, int bovines, double area);
    double occupancyRate(double lotFinalAliveWeight, double area);
}