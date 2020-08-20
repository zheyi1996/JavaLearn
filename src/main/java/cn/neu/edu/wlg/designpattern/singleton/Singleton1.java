//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.designpattern.singleton;

/*
    EagerSingleton只饿汉模式:
        1.私有构造器
        2.私有静态实例
        3.公有静态getInstance()方法
    特点：
        以空间换时间，在类加载的时候就创建了类的实例。
 */

//@wlg 饿汉式(静态常量) EagerSingleton
public class Singleton1 {

    private Singleton1() { // 私有默认构造器

    }
    private static Singleton1 instance = new Singleton1(); // 静态对象
    public static Singleton1 getInstance() {
        return instance;
    }
}

class EagerSingleton {

    // 私有构造器
    private EagerSingleton() {}
    // 私有静态实例
    private static EagerSingleton instance = new EagerSingleton();
    // 公有静态getInstance()方法
    public static EagerSingleton getInstance() {
        return instance;
    }
}
