package org.dorum.algo;

import org.dorum.utils.RecordMethodInfo;

import java.util.*;

public class AlgoExpert {

    private static final String ALGO_EXPERT_LINK = "https://www.algoexpert.io/questions";

    /**
     * <a href="{@link AlgoExpert#ALGO_EXPERT_LINK}">sumOfTwo</a>
     */
    @RecordMethodInfo(link = ALGO_EXPERT_LINK)
    public static List<int[]> sumOfTwo(int[] array, int sum) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                System.out.println("Numbers " + array[i] + " and " + array[map.get(array[i])]);
                list.add(new int[]{array[i], array[map.get(array[i])]});
            }
            map.put(sum - array[i], i);
        }
        System.out.println(map);
        return list;
    }

    /**
     * <a href="{@link AlgoExpert#ALGO_EXPERT_LINK}">sumOfNumber</a>
     */
    @RecordMethodInfo(link = ALGO_EXPERT_LINK)
    public static List<int[]> sumOfNumber(int[] array, int sum) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.println(array[i] + " with index '" + i + "'");
                    System.out.println(array[j] + " with index '" + j + "'");
                    list.add(new int[]{i, j});
                } else {
                    System.out.println(array[i] + " + " + array[j] + " = " + (array[i] + array[j]));
                }
            }
        }
        return list;
    }

    /**
     * <a href="{@link AlgoExpert#ALGO_EXPERT_LINK}">validateSubSequence</a>
     */
    @RecordMethodInfo(link = ALGO_EXPERT_LINK)
    public static boolean validateSubSequence(int[] inputArray, int[] sequenceArray) {
        int inputPointer = 0;
        int sequencePointer = 0;
        int inputLength = inputArray.length;
        int sequenceLength = sequenceArray.length;
        if (inputLength == 0 || sequenceLength == 0) {
            return false;
        }
        while (inputLength > inputPointer) {
            if (inputArray[inputPointer] == sequenceArray[sequencePointer]) {
                System.out.println("We have found a match on indexes: " + inputPointer + " | " + sequencePointer);
                sequencePointer++;
            }
            inputPointer++;
            if (sequencePointer == sequenceLength) {
                System.out.println("Input array has subsequence inside");
                return true;
            }
        }
        System.out.println("Input array doesn't have subsequence inside");
        return false;
    }

    /**
     * <a href="{@link AlgoExpert#ALGO_EXPERT_LINK}">binarySearch</a>
     */
    @RecordMethodInfo(link = ALGO_EXPERT_LINK)
    public static int binarySearch(int[] array, int target) {
        System.out.println(Arrays.toString(array));
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int middleIndex = (leftIndex + rightIndex) / 2;

        System.out.println("leftIndex: " + leftIndex);
        System.out.println("rightIndex: " + rightIndex);
        System.out.println("middleIndex: " + middleIndex);
        System.out.println("middle value: " + array[middleIndex]);
        System.out.println("__________________________");

        while (leftIndex <= rightIndex) {
            middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == target) {
                return middleIndex;
            }
            if (array[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
            System.out.println("leftIndex: " + leftIndex);
            System.out.println("rightIndex: " + rightIndex);
            System.out.println("middleIndex: " + middleIndex);
            System.out.println("middle value: " + array[middleIndex]);
            System.out.println("__________________________");
        }
        return -1;
    }
}
