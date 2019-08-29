# JAVA基础知识回顾

## I.运算符 
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
                 二进制:01
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

## II.for循环
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
## 设计模式(23种)
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


## III.包装类
#### 学会使用包装类 (API) :
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
## IV.集合
 ### HashMap：
 ![](http://small-howe.cn-bj.ufileos.com/ce6daaa9-0434-4c32-a860-3205e57ee743.png?UCloudPublicKey=TOKEN_7728f428-03f0-4a5f-b3fd-e5632771d02e&Signature=rRIYuyjoMBi8szUzhvv1q61YB08%3D&Expires=1882407463)
 
 相关面试题: 
 三个值: 16,  8,  0.75
        16: 初始化的桶的长度
         8:超过8变为红黑书(1.8版本及以上)
      0.75: 负载因子
     老版本:HashMap中存放的总数量达到负载因子时(桶长度 * 负载因子)，扩容一倍(1.7之前)
     新版本:HashMap中存放的总数量，达到桶长度时，扩容负载因子倍。(1.7及1.7之后)
 ```
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
        String x = new String("abc");// 底层直接给出hash值 (1)
        String z = new String();
}
```
   
  ### 单向链表
``` 
   A -------> B -------> C -------> D
```
 ### 双向链表
 ``` 
    A <-------> B <-------> C <-------> D
 ```
 ### 环链表
 
 
 

## V.String 
## VI.IO


## VII.反射


## VIII.JVM
 
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
   