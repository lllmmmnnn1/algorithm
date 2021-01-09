package com.algo.base;

import java.sql.SQLOutput;

/**
 * 异或运算
 * 6^7
 * 6拆分成为二进制110 7拆分二进制111
 * 110
 * 111
 * 001
 * 相同为0 不同为1
 * 所以 6^7 是001
 * <p>
 * 同或运算：相同为1 不同为0
 * 异或运算可以记为无进位相加
 * <p>
 * 异或运算的性质
 * <p>
 * 0^N == N      N^N == 0
 * 异或运算满足交换律和结合率
 * <p>
 * 上面的两个性质用无进位相加来理解就非常的容易
 */

public class XOROperation {

    public static void main(String[] args) {
        //如何不用额外变量交换两个数
        //只试用于不同内存区域的数字交换，如果同意区域的数组交换不了，变为0了
        int a = 1;
        int b = 2;
        System.out.println("a=" + a + "------" + "b=" + b);

        a = a ^ b;//此时b不变  a=a^b
        b = a ^ b;//此时 b= a^b^b = a  a=a^b
        a = a ^ b;//此时 b = a a=a^b^a=b

        System.out.println("a=" + a + "------" + "b=" + b);
        int[] arr = {3,1,100};

        int i = 0;
        int j = 0;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

        System.out.println(arr[i] + " , " + arr[j]);









        System.out.println(arr[0]);
        System.out.println(arr[2]);

        swap(arr, 0, 0);

        System.out.println(arr[0]);
        System.out.println(arr[2]);



    }


    public static void swap (int[] arr, int i, int j) {
        // arr[0] = arr[0] ^ arr[0];
        arr[i]  = arr[i] ^ arr[j];
        arr[j]  = arr[i] ^ arr[j];
        arr[i]  = arr[i] ^ arr[j];
    }


}
