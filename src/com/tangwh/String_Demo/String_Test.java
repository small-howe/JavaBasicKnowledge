package com.tangwh.String_Demo;

public class String_Test {
    public static void main(String[] args) {

//        byte[] value = new byte[]{65,97,48};
//        String str = new String(value);//Aa0
//        System.out.println(str);//



//        char[] value = {'h','e','l','l','o'};
//        String str = new String(value,1,3);
//        System.out.println(str);//ell
//        str.equals(null);// 默认比较地址 this==obj  String重写啦 改成了比字符串内容
//        str.hashCode();// 内存地址调用一个本地的native方法进行计算
        /**
         * "abc"   h=0
         * h = (0*31+97)
         * h = (97)*31+98
         * h = ((97)*31+98)*31+99
         *
         * public int hashCode() {
         *         int h = hash;
         *         if (h == 0 && value.length > 0) {
         *             char val[] = value;
         *
         *             for (int i = 0; i < value.length; i++) {
         *                 h = 31 * h + val[i];
         *             }
         *             hash = h;
         *         }
         *         return h;
         *     }*/

















        String s1 ="abc";
        String s2 ="abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));

    }
}
