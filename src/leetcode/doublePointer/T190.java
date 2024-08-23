package leetcode.doublePointer;

/**
 * @description: 颠倒二进制位
 * @author: lzy
 * @time: 2024/8/23 9:38
 */
public class T190 {
    public static void main(String[] args) {
        T190 solution = new T190();
        System.out.println(Integer.toBinaryString(43261596));
        solution.reverseBits(43261596);
    }

    /**
     * 使用双指针模拟颠倒二进制位的过程
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        //高位补0
        if (binaryString.length() < 32) {
            binaryString = "0".repeat(32 - binaryString.length()) + binaryString;
        }
        char[] chars = binaryString.toCharArray();
        int len = chars.length;
        int left = 0, right = len - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left += 1;
            right -= 1;
        }
        String reverseBinaryString = new String(chars);
        return Integer.parseUnsignedInt(reverseBinaryString, 2);
    }

    /**
     * 使用位运算模拟
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        int i = 0;
        int res = 0;
        while (i < 32 && n != 0) {
            res = res | (n & 1) << (31 - i);
            //无符号右移，高位补0
            n >>>= 1;
            i += 1;
        }
        return res;
    }
}
