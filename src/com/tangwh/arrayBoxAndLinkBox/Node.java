package com.tangwh.arrayBoxAndLinkBox;

/**
 * 双向链表结构  节点: 【上】  【数据】  【下】
 */
public class Node {

    public Node prev; //上一个Node对象
    public int item; // 当前数据
    public Node next; // 下一个node 对象

    public Node(Node prev, int item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
