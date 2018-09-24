package com.github.engfragui.fundamentals.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fguiducci on 6/30/18.
 */
public class ExecutorServiceUsage {

  private static void printSampleString() {
    System.out.println("Hello World | " + Thread.currentThread());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 50; i++) {
      executorService.submit(ExecutorServiceUsage::printSampleString);
    }
    executorService.shutdown();
  }
}
