package mergesortarrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortedArrayTest {

    @DisplayName("Given nums1 = [1], m = 1, nums2 = [], n = 0 mergeSorted should return [1]")
    @Test
    void oneAndEmpty() {
        // Given
        int[] nums1 = { 1 };
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        // When
        int[] merged = MergeSortedArray.merge(nums1, m, nums2, n);
        // Then
        int[] expectedMerged = { 1 };
        assertThat(merged).isEqualTo(expectedMerged);
    }

    @DisplayName("Given  nums1 = [0], m = 0, nums2 = [1], n = 1 mergeSorted should return [1]")
    @Test
    void zeroAndOne() {
        // Given
        int[] nums1 = { 0 };
        int m = 0;
        int[] nums2 = { 1 };
        int n = 1;
        // When
        int[] merged = MergeSortedArray.merge(nums1, m, nums2, n);
        // Then
        int[] expectedMerged = { 1 };
        assertThat(merged).isEqualTo(expectedMerged);
    }

    @DisplayName("Given nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 mergeSorted should return [1,2,2,3,5,6]")
    @Test
    void twoNormalArrays() {
        // Given
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        // When
        int[] merged = MergeSortedArray.merge(nums1, m, nums2, n);
        // Then
        int[] expectedMerged = { 1, 2, 2, 3, 5, 6 };
        assertThat(merged).isEqualTo(expectedMerged);
    }

}
