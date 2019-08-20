# java基础之代码注释@see与{@link}

标签： java基础

------

善用java代码注释，写出高可读性代码，便于项目后期维护。
`@see`与`{@link}`都具有代码关联、参考转向作用

#### 1.@see
> 使用`@see`时应注意 `顶头写`。
> 用法：@see 类#属性 / 方法
```
/**
 * @see ClassA#属性
 * @see ClassA#方法
 * @see com.joh.demo.ClassB#方法
 */
```
#### 2.{@link}
>`{@link}`的使用与`@see`有一点区别就是可以`不用顶头写`,其他和`@see`用法相同。
> 用法：{@link 类#属性 / 方法}
```java
/**
 * {@link ClassA#属性}
 * {@link ClassA#方法}
 * {@link com.joh.demo.ClassB#方法}
 * 
 * 可不用顶头写 {@link ClassA#属性}
 * 可不用顶头写 {@link ClassA#方法}
 * 可不用顶头写 {@link com.joh.demo.ClassB#方法}
 */
```






