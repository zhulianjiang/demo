package com.hengnan.test;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/2/4 16:39
 **/
public class Test2 {
    public static void main(String[] args) throws Exception {

//        long time1 = DateTimeUtil.timestampNow().getTime();
//        var ts = new Thread[]{new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread()};
//        for (var t : ts) {
//            t.start();
//        }
//        for (var t : ts) {
//            t.join();
//        }
//        System.out.println(Counter.studentCount);
//        System.out.println(Counter.teacherCount);
//        long time2 = DateTimeUtil.timestampNow().getTime();
//        System.out.println("=========:" + (time2-time1));
//        Thread add = new AddThread();
//        Thread dec = new DecThread();
//        add.start();
//        dec.start();
//        add.join();
//        dec.join();
//        System.out.println(Counter.count);
    }
}

class Counter {
    public static final Object lockTeacher = new Object();
    public static final Object lockStudent = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lockStudent) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lockStudent) {
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lockTeacher) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lockTeacher) {
                Counter.teacherCount -= 1;
            }
        }
    }
}


//class Counter {
////    public static final Object lock1 = new Object();
////    public static final Object lock2 = new Object();
////    public static final Object lock = new Object();
//    public static final String lock = "lock";
//    public static int count = 0;
//}
//
//class AddThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized (Counter.lock){
//                Counter.count += 1;
//            }
//        }
//    }
//}
//
//class DecThread extends Thread {
//    public void run() {
//        for (int i=0; i<10000; i++) {
//            synchronized (Counter.lock){
//                Counter.count -= 1;
//            }
//        }
//    }
//}


