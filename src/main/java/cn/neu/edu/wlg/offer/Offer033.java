package cn.neu.edu.wlg.offer;

public class Offer033 {

    public static void main(String[] args) {
        Offer033 offer033 = new Offer033();
        System.out.println(offer033.GetUglyNumber_Solution(2));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int p2 = 0, p3 = 0, p5 = 0; // 初始化三个指向三个潜在成为最小丑数
        int [] result = new int[index];
        result[0] = 1;
        for (int i = 1; i < index; ++i) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2) {
                ++p2;
            }
            if (result[i] == result[p3] * 3) {
                ++p3;
            }
            if (result[i] == result[p5] * 5) {
                ++p5;
            }
        }
        return result[index - 1];
    }
}
