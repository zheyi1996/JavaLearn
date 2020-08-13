package cn.neu.edu.wlg.base.NIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {

    /*
        FileOutputStream(String name, boolean append)
        append是追加写开关
        换行 Windows \r\n
        linux /n
     */
    public static void main(String[] args) throws IOException {
        // 创建一个FileOutputStream对象
        FileOutputStream fos = new FileOutputStream("D:\\project\\java\\JavaLearn\\src\\main\\java\\cn\\neu\\edu\\wlg\\base\\NIO\\NIOData.txt", true);
        // 写入数据
        fos.write(97);
        // 一次写多个字节
        byte [] bytes = {65, 66, 67};
        fos.write(bytes);
        // 写字节数组的一部分
        fos.write(bytes, 1, 2);
        fos.close();
    }
}
