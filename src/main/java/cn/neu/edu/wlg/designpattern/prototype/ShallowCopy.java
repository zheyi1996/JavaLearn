package cn.neu.edu.wlg.designpattern.prototype;

import java.util.Date;

/*
    1.与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的
    2.浅拷贝实现 Cloneable，重写colne()方法，深拷贝是通过实现 Serializable 读取二进制流
        浅拷贝只拷贝对象的引用，深拷贝拷贝对象的内存
    3.原型模式很少单独出现，一般是和工厂模式一起出现，通过clone方法创建一个对象，然后由工厂方法提供给调用者
 */
public class ShallowCopy { //浅拷贝只拷贝对象的引用

    public static void main(String[] args) throws CloneNotSupportedException {

        Date date = new Date(123123123123L);
        Sheep s1 = new Sheep("Dolly", date);
        Sheep s2 = (Sheep) s1.clone();

        System.out.println(s1.getBirthday());

        date.setTime(234234234L);
        s1.setBirthday(date);
        s2.setName("NotDolly");

        System.out.println(s1.getBirthday());
        System.out.println(s1.getName());
        System.out.println(s2.getBirthday());
        System.out.println(s2.getName());
    }
}


class Sheep implements Cloneable {

    private String name;
    private Date birthday;

    public Sheep() { }

    public  Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用Object对象的clone()方法

        //添加如下代码实现深复制
//        Sheep s = (Sheep) obj;
//        s.birthday = (Date)this.birthday.clone();

        return obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
