package com.tangwh.arrayBoxAndLinkBox;

public class ArrayBox implements Box{


    // 设置静态常量 设置默认数组的长度
    private static final int DEFAULT_CAPACITY = 10;

    // 构造方法重载
    public ArrayBox() {

        elementDate = new int[DEFAULT_CAPACITY];
    }

    public ArrayBox(int capacity) {
        elementDate = new int[capacity];

    }

    // 设置一个属性用来存储数据
    public int elementDate[];
    // 再设计一个属性 用来记录自己存储数据的个数
    private int size = 0;

    // 获取size 有效的个数
    public int size() {
        return size;
    }


    // 将用户给的 element 的保存起来  参数是:要存起来的元素  返回值:是否 存储成功
    public boolean add(int element) {
        // 首先添加的时候 去判断当前容量 是否能满足你要存的 数字  所需的容量 + 1
        this.ensureCapacityInternal(size + 1);
        // 上边的 代码通过 说明 elementDate 数组长度肯定够用 将新来的元素存入数组中
        elementDate[size++] = element;

        return true;
    }

    // 设计一个方法在 添加元素时 来判断容量           参数事:size +1
    private void ensureCapacityInternal(int minCapacityb) {
        // 判断 需要的容量和 数组大小去比较
        if (minCapacityb - elementDate.length > 0) {
            // 容量不够则需要扩容
            this.grow(minCapacityb);

        }

    }

    //扩容后  需要把原数组的值 移到 新数组长度 参数:elementDate(原数组的长度)
    private int[] copyOf(int[] oldArray, int newCapacityb) {
        // 按照新数组长度 创建一个新的数组
        int[] newArray = new int[newCapacityb];
        for (int i = 1; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        //将新数组返回
        return newArray;
    }


    // 计算扩容      参数是：size+1
    private void grow(int minCapacityb) {
        // 获取原数组的长度
        int oldCapacityb = elementDate.length;
        // 在元素组的长度 1.5 倍
        int newCapacityb = oldCapacityb + (oldCapacityb >> 1);
        // 新数组长度  和 所需的长度再做比较
        if (newCapacityb - minCapacityb < 0) {
            // 新数组的长度小于所需的长度   那么直接用所需的长度
            newCapacityb = minCapacityb;
        }
        // 将元素组的元素移入新的数组  最后在移入旧的数组
        elementDate = this.copyOf(elementDate, newCapacityb);

    }


    // 来获取给定位置的元素   参数是:索引位置  返回值是:取得该元素
    public int get(int index) {
        // 判断给定的index 是否合法
        this.rangeCheck(index);
        // 上述代码通过 则 合法
        // 找到index 对应的元素 然后取出元素
        return elementDate[index];
    }

    // 判断给定的index 是否合法
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            // 自定义异常
            throw new BoxIndexOutOfBoundsException("Index:" + index + ",Size" + size);

        }

    }

    // 删除给定位置的元素   参数是: 索引位置  返回值:删除掉的那个元素
    public int remove(int index) {
        // 判断给定的index 是否合法
        this.rangeCheck(index);
        // 找到index 元素  先保存起来 留给用户
        int oldValue = elementDate[index];
        // 从index 元素开始 至 size-1 结束 依次覆盖前面的元素
        for (int i = index; i < size - 1; i++) {
            elementDate[i] = elementDate[i + 1];
        }
        elementDate[--size] = 0;
// 旧数据返回
        return oldValue;
    }
}
