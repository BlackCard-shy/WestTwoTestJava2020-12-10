package com.company;

import java.security.PublicKey;
import java.util.Scanner;
public class MyThread implements Runnable {
    protected int Start,End;
    protected int x;
    protected long ans=0;

    public MyThread(int start, int end, int x) {
        Start = start;
        End = end;
        this.x = x;
    }
//    public void getter(int start, int end, int x) {
//        Start = start;
//        End = end;
//        this.x = x;
//    }
    public void run() {
        for (int i = Start; i < End; i++) {
            if (contain(i, x)) {
                ans += i;
                //System.out.println(i);
            }
        }
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
