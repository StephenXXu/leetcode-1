import java.util.Arrays;

public class MergeSort {
    // 合并两个已排好序的数组
    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = low;
        while (k <= high) {
            //处理边界值
            if (i > mid) {
                temp[k++] = nums[j++];
            } else if (j > high) {
                temp[k++] = nums[i++];
                //比较low->mid;mid+1->high这两个有序数组并合并
            } else if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        System.arraycopy(temp, low, nums, low, high - low + 1);
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        // 避免(high+low)/2溢出
        int mid = low + ((high - low) >> 1);
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);
        merge(nums, low, mid, high, temp);
    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 5, 3,3,5,7,9,0};
        //mergeSort(nums);
        myMergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void myMergeSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        myMergeSort(nums, 0, nums.length-1, new int[nums.length]);
    }
    private static void myMergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        myMergeSort(nums, low, mid, temp);
        myMergeSort(nums, mid + 1, high, temp);
        myMerge(nums, low, mid, high, temp);
    }
    private static void myMerge(int[] nums, int low, int mid, int high, int[] temp) {
        //k:low ~ high;i:low -mid;j:mid+1-high
        int i = low, j = mid + 1, k = low;
        while (k <= high) {
            if (i > mid) {
                temp[k++] = nums[j++];
            } else if(j > high) {
                temp[k++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        System.arraycopy(temp, low, nums, low, high - low + 1);
    }
}