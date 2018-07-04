package com.github.engfragui.fundamentals.designpatterns;

/**
 * Created by fguiducci on 6/30/18.
 */
public class Singleton {

  private static Singleton instance = null;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      System.out.println("Instantiating new singleton instance");
      instance = new Singleton();
    }
    return instance;
  }

  public static void printHashCode() {
    Singleton singleton = Singleton.getInstance();
    System.out.println("Singleton " + singleton.hashCode());
  }
}
