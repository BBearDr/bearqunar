package com.java.bearqunar.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author junxiong.chen
 * @date 2019/5/8
 */
@Slf4j
public class MyStack {

    private List<String> list = Lists.newArrayList();

    public synchronized void push(){
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anything =" + Math.random());
            this.notify();
            log.info("push notify size:{}", list.size());
        } catch (InterruptedException e) {
            log.error("interrupt exception" ,e);
        }
    }
    public synchronized void pop(){
        try {
            while (list.size() == 0) {
                log.info("pop操作:{}",Thread.currentThread().getName());
                this.wait();
            }
            list.remove(0);
            this.notify();
            log.info("pop notify size:{}", list.size());
        } catch (InterruptedException e) {
            log.error("interrupt exception" ,e);
        }
    }
}
