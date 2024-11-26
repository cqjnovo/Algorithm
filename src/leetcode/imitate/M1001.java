package leetcode.imitate;

import java.util.Arrays;

/**
 * @description:
 * @author: lzy
 * @time: 2024/11/26 9:11
 */
public class M1001 {
    /**
     * 方法1：借助数组C复制A前m个元素，然后依次比较C和B中指定位置的元素大小，将更小的元素覆盖到A中
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        //使用一个数组存储A前m个位置,依次
        int[] C = Arrays.copyOfRange(A, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (C[i] <= B[j]) {
                A[k] = C[i];
                i += 1;
            } else {
                A[k] = B[j];
                j += 1;
            }
            k += 1;
        }
        while (i < m) {
            A[k] = C[i];
            i += 1;
            k += 1;
        }
        while (j < n) {
            A[k] = B[j];
            j += 1;
            k += 1;
        }
    }

    /**
     * 方法2:在1的基础上进行优化，从后向前比较,因此可以避免开辟一个新的数组
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int end = A.length - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[end] = A[m];
                m -= 1;
            } else {
                A[end] = B[n];
                n -= 1;
            }
            end -= 1;
        }
        //退出循环后，仍需要判断A,B两个数组是否没有遍历结束
        while (m >= 0) {
            A[end] = A[m];
            m -= 1;
            end -= 1;
        }
        while (n >= 0) {
            A[end] = B[n];
            n -= 1;
            end -= 1;
        }
    }
}
