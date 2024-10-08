package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.util.Arrays;

public class Sorting {

    @RecordMethodInfo()
    public static void bubbleSort(int[] inputArray) {
        System.out.println("Input:" + Arrays.toString(inputArray));
        long start = System.currentTimeMillis();
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j] < inputArray[j + 1]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
        System.out.println("Output:" + Arrays.toString(inputArray));
    }

    @RecordMethodInfo()
    public static void mergeSort(int[] inputArray) {
        int middleIndex = inputArray.length / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[inputArray.length - middleIndex];
        if (inputArray.length < 2) {
            return;
        }
        System.arraycopy(inputArray, 0, leftArray, 0, leftArray.length);
        System.arraycopy(inputArray, middleIndex, rightArray, 0, rightArray.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        sort(inputArray, leftArray, rightArray);
    }

    private static void sort(int[] array, int[] leftArray, int[] rightArray) {
        int mainIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mainIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mainIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }

        while (leftIndex < leftArray.length) {
            array[mainIndex] = leftArray[leftIndex];
            mainIndex++;
            leftIndex++;
        }

        while (rightIndex < rightArray.length) {
            array[mainIndex] = rightArray[rightIndex];
            mainIndex++;
            rightIndex++;
        }
    }
}
