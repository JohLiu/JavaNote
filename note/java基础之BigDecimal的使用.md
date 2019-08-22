# java基础之BigDecimal的使用

标签： java基础

---

java中常会用到数字的格式化显示，常用类有`DecimalFormat`、`NumberFormat`以及`BigDecimal`。
java的`float`只能用来进行科学计算或工程计算，在大多数的商业计算中，一般采用`java.math.BigDecimal`类来进行精确计算。
```java
double dd4 = 1.01 + 2.02;
System.out.println(dd4); //3.0300000000000002

BigDecimal add = new BigDecimal("1.01").add(new BigDecimal("2.02"));
System.out.println("a + b =" + add); //3.03
```

#### 1.数据精准度
初始化数据时可以是`int`，`float`，`double`，`String`等类型数据，但是直接使用`double`或是`float`初始化，会出现数据精准度问题。所以尽量使用参数类型为`String`的构造函数
```java
// 直接使用double类型初始化，精准度会出现问题
// 因精准度问题，尽量使用参数类型为String的构造函数。
BigDecimal big1 = new BigDecimal(1.34);
System.out.println(big1); //1.3400000000000000799360577730112709105014801025390625

BigDecimal big2 = new BigDecimal("1.34");//1.34
BigDecimal big3 = BigDecimal.valueOf(1.34);//1.34
System.out.println(big2); //1.34
System.out.println(big3); //1.34
```

#### 2.特殊数字表示
在BigDecimal 中提供了0，1，10的特殊表示方式
```java
// BigDecimal中，0、1、10的写法与普通数字不同。
BigDecimal num0 = BigDecimal.ZERO;
BigDecimal num1 = BigDecimal.ONE;
BigDecimal num10 = BigDecimal.TEN;
System.out.println(num0); //0
System.out.println(num1); //1
System.out.println(num10); //10
```

#### 3.比较大小

BigDecimal 比较大小不要使用`equals`，可使用`compareTo`来比较大小，需要注意的是`compareTo`返回值是`int`类型。
```java
// 判断是否为0，不要用equal,需要使用compareTo
BigDecimal bj0 = new BigDecimal("0.0");
System.out .println("equal判断结果：" + bj0.equals(BigDecimal.ZERO)); //false
System.out .println("compareTo判断结果：" + (bj0.compareTo(BigDecimal.ZERO) == 0)); //true

// compareTo判断大小，返回值：0（相等），1（表示大于），-1（表示小于）
BigDecimal bj3 = new BigDecimal("-1");
BigDecimal bj13 = new BigDecimal("13");
System.out .println(bj3.compareTo(bj13)); //-1 (表示小于)
System.out .println(bj13.compareTo(bj0)); //1 (表示大于)
System.out .println(bj13.compareTo(BigDecimal.ZERO)); //1 (表示大于)
System.out .println(bj0.compareTo(BigDecimal.ZERO)); //0 (表示等于)
```

#### 4.加减乘除运算

BigDecimal 提供了用于加减乘除运算的方法，使用方式很简单，需要注意的是BigDecimal 的除法运算处理需要传入运算数据外，还需要传入 舍入方式和小说点位数。
```java
BigDecimal a = new BigDecimal("100.712");
BigDecimal b = new BigDecimal("70.25");

System.out.println("a + b =" + b.add(a)); //170.962
System.out.println("a - b =" + b.subtract(a)); //-30.462
System.out.println("a * b =" + b.multiply(a)); //7075.01800
// 注意，除法运算需要写三个参数（除数，小数点后保留位数，舍入模式）
System.out.println("a / b =" + a.divide(b, 3, ROUND_HALF_UP)); // 1.434
```


