package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int Num_threads=30;//线程数
        int Group_len=1000000000/Num_threads;

        MyThread[] ee = new MyThread[Num_threads];
        Thread[] e=new Thread[Num_threads];
        //new Thread(e).start();
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        //long startTime = System.currentTimeMillis(); //获取开始时间
        for(int i=0;i<Num_threads;i++)
        {
            ee[i]=new MyThread(i*Group_len,(i+1)*Group_len,x);
            e[i]=new Thread(ee[i]);
        }
        for(Thread i:e)
        {
            i.start();
        }
        for(Thread i:e)
        {
            try {
                i.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i;
        }

        for(MyThread i:ee)
        {
           // System.out.println(i.ans);
            ans+=i.ans;
        }
        //long endTime = System.currentTimeMillis(); //获取结束时间
        //System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时 间
        System.out.println("ans:"+ans);
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
