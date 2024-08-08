package sort;

public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,6,3,5,2};
        BubbleSort.bubbleSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
