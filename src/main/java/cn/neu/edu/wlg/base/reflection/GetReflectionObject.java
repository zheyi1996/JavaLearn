package cn.neu.edu.wlg.base.reflection;

/*
使用反射获取对象并调用该对象的方法：
    1.获取类的 Class 对象实例
    2.根据 Class 对象实例获取 Constructor 对象
    3.使用 Constructor 对象的 newInstance 方法获取反射类对象
    4.获取方法的 Method 对象
    5.利用 invoke 方法调用方法
 */

//三种获取Class对象的方式
public class GetReflectionObject {
    public static void main(String[] args) {

        //1.通过Object类的getClass()方法获取 -- 提前获取对象才能使用
        Student student1 = new Student();
        Class stuClass1 = student1.getClass();
        System.out.println(stuClass1.getName());

        //2.通过对象的静态class属性获取 -- 需要导入该类的包才能使用
        Class stuClass2 = Student.class;
        System.out.println(stuClass2.getName());

        //3.通过forName(类的全路径名)方法获取 -- 只需要知道类的全路径名
        try {
            Class stuClass3 = Class.forName("com.wlg.base.reflection.Student");
            System.out.println(stuClass3.getName());
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}