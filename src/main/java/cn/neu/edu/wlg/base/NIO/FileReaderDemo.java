package cn.neu.edu.wlg.base.NIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("D:\\project\\java\\JavaLearn\\src\\main\\java\\cn\\neu\\edu\\wlg\\base\\NIO\\NIOData.txt");
        int len = 0;
        while ((len = file.read()) != -1) {
            System.out.println((char)len);
        }
        file.close();
    }
}
