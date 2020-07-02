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
import java.lang.reflect.Field;

//获取成员变量
public class GetReflectionField {

    public static void main(String[] args) throws Exception{

        //获取Class对象
        Class stuClass = Class.forName("com.wlg.base.reflection.Student");
        //获取构造方法
        Constructor constructor = stuClass.getConstructor();
        //实例化Student对象
        Object obj = constructor.newInstance();

        //1.批量获取公有变量
        System.out.println("--------------------获取所有公有变量--------------------");
        Field[] fields = stuClass.getFields();
        for(Field field : fields) {
            System.out.println(field);
        }

        //2.批量获取所有变量
        System.out.println("--------------------获取所有变量--------------------");
        Field[] fields1 = stuClass.getDeclaredFields();
        for(Field field : fields1) {
            System.out.println(field);
        }

        //3.获取单个共有变量
        System.out.println("--------------------获取单个公有变量--------------------");
        Field nameField = stuClass.getField("name");
        nameField.set(obj, "wlg");
        //测试下
        Student student = (Student) obj;
        System.out.println(student.toString());

        //4.获取单个私有变量
        System.out.println("--------------------获取单个私有变量--------------------");
        Field phoneNumFiled = stuClass.getDeclaredField("phoneNum");
        phoneNumFiled.setAccessible(true);
        phoneNumFiled.set(obj, "18300235486");
        //测试下
        System.out.println(student.toString());
    }
}