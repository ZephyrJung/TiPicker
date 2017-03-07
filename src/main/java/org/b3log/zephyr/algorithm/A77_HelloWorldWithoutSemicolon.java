package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-3-4.
 */
public class A77_HelloWorldWithoutSemicolon {
    public void printHelloWorld() {
        if ((System.out.append("Hello world")) != null) {
        }
    }

    public static void main(String[] args) {
        A77_HelloWorldWithoutSemicolon helloWorldWithoutSemicolon = new A77_HelloWorldWithoutSemicolon();
        helloWorldWithoutSemicolon.printHelloWorld();
    }
}
