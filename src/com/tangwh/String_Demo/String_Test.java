package com.tangwh.String_Demo;

import java.util.LinkedList;

public class String_Test {
    public static void main(String[] args) {
 //     判断给定的s是否在字符串中存在
//                String str = "abcdefg";
//        //判断此字符串中是否含有a
//        boolean value = str.contains("a");
//        System.out.println(value);


        //  判断此字符串是否已xx开头/结尾
//        String str = "TestString.java";
//        boolean value = str.endsWith(".java");
//        System.out.println(value);


   // 将当前的字符串转化成数组   "我爱你中国"   char[]  '我' '爱' '你' '中' '国'
//
//        String str = "我爱你中国";
//        byte[] b = str.getBytes();
//        for(byte v:b){
//            System.out.println(v);//byte
//        }
//        char[] c = str.toCharArray();
//        for(char v:c){
//            System.out.println((int)v);
//        }



//  找寻给定的元素在字符串中第一次出现的索引位置   若字符串不存在则返回-1

//
//                String str = "abcdefgabc";
//        int index = str.lastIndexOf("b",7);// 从7号索引开始
//        System.out.println(index);//1  不论从哪儿开始找寻 返回的index都是相对于整个String的
//
//        str.indexOf(98,3);



       // 判断当前字符串是否为空字符串  (length是否为0)

        //        String str = "a";
//        boolean value = str.isEmpty();//NullPointerException
//        System.out.println(value);




// 将给定的字符串替换成另外的字符串
//                String str = "王者荣耀打游戏很傻逼";
//        //str = str.replace('帅','骚');
//        str = str.replace("傻逼","**");
//        System.out.println(str);



        // 按照给定的表达式将原来的字符串拆分开的
//                String str1 = "a-b-c-d";
//        String[] value = str1.split("-",3);
//        for(String v:value){
//            System.out.print(v);
//        }


        //  将当前的字符串截取一部分


//        String str = "abcdefgh";
//        str = str.substring(3);//从3号索引开始一直到最后
//      //  str = str.substring(-3,1);//从3号索引开始到5号索引结束   [3,5)
//        System.out.println(str);


        //  将全部字符串转换成大写/小写
//        String str = "abcdefg";
//        str = str.toUpperCase();
//        System.out.println(str);
//        str = str.toLowerCase();
//        System.out.println(str);
        //equalsIgnoreCase() // 忽略大小写



        //去掉字符串前后多余的空格
        String str = "  zheng zhongtuo    ";
        str = str.trim();
        System.out.println(str.equals("zhengzhongtuo"));




//------------------------------------------------------------------------------------------




//        byte[] value = new byte[]{65,97,48};
//        String str = new String(value);// Aa0
//        System.out.println(str);//

        LinkedList linkedList = new LinkedList();

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

//
//        String s1= "abc";
//        String s2= "abc";
//        System.out.println(s1.compareTo(s2));
//        String ts =new String().toString();
//        System.out.println(ts);


        //数组-->length属性
        //box--->size()方法
        //String-->length()方法

//        String str = "abcdef";//-->123456
//        String result = "";
//        for(int i=0;i<str.length();i++){
//            int value = str.codePointAt(i);
//            result += (char)(value-48);//密钥  U盾
//        }
//        System.out.println(result);

//        String str = "abcdef";
//        //String对象 (字符串常量池) value属性char[]
//        //长度不能改变 数组地址不让改变 数组属性私有的我们操作不了
//        str = str.concat("g");
//        //创建一个新的String对象  (字符串常量池)  value属性  7个
//        //刚才那个String对象value值依次取出来  存入新对象的value属性 g放在后面
//        System.out.println(str);//abcdefg ????
//        //String的不可变特性

//        String str = "a"+"b"+"c"+"d";//数学计算  拼接符号
//        System.out.println(str);//过程中产生了几个String对象? 字符串常量池7个
//        //1对象-->value[] a       "a"
//        //2对象-->value[] b       "b"
//        //3对象-->value[] {a,b}  "ab"
//        //4对象-->value[] c       "c"
//        //5对象-->value[] {a,b,c} "abc"
//        //6对象-->value[] d       "d"
//        //7对象-->value[]         "abcd"



//
//        String str = "a";
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            //str+="a";//每一次利用+在原来的字符串后面拼接一个新的a  +   9447毫秒
//            //str = str.concat("a");//利用concat拼接字符        5324毫秒
//            //StringBuffer对象  拼接效率非常高  像以前自己封装的ArrayBox
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);


//        System.out.println(str1.compareTo(str2));//int
        //按照两个字符串长度较短的那个作为比较循环的次数
        //挨个比较元素   str1[i]-str2[i]    循环内如果有结果
        //如果循环过后发现所有的字符都一样  len1-len2
        //返回0表示两个字符相等











//        String s1 ="abc";
//        String s2 ="abc";
//        String s3 = new String("abc");
//        String s4 = new String("abc");
//
//        System.out.println(s1==s2);
//        System.out.println(s1==s3);
//        System.out.println(s3==s4);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s3.equals(s4));

    }
}
