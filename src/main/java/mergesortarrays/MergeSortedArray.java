package mergesortarrays;

import java.util.Arrays;
import java.util.stream.IntStream;

class MergeSortedArray {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numbersFromNums1 = Arrays.copyOfRange(nums1, 0, m);
        int[] array = IntStream.concat(Arrays.stream(numbersFromNums1), Arrays.stream(nums2))
                               .sorted()
                               .toArray();
        System.out.println(Arrays.toString(array));
        return array;
    }



}
