//http://www.blogjava.net/jiangshachina/archive/2012/02/13/369898.html

package cn.neu.edu.wlg.base.serializable;

import java.io.*;
//import

public class SerializableDemo {

    public static void main(String[] args) throws Exception{ //@wlg IDEA提示抛异常不够明显

        Person person = new Person("wlg", Gender.MALE, 23);

        File file = new File("person.out");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object p = ois.readObject();
        ois.close();
        System.out.println(p);
    }
}
