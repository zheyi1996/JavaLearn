package cn.neu.edu.wlg.base.file;

import java.io.File;

public class FileDemo002 {

    public static void main(String[] args) {
        FileDemo002.show();
    }
    private static void show() {
        File f1 = new File("D:\\project\\java\\JavaLearn\\README.md");
        System.out.println(f1);
    }
}
