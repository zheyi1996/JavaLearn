package cn.neu.edu.wlg.writtenExamination;

public class Nongye001 {
    public static void main(String[] args) {
        String[] points = {"1,1","2,2","1,2","1,3"};
//        String[] points = {"1,1","1,1","1,1","1,1"};
        System.out.println(get_index(points));
    }

    public static int get_index(String[] points) {
        double[] x = new double[points.length];
        double[] y = new double[points.length];
        int i = 0;
        double centroidX, sumX = 0;
        double centroidY, sumY = 0;
        for(String str : points) {
            x[i] = Integer.parseInt(str.split(",")[0]);
            y[i] = Integer.parseInt(str.split(",")[1]);
            sumX += x[i];
            sumY += y[i++];
        }
        centroidX = sumX / points.length;
        centroidY = sumY / points.length;
        int index = -1;
        double minDist = 0x3f3f3f3f;
        //计算距离^2
        for(i = 0; i < points.length; ++i) {
            double temp = (x[i] - centroidX) * (x[i] - centroidX) +
                    (y[i] - centroidY) * (y[i] - centroidY);
            if (temp < minDist) {
                minDist = temp;
                index = i;
            }
        }
        return index;
    }
}
