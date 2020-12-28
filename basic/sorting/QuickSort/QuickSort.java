import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        //取得中轴元素所在的中轴区间
        int[] p = partition(nums, low, high);
        quickSort(nums, low, p[0] - 1);
        quickSort(nums, p[1] + 1, high);
    }

    private static int[] partition(int[] nums, int low, int high) {
        int less = low - 1, more = high, pivotal = nums[high];
        while (low < more) {
            if (nums[low] < pivotal) {
                swap(nums, ++less, low++);
            } else if (nums[low] > pivotal) {
                swap(nums, --more, low);
            } else {
                ++low;
            }
        }
        swap(nums, more, high);
        //返回中轴元素所对应的区间
        return new int[] {less + 1, more};
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 5, 3,3,4,5,6,7,3,0};
        //quickSort(nums);
        myQuickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void myQuickSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        myQuickSort(nums, 0,nums.length-1);

    }
    private static void myQuickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int[] partition = myPartition(nums, low, high);
        System.out.println("low:"+low+",high:"+high+"本次分区后的数组为");
        System.out.println(Arrays.toString(nums));
        myQuickSort(nums, low, partition[0]-1);
        myQuickSort(nums, partition[1]+1, high);
    }
    private static int[] myPartition(int[] nums, int low, int high) {
        int k=low + (high-low)/2;
        int less = low, more = high, pivotal = nums[k];
        while (low <= more) {
            if (nums[low] < pivotal) {
                swap(nums, less++, low++);
            } else if (nums[low] > pivotal) {
                swap(nums, more--, low);
            } else {
                low++;
            }
        }
        System.out.println("low:"+low+",high:"+high+"本次分区后的数组为"+"less:"+less+",more:"+more);
        if(low <=more){
            swap(nums, more, k);
        }
        return new int[]{less, more};
    }
    //low:6,high:12本次分区后的数组为less:3,more:5
    //low:0,high:12本次分区后的数组为
    //[1, 2, 0, 3, 3, 3, 4, 5, 6, 7, 5, 4, 7]
    //low:3,high:2本次分区后的数组为less:2,more:2
    //low:0,high:2本次分区后的数组为
    //[1, 0, 2, 3, 3, 3, 4, 5, 6, 7, 5, 4, 7]
    //low:2,high:1本次分区后的数组为less:1,more:1
    //low:0,high:1本次分区后的数组为
    //[0, 1, 2, 3, 3, 3, 4, 5, 6, 7, 5, 4, 7]
    //low:13,high:12本次分区后的数组为less:11,more:12
    //low:6,high:12本次分区后的数组为
    //[0, 1, 2, 3, 3, 3, 4, 5, 6, 5, 4, 7, 7]
    //low:11,high:10本次分区后的数组为less:10,more:10
    //low:6,high:10本次分区后的数组为
    //[0, 1, 2, 3, 3, 3, 4, 5, 5, 4, 6, 7, 7]
    //low:10,high:9本次分区后的数组为less:8,more:9
    //low:6,high:9本次分区后的数组为
    //[0, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7]
    //low:8,high:7本次分区后的数组为less:6,more:7
    //low:6,high:7本次分区后的数组为
    //[0, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7]
    //[0, 1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7]
}