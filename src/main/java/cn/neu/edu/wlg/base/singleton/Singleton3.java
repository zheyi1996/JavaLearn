//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.base.singleton;

//@wlg 懒汉式,线程不安全
public class Singleton3 {

    private Singleton3() {

    }
    private static Singleton3 instance;
    public static Singleton3 getInstance() {
        if(instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
