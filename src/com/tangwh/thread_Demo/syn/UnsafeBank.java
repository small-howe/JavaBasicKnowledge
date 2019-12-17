package com.tangwh.thread_Demo.syn;

/**
 * 不安全的取钱
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000, "工资");


        Drawing you = new Drawing(account,50, "你");
        Drawing gurl = new Drawing(account,100, "gurl");

        you.start();
        gurl.start();
    }


}

// 账户
class Account {

    int money; //余额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行 取款
class Drawing extends Thread {

    Account account; // 账户
    // 取了多少钱
    int drawingMoney;

    //手里还有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }



    // 取钱
    //synchronized 所得this
    @Override
    public  void run() {

        synchronized (account){
            // 判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够 取不了");
                return;
            }

            // 延迟
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 卡内越 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;

            //你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为:" + account.money);
            System.out.println(this.getName() + "手里的钱" + nowMoney);

        }


    }
}