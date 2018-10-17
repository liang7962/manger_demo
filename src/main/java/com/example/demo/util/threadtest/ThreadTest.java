package com.example.demo.util.threadtest;

public class ThreadTest {
//    public static void main(String[] args) {
//
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//            for (int i = 0; i < 100; i++) {
//                   System.out.println(Thread.currentThread().getName() + " " + i);
//                   if (i == 30) {
//                       thread.start();
//                      try {
//                               thread.join();    // main线程需要等待thread线程执行完后才能继续执行
//                          } catch (InterruptedException e) {
//                              e.printStackTrace();
//                         }
//                  }
//            }
//   }
             public static void main(String[] args) {
              Account account = new Account("123456", 1000);
              DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account, 700);
              Thread myThread1 = new Thread(drawMoneyRunnable);
              Thread myThread2 = new Thread(drawMoneyRunnable);
              myThread1.start();
              myThread2.start();
           }

}

class DrawMoneyRunnable implements Runnable {
    private Account account;
    private double drawAmount;

    public DrawMoneyRunnable(Account account, double drawAmount) {
        super();
        this.account = account;
        this.drawAmount = drawAmount;
    }

//    public synchronized  void run() {//同步方法
//        if (account.getBalance() >= drawAmount) {  //1
//            System.out.println("取钱成功， 取出钱数为：" + drawAmount);
//            double balance = account.getBalance() - drawAmount;
//            account.setBalance(balance);
//            System.out.println("余额为：" + balance);
//        }
//    }
    public void run() {
        synchronized (account){//同步代码块
            if (account.getBalance() >= drawAmount) {  //1
                System.out.println("取钱成功， 取出钱数为：" + drawAmount);
                double balance = account.getBalance() - drawAmount;
                account.setBalance(balance);
                System.out.println("余额为：" + balance);
            }
        }
    }

}
class Account {
    private String accountNo;
    private double balance;
     public Account() {

     }

     public Account(String accountNo, double balance) {
         this.accountNo = accountNo;
         this.balance = balance;
     }

     public String getAccountNo() {
         return accountNo;
     }

     public void setAccountNo(String accountNo) {
         this.accountNo = accountNo;
     }

     public double getBalance() {
         return balance;
     }

     public void setBalance(double balance) {
         this.balance = balance;
     }
 }

