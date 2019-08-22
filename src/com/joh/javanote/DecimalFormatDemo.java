package com.joh.javanote;

import java.text.DecimalFormat;

/**
 * DecimalFormat的使用
 *
 * @author : Joh Liu
 * @date :
 */
public class DecimalFormatDemo {
    public static void main(String[] args) {
        // DecimalFormat用来格式化十进制数字，入保留小数，科学计算法等等。
        // 在DecimalFormat中，有以下几种特殊字符，基本含义解释如下：
        // 0 : 代表一个任意数字，或者是在末尾补0
        // # : 代表一个不包含0的任意数字，末尾若为0，则以缺失显示
        // . : 代表小数点占位符
        // , : 代表分组分隔符占位符
        // - : 代表减号或者负号
        // % : 代表百分数
        // /u2030 : 代表千分数
        // E : 代表分隔科学计数法中的尾数和指数。在前缀或后缀中无需加引号。

        double df1 = 15465780.123456789;
        double df2 = 15465789.987654321;
        // 保留整数
        System.out.println("\n//******=保留整数=******//");

        System.out.println(new DecimalFormat("0").format(df1)); //15465780
        System.out.println(new DecimalFormat("#").format(df1)); //15465780

        System.out.println(new DecimalFormat("0").format(df2)); //15465790
        System.out.println(new DecimalFormat("#").format(df2)); //15465790

        //保留一位小数
        System.out.println("\n//******=保留一位小数=******//");

        System.out.println(new DecimalFormat("0.0").format(df1)); //15465780.1
        System.out.println(new DecimalFormat("0.#").format(df1)); //15465780.1
        System.out.println(new DecimalFormat("#.#").format(df1)); //15465780.1
        System.out.println(new DecimalFormat("#.0").format(df1)); //15465780.1

        System.out.println(new DecimalFormat("0.0").format(df2)); //15465790.0
        System.out.println(new DecimalFormat("0.#").format(df2)); //15465790
        System.out.println(new DecimalFormat("#.#").format(df2)); //15465790
        System.out.println(new DecimalFormat("#.0").format(df2)); //15465790.0

        //保留两位位小数
        System.out.println("\n//******=保留两位小数=******//");
        System.out.println(new DecimalFormat("0.00").format(df1) + "(建议方式)"); //15465780.12
        System.out.println(new DecimalFormat("0.##").format(df1)); //15465780.12
        System.out.println(new DecimalFormat("#.##").format(df1)); //15465780.12
        System.out.println(new DecimalFormat("#.00").format(df1)); //15465780.12
        System.out.println(new DecimalFormat(",###").format(df1)); //15,465,780.01

        //百分比输出，保留两位小数
        double df3 = 0.987654;
        double df4 = 0.123036;
        System.out.println("\n//******=百分比输出,保留两位小数=******//");
        System.out.println(new DecimalFormat("0.00%").format(df3)); //98.77%
        System.out.println(new DecimalFormat("0.##%").format(df3)); //98.77%
        System.out.println(new DecimalFormat("#.##%").format(df3)); //98.77%
        System.out.println(new DecimalFormat("#.00%").format(df3)); //98.77%

        System.out.println(new DecimalFormat("0.00%").format(df4)); //12.35%
        System.out.println(new DecimalFormat("0.##%").format(df4)); //12.3%
        System.out.println(new DecimalFormat("#.##%").format(df4)); //12.3%
        System.out.println(new DecimalFormat("#.00%").format(df4)); //12.35%

        //变为负数输出，保留两位小数
        System.out.println("\n//******=负数输出,保留两位小数=******//");
        System.out.println(new DecimalFormat("-0.00").format(df3)); //-0.99
        System.out.println(new DecimalFormat("-000.00").format(df3)); //-000.99 （整数不足部分以0填补）
        System.out.println(new DecimalFormat("-0.##").format(df3)); //-0.99
        System.out.println(new DecimalFormat("-#.##").format(df3)); //-0.99
        System.out.println(new DecimalFormat("-#.00").format(df3)); //-.99

        // 可直接插入文字
        System.out.println("\n//******=直接插入文字=******//");
        System.out.println(new DecimalFormat("光速大小为每秒 ,### 米。").format(df1));

        System.out.println("\n//******=科学计数法=******//");
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(df1)); //1.54658E7
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(df1)); //15.4658E6

    }
}
