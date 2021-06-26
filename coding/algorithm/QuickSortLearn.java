package algorithm;

/**
 * @author yuyunlong
 * @date 2021/6/21 9:31 下午
 * @description
 */
public class QuickSortLearn {

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = partition(array, start, end);
        quickSort(array, start, middle - 1);
        quickSort(array, middle + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        //以start作为基数
        int pivot = array[start];
        int left = start + 1, right = end;
        while (left < right) {
            while (left < right && array[left] < pivot) {
                left++;
            }
            while (left < right && array[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        //如果left==right，不会走到while循环里，需要单独处理
        //上面的循环有个问题，如果left加到right位置，这里不会再判断了，也不会发生交换
        if (left == right && array[right] > pivot) {
            right--;
        }
        //这里是将基数 和 中间点 交换
        swap(array, start, right);
        return start;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[right] = array[left];
        array[left] = temp;
    }
}
