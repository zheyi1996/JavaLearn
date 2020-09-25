//private static int piPei(char[] str1, char[] str2, int N, int K) {
//    int[] d = new int[N + 1];
//    for (int i = 1; i <= N; i++) {
//        d[i] = str1[i - 1] == str2[i - 1] ? d[i - 1] + 1 : d[i - 1];
//    }
//    return d[N];
//}
//
//private static int noPiPei(char[] str1, char[] str2, int N, int K) {
//    int[] d = new int[N + 1];
//    for (int i = 1; i <= N; i++) {
//        d[i] = str1[i - 1] != str2[i - 1] ? d[i - 1] + 1 : d[i - 1];
//    }
//    return d[N];
//}
//
//
//
//public static Interval solve(int n, int k, String str1, String str2){
//    int pipei = piPei(str1.toCharArray(), str2.toCharArray(), n, k);
//    int nopipei = noPiPei(str1.toCharArray(), str2.toCharArray(), n, k);
//    int r1 = 0;
//    if (pipei <= k) r1 = pipei;
//    r1 += n-k;
//    int r2 = Math.max(pipei - nopipei, 0);
//    return new Interval(r2, r1);
//}
