package algorithm;

import java.util.LinkedHashMap;

/**
 * 异或的特性
 */

public class yihuo_practice {
    /**
     * 一个int型数组，其中有一个数是奇数个，其他数都是偶数个，如何找到这个数
     */
    public void printOddArr(int [] arr){
        int eor = 0;
        for(int i: arr){
            eor = eor ^ i;
            System.out.println(eor);
        }
    }

    /**
     * 一个int型数组，其中有两个不同的数是奇数个，其他数都是偶数个，如何找到这两个数
     * 数组异或后结果非0，所求两数中必有某一位是1，另一位是0。将原数组分成两份，一份是该位为1的集合，一份是该位为0的集合。
     * 求一个数最右侧非1位， a & (~a+1)
     */
    public void printTwoOddArr(int [] arr){
        int eor = 0;
        int eorOne = 0;
        for (int i: arr){
            eor = eor ^ i;
        }
        int rightBitOne = eor & (~eor + 1);
        for(int i: arr){
            if((i&rightBitOne)!=0){
                eorOne = eorOne ^ i;
            }
        }
        int anotherOne = eor ^ eorOne;
        System.out.println(eorOne);
        System.out.println(anotherOne);

    }
}
