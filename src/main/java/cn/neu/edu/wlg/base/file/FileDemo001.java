package cn.neu.edu.wlg.base.file;

import java.io.File;

public class FileDemo001 {

    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator); // 路径分隔符 Windows：分号  Linux：冒号

        // 路径不能写死
        String separator = File.separator;
        System.out.println(separator); // 文件名称分隔符 Windows：\  Linux：/
    }
}
