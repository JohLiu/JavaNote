package com.joh.javanote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 数据显示方式（保留两位小数点）
 *
 * @author : Joh Liu
 * @date :
 */
public class DecimalDemo {
    public static void main(String[] args) {

        System.out.println("\n\n//**************************=保留两位小数点=**************************************//");
        //**************************=保留两位小数点=**************************************//
        double d = 10 / 3;

        // 方式一 DecimalFormat方式
        System.out.println("DecimalFormat方式显示数据：");
        DecimalFormat df = new DecimalFormat("#.00");
        double d1 = Double.parseDouble(df.format(1 / (float) 3));
        System.out.println("保留两位小数点：" + d1);  //保留两位小数点：0.33
        System.out.println("保留两位小数点：" + df.format(1.1256)); //保留两位小数点：1.13

        // 方式二 format
        System.out.println("format方式显示数据：");
        String ss1 = String.format("%10.2f%%", 1.1256);
        String ss2 = String.format("%10.2f", 1000.1256);
        String ss3 = String.format("%.2f", 1000.1256);
        String ss4 = String.format("%.2f", d);
        System.out.println(ss1); //      1.13%
        System.out.println(ss2); //   1000.13
        System.out.println(ss3); //1000.13
        System.out.println(ss4); //3.00

        // 方式三 NumberFormat
        System.out.println("NumberFormat方式显示数据：");
        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(2); // 最大小数位数
        ddf1.setMinimumFractionDigits(2); // 最小小数位数
        ddf1.setMaximumIntegerDigits(10); // 最大整数位数
        ddf1.setMinimumIntegerDigits(1); // 最小整数位数
        System.out.println(ddf1.format(d)); //3.00

        // 方式四 BigDecimal
        System.out.println("BigDecimal方式显示数据：");
        BigDecimal ff = new BigDecimal("1.12345");
        BigDecimal setScale2 = ff.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale2); //1.12


        System.out.println("\n\n//**************************=科学计数法+保留两位小数点=**************************************//");
        //**************************=科学计数法+保留两位小数点=**************************************//
        Double num2 = 101246546540.12345;

        System.out.println("原始数据：\n" + num2);
        // 方式一 DecimalFormat
        String aa = new DecimalFormat("###,###,###.##").format(num2);
        System.out.println("DecimalFormat数据：\n" + aa); //101,246,546,540.12

        // 方式三 NumberFormat
        NumberFormat bb = NumberFormat.getNumberInstance();
        bb.setMaximumFractionDigits(2); // 最大小数位数
        bb.setMinimumFractionDigits(2); // 最小小数位数
        System.out.println("NumberFormat数据：\n" + bb.format(num2)); //101,246,546,540.12

    }
}













