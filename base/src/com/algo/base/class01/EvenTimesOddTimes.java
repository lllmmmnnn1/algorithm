package com.algo.base;

/**
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 * 加入有一个数组
 * [2,4,4,3,3,3,4,2,4]
 * 4出现了4次 2出现了2次 3出现了3次
 * 偶数次的数异或自己即会变成0 最终只会剩下奇数次的数字
 */
public class EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4,3,4,2,2,1,4,3};
        printOddTimesNum2(arr2);

    }

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     *怎么把一个int类型的数，提取出最右侧的1来
     * 比如一个数N 他的二进制
     *      N=10001011001
     *取反 ~N=01110100110
     *  ~N+1=01110100111
     *N&((~N)+1)=00000000001
     *N&((~N)+1)
     * 同或运算 相同为1 不同为0 最后可以取出最右侧的1
     *
     */

    /**
     * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        int rightOne = eor & (-eor + 1); // 提取出最右的1


        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    //计算二进制数中有多少1
    public static int bit1counts(int N) {
        int count = 0;

        //   011011010000
        //   000000010000     1

        //   011011000000

        while(N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
            // N -= rightOne
        }
        return count;
    }


}
