package oa.bluemoon.com.cn.lib_java.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {
    public static void main(String[] args) {
        int[][] res = test(17, 17);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                StringBuilder s = new StringBuilder(String.valueOf(res[i][j]));
                for (int k = s.length(); k <= 4; k++) {
                    s.append(" ");
                }
                System.out.print(s.toString());
            }
            System.out.println();
        }
    }

    public static int[][] test(int m, int n) {
        int[][] result = new int[n][m];
        int[] ms = new int[]{1, 0, -1, 0};
        int[] ns = new int[]{0, 1, 0, -1};
        int cP = 0;
        int x = 0, y = 0;
        for (int i = 1; i <= m * n; i++) {
            result[y][x] = i;
            if (x + ms[cP] == m || x + ms[cP] == -1 || y + ns[cP] == n || y + ns[cP] == -1 || result[y + ns[cP]][x + ms[cP]] != 0) {
                cP = (cP + 1) % 4;
            }
            x += ms[cP];
            y += ns[cP];
        }
        return result;
    }
}
