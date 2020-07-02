//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.base.singleton;

/*
    单例模式:
        1.私有构造器
        2.私有静态实例
        3.公有静态getInstance()方法

 */

//@wlg 饿汉式(静态常量)
public class Singleton1 {

    private Singleton1() { //@wlg 私有构造器

    }
    private static Singleton1 instance = new Singleton1(); //@wlg 静态对象
    public static Singleton1 getInstance() {
        return instance;
    }
}
