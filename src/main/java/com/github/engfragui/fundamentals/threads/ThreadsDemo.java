package com.github.engfragui.fundamentals.threads;

public class ThreadsDemo {

  public static class MyThread extends Thread {

    @Override
    public void run() {
      System.out.println("Hello World from Thread");
    }
  }

  public static class MyRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println("Hello World from Runnable ");
    }
  }

  public static void main(String[] args) {

    // Method 1:
    //  - extend Thread
    //  - call start()

    MyThread thread1 = new MyThread();
    thread1.start();

    // you can also create an anonymous subclass and then call start()
    Thread thread2 = new Thread() {
      @Override
      public void run() {
        System.out.println("Hello World from Thread");
      }
    };
    thread2.start();

    // Method 2:
    //  - implement Runnable
    //  - pass it to Thread constructor
    //  - call start()

    MyRunnable runnable = new MyRunnable();
    Thread thread3 = new Thread(runnable);
    thread3.start();

    // you can also usa a lambda expression
    Thread thread4 = new Thread(() -> System.out.println("Hello World from Runnable"));
    thread4.start();
  }
}
