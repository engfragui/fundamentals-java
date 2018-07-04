package com.github.engfragui.fundamentals.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fguiducci on 6/30/18.
 */
public class ExecutorServiceUsage {

  public static void printSampleString() {
    System.out.println("Hello World | " + Thread.currentThread());
  }

  public static void main(String[] args) {
    int n = 10;
    ExecutorService executorService = Executors.newFixedThreadPool(n);
    for (int i = 0; i < n; i++) {
      executorService.submit(ExecutorServiceUsage::printSampleString);
    }
    executorService.shutdown();
  }
}
