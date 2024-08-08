package sort;


public class QuickSort {
    public static int partition(int[] nums, int L, int R) {
        int left = L, right = R;
        int pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right -= 1;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left += 1;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void quickSort(int[] nums, int L, int R) {
        if (L >= R) return;
        int idx = partition(nums, L, R);
        quickSort(nums, L, idx - 1);
        quickSort(nums, idx + 1, R);
    }

    public static void main(String[] args) {
        int[] nums = {10,5,7,3,1};
        quickSort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}


