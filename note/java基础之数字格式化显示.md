# java基础之数字格式化显示

标签： java基础

---

java中常会用到数字的格式化显示，常用类有`DecimalFormat`、`NumberFormat`以及`BigDecimal`。

#### 1.保留两位小数点
```java
    //******=保留两位小数点=******//
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
```
#### 2.科学计数法+保留两位小数点
```java
    //******=科学计数法+保留两位小数点=******//
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
```
#### 3.NumberFormat多重用途
```java
    //******=NumberFormat多重用途=******//
    Double dou = 123456789.987654321;

    //原始数据
    String str1 = dou.toString();
    System.out.println("原始数据：\n" + str1); //1.2345678998765433E8

    //默认显示，保留3位小数
    String str2 = NumberFormat.getInstance().format(dou);
    System.out.println("默认显示：\n" + str2); //123,456,789.988

    //数据的金额显示形式
    String str3 = NumberFormat.getCurrencyInstance().format(dou);
    System.out.println("金额格式显示：\n" + str3); //￥123,456,789.99

    //数据的数字显示格式（与默认相同）
    String str4 = NumberFormat.getNumberInstance().format(dou);
    System.out.println("数据格式显示：\n" + str4); //123,456,789.988

    //百分比显示，默认不保留小数
    String str5 = NumberFormat.getPercentInstance().format(dou);
    System.out.println("百分比格式显示：\n" + str5); //12,345,678,999%
```

