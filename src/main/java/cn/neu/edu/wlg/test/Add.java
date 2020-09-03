package cn.neu.edu.wlg.test;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Add extends Thread {

    public void run() {
        System.out.println("run");
    }
    public static void main(String[] args) {
        (new Add()).start();
    }

}
