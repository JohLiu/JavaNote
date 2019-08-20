# java基础之数据取整

标签： java基础

---

对数据进行取整
```
package com.joh.java;

/**
 * java取整
 * 
 * @author : Joh Liu
 * @date :
 */
public class TruncDemo {

    public static void main(String[] args) {
//        向上取整:Math.ceil() //只要有小数都+1
//        向下取整:Math.floor() //不取小数
//        四舍五入:Math.round() //四舍五入

        int a = new Double(Math.ceil(7.10000000000000023)).intValue();
        System.out.println(a); //8
        int b = new Double(Math.ceil(3.9000000000052)).intValue();
        System.out.println(b); //4
        int c = Math.round(10.200000000001f);
        System.out.println(c); //10
    }
}
```




