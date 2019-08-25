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
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        Object o = linkedList.get(3);
        System.out.println(o);

        LinkedBox linkedBox =new LinkedBox();
        linkedBox.add(1);
        linkedBox.add(2);
        linkedBox.add(3);
        linkedBox.add(4);
        int i1 = linkedBox.get(1);
        System.out.println(i1);

    }
}
