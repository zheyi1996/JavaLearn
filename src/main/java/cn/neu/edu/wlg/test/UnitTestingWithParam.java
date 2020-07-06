package cn.neu.edu.wlg.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UnitTestingWithParam {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    void testAbs(int x) {
        System.out.println(x);
    }

    @ParameterizedTest
    @ValueSource(strings = "w l g")
    void testString(StringBuffer x) {
        System.out.println(x);
    }
}
