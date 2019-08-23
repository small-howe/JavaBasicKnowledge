package com.tangwh.fors;

import javax.sound.midi.SoundbankResource;

public class forDemo {

    public static void main(String[] args) {
        /**
         * for 循环(初始值;重点判断条件;变化量){
         *
         *  System.out.println("跑了第"+i+"圈了");
         * }
         */
        for (int i=0;i<=5;i++){
            System.out.println("跑了第"+i+"圈了");
        }
        int num = (1<3) ? 1:2;

        System.out.println(num);
       int m=1;
    int n=2;
    //m :   1                    1          0
    //n :           3    3           1
    //sum   1   +  3  -  3   -  1  + 2   -  0
    int sum=m++ + ++n -  n-- - --m + n-- - --m;
        //    //
        System.out.println(m);
        System.out.println(n);
        System.out.println(sum);
    }
}
