//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.base.singleton;

//@wlg 懒汉式(线程安全,同步代码块)
public class Singleton5 {

    private Singleton5() {

    }
    private static Singleton5 instance;
    public static Singleton5 getInstance() {
        if(instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
