package com.tangwh.fors;



public class forDemo {
    public static void main(String[] args) {
        int[] list = new int[]{5,4,8,6,4,1,3,4,5,97,1,2};
         bubbleSort_2(list);
    }

  public void showFor(){
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



    public  static void bubbleSort_2(int[] list){

        int temp = 0; // 用来交换的临时数
        boolean bChange = false; // 交换标志

        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            bChange = false;
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }

            }

            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (false == bChange)
                break;


        }
        for (int i1 : list) {
            System.out.print(i1);
        }


    }
}
