import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] sourceArray = new int[]{3, 4, 2, 1, 0, 0, 4, 3, 4, 2};
        int[] result = countingSort(sourceArray);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 计数排序是一种非基于比较的排序算法，其空间复杂度和时间复杂度均为O(n+k)，
     * 其中k是整数的范围。基于比较的排序算法时间复杂度最小是O(nlogn)的。该算法于1954年由 Harold H. Seward 提出。
     * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，
     * 计数排序要求输入的数据必须是有确定范围的整数
     * 步骤
     * 花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
     * 数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
     * 最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
     */
    public static int[] countingSort(int[] sourceArray) {
        int[] resultArray = new int[findMax(sourceArray) + 1];
        for (int i = 0; i < sourceArray.length; i++) {
            resultArray[sourceArray[i]]++;
        }
        int index = 0;
        for (int i = 0; i < resultArray.length; i++) {
            while (resultArray[i] > 0) {
                sourceArray[index++] = i;
                resultArray[i]--;
            }
        }
        return sourceArray;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            if (item > max) max = item;
        }
        return max;
    }
}
