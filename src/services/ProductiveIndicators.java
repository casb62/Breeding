package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductiveIndicators implements Labor {

    @Override
    public int dailyCalcutation(String initialDate, String finalDate) {
       
        int dailyInt = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = sdf.parse(initialDate);
            long sd = date1.getTime();
            Date date2 = sdf.parse(finalDate);
            long fd = date2.getTime();
            long daily = ((fd - sd) / (1000 * 60 * 60 * 24) + 1);
            dailyInt = (int) daily;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dailyInt;
    }

    @Override
    public double productiveCycle(int dailyInt) {
        return dailyInt / 30.0;
    }

    @Override
    public double weightKg(double lotWeight, int bovines) {
        return lotWeight / bovines;
    }

    @Override
    public double initialWeightAr(double lotWeight, int bovines) {
        return lotWeight / bovines / 30;
    }

    @Override
    public double finalWeightAr(double lotWeight, int bovines) {
        return lotWeight / bovines / 15;
    }
    
    @Override
    public double weightGainKg(double initialWeightKg, double finalWeightKg) {
        return finalWeightKg - initialWeightKg;
    }
    
    @Override
    public double weightGainAr(double initialWeightAr, double finalWeightAr) {
        return finalWeightAr - initialWeightAr;
    }

    @Override
    public double revenueByAnimal(double lotFinalValue, int bovines) {
        return lotFinalValue / bovines;
    }

    @Override
    public double arPerAnimalPerMonth(double initialWeightAr, double  finalWeightAr, int dailyInt) {
        return (finalWeightAr - initialWeightAr) / dailyInt * 30;
    }

    @Override
    public double totalWeightGainKg(double initialWeightKg, double finalWeightKg, int bovines) {
        return (finalWeightKg - initialWeightKg) * bovines;
    }

    @Override
    public double totalWeightGainAr(double initialWeightAr, double finalWeightAr, int bovines) {
        return (finalWeightAr - initialWeightAr) * bovines;
    }

    @Override
    public double kgPerAnimalPerDay(double initialWeightKg, double finalWeightKg, int dailyInt) {
        return (finalWeightKg - initialWeightKg) / dailyInt;
    }

    @Override
    public double kgCarcassPerDay(double initialWeightAr, double finalWeightAr, int dailyInt) {
        return (finalWeightAr - initialWeightAr) * 15 / dailyInt;
    }

    @Override
    public double daysToGainAr(double initialWeightAr, double finalWeightAr, int dailyInt) {
        return dailyInt / (finalWeightAr - initialWeightAr);
    }

    @Override
    public double totalAr(double finalWeightAr, int bovines) {
        return finalWeightAr * bovines;
    }

    @Override
    public double carcassYield(double finalWeightAr, double finalWeightKg) {
        return finalWeightAr * 15 / finalWeightKg * 100;
    }

    @Override
    public double gainYield(double lotInitialCarcassWeight, double lotFinalCarcassWeight, double lotInitialAliveWeight, double lotFinalAliveWeight) {
        return (lotFinalCarcassWeight - lotInitialCarcassWeight) / (lotFinalAliveWeight - lotInitialAliveWeight) * 100;
    }

    @Override
    public double arInitialValue(double lotStartingValue, double lotStartingCarcassWeight) {
        return lotStartingValue / lotStartingCarcassWeight * 15;
    }

    @Override
    public double arFinalValue(double lotFinalValue, double lotFinalCarcassWeight) {
        return lotFinalValue / lotFinalCarcassWeight * 15;
    }

    @Override
    public double arPerHectare(double initialWeightAr, double finalWeightAr, int bovines, double area) {
        return (finalWeightAr - initialWeightAr) * bovines / area;
    }

    @Override
    public double occupancyRate(double lotFinalAliveWeight, double area) {
        return lotFinalAliveWeight / 450 / area;
    }
}
