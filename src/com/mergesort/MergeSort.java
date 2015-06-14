package com.mergesort;

// Inspired by http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
public class MergeSort {

    private int[] array;
    private int[] helper;

    public MergeSort() {
        initArray(new int[] {});
    }

    public MergeSort(int[] array) {
        initArray(array);
    }

    private void initArray(int[] array) {
        this.array = array;
        this.helper = new int[array.length];
    }

    public void setArray(int[] array) {
        initArray(array);
    }

    public int[] getArray() {
        return array;
    }

    public void sort() {
        sort(0, array.length - 1);
    }

    private void sort(int start, int end) {
        if (end > start) {
            int middle = (start + end) / 2;
            sort(start, middle);
            sort(middle + 1, end);
            mergeRoutine(start, middle, end);
        }
    }

    private void mergeRoutine(int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = array[i];
        }
        int k = start;
        int i = start;
        int j = middle + 1;
        while (i <= middle && j <= end) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest. Either of the while loops works, not both.
        while (i <= middle) {
            array[k] = helper[i];
            i++;
            k++;
        }
    }

}
