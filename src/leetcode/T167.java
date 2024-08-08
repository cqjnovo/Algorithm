package leetcode;

public class T167 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return null;
    }
}
