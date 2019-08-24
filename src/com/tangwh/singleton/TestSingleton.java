package com.tangwh.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        Singleton s = Singleton.getSingleton();
        Singleton s1 = Singleton.getSingleton();
        System.out.println(s==s1);// true
        System.out.println(s.equals(s1));//true

    }
}
