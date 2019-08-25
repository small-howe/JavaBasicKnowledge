package com.tangwh.arrayBoxAndLinkBox;

import javax.sound.midi.SoundbankResource;
import java.util.LinkedList;

public class Testlist {
    public static void main(String[] args) {
        ArrayBox arrayBox =new ArrayBox();
        arrayBox.add(1);
        arrayBox.add(2);
        arrayBox.add(3);
        arrayBox.add(4);

        int i = arrayBox.get(0);
        System.out.println(i);

        int remove = arrayBox.remove(2);
        System.out.println(remove);
        LinkedList linkedList = new LinkedList();
    }
}
