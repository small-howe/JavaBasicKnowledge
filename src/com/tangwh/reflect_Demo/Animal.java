package com.tangwh.reflect_Demo;



public class Animal {
 public String anmi;

 @MyAnnotation_Test("as")
 public void sleep(){

  System.out.println("动物的睡觉方法");
 }
}
