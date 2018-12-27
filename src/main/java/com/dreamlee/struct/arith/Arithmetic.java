package com.dreamlee.struct.arith;

/**
 * @author: DreamLee
 * @date: Created on 19:58 2018/11/6
 * @description:
 * @modified:
 */
public class Arithmetic {

    public static void bubblingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void bubblingSortPro(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void selectSortPro(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                //取出此轮比较的数组中最小值的下标赋给k
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(arr, k, i);
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (a < 0 || b < 0 || a >= arr.length || b > arr.length) {
            throw new IllegalArgumentException("The argument is out of boundary.");
        } else {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,9,7,1,3,6,0,4,8};
        insertSort(arr);
        print(arr);
    }

}
