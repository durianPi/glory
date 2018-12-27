package com.dreamlee.exam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: DreamLee
 * @date: Created on 21:31 2018/11/22
 * @description: 算法题，请给出下面二维数组的排序算法
 * int[][] Sort(int[][] input)
 * 测试用例：
 * 输入：
 * [1]	    [3]	    [2]	    [4]	    [5]
 * [6]	    [7]	    [9]	    [8]	    [10]
 * [11]	    [13]	[12]	[14]	[15]
 * [17]	    [16]	[18]	[19]	[20]
 * [22]	    [24]	[23]	[21]	[25]
 * 输入乱序
 * 输出：
 * [11]	    [7]	    [4]	    [2]	    [1]
 * [16]	    [12]	[8]	    [5]	    [3]
 * [20]	    [17]	[13]	[9]	    [6]
 * [23]	    [21]	[18]	[14]	[10]
 * [25]	    [24]	[22]	[19]	[15]
 * 注意输出的数字是沿对角排序, 注意处理2维数组的下标.
 * 输入可以是hard code的常量,如果是这样,请将输入也打印到控制台.
 * @modified:
 */
public class TwoDimensionArray {

    public static int[][] sort(int[][] input) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null != input)
            for (int[] arr : input)
                for (int i : arr)
                    list.add(i);
        else
            return null;
        //设数组input[m][n]，则行数m，列数n
        int m = input.length;
        //此处暂未对input[0]进行校验
        int n = input[0].length;
        Collections.sort(list);
        int index = 0;
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = n - i - 1;
            for (int j = 0; j <= i; j++)
                input[x++][y++] = list.get(index++);
        }
        for (int i = 0; i < m - 1; i++) {
            int y = 0;
            int x = i + 1;
            for (int j = 0; j < m - 1 - i; j++)
                input[x++][y++] = list.get(index++);
        }
        return input;
    }

    public static void print(int[][] arr) {
        if (null != arr)
            for (int[] arr2 : arr) {
                for (int i : arr2) {
                    System.out.print("[" + i);
                    System.out.print("] \t");
                }
                System.out.println();
            }
        else
            System.out.println("null");
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,2,4,5},{6,7,9,8,10},{11,13,12,14,15},{17,16,18,19,20},{22,24,23,21,25}};
        print(arr);
        sort(arr);
        System.out.println();
        print(arr);
    }
}
