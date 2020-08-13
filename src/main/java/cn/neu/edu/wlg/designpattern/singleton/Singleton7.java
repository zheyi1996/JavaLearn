//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.designpattern.singleton;

//@wlg 静态内部类 -- 静态内部类方式在Singleton类被装载时并不会立即实例化
public class Singleton7 {

    private Singleton7() {

    }
    private static class SingletonInstance {

        private static final Singleton7 INSTANCE = new Singleton7();
    }
    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
