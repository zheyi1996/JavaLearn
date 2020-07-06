package cn.neu.edu.wlg.base.baseUsing;

//import org.junit.Test;
/*
总结：
    1. String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变；如果需要对字符串进行修改，可以使用 StringBuilder 和 StringBuffer 类
    2. 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
    3. 相比于 StringBuffer， StringBuilder 的方法不是线程安全的（不能同步访问）。所以 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
    然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
 */
public class StringBuffer_StringBuilder {

//    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder("菜鸟教程官网：");
        stringBuilder.append("www");
        stringBuilder.append(".runoob");
        stringBuilder.append(".com");
        System.out.println(stringBuilder);
    }

//    @Test
    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer("菜鸟教程官网：");
        stringBuffer.append("www");
        stringBuffer.append(".runoob");
        stringBuffer.append(".com");
        System.out.println(stringBuffer);
    }

}
