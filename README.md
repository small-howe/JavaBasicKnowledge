# JAVA基础知识回顾

## I.运算符:
```
    按照操作数的功能来分：
       算数运算 : + ,  -,  /,  *, %(取余 || 取模),++(自增),--(自减)
          - i++=  (i=i+1):先将i变量的内容先取出——>常量区取出1——>进行计算 ——>再次存回i空间
          i在做值交换的时候回产生一个临时的副本空间(备份)    所以会 先(备份)后自增 会将副本赋值给对方(如果对方有值 会覆盖对方的变量的值) 随后副本的临时空间会销毁
          - (++i):先自增后(备份) 
        ----------------------------------------------------------------------------------------------------
       赋值运算 :=(赋值) ,+=, -=, *=, /=, %=(复合)
       -----------------------------------------------------------------------------------------------------
       关系运算 :< , >,  <=,  >=, !=,  ==, (对象instanceof类)
       -----------------------------------------------------------------------------------------------------
       逻辑运算(比较): '&'逻辑与 '&&' 短路与 ,   '|' 逻辑或 '||' 短路或 ,  '^' 逻辑异或 ,'!'逻辑非
          '&&' 短路与:第一个表达式则为false 则不计算后面的表达式 结果集为false;
          '||' 短路或:第一个表达式则为true 则不计算后面的表达式 结果集为true;
          '^'异或(前后两个结果不一致就可以了)   
         ----------------------------------------------------------------------------------------------------
       位bit运算:'&'按位与,  '|'按位或,  '^'按位异或,  '~'按位取反,  '<<'按位左位移, '>>'按位右位移 , '>>>'按位右位移(无符号)
                 3 & 5 = ?                                 3 & 5 = ?    3 | 5 = ?        3 ^ 5 = ?
            1.先将3和5转换成准换成二进制                  00000011        00000011         00000011 
            2.竖着按照对应位置进行&|^计算(1:true 0:false) 00000101        00000101         00000101 
            3.再将二进制准换成10进制                      00000001——>1    00000111——>7     00000110——>6
                ~6=?
       知识补充:  原码   反码  补码 二进制表示数字
             整数:6                                 符号(1)     负数:6
       原码:00000000 00000000 00000000 00000110       10000000 00000000 00000000 00000110
       反码:00000000 00000000 00000000 00000110       11111111 11111111 11111111 11111001 符号不变其他取反
       补码:00000000 00000000 00000000 00000110       11111111 11111111 11111111 11111010  反码+1
       计算机不管是整数和负数 存储的形式都是以  补码 方式来存储
       注意：反码是一种表示形式  取反是一个计算过程(每一个位置都取反)
              6<<1= 12  ==(相当于*2的位移次幂) 向左移动一位 最后转换成10进制 
              00000000 00000000 00000000 00000110
           (0)0000000 00000000 00000000 000001100
           6>>1 =  3  ==(相当于➗2的位移次幂)     向右移动一位 最后转换成10进制 
           00000000 00000000 00000000 00000110
           000000000 00000000 00000000 0000011(0)
       知识补充:  十进制:0123456789
                 二进制:0和1组合成的
               十进制————>二进制 :  十进制数 ➗ 2 将余数倒叙排列  即为有效数 
               60十进制——>32bit个0或1来表示1  60➗ 2=30  余0  30➗ 2=15 余0  15➗ 2=7 余1 7➗ 2=3 余 1  3➗ 2=1 余1  1➗ 2=0 余1
                       余数倒叙排列为:111100   
                 用32bit表示：00000000 00000000 00000000 00111100
               二进制————>十进制 :  从右至左计算开始 每一个元素乘以2的位置(从0开始)的次幂    
               0*2^1 + 0*2^1 + 1*2^2 + 1*2^3 + 1*2^4 + 1*2^5 = 60
               ------------------------------------------------------------------------------------------------
               八进制:每3个bit位记录为以小组————>选通过3个bit转换成十进制的数 为代表
               00 000 000 000 000 000 000 000 000 111 100
                  111=1*2^0 + 1*2^1 + 1*2^2 =7 0   7    4     100=0*2^0+0*2^1+1*2^2 = 4
               八进制:01234567    将三个二进制合并为一个 计算成十进制表示 八进制表示形式以0开头 074  
               -------------------------------------------------------------------------------------------------
               十六进制:每4个bit记录为以小组————>选通过4个bit转换成十进制的数 为代表 
               00000 0000 0000 0000 0000 0000 0011 1100
                                          0X    3     C （12)    10-A 11-B 12-C 13-D 13-E 15-F
               八进制:0123456789ABCDEF将4个二进制合并为一个 计算成十进制表示 0X3C                       
```                

## II.for循环:
```java
 public class forDemo{
    public void showFor(){
//      for循环(初始值;终点判断条件;变化量){
          // (1)    ;(2),(5)(8);(4),(7)
       for (  int i=0;  i<5;  i++){
           // (3),(6)
           System.out.println("跑了第"+i+"圈了");
        }
       }
       }
```
   ### 冒泡排序:   
   ```java
   public class bubbleSortDemo{
   // 对 bubbleSort 的优化算法
   public void bubbleSort_2(int[] list) {
       int temp = 0; // 用来交换的临时数
       boolean bChange = false; // 交换标志
   
       // 要遍历的次数
       for (int i = 0; i < list.length - 1; i++) {
           bChange = false;
           // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
           for (int j = list.length - 1; j > i; j--) {
               // 比较相邻的元素，如果前面的数大于后面的数，则交换
               if (list[j - 1] > list[j]) {
                   temp = list[j - 1];
                   list[j - 1] = list[j];
                   list[j] = temp;
                   bChange = true;
               }
           }
   
           // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
           if (false == bChange)
               break;
   for (int i1 : list) {
               System.out.print(i1);
           }
       }
   }
   }
   ```
## III.设计模式(23种):
```
 创建型模式(5):--->用于解决对象创建过程
 1.单例模式  2.工厂方法模式  3.抽象工厂模式  4.建造者模式  5.原型模式
 
 构建型模式(7):--->把类或对象通过某种形式结合在一起 构成某种复杂或合理的结构
 1.适配器模式  2.装饰者模式  3.代理模式  4.外观模式   5.桥接模式  6.组合模式  7.享元模式
 
 行为型模式(11)：--->用来解决类或对象之间的交互 更合理的优化类或对象之间的关系
 1.观察者模式 2.策略模式 3.模板模式  4.责任链模式 5.解析器模式 6.迭代子模式 
  7.命令模式  8.状态模式  9.备忘录模式 10.访问者模式  11.中介者模式
```
#### 单例模式(Singleton)实现 :-----> 饿汉式(立即加载) 懒汉式(延迟加载) 生命周期托管式(单例对象被人帮我们处理)
```java
public class Singleton {
  //1.私有的构造方法  让无参构造变成私有 保证外面改变不可随便创建
      private Singleton(){};
//2. 私有的静态的当前类对象作为属性 volatile强制制止指令重排
  private volatile static  Singleton singleton = new Singleton();// 饿汉式 立即加载
 //  private static Singleton singleton; // 懒汉式加载
  // 3.公开的静态的方法返回当前对象
  public static Singleton getSingleton(){
        if(singleton==null){
      synchronized (this){    
    if(singleton==null){
     singleton =  new Singleton(); //  懒汉式加载
   }
          return singleton;
      }
      }
 }
   //饿汉式(立即加载):对象启动时就加载  优点:不会产生 空指针异常   缺点:会给服务器带来压力
   //懒汉式(延迟加载) :需要的时候再去加载  优点:不会浪费空间             缺点: 可能会产生空指针   
   //生命周期托管式:对象加载过程交给别人 
   }
```
#### 缺省适配器模式(Adapter): 子类 implements 父类 必须实现所有方法   适配器:  
```java
/**
 *       中间类 适配器 模式 实现接口  抽象类
 */
public abstract class AdapterMode implements Box{
    public  void addll(){
        // 内部抛出异常   如果子类想用该方法 必须重写 
        throw new BoxIndexOutOfBoundsException(IsindexAction);
    }
}
/**
*  继承中间类  子类
*/ 
public class ArrayBox extends AdapterMode{
    
    public void  addlla(){
        // 子类 重写该方法 才能使用
        
    }
}
```
#### 策略模式(Strategy): 解决类和类之间的关系  执行流程固定 执行的结果由于提供了不同的策略而不同


## IV.工具类:
#### 包装类 (API) :
![](http://mawen-ufile.cn-bj.ufileos.com/f54fc21b-c9a1-40c8-b7b7-8ffef884cc30.jpg?UCloudPublicKey=TOKEN_30fe6ff0-4d19-498b-b286-69be191b1881&Signature=2ITYSLaTvMsh9qnua%2FC1wH0U4mI%3D&Expires=1882448172)
```
    1.类所在的包
	2.类的关系   自己默认继承 实现
	3.是否可以创建对象  调用    方法本身静态的
	4.类中提供的常用方法

     byte---Byte   short---Short   int---Integer  long---Long
	float---Float  double---Double  char---Character   boolean---Boolean
	
	1.八个包装类都在同一个包下   java.lang包   不需要import导包直接使用
    2.八个包装类中有六个是与数字相关  都默认继承父类Number
    3.八个包装类都实现了Serializable, Comparable
    4.八个包装类都有带自己对应类型参数的构造方法
     八个包装类中有七个(除了Character)还有构造方法重载   带String类型
     new Integer("10");
     
     Integer：
     
     1.==与equals()区别
     ==可以比较基本数据类型  也可以比较引用数据类型  (变量中存储的内容)
     如果比较基本类型比较是变量中存储的值
     如果比较引用类型比较是变量中存储的地址引用
     equals()是Object类中继承过来的方法  每一个引用类型都可以调用
     默认继承的equals()方法比较与==一致  如果想要改变比较规则 可以重写equals方法
     由于Integer类就重写了equals() 所以Integer比较的是数值
     
     ----------------------------------------------------------------------------
     
     2.考察Integer类加载的时候  自己有一个静态的空间
     空间内立即加载 Integer类型的数组  内存储256个Integer对象   -128 ~ 127
     如果我们用的对象范围在这之内Integer i1 = 10;  直接取静态区中找对应的对象
     如果我们用的对象范围超出了这个Integer i1 = 1000;  会帮我们创建一个新的Integer对象
     
     
     		
```
#### 数学相关的:
```
Math类
	1.所属的包java.lang
	2.Math构造方法是私有的  我们不能直接调用创建对象
	3.由于Math中提供的属性及方法都是static  不需要创建对象
	4.常用的方法:
	     abs()返回给定数字的绝对值    (参数 int long float double)
         double = ceil()向上取整
    	 double = floor()向下取整
    	 double = rint()临近的整数 如果两边距离一样 则返回偶数
    	 int = round()  四舍五入的整数
    	 max(a,b)  min(a,b)    (参数int  long  float  double)
    	 pow(a,b)  a的b次方  (参数double 返回值double)
    	 sqrt(double a)  获取给定参数的平方根
    	double = random();	  随机产生一个     [0.0--1.0)
    5.Math.random()计算小数的时候精确程度可能有些损失
    
Random类
    1.在java.util包中的类   需要import导入
    2.没有任何继承关系  默认继承Object类
    3.查找构造方法--->如何创建对象
    Random r = new Random();
    4.常用方法:
          r.nextInt();   随机产生 int取值范围的整数 有正有负
          r.nextInt(int bound);   随机产生一个  [0--bound)  整数  
          注意bound必须为正数  否则会出现如下的运行时异常
          IllegalArgumentException
          r.nextFloat()  随机产生一个 [0.0---1.0)
          r.nextBoolean()   随机产生一个boolean值   true  false         

UUID类
    1.所属的包  java.util    需要import导入
    2.没有任何继承关系  默认继承Object类
    3.构造方法有  没有无参数的  我们通常不会创建对象
    UUID uuid = UUID.randomUUID();
    System.out.println(uuid.toString());//数据库表格主键 primary key
    产生一个32位的随机元素 每一个位置是一个16进制的数字
    
    
BigInteger类(大整数)  
         long范围:  -2的63次方 ~ 2的63次方-1
    1.所属的包java.math  需要import导入
    2.继承自Number   
    3.如何创建对象   提供的构造方法全部都是带参数的
    	通常利用带String参数的构造方法创建这个类的对象
    	BigInteger  bi = new BigInteger("123");	
    4.类中的常用方法
           做四则运算 加减乘除
              add()   subtract()   multiply()   divide()
    5.小例子   设计一个方法 用来计算给定数字的阶乘  5   1*2*3*4*5==120
    		//设计一个方法  用来计算给定数字的阶乘
    		//参数   返回值
    		public BigInteger factorial(int num){
    			BigInteger result = new BigInteger("1");
    			for(int i=1;i<=num;i++){
    				result = result.multiply(new BigInteger(i+""));
    			}
    			return result;
    		}
    
BigDecima类    
          超过了double取值范围
     1.所属的包  java.math包
     2.继承Number类
     3.通常也是可以通过 带String参数 构建对象
     4.类中的常用方法
     	做四则运算  加减乘除
     	add()   subtract()   multiply()   divide()
        两个参数前面是保留小数点之后的位数  后面参数是设置的模式
        对象.setScale(2,BigDecimal.ROUND_DOWN);
        
DecimalFormat类
      1.所属的包 java.text
      2.import导入才能使用
      3.通过带String参数的构造方法创建一个格式化对象   0表示必须存在  #可有可无
      4.调用format方法将一个小数格式化成一个字符串
      		DecimalFormat df = new DecimalFormat("000.###");// 0 #
              		String value = df.format(12.45);
              		System.out.println(value);
System类
	1.所属的包java.lang包 不需要导入
	2.不需要创建对象  通过类名就可以访问
	3.有三个属性及若干的方法
		三个属性out   in   err
		方法gc()  exit(0);  currentTimeMillis();当前时间毫秒
```
#### 日期相关的:
```
Date类
	1.通常使用的是java.util包
	2.导包 拿来使用  构建对象
	3.通常使用无参数的构造方法  或者带long构造方法
	4.Date类中常用的方法
		before();x是否在y之前  after();x是否在y之后
		setTime()  getTime();----->long
		compareTo();   -1  1  0 比较 时间x 和 y 那个在前？ 
	5.可以处理一个Date日期的格式


DateFormat抽象类  通过子类来使用(SimpleDateFormat)
	1.包java.text 需要导包使用
	2.此类是一个抽象类  不能创建对象   子类来使用
	3.SimpleDateFormat类   是DateFormat的子类
	4.调用带String参数的构造方法创建format对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String v = sdf.format(date1);//通过sdf对象将date1格式化成你描述的样子

Calendar类   1.1版本
    1.所属的包java.util  需要导包
    2.有构造方法  用protected修饰的  通常访问不到   通常会调用默认的getInstance();
    3.常用方法
    	after()  before()
    	setTime()  getTime()---->Date
    	getTimeInMillis()----time
    	getTimeZone()---TimeZone
    	Calendar里面包含一个date属性  可以操作date的某一个局部信息
    	set   get
    	calendar.set(Calendar.YEAR,2015);
           int year = calendar.get(Calendar.YEAR);

TimeZone
	1.java.util包
	2.可以通过calendar对象.getTimeZone()获取  或   TimeZone.getDefault();
	3.常用方法
	   tz.getID()	   ---->    Asia/Shanghai
        tz.getDisplayName()   中国标准时间
```
## V.集合:
```
变量---容器
		存储一个元素
	数组---容器
	一组具有某种特性的数据存放在一起
		存储一组元素(数据类型一致)	长度固定
	集合---容器  与数组类似  集合的长度存储之后还能改变
	集合是用来存储一组元素
	                               集合java.util
	            Collection(值 value)			         Map(key - value)      
	            存储的都是value			               存储的是以key-value形式存在(key无需无重复 value无需可重复)
         •List(有序可重复)	  •	Set( 无序无重复)           • HashMap      • TreeMa    • ConcurrentHashMap    • Hashtable
           o ArrayList            o	HashSet                  o LinkedHashMap
           o LinkedList           o	LinkedHashSet
           o Vector               o	TreeSet
           o Stack
                序 : 顺序	添加进去的元素  取得元素的顺序一致   注意指的不是集合自己的顺序
                	重复：两个对象元素一致               	
```
### List、Set、Map 之间的区别：
![](http://mawen-ufile.cn-bj.ufileos.com/a0f1ed7a-ed37-4b01-b8f1-c55e5e4a8a65.png?UCloudPublicKey=TOKEN_30fe6ff0-4d19-498b-b286-69be191b1881&Signature=rJLUBU8Qw%2B7x37Ifa8du%2FSb%2Ba3E%3D&Expires=1882923800)
 ### HashMap：
 ### [HashMap 相关](https://mp.weixin.qq.com/s/AnbkXhWttllCnLC3wLnAhA)    
 ![](http://small-howe.cn-bj.ufileos.com/ce6daaa9-0434-4c32-a860-3205e57ee743.png?UCloudPublicKey=TOKEN_7728f428-03f0-4a5f-b3fd-e5632771d02e&Signature=rRIYuyjoMBi8szUzhvv1q61YB08%3D&Expires=1882407463)

 相关面试题: 
 ```
 三个值: 16,  8,  0.75
         16: 初始化的桶的长度
          8:超过8变为红黑书(1.8版本及以上)
       0.75: 负载因子
      老版本:HashMap中存放的总数量达到负载因子时(桶长度 * 负载因子)，扩容一倍(1.7之前)
      新版本:HashMap中存放的总数量，达到桶长度时，扩容负载因子倍。(1.7及1.7之后)
      
   1. HashMap初始化桶大小？
    32位:8  64位:16  jdk1.8:16
    
   2. HashMap的查找效率一定比ArrayList的查找效率高吗？
        不
   2. 什么情况下，查找效率没有arrayList高？
         (1)在存储2个值以内。
         (2)在存放的内容hash值一样时，且长度不超过8时。(超过8链表就变为红黑树了)
         (3)在高速并发写入的同时。(高速并发写入的时候，HashMap会扩容或者将链表转为红黑树)
         
   3. 我要向HashMap中存1000个数，我应该初始化大小为多少?
       1000 / 0.75 = 1333.333333  1333+    2048
       时间换空间(1.8以前)，空间换时间(1.8)
       
   4. Hash的底层数据结构是什么？
       数组加链表，邻接链表
       数组是用来确定桶的位置 利用元素key 的hash值对数组长度取模(%)得到
       链表是用来解决hash冲突问题,当出现hash 值一样的情形 就在数组上对应的位置上形成一条链表
       
       ps:这里的hash值并不是指向hashcode 而是讲hashcode高低十六位异或过的 
   5.hash冲突你还知道哪些解决方法?
   比较出名的四种:1.开放定址法 2.链地址法 3.再哈希法 4.公共溢出区域法
       
   5. HashMap是否是线程安全的？
      不是
   5. 如果需要线程安全的HashMap怎么办？
      (1) ConcurrentHashMap
      (2) 自己封装HashMap，使用Synchronized，Lock(手动锁)，CAS(原子锁)
      (3) 初始化容量。（能解决一大块问题，不能解决全部问题。）
      (4) 放在ThreadLocal中。
   
   6. hash值，对HashMap有什么影响？
     有Hash值，就可以直接找桶，没hash值，得现算Hash值。 
```
```java

public class StringClaaa{
HashMap<String, Object> map1 = new HashMap<>();
        String s = "";
        String x = new String("abc");// 底层直接给出hash值 (1) 省略一个方法
        String z = new String();
}
```
## VI.字符串(String)类:    
---->引用类型    java.lang包  
注意: 注意:  区别数组length是属性  String的length()方法    集合size()方法
### String:
```
1.存在哪儿?   java.lang包   
  	没有任何继承关系  实现三个接口Serializable, CharSequence, Comparable<String>
2.如何构建对象:
			String str = "abc"; //直接将字符串常量赋值给str   (字符串常量池)
			String str = new String();//无参数构造方法创建空的对象
			String str = new String("abc");//带string参数的构造方法创建对象
			String str = new String(byte[] )//将数组中的每一个元素转化成对应的char 组合成String
			String str = new String(char[] )//将数组中的每一个char元素拼接成最终的String
	        String str = new String(char[] )//将数组中的每一个char元素拼接成最终的String
3.String的不可变特性:
			String类中包含一个private final char[] value;
			体现在两个地方   长度及内容
			长度--->final修饰的数组   数组长度本身不变  final修饰数组的地址也不变
			内容--->private修饰的属性  不能在类的外部访问
*4.常用的方法:
		1.	boolean = equals(Object obj);
				继承自Object 重写啦  比较两个字串中的字面值是否相等
		2.	int = hashCode();
				继承自Object 重写啦  将当前字符串的每一个char元素拆开 乘以31求和
		3.	int = compareTo(String str);
				实现自Comparable接口  实现啦  按照字典(Unicode编码)索引的顺序比较
               实现自Comparable接口  实现方法   结果按照字典排布(unicode编码)顺序
                按照两个字符串的长度较小的那个(次数)来进行循环
               若每次的字符不一致 则直接返回code之差 
               若比较之后都一致  则直接返回长度之差
                compareToIgnoreCase();
		4.	String = toString();
				继承自Object 重写啦 不再输出 类名@hashCode  字符串中的字面值
               没有重写过的toString从Object类中继承过来的
               类名@hashCode(16进制形式)
               String类重写啦  返回的是String对象的字面值
			--------------------------------------------------------------------
		5.	char = charAt(int index);//"abc"   0-->a
				  返回给定index位置对应的字符
    	5.1	int = codePointAt(int index);//"abc"   0-->97
				返回给定index对应位置的那个char所对应的code码
		6.	int = length();
				返回字符串的长度
             返回字符串的长度   (其实就是底层char[] value属性的长度)
              注意:  区别数组length是属性  String的length()方法    集合size()方法
		7.	String = concat(String);
           将给定的str拼接在当前String对象的后面
               注意:方法执行完毕需要接受返回值   String的不可变特性
                concat方法与   +拼接的性能问题
                开发中若遇到频繁的拼接字符串--->通常使用StringBuilder/StringBuffer
        8.boolean = contains(CharSequence s);
         		   判断给定的s是否在字符串中存在
        9. startsWith(String prefix);
         		    endsWith(String suffix);
               判断此字符串是否已xx开头/结尾
        10.byte[] = getBytes();   --->    getBytes(String charsetName);
         		     char[] = toCharArray();
         		   将当前的字符串转化成数组   "我爱你中国"   char[]  '我' '爱' '你' '中' '国'
        11. int index = indexOf(int/String str [,int fromIndex] );   四个方法重载
           找寻给定的元素在字符串中第一次出现的索引位置   若字符串不存在则返回-1
              lastIndexOf(int/String str , [int fromIndex]);
           找寻给定的元素在字符串中最后一次出现的索引位置  若不存在则返回-1
        12.boolean = isEmpty();
           判断当前字符串是否为空字符串  (length是否为0)
           注意： 与null之间的区别  
        13.replace();
             replaceAll();
             replaceFirst(); 换第一次出现的那个字串
           将给定的字符串替换成另外的字符串
        14.String[] = split(String regex [,int limit限度界限]);
           按照给定的表达式将原来的字符串拆分开的
        15.String = substring(int beginIndex [,int endIndex]);
           将当前的字符串截取一部分   
           从beginIndex开始至endIndex结束  [beginIndex,endIndex)
           若endIndex不写 则默认到字符串最后
        16.String = toUpperCase();
           String = toLowerCase();
          将全部字符串转换成大写/小写
        17.String = trim();
          去掉字符串前后多余的空格
        18.boolean = matches(String regex)
          regular有规律的 expression表达式
          正则表达式


     常见的String笔试题:
	     ==  equals方法的区别: ==可以比较基本类型  可以比较引用类型   比较基本类型比较值 比较引用类型比较地址
		equals只能比较引用类型(方法) 默认比较地址this==obj 如果想要修改其比较规则  可以重写equals方法
         通常重写equals方法时会伴随着重写hashCode方法
       比如String类  比如Integer
			*String的不可变特性
		 		长度及内容
			String与StringBuffer区别
			StringBuffer与StringBuilder区别
			String对象的存储
				"abc"---->字符串常量池
				new String("abc")--->堆内存
				"a"+"b"+"c"+"d"
			*String中常用的方法
**~~_``_~~**	
```
### StringBuffer & StringBuilder:
```
StringBuffer
StringBuilder
1.所属的包  java.lang包
	2.继承AbstractStringBuilder 间接继承 Object  
		实现接口Serializable,CharSequence,Appendable
		StringBuffer/StringBuilder没有compareTo方法
		StringBuffer/StringBuilder含有一个String没有的方法 append();拼接
	3.特性
		可变字符串   char[] value;  动态扩容
	4.对象的构建
		无参数构造方法  构建一个默认长度16个空间的对象  char[]
		StringBuilder builder = new StringBuilder();
		利用给定的参数 构建一个自定义长度空间的对象 char[]
		StringBuilder builder = new StringBuilder(20);
		利用带String参数的构造方法  默认数组长度字符串长度+16个
		StringBuilder builder = new StringBuilder("abc");
    5.StringBuilder中常用的方法
        最主要的方法 append()  频繁的拼接字符串的时候使用此方法 提高性能
        ensureCapacity(int minimumCapacity)  确保底层数组容量够用
        capacity();//字符串底层char[]的容量
        length();//字符串有效元素个数(长度)
        setLength();//设置字符串的有效元素个数
        char = charAt(int index);
        int = codePointAt(int index);
        String = substring(int start [,int end]);
            注意需要接受返回值 看见截取出来的新字符串效果
        StringBuilder = delete(int start [,int end]);
            StringBuilder类中独有的方法String类没有
            将start到end之间的字符串删掉  不用接受返回值就看到效果啦
        StringBuilder = deleteCharAt(int index);
            String类中没有的方法
            将给定index位置的某一个字符删除掉啦
        int = indexOf(String str [,int fromIndex]);
        int = lastIndexOf(String str [,int fromIndex])
            找寻给定的str在字符串中第一次出现的索引位置  带重载 则从某一个位置开始找
        insert(int index,value);
            将给定的value插入在index位置之上
        replace(int start,int end,String str);
            将start和end之间的部分替换成str
            builder.replace(2,5,"zzt");
        setCharAt(int index,char value);
            将index位置的字符改成给定的value
        toString()
            将StringBuilder对象 构建成一个string对象 返回
        trimToSize()
    	将数组中无用的容量去掉  变成length长度的数组
    	
    	
--------------------------------------------------------------------------------------------------------------
知识总结
	1.StringBuilder类不一定需要   是为了避免String频繁拼接修改字符串信息的时候才用的
		底层数组是可变的  提高了性能
	2.常用方法
		与String类不同的独有方法:
		append()  insert()  delete()  deleteCharAt()  reverse()
		与String类相同的方法:
		length() charAt() codePointAt() indexOf() lastIndexOf() 
		substring() replace()名字相同 用法不一致
		不是很常用的方法:
		ensureCapacity() capacity() setLength() trimToSize(); setCharAt();
	3.String家族笔试中经常容易考察的知识点
		1.String所属的包 继承关系 实现接口
			java.lang 继承Object 接口Serializable,CharSequence,Comparable
		2.String构建方式
			常量  构造方法  
		3.String对象内存结构
			字符串常量区  new堆内存对象
			==  equals()区别
			"a"+"b"+"c"
		4.String不可变特性
			长度及内容
		5.String中的常用方法---与StringBuilder的区别
			concat();  toUpperCase();
		6.String和StringBuilder区别   |   String和StringBuffer区别
			String不可变字符串
				JDK1.0
				有一个接口Comparable
				不可变体现在长度及内容
				有一些方法StringBuilder没有 concat  compareTo  toUpperCase
			StringBuilder可变字符串
				JDK1.5
				有一个接口Appendable
				可变字符串  没有final修饰  底层可以进行数组扩容
				有一些方法String没有  append() insert() delete() reverse()
		7.StringBuffer和StringBuilder的不同
			StringBuffer早期版本1.0
			StringBuilder后来的版本1.5
			早期版本  线程同步   	  安全性比较高  执行效率相对较低
			后期版本  线程非同步    安全性比较低  执行效率相对较高

```
### 正则表达式(Regular Expression):
```
正则表达式regex
		一个带有一定规律的表达式
		匹配字符串格式的
	正则表达式通常的作用如下:
	1.字符串的格式校验		String类中提供的一个方法 boolean = str.matches("regex");
	2.字符串的拆分及替换		String类中提供的方法replace  split
	3.字符串的查找		Pattern模式  Matcher匹配器
	如下的所有都用来描述字符的信息
    		[abc]	abc其中的一个
    		[^abc]	不能是abc其中的一个 其他都可以
    		[a-zA-Z]	表示必须是这两个范围内的
    		[a-z&&[^bc]]  表示a-z其中的一个但不能是b和c
    		|	或者
    		. 代表任意一个字符
    		\d  digit数字   [0-9]
    		\D  非数字       [^0-9]
    		\s  space留白  一个空格 一个回车 一个换行。。。
    		\S  非留白
    		\w  word单词  [0-9A-Za-z]  数字或字母都可以
    		\W 非单词        [^0-9A-Za-z]
    
    		如下的所有都用来描述字符出现的次数
    		?   0-1次    [0-9]?
    		*   0-n次
    		+  1-n次
    		{n} 固定n次
    		{n,} 至少出现n次
    		{m,n}  m-n次

```
## VII.I/O:
```
输入/输出	   流(数据流动)
数据流动的方向   读数据(输入Input)   写数据(输出output)
文件流  字符流  对象流  网络流....
File类中的常用的方法:
文件是否:  读          写            隐藏         文件       目录        
           canRead()   canWrite()   isHidden()   isFile()   isDirectory()
		   length()获取文件中字节的个数
		   lastModified()获取文件最后的修改时间--->毫秒值
		   *String path = getAbsolutePath()  获取文件的绝对路径   D://test//Test.txt
		    String name = getName() 获取文件的名字    Test.txt
		    
			绝对路径<---->相对路径
			绝对路径可以通过完整的字符串  定位盘符 文件夹 文件
			相对路径没有盘符的写法           当前工程(项目)所在的位置找寻
			
		
       	   *boolean = createNewFile()  创建新的文件
       	   *boolean = mkdir	              创建新的文件夹  外层没有 不能创建
       	   *boolean = mkdirs              创建新的文件夹  外层没有 可以自动创建
       	   String pname = getParent()     获取当前file的父亲file名字
       	   *File file = getParentFile()      获取当前file的父亲file对象
       	   String[] names = list()            获取当前file的所有儿子名字
       	   *File[] files = listFiles()             获取当前file的所有儿子对象
       	   *boolean = delete()	删除文件或空的文件夹  不能删除带元素的文件夹	
--------------------------------------------------------------------------------------------------------------
 操作文件内容 :
 流按照方向(功能)来区分
 		in(读取)	out(写入)
 	操作的目标来区分
 		文件流  数组流  字符串流  数据流  对象流  网络流。。。。
		字节型文件流(1字节)
			FileInputStream/FileOutputStream
		字符型文件流(2字节--1字符)
			        FileReader/FileWriter		
 字节型文件输入流:
 		FileInputStream
 		1.包   java.io
 		2.了解一下继承关系    InputStream类  字节型输入流的父类
 		3.创建对象
 			调用一个带File类型的构造方法
 			调用一个带String类型的构造方法
 		4.常用方法
 			int code = read();	每次从流管道中读取一个字节   返回字节的code码
 			*int count = read(byte[] )  每次从流管道中读取若干个字节  存入数组内  返回有效元素个数
 			int count = available();   返回流管道中还有多少缓存的字节数
 			skip(long n)   跳过几个字节  读取
 				多线程--->利用几个线程同时读取文件
 				10000字节    5个小人同时读取
 				1-2000   2001-4000   4001-6000   6001-8000   8001-10000
 				D当做服务器    E当做客户端
 			*close()	将流管道关闭---必须要做  最好放在finally里  注意代码的健壮性  判断严谨
 	字节型文件输出流:
 		FileOutputStream	将数据写入文件中
 		1. java.io
 		2.继承OutputStream  所有字节型输出流的父类
 		3.创建对象
 			调用一个带File参数   还有File boolean重载
 			调用一个带String参数   还有String boolean重载
 		4.常用方法
 			write(int code);  将给定code对应的字符写入文件   '='
 			write(byte[])    将数组中的全部字节写入文件   getByte()
 			flush();	将管道内的字节推入(刷新)文件
 			close();	注意在finally中关闭

 
```

## VIII.多线程:




### 线程池(创建有七种方式(不需要死记硬背！！！))
#### 注意:线程池的本质只有一个  无论哪个线程池，都是调用ThreadPoolExecutor线程池创建出来的。
```
  为什么不同的线程池会有不同的特性呢？
  参数不一样。             (参数类型)    (参数)
  public ThreadPoolExecutor( int    (1)corePoolSize ,(核心线程数)
                             int    (2)maximumPoolSize,(最大线程数)
                            long    (3)keepAliveTime,(保持活跃的时间L)
                        TimeUnit    (4)unit,(时间的单位)
          BlockingQueue<Runnable>   (5)workQueue,(等待队列数)
                    ThreadFactory   (6)threadFactory,(创建线程的工厂)
         RejectedExecutionHandler   (7)handler(拒绝策略)


举个栗子:
去银行办理业务: 银行平时就开3个窗口（corePoolSize:核心线程数）  今天来的人多，有人需要等待。
              等待的人就坐在大厅里，这个大厅就是（workQueue:等待队列）。 
              如果大厅坐满了，银行会觉得今天人太多了，我们得多开几个窗口，此时银行会开启更多窗口(注意:后面添加的窗口都是临时窗口)。
              但是不可能大于总得窗口数（maximumPoolSize：最大线程数）。
              ------- 
              当银行开启了足够多得窗口之后，大厅中得人数明显开始减少了。
              当大厅中的人都办完业务离开,2分钟之后(keepAliveTime:保持活跃的时间L, unit：时间的单位)，后开的那些窗口，觉得自己任务完成了，就会将窗口关闭。
              当银行开启了足够多的窗口之后，大厅中的人数还在增加，并且装不下了。
              此时银行会告知后来的人，今天可能办不完业务了（handler:拒绝策略），可以明天再来。 
              
              
 自己创建线程池 :只需要 参数:(1),(2),(3),(4)(5)
  new ThreadPoolExecutor(
                         50,
                         100,
                         120L,
                         TimeUnit.SECONDS,
                        (等待队列数) new LinkedBlockingQueue(1)
                        (等待队列数) new SynchronousQueue() 
    );                     
```  
#### 了解了  ThreadPoolExecutor 下来再看创建线程的这几种方式                                                        
```
java
public class threadTest{
    
    public static void main(String[] args){
        int nThreads = 10;
        int corePoolSize=nThreads;
       /**
       *  第一种  (Single) 单线程
       * 参数:(1, 1, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()))
       * (核心线程数) (最大线程数)(保持活跃的时间L)(时间单位:m) (等待队列(Integer.MAX_VALUE)无穷大)
       * 
       * 缺点: 有且仅有一个线程工作  等待队列：无穷大，慢慢的一个一个来。 简单线程，就一个线程，也太少了
       * /
        Executors.newSingleThreadExecutor();
        
        
        /**
        * 第二种:  (Fixed)固定的 
        参数:(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())
          (核心线程数)<--传进来的--> (最大线程数) (保持活跃的时间L)(时间单位:m)(等待队列(Integer.MAX_VALUE)无穷大)
          
          缺点: 和SingleThread线程池逻辑一模一样，只不过这个指定了线程数。等待队列：无穷大。
         
        */
        Executors.newFixedThreadPool(nThreads);
       
        
        
        /**
        *  (Scheduled)预定的，安排
        *  参数:(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,  new DelayedWorkQueue())
        *  传进来的--> (核心线程数) 最大线程数:无穷大  (保持活跃的时间L)(时间单位:n)等待队列 
        * 
        * 缺点: 就这么点线程，任务多了就得堆积
        *      当达到核心线程数之后，就创建新的线程，可以创建无穷多个线程。
        *     新开出来的线程，只要完成了，就销毁。
        *  
        */
        Executors.newScheduledThreadPool(corePoolSize);
        
        
        
        /**
        * 
        * (Cached)缓存（不适用与任务间隔比较长（超过一分钟）的清空）
        *参数:(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())
        * 
        * 
        * 缺点:默认 没有核心线程数，都是临时工，没有正式员工。
        *  任务堆积很多的时候，当有线程完成任务时，居然不复用，居然得先销毁再创建
        *  来了任务就干，干完等一会儿，要是还有活儿就继续干，要是等了一分钟还没有活，就不干了（销毁）
        */
        
        Executors.newCachedThreadPool();
        
        
        // jdk  8这是一个经常被人忽略的线程池，Java 8 才加入这个创建方法，其内部会构建ForkJoinPool，利用Work-Stealing算法，并行地处理任务，不保证处理顺序
         Executors.newWorkStealingPool();// 不建议使用的，容易引起雪崩效应。适合非常消耗CPU的性能，且非常耗时的操作。如果是任务独享机器，并且很耗费性能，很耗时。
    }
    }
```
## IX.反射:

## Ⅹ异常(错误):
```
        Throwable类实现了一个序列化接口
    Error(错误)	     		   Exception(异常)
    StackOverflowError	    	RuntimeException(运行时)   IOException。。。。。
    OutOfMemoryError
    
    异常:
    异常的分支体系：
    	运行时异常(非检查异常)：
    		Error和RuntimeException都算作运行时异常
    		javac编译的时候，不会提示和发现的，
    		在程序编写时不要求必须做处理，如果我们愿意可以添加处理手段(try throws)
    		要求大家出现这样异常的时候 知道怎么产生及如何修改
    		1.InputMisMatchException 输入不匹配
    			int value = input.nextInt();//   abc
    		*2.NumberFormatException 数字格式化
    			int value = Integer.parseInt("123.45");
    		3.NegativeArraySizeException 数组长度负数
    			int[] array = new int[-2];
    		*4.ArrayIndexOutOfBoundsException 数组索引越界
    			int[] array = {1,2,3};
    			array[5];
    		*5.NullPointerException 空指针异常
    			int[][] array = new int[3][];
    			array[0][0] =10;
    			Person p = null;
    			p.getName();
    		6.ArithmeticException 数字异常
    			10/0	整数不允许除以0	Infinity小数除以0会产生无穷
    		*7.ClassCastException 造型异常
    			Person p = new Teacher();
    			Student s = (Student)p;
    		*8.StringIndexOutOfBoundsException 字符串越界
    			String str = "abc";
    			str.charAt(5);
    		*9.IndexOutOfBoundsException 集合越界
    			List家族
    			ArrayList  list = new ArrayList();
    			list.add(); list.add(); list.add();
    			list.get(5);
    		10.IllegalArgumentException 非法参数异常
    			ArrayList  list = new ArrayList(-1);
    	编译时异常(检查异常):
    		除了Error和RuntimeException以外其他的异常
    		javac编译的时候  强制要求我们必须为这样的异常做处理(try或throws)
    		因为这样的异常在程序运行过程中极有可能产生问题的
    		异常产生后后续的所有执行就停止啦
    		1.InterruptException
    			try{
    				Thread.sleep(5000);
    			}catch(Exception e){
    			}
   ---------------------------------------------------------------------------------------
   try{ 
   。。代码省略。。。。
   }catch(代码省略){
    。。。代码省略。。。
    }
    [finally{
     。。代码省略。。
     } ]
   	1.try不能单独的出现
   	2.后面必须添加catch或finally
   	3.catch有一组括号 (NullPointerException) 目的是为了捕获某一种异常
   	4.catch可以有很多个存在
   		捕获的异常之间没有任何的继承关系
   		捕获的异常需要从小到大进行捕获
   	5.finally不是必须存在的
   		若存在finally结构  则必须执行
   		引申一个小问题:   final   finally  finalize区别
   			final  特征修饰符  修饰变量 属性 方法 类
   				修饰变量 基本类型 值不能改变 引用类型 地址不能改变(如果变量没有初值 给一次机会赋值)
   				修饰属性 特点与修饰变量类似 (要求必须给属性赋初始值 否则编译报错)
   				修饰方法 不能被子类重写
   				修饰类    不能被其他的子类继承
   			finally 处理异常手段的一部分
   				try{}catch(){}后面的一个部分
   				这个部分可有可无  如果有只能含有一份 且必须执行
   			finalize 是Object类中的一个protected方法
   				对象没有任何引用指向的时候 -- 会被GC回收
   				当对象回收的时候 默认调用finalize方法
   				若想要看到对象回收的效果  可以重写 public void finalize(){}
   	6.处理异常放在方法内部 可能还会有小问题
   		如果在方法内部含有返回值
   		不管返回值return关键字在哪里   finally一定会执行完毕
   		返回值的具体结果   看情况 	
```
## Ⅺ.JVM:
 ![](http://mawen-ufile.cn-bj.ufileos.com/82aa16d0-655f-43c2-a9fc-4ff5115026a8.png?UCloudPublicKey=TOKEN_30fe6ff0-4d19-498b-b286-69be191b1881&Signature=GQuSCe9BmE3HRb5DZPWUxDxk2G8%3D&Expires=1883044495)
   #### 栈---> person p  = new person; <----- 堆  



   ### 堆内存:new创建的对象  用 Garbage Collection垃圾回收器  GC 回收
   ```
    new  出来的    垃圾回收器GC    对象空间没有任何引用指向视为垃圾
   OutOfMemoryError 堆内存溢出错误
   ```
  
   

   ### 栈内存:存--->创建开始 用完立即回收   StackOverflowError(栈内存溢出)
     
     变量      方法执行临时空间  创建开始 用完立即回收
     StackOverflowError 栈内存溢出错误
     
        			
    
   
   
   
   ### 方法区:类   常量   静态   只有一份回收不了   加载类  类模板
   