package cn.neu.edu.wlg.base.file;

import java.io.File;

public class FileDemo003 {

    public static void main(String[] args) {
        show();
    }
    private static void show() {
        File file = new File("D:\\project\\java\\JavaLearn");
        String [] arr = file.list();
        for (String filename : arr) {
            System.out.println(filename);
        }

        File [] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }
}
