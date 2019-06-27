package oa.bluemoon.com.cn.lib_java;

import java.util.Arrays;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * <p>
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>
 * Rectangle Area
 * <p>
 * 示例:
 * <p>
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 */
public class _0223_Rectangle_Area {

    public static void main(String[] args) {
        System.out.print(new _0223_Rectangle_Area().computeArea1(-3, 0, 3, 4, 0, -1, 9, 2) + "");
    }

    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (A >= G || B >= H || C <= E || D <= F) {
            //先过滤不相交的情况
            return area2 + area1;
        }

        int overlap = 0;
        int left1, left2, bottom1, bottom2, right1, right2, top1, top2;

        //找到面积小的那个，提高遍历速度
        if (area1 < area2) {
            left1 = A;
            bottom1 = B;
            right1 = C;
            top1 = D;
            left2 = E;
            bottom2 = F;
            right2 = G;
            top2 = H;
        } else {
            left1 = E;
            bottom1 = F;
            right1 = G;
            top1 = H;
            left2 = A;
            bottom2 = B;
            right2 = C;
            top2 = D;
        }

//借助int类型的特异性，分成小方格
        for (int i = left1; i < right1; i++) {
            for (int j = bottom1; j < top1; j++) {
                //这里找到某个格子左下那个点
                if (i >= left2 && i < right2 && j >= bottom2 && j < top2) {
                    //这个格子同时落在另一个矩形内
                    overlap++;
                }
            }
        }
        return area1 + area2 - overlap;
    }

    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = 0;
        int[] horizontals = new int[]{A, C, E, G};
        int[] verticals = new int[]{B, D, F, H};
        Arrays.sort(horizontals);
        Arrays.sort(verticals);
        for (int i = 0; i < horizontals.length - 1; i++) {
            for (int j = 0; j < verticals.length - 1; j++) {
                int h1 = horizontals[i];
                int h2 = horizontals[i + 1];
                int v1 = verticals[j];
                int v2 = verticals[j + 1];
                if ((h1 >= A && h1 < C && v1 >= B && v1 < D) || (h1 >= E && h1 < G && v1 >= F &&
                        v1 < H)) {
                    result += (h2 - h1) * (v2 - v1);
                }
            }
        }
        return result;
    }

    public int computeArea3(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = (A - C) * (B - D) + (E - G) * (F - H);
        if (A >= G || B >= H || C <= E || D <= F) {
            return result;
        }else{
            int[] horizontals = new int[]{A, C, E, G};
            int[] verticals = new int[]{B, D, F, H};
            Arrays.sort(horizontals);
            Arrays.sort(verticals);
            return result-(horizontals[2]-horizontals[1])*(verticals[2]-verticals[1]);
        }
    }
}
