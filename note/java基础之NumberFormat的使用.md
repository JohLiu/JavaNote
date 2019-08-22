# java基础之NumberFormat的使用

标签： java基础

---

java中常会用到数字的格式化显示，常用类有`DecimalFormat`、`NumberFormat`以及`BigDecimal`。
NumberFormat是一个抽象的数字格式化类。该类提供的格式和解析数字的接口。

#### NumberFormat多重用途
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

