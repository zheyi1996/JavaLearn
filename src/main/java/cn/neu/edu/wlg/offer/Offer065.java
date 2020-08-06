package cn.neu.edu.wlg.offer;

/*
    题目：矩阵中的路径
    思路：
        - 1. 找到第一个字母出现的所有位置并记录到Map中 -- 不需要，直接用函数进行判断
        - 2. 遍历map尝试从每个初始位置开始进行搜索
        3. 如果当前位置的上下左右没有走过的点中不包含下一个字符，则返回false
        4. 如果走到最后一个字符，则返回true
        重点，由于矩阵是一维数组，所以需要根据i,j计算出当前字符在一维数组中的位置
 */
public class Offer065 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean [] flag = new boolean[matrix.length]; // 标志
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (getPath(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean getPath(char[] matrix, int i, int j, int rows, int cols, boolean [] flag, char[] str,int k) {
        // 计算二维坐标对应的一维坐标的位置
        int index = i * cols + j;
        // 判断搜索是否越界
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || true == flag[index]) {
            return false;
        }
        if (k == str.length - 1) { // 搜索到了
            return true;
        }
        // 搜索
        flag[index] = true;
        // 上下左右遍历
        if (getPath(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                getPath(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                getPath(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                getPath(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
