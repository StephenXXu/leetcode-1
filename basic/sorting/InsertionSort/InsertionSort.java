import java.util.Arrays;

public class InsertionSort {
    //分为2个区间，已排序区间和未排序期间，初始已排序期间为nums[0]
    private static void insertionSort(int[] nums) {
        for (int i = 1, j, n = nums.length; i < n; ++i) {
            int num = nums[i];
            for (j = i - 1; j >=0 && nums[j] > num; --j) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }




    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8,0,2,3,4};
        myInsertionSort(nums);
        //insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void myInsertionSort(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            int num = nums[i];
            // 未排序区间往已排序区间插入
            int j;
            for (j = i - 1; j >= 0 && num < nums[j]; j --) {
                    nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }
}
