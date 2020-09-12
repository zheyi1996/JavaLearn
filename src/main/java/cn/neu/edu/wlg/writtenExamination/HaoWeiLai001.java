package cn.neu.edu.wlg.writtenExamination;

public class HaoWeiLai001 {
    public void reOrderArray(int [] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        int [] temp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                temp[j++] = array[i];
            }
        }
        j = array.length - 1;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] % 2 == 0) {
                temp[j--] = array[i];
            }
        }

        for (int i = 0; i < array.length; ++i) {
            array[i] = temp[i];
        }
    }
}
