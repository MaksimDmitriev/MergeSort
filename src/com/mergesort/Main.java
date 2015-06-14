package com.mergesort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 2;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }

        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort();
    }
}
