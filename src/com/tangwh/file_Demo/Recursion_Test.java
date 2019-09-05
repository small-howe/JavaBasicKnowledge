package com.tangwh.file_Demo;

public class Recursion_Test {
 private  void  testOne(){
     this.testTwo();
     System.out.println("我是testOne");
 }
    private  void  testTwo(){
     this.testThree();
        System.out.println("我是testTwo");
    }
    private  void  testThree(){
        System.out.println("我是testThree");

    }
    //递归的想法
    //  想让我做事(盖第五层) 我要求让别人把之前的事情做完
    //      1.让别人先做事
    //      2.我自己做事
    public void buildTower(int floor){//5
        //判断当前floor是否为1 若不是找一个别人先盖之前层
        if(floor>1){
            this.buildTower(floor-1);
        }
        //我自己做事
        System.out.println("盖到第"+floor+"层宝塔啦");
    }
    public static void main(String[] args) {
     Recursion_Test recursion_test = new Recursion_Test();
     recursion_test.buildTower(5);

    }
}
