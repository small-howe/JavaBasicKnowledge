package com.tangwh.arrayBoxAndLinkBox;


/**
 * 链式结构
 *
 */
public class LinkedBox  extends AdapterMode {

    // 创建几个属性  记录首节点  尾节点  有效元素的个数
    private Node first; // 记录首节点
    private Node last;  // 记录尾节点

    private int size; // 有效元素的个数


    // 添加方法
    public boolean add(int element) {
        // 将传进来的 element 添加至Node 节点至尾端 中
        this.linkLast(element);
        // 添加成功
        return true;
    }

    // 将element 添加至 Node 节点尾端
    private void linkLast(int element) {
        // 获取 节点 Node 尾端
       Node l = last;
        // 创建一个新的Node 将数据包装起来
        Node nweNode = new Node(l, element, null);
        //将新节点对象设置为 尾几点
        last =nweNode;
        // 判断 自己 是不是首节点  如果原来没有尾节点 那么自己就是新的一个节点 从未使用过
        if (l == null) {
            first = nweNode;
        } else {  //之前有 节点 那么需要 之前得节点 链接我
            l.next = nweNode;
        }
        // 有效元素个数 加 1
        size++;
    }


    // 获取方法
    public int get(int index) {

        //
        // 判断给的index 是否合法
        this.checkElementIndex(index);
        // 通过index 查找Node对象
        Node targetNode = this.node(index);
        return targetNode.item;

    }

    private Node node(int index) {

        Node targetNode;// 声明一个变量 用来存储当前目标
        // 通过上边的代码 index 合法  判断index 在size的前半部 还是后半部分  index小于 一半 则在前半部分
        if (index < (size >> 1)) {// 从前往后
            targetNode = first; //把第一个存储
            for (int i = 0; i < index; i++) {
                targetNode = targetNode.next;
            }
        } else {
            targetNode = last; //把最后一个存储
            for (int i = size - 1; i > index; i--) {

                targetNode = targetNode.prev;
            }
        }
        return targetNode;
    }

    // 判断index 是否合法
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new BoxIndexOutOfBoundsException("Index:" + index + ",size" + size);
        }
    }


    // 移除方法
    public int remove(int index) {
        // 检测范围是否合法
        this.checkElementIndex(index);
        //通过index 找到对应属性
        Node targetNode = this.node(index);
        int oldValue = this.unlink(targetNode);
        return oldValue;
    }

    // 删除
    private int unlink(Node targetNode) {
        Node prev = targetNode.prev; // 当前对象的上一个
        int oldValue = targetNode.item;//当前对象
        Node next = targetNode.next;//当前对象的下一个


        //判断 targetNode处在那个位置
        if (prev == null) { //当 targetNode 为第一个 则上一个为 null
            first = next;
        } else {
            prev.next = next;//上一个节点的 写一个 等于下一个
            targetNode.prev = null;
        }

        if (next == null) { // 当targetNode  是最后一个
            last = prev;

        } else {
            next.prev = prev;
            targetNode.next = null;
        }
        // 让有效元素 --
        size--;
        return oldValue;


    }


    public int size() {
        return size;
    }


}
