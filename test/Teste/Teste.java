package Teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Teste {

    public static void main(String[] args) throws ParseException {

        Date x1 = new Date();
        System.out.println("x1: " + x1); // Mon Mar 14 11:48:49 BRT 2016
        Date x2 = new Date(System.currentTimeMillis());
        System.out.println("x2: " + x2);

        DateFormat dfm = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("x3: " + dfm.format(x1)); // 14/03/2016

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date x4 = formato.parse("23/11/2015");
        System.out.println("x4: " + x4);

        String nova = "WED MAR 05 00:00:00 BRT 2014";
        String[] n = nova.split(" ");
        System.out.println("x5: " + n[2] + "/" + n[1] + "/" + n[5]);
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        //De string para date: 15/03/2017 -> wed mar 15 00:00:00 BRT 2017
        //Date date = sdf.parse(sc.next())
        Date x6 = sdf1.parse("25/06/2018");// sc.next()
        Date x7 = sdf2.parse("25/06/2018 15:42:07");
        
        System.out.println("De string para date");
        System.out.println("x6: " + x6);
        System.out.println("x7: " + x7);
        
        //De date para string - sdf.format(date): wed mar 15 00:00:00 BRT 2017 -> 15/03/2017
        System.out.println("De date para string");
        System.out.println("x8: " + sdf2.format(x6));
        System.out.println("x9: " + sdf2.format(x7));
        
        //Padrão ISO 8601 e classe Instant para armazenar horários em relação ao UTC (que é uma boa prática)
        //T - time
        //Z - zone
        //3 horas de atraso
        Date x8 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
        System.out.println("x10: " + x8);
        
        Date x9 = new Date(0L);//BRT atrasado 3 horas em relação ao GMT.
        System.out.println("x11: " + x9);
        
        Date x10 = new Date(1000L * 60L * 60L * 5L);
        System.out.println("x12: " + x10);
        
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("x13: " + sdf3.format(x8));
        
        Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
        System.out.println("x14: " + d);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR_OF_DAY, 4);
        d = cal.getTime();
        System.out.println("x15: " + d);
        
        int minutes = cal.get(Calendar.MINUTE);
        int month = 1 + cal.get(Calendar.MONTH);
        System.out.println("Minutes: " + minutes);
        System.out.println("Month: " + month);
    }

    /** 
     * Converte uma data no formato WED MAR 05 00:00:00 BRT 2014 para o formato
     * dd/MM/yyyy
     *
     * @param data
     * @return
     */
    public static String converterData(String data) {
        String s = data;
        String dia = s.substring(8, 10);
        String mes = s.substring(4, 7);
        String ano = s.substring(24, 28);
        if (mes.equalsIgnoreCase("JAN")) {
            mes = "01";
        } else if (mes.equalsIgnoreCase("FEV")) {
            mes = "02";
        } else if (mes.equalsIgnoreCase("MAR")) {
            mes = "03";
        } else if (mes.equalsIgnoreCase("ABR")) {
            mes = "04";
        } else if (mes.equalsIgnoreCase("MAI")) {
            mes = "05";
        } else if (mes.equalsIgnoreCase("JUN")) {
            mes = "06";
        } else if (mes.equalsIgnoreCase("JUL")) {
            mes = "07";
        } else if (mes.equalsIgnoreCase("AGO")) {
            mes = "08";
        } else if (mes.equalsIgnoreCase("SET")) {
            mes = "09";
        } else if (mes.equalsIgnoreCase("OUT")) {
            mes = "10";
        } else if (mes.equalsIgnoreCase("NOV")) {
            mes = "11";
        } else if (mes.equalsIgnoreCase("DEZ")) {
            mes = "12";
        }
        String dataCorr = dia + "/" + mes + "/" + ano;

        return dataCorr;
    }//Fim do método converterData().
}