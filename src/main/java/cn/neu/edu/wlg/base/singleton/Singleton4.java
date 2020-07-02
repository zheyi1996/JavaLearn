//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.base.singleton;

//@wlg 懒汉式(线程安全,同步方法)
public class Singleton4 {

    private Singleton4() {

    }
    private static Singleton4 instance;
    public static synchronized Singleton4 getInstance() {
        if(instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
