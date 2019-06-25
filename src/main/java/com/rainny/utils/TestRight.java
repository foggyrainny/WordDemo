package com.rainny.utils;

import java.io.File;
import java.text.NumberFormat;

/**
 * Created by rainny on 2019/6/15.
 */
public class TestRight {

    public static boolean test(Double totalMoney, Double totalTax, Double totalTM) throws NumberFormatException {

        Double c = totalMoney + totalTax;

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String b = numberFormat.format(totalMoney * 0.16).replace(",", "");
        boolean flag = false;
        if (b.equals(totalTax.toString()) && c.equals(totalTM)) {
            flag = true;
        }
        return flag;
    }


    public static void main(String[] args) {
//       boolean a= TestRight.test(79088.90,12654.22,91743.12);
//       long time1=System.currentTimeMillis();
       boolean b= TestRight.test(70516.42,11282.63,81799.05);
//        long time2=System.currentTimeMillis();
//        System.out.println(time2-time1);
       System.out.println(b);
//        File file = new File("DFSDFSD");
//        System.out.println(file);
//        File[] filePaths = file.listFiles();
//        System.out.println(filePaths);
    }
}
