package algorithm;

/**
 * @author yuyunlong
 * @date 2021/3/13 4:57 下午
 * @description https://leetcode-cn.com/leetbook/read/sort-algorithms/eul7hm/
 */
public class QuikSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        //将数组分区，确定一个基数的位置
        int middle = partition(array, start, end);
        //左边继续排
        quickSort(array, start, middle - 1);
        //右半区继续排
        quickSort(array, middle + 1, end);

    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];

        int left = start + 1;
        int right = end;
        while (left < right) {
            //从左到右第一个大于pivot的数
            while (array[left] < pivot && left < right) {
                left++;
            }
            //从右到左第一个小于pivot的数
            while (array[right] > pivot && right > left) {
                right--;
            }
            exchange(array, left, right);
        }

        if (left == right && array[right] > pivot) {
            right--;
        }
        //交换基数与转轴
        exchange(array, start, right);
        return right;
    }

    public static void exchange(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{4,7,9, 2,1, 0, 3, 44, 12, 564, 5, 21, 67};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
    }
}
