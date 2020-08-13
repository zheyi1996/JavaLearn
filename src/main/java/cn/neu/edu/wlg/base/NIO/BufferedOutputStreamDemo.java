package cn.neu.edu.wlg.base.NIO;

import java.io.*;

public class BufferedOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 1. 创建FileOutputStream
        FileOutputStream fos = new FileOutputStream("D:\\project\\java\\JavaLearn\\src\\main\\java\\cn\\neu\\edu\\wlg\\base\\NIO\\NIOData.txt", true);
        // 2. 创建BufferedOutputStream
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 3. 调用write方法
        bos.write("我要把数据写入到内部缓冲区中".getBytes());
        // 4. 使用flush，将内部缓冲区中的数据刷新到文件中
        bos.flush();
        // 5. 释放资源
        bos.close();
    }
}
