package cn.neu.edu.wlg.writtenExamination;

import java.util.*;

public class XiaoHongShu003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<Box> lists = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            int n = scanner.nextInt();
            for(int j = 0; j < n; ++j) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                Box box1;
                Box box2;
                Box box3;
                if(x < y) {
                    box1 = new Box(x, y, z);
                } else {
                    box1 = new Box(y, x, z);
                }

                if(y < z) {
                    box2 = new Box(y, z, x);
                } else {
                    box2 = new Box(z, y, x);
                }
                if(x < z) {
                    box3 = new Box(x, z, y);
                } else {
                    box3 = new Box(z, x, y);
                }
                lists.add(box1);
                lists.add(box2);
                lists.add(box3);
            }
            Collections.sort(lists ,new Comparator<Box>() {
                @Override
                public int compare(Box o1, Box o2) {
                    return o1.getX() - o2.getX();
                }
            });
            Collections.sort(lists ,new Comparator<Box>() {
                @Override
                public int compare(Box o1, Box o2) {
                    return o1.getY() - o2.getY();
                }
            });
            int sum = 0;
            int[] temp = new int[lists.size()];
            Box boxOne = lists.get(0);
            temp[0] = boxOne.z;
            for(int k = 1; k < lists.size(); ++k) {
                Box boxTwo = lists.get(k);
                if(boxTwo.getX() == boxOne.getX()) {
                    temp[k] = Math.max(boxOne.z, boxTwo.z);
                } else {
                    for(int t = k - 1; t >= 0; --t) {
                        Box little = lists.get(t);
                        if(boxTwo.y > little.y) {
                            sum += temp[t];
                        }
                    }
                }
            }
        }
    }
}
class Box {
    int x;
    int y;
    int z;
    public Box(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
