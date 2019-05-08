package com.java.bearqunar.util;

/**
 * @author junxiong.chen
 * @date 2019/4/29
 */
public class TestThread {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(100);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    if (interrupted()) {
                        System.out.println("是中断状态");
                        throw new InterruptedException();
                    }
                    System.out.println("i = " + i++);
                }
                System.out.println("在for下面");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("catch exception");
            }
        }
    }

}
