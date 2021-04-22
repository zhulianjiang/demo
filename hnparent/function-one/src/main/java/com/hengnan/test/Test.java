package com.hengnan.test;

import java.util.Date;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/2/1 17:26
 **/
public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    static class TimerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread t = new TimerThread();
        t.setDaemon(Boolean.TRUE);
        t.start();












//        final Test test = new Test();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                public void run() {
//                    for(int j=0;j<1000;j++)
//                        test.increase();
//                };
//            }.start();
//        }
//
//        while(Thread.activeCount()>1)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc);


//        HelloThread t = new HelloThread();
//        t.start();
//        Thread.sleep(1);
//        t.running = false; // 标志位置为false


//        Thread t = new MyThread();
//        t.start();
//        Thread.sleep(1000);
//        t.interrupt(); // 中断t线程
//        t.join(); // 等待t线程结束
//        System.out.println("end");



//        Thread thread = new Thread(()-> {
//            System.out.println("123");
//        });
//        System.out.println("start");
//        thread.start();
//        thread.join();
//        System.out.println("end");


//        Thread thread = new MyThread();
//        thread.start();

//        System.out.println("main start...");
//        Thread t = new Thread() {
//            public void run() {
//                System.out.println("thread run...");
//                try{
//                    Thread.sleep(30);
//                }catch (Exception e){}
//                System.out.println("thread end.");
//            }
//        };
//        t.start();
//        try {
//            Thread.sleep(20);
//        } catch (Exception e){}
//        System.out.println("main end...");



//        ExecutorService service = Executors.newCachedThreadPool();
//        final CountDownLatch cdOrder = new CountDownLatch(1);
//        final CountDownLatch cdAnswer = new CountDownLatch(4);
//        for (int i = 0; i < 4; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
//                        cdOrder.await();
//                        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
//                        Thread.sleep((long) (Math.random() * 10000));
//                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
//                        cdAnswer.countDown();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            service.execute(runnable);
//        }
//        try {
//            Thread.sleep((long) (Math.random() * 10000));
//            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
//            cdOrder.countDown();
//            System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
//            cdAnswer.await();
//            System.out.println("所有选手都到达终点");
//            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        service.shutdown();







//        ExecutorService service = Executors.newFixedThreadPool(3);
//        final CountDownLatch latch = new CountDownLatch(3);
//        for (int i = 0; i < 3; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
//                        Thread.sleep((long) (Math.random() * 10000));
//                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
//                        latch.countDown();//当前线程调用此方法，则计数减一
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            service.execute(runnable);
//        }
//
//        try {
//            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
//            latch.await();//阻塞当前线程，直到计数器的值为0
//            System.out.println("主线程"+Thread.currentThread().getName()+"开始执行...");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //    public static class MyThread extends Thread{
//        public void run() {
//            Thread hello = new HelloThread();
//            hello.start(); // 启动hello线程
//            try {
//                hello.join(); // 等待hello线程结束
//            } catch (InterruptedException e) {
//                System.out.println("interrupted!");
//            }
//            hello.interrupt();
//        }
//    }

//    public static class HelloThread extends Thread {
//        public volatile boolean running = true;
//        public void run() {
//            int n = 0;
//            while (running) {
//                n ++;
//                System.out.println(n + " hello!");
//            }
//            System.out.println("end!");
//        }
//    }
    }

}
