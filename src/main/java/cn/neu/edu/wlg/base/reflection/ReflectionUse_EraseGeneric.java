package cn.neu.edu.wlg.base.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    泛型用在编译期间,编译过后泛型擦除,所以可以通过反射越过泛型检查
 */
public class ReflectionUse_EraseGeneric {

    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("wlg");
        list.add("hello");

        Class listClass = list.getClass();
//        Constructor constructor = listClass.getConstructor();
        Method listMethod = listClass.getMethod("add", Object.class);
        listMethod.invoke(list, 125);
        for(Object object : list) {
            System.out.println(object);
        }
    }
}
