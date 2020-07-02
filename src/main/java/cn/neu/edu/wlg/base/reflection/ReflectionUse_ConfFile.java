package cn.neu.edu.wlg.base.reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

//使用反射和配置文件,可以使:应用程序更新时,对源码无需进行任何修改
public class ReflectionUse_ConfFile {

    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class stuClass = Class.forName(getValue("className"));
        //获取构造方法
        Constructor constructor = stuClass.getConstructor();
        //获取方法
        Method stuMethod = stuClass.getMethod(getValue("methodName"), String.class);
        //实例化对象
        Object obj = constructor.newInstance();
        //调用show1方法
        stuMethod.invoke(obj, "wlg");
    }

    //此方法接收一个key,在配置文件中获取相应的value
    public static String getValue(String key)  throws IOException {

        Properties pro = new Properties(); //获取配置文件对象
        FileReader in = new FileReader("pro.txt"); //获取输入流
        pro.load(in); //将流加载到配置文件对象
        in.close();
        return pro.getProperty(key); //返回根据key获取的value值
    }
}
