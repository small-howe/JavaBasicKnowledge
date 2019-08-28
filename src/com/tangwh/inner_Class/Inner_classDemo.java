package com.tangwh.inner_Class;

public class Inner_classDemo {
    private String name="正常类中的属性";

    public void testDemo(){
        System.out.println("正常类中的方法");
    }

    /**
     * 定义成员内部了
     */
    public void show(){

        class InnerMethod{


        }

    }


    /**
     * 成员内部类
     */
    public class Inner_classDemo1{
        private String name="成员内部类中的属性";

        public void testDemo1(){
            System.out.println("成员内部类中的方法"+Inner_classDemo.this.name);
            Inner_classDemo.this.testDemo();
        }
    }

}
