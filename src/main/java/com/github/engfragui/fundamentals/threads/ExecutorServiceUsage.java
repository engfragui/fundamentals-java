package com.github.engfragui.fundamentals.threads;

import com.github.engfragui.fundamentals.designpatterns.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fguiducci on 6/30/18.
 */
public class ExecutorServiceUsage {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(Singleton::printHashCode);
    executorService.submit(Singleton::printHashCode);
    executorService.shutdown();
  }
}
