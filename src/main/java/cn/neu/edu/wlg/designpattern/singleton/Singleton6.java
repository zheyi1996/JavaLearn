//https://www.cnblogs.com/zhaoyan001/p/6365064.html

package cn.neu.edu.wlg.designpattern.singleton;

//@wlg 双重检查
public class Singleton6 { //@wlg 双重检查的意义在哪里?

    private Singleton6() {

    }
    private static Singleton6 instance;
    public static Singleton6 getInstance() {
        if(instance == null) {
            synchronized (Singleton6.class) {
                if(instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
