/**
 * Created by Ealing on 4/29/18.
 */
public class SortAlgorithms {
    public static void selectSort(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int i = index;
            int min = nums[index];
            int minIndex = index;
            while (i < nums.length) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
                i++;
            }

            swap(nums, index, minIndex);
            index++;
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {64,25,12,22,11};
//        selectSort(test);
//        bubbleSort(test);
        insertionSort(test);

        for (int i: test) {
            System.out.print(i+",");
        }
    }
}
