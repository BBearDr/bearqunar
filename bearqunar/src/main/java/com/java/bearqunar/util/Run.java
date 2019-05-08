package com.java.bearqunar.util;

/**
 * @author junxiong.chen
 * @date 2019/5/8
 */
public class Run {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        P p = new P(stack);
        C c = new C(stack);
        Thread thread = new Thread(p);
        Thread thread1 = new Thread(c);
        thread.start();
        thread1.start();
    }
}
class P implements Runnable {
    private MyStack myStack;
    P(MyStack myStack){
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            myStack.push();
        }
    }
}

class C implements Runnable{
    private MyStack myStack;

    C(MyStack myStack) {
        this.myStack = myStack;
    }

    @Override
    public void run() {
        while (true) {
            myStack.pop();
        }
    }
}
