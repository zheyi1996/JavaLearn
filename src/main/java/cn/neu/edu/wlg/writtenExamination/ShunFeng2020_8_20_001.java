package cn.neu.edu.wlg.writtenExamination;

import java.util.*;

/*
    1. 给服务器带宽升序排序
    2. 将带宽-钱按钱排序
    3. 用最合适的带宽满足钱给的最多的用户
 */
public class ShunFeng2020_8_20_001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] serverBandwidth = new int[n];

        for (int i = 0; i < n; ++i) {
            serverBandwidth[i] = scanner.nextInt();
        }
        Arrays.sort(serverBandwidth);
        List<User> userNeedAndPay = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            int need = scanner.nextInt();
            int pay = scanner.nextInt();
            userNeedAndPay.add(new User(need, pay));
        }
        Collections.sort(userNeedAndPay ,new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getPay() - o1.getPay();
            }
        });
        int sum = getMaxPay(n, serverBandwidth, userNeedAndPay);
        System.out.println(sum);
    }
    public static int getMaxPay(int n, int[] serverBandwidth, List<User> userNeedAndPay) {
        boolean [] flag = new boolean[n]; // 默认false true为已经被使用
        int sum = 0;
        int k = 0;
        for (User user: userNeedAndPay) {
            int temp = -1;
            // 找到第一个大于用户需要带宽的服务器
            for (int i = n - 1; i >= 0; --i) {
                if (flag[i]) {
                    continue;
                }
                if (user.getNeed() <= serverBandwidth[i]) {
                    temp = i;
                } else {
                    break;
                }
            }
            if (-1 != temp) {
                sum += user.getPay();
                flag[temp] = true;
                ++k;
                if (k == n) { // 最多n个服务器可用
                    break;
                }
            }
        }
        return sum;
    }
}
class User {

    private int need;
    private int pay;
    public User(int need, int pay) {
        this.need = need;
        this.pay = pay;
    }

    public int getPay() {
        return pay;
    }

    public int getNeed() {
        return need;
    }
}
