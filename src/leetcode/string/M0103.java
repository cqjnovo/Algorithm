package leetcode.string;

/**
 * @description: 将字符串S中所有的空格替换为"%20"
 * length表示字符串S中所有字符结束的位置，从这个位置开始向前遍历，遇到''就在idx处替换成'%20',否则就替换原本的字符
 * 结束时，idx+1开始，到字符串结尾即为最终的结果
 * @author: lzy
 * @time: 2024/12/7 10:03
 */
public class M0103 {
    public static void main(String[] args) {
        M0103.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",27);
    }
    public static String replaceSpaces(String S, int length) {
        char[] charArray = S.toCharArray();
        int idx = charArray.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                charArray[idx--] = '0';
                charArray[idx--] = '2';
                charArray[idx--] = '%';
            } else {
                charArray[idx--] = charArray[i];
            }
        }
        //offset表示跳过数组中前几个字符，count表示子数组的长度
        return new String(charArray,idx+1,charArray.length-1-idx);
    }
}
