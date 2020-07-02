package cn.neu.edu.wlg.base.reflection;

import java.lang.reflect.Constructor;

//通过获取批量构造方法和获取单个构造方法
public class GetReflectionConstructor {

    public static void main(String[] args) throws Exception{
        Class stuClass3 = Class.forName("com.wlg.base.reflection.Student");

        //1.批量获取公有构造方法
        System.out.println("--------------------获取所有公有构造方法--------------------");
        Constructor[] constructors = stuClass3.getConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //2.获取所有的构造方法
        System.out.println("--------------------获取所有构造方法--------------------");
        Constructor[] constructors1 = stuClass3.getDeclaredConstructors();
        for(Constructor constructor : constructors1) {
            System.out.println(constructor);
        }

        //3.获取单个公有,无参构造方法
        System.out.println("--------------------获取单个公有构造方法--------------------");
        Constructor constructor2 = stuClass3.getConstructor();
        System.out.println(constructor2);
        //通过构造方法实例化对象
        Object obj = constructor2.newInstance();

        //4.获取单个私有,有参构造方法
        System.out.println("--------------------获取单个私有,有参构造方法--------------------");
        Constructor constructor3 = stuClass3.getDeclaredConstructor(int.class);
        System.out.println(constructor3);
        //通过构造方法实例化对象
        constructor3.setAccessible(true);
        Object object1 = constructor3.newInstance(4);
    }
}
