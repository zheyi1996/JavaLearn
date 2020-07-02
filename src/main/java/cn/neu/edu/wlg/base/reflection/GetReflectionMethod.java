package cn.neu.edu.wlg.base.reflection;

/*
使用反射获取对象并调用该对象的方法：
    1.获取类的 Class 对象实例
    2.根据 Class 对象实例获取 Constructor 对象
    3.使用 Constructor 对象的 newInstance 方法获取反射类对象
    4.获取方法的 Method 对象
    5.利用 invoke 方法调用方法
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//获取成员方法
public class GetReflectionMethod {

    public static void main(String[] args) throws Exception{

        System.out.println("main方法执行了。。。");

            //获取Class对象
        Class stuClass = Class.forName("com.wlg.base.reflection.Student");
        //获取构造方法
        Constructor constructor = stuClass.getConstructor();
        //实例化Student对象
        Object obj = constructor.newInstance();

        //1.批量获取公有方法
        System.out.println("--------------------获取所有公有方法--------------------");
        Method[] methods = stuClass.getMethods();
        for(Method method : methods) {
            System.out.println(method);
        }

        //2.批量获取所有方法
        System.out.println("--------------------获取所有方法--------------------");
        Method[] methods1 = stuClass.getDeclaredMethods();
        for(Method method : methods1) {
            System.out.println(method);
        }

        //3.获取单个共有方法
        System.out.println("--------------------获取单个公有方法--------------------");
        Method show1Method = stuClass.getMethod("show1", String.class);
        //测试下
        show1Method.invoke(obj, "ceshi");

        //4.获取单个私有方法
        System.out.println("--------------------获取单个私有方法--------------------");
        Method show4Method = stuClass.getDeclaredMethod("show4", int.class);
        //测试下
        show4Method.setAccessible(true);
        show4Method.invoke(obj, 18);

        //5.反射main方法
        System.out.println("--------------------获取main方法--------------------");
        Method mainMethod = stuClass.getMethod("main", String[].class);
        //测试下
//        mainMethod.invoke(null, (Object)new String[]{"1", "2"});
    }
}