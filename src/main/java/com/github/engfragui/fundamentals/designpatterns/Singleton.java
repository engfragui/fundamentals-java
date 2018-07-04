package com.github.engfragui.fundamentals.designpatterns;

/**
 * Created by fguiducci on 6/30/18.
 */
public class Singleton {

  private static Singleton instance = null;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
