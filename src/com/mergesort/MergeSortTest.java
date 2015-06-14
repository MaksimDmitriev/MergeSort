package com.mergesort;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Random;

public class MergeSortTest {

    private Random mRandom = new Random();
    private MergeSort mMergeSort = new MergeSort();

    @SuppressWarnings("deprecation")
    @Test
    public void testMergeSort() {
        // Empty array
        Assert.assertTrue(assertSorted(mMergeSort.getArray()));

        // Even number of elements
        mMergeSort.setArray(generateArray(8096));
        mMergeSort.sort();
        Assert.assertTrue(assertSorted(mMergeSort.getArray()));

        // Odd number of elements
        mMergeSort.setArray(generateArray(7997));
        mMergeSort.sort();
        Assert.assertTrue(assertSorted(mMergeSort.getArray()));

        // Already sorted
        int[] sorted = new int[1000000];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = i;
        }
        mMergeSort.setArray(sorted);
        mMergeSort.sort();
        Assert.assertTrue(assertSorted(mMergeSort.getArray()));

    }

    private int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = mRandom.nextInt();
        }
        return array;
    }

    private boolean assertSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return false;
            }
        }
        return true;
    }

}
